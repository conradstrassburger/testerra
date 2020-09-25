/*
 * Testerra
 *
 * (C) 2020, Peter Lehmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
 package eu.tsystems.mms.tic.testframework.pageobjects;

import eu.tsystems.mms.tic.testframework.annotations.PageOptions;
import eu.tsystems.mms.tic.testframework.enums.CheckRule;
import eu.tsystems.mms.tic.testframework.exceptions.PageNotFoundException;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.factory.PageFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.action.AbstractFieldAction;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.action.SetNameFieldAction;
import eu.tsystems.mms.tic.testframework.report.model.context.MethodContext;
import eu.tsystems.mms.tic.testframework.report.utils.ExecutionContextController;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.TestFeatures;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This is an abstract page object used for {@link Page} and {@link AbstractComponent}.
 * Provides basic {@link PageObject} related features:
 *      Supports element {@link Check}
 *      Supports {@link PageOptions}
 * Livecycle methods for {@link #checkUiElements(CheckRule)}:
 *      {@link #checkPagePreparation()}
 *      {@link #addCustomFieldActions}
 *      {@link #assertPageIsNotShown()} or {@link #assertPageIsNotShown()}
 *      {@link #checkPageErrorState(Throwable)}
 * @see {https://martinfowler.com/bliki/PageObject.html}
 * @author Peter Lehmann
 * @author Mike Reiche
 * @todo Rename to AbstractPageObject
 */
public abstract class AbstractPage implements
        Loggable,
        TestFeatures,
        PageObject,
        UiElementLocator,
        UiElementFactoryProvider,
        PageFactoryProvider
{
    abstract protected UiElement find(Locate locate);
    protected UiElement findById(Object id) {
        return find(Locate.by(By.id(id.toString())));
    }
    protected UiElement findByQa(String qa) {
        return find(Locate.byQa(qa));
    }
    protected UiElement find(By by) {
        return find(Locate.by(by));
    }
    protected UiElement find(XPath xPath) {
        return find(Locate.by(xPath));
    }

    /**
     * Calls the assertPageIsShown method.
     */
    private void checkAdditional(CheckRule checkRule) {
        try {
            switch (checkRule) {
                case IS_NOT_PRESENT:
                case IS_NOT_DISPLAYED:
                    assertPageIsNotShown();
                break;
                default:
                    assertPageIsShown();
            }
        } catch (final Exception t) {
            /*
            set readable message
             */
            String message = "Page check failed on " + this.getClass().getSimpleName();

            MethodContext methodContext = ExecutionContextController.getCurrentMethodContext();
            if (methodContext != null) {
                methodContext.errorContext().setThrowable(message, t);
            }

            /*
            exception
             */
            throw new PageNotFoundException(message, t);
        }
    }

    /**
     * Package private accessible by {@link PageObjectFactory}
     */
    PageObject checkUiElements() {
        return checkUiElements(CheckRule.DEFAULT);
    }

    /**
     * Package private accessible by {@link PageObjectFactory}
     */
    PageObject checkUiElements(CheckRule checkRule) {
        pCheckPage(checkRule, true);
        return this;
    }

    /**
     * The call of this method is injected into the constructor of every page class or must be called from every page
     * class constructor!!!
     * If there are several subclasses each calling checkPage, it will be only called from the class of the calling instance.
     * @deprecated Don't call this method on your own and use {@link PageFactory#create(Class, WebDriver)} instead
     */
    @Deprecated
    public final void checkPage() {
        pCheckPage(CheckRule.DEFAULT, true);
    }

    private void pCheckPage(CheckRule checkRule, final boolean checkCaller) {
        /*
        Logging and demo mode
         */
        log().info("Checking mandatory elements");

        /*
        page checks
         */
        checkPagePreparation();
        try {
            checkAnnotatedFields(checkRule);
            checkAdditional(checkRule);
        } catch (Throwable throwable) {
            try {
                // call page error state logic
                checkPageErrorState(throwable);

                // if nothing is checked then the orig throwable is thrown
                throw throwable;
            } catch (Throwable importantThrowable) {
                String message = importantThrowable.getMessage();
                if (message == null) {
                    message = "Page not found: " + this.toString();
                }

                /*
                set readable message
                 */
                String throwableMessage = throwable.getMessage();
                if (throwableMessage == null) {
                    throwableMessage = message;
                }

                MethodContext methodContext = ExecutionContextController.getCurrentMethodContext();
                if (methodContext != null) {
                    methodContext.errorContext().setThrowable(throwableMessage, importantThrowable);
                }

                if (importantThrowable instanceof Error) {
                    throw (Error) importantThrowable;
                } else if (importantThrowable instanceof RuntimeException) {
                    throw (RuntimeException) importantThrowable;
                } else {
                    throw new PageNotFoundException(message, importantThrowable);
                }
            }
        }

        pageLoaded();
        log().info("Page loaded successfully");
    }

    /**
     * Allows pages to run code before performing checkpage
     */
    protected void checkPagePreparation() {
    }

    protected void pageLoaded() {

    }
    /**
     * Method entered when checkPage runs into an error (catching any throwable). You can throw a new throwable that
     * should be stacked onto the checkpage error (like new RuntimeException("bla", throwable) ).
     *
     * @param throwable .
     * @throws Throwable .
     */
    protected void checkPageErrorState(Throwable throwable) throws Throwable {
    }

    /**
     * Gets all @Check annotated fields of a class and executes a webdriver find().
     */
    private void checkAnnotatedFields(CheckRule checkRule) {
        List<Class<? extends AbstractPage>> allClasses = collectAllSuperClasses();

        allClasses.forEach(pageClass -> {
            for (Field field : pageClass.getDeclaredFields()) {
                field.setAccessible(true);
                List<AbstractFieldAction> fieldActions = getFieldActions(field, checkRule, this);
                fieldActions.forEach(AbstractFieldAction::run);
                field.setAccessible(false);
            }
        });
    }

    protected Optional<List<AbstractFieldAction>> addCustomFieldActions(Field field, AbstractPage declaringPage) {
        return Optional.empty();
    }

    private List<AbstractFieldAction> getFieldActions(Field field, CheckRule checkRule, AbstractPage declaringPage) {
        List<AbstractFieldAction> fieldActions = new ArrayList<>();

        SetNameFieldAction setNameFieldAction = new SetNameFieldAction(field, declaringPage);
        fieldActions.add(setNameFieldAction);

        addCustomFieldActions(field, declaringPage).ifPresent(customFieldActions -> fieldActions.addAll(customFieldActions));

        GuiElementCheckFieldAction guiElementCheckFieldAction = new GuiElementCheckFieldAction(field, checkRule, declaringPage);
        fieldActions.add(guiElementCheckFieldAction);

        return fieldActions;
    }

    /**
     * Collects all classes in the hierarchy that are sub classes of {@link AbstractPage}
     */
    private List<Class<? extends AbstractPage>> collectAllSuperClasses() {
        final LinkedList<Class<? extends AbstractPage>> allClasses = new LinkedList<>();
        allClasses.add(this.getClass());
        boolean running = true;
        /*
         * Find all superclasses.
         */
        Class<?> clazz = this.getClass();
        while (running) {

            clazz = clazz.getSuperclass();

            try {
                if (clazz == null) {
                    running = false;
                } else if (clazz == AbstractComponent.class || clazz == Page.class) {
                    /*
                      When the class is on of the abstract implementations,
                      then stop searching here
                     */
                    break;
                } else {
                    @SuppressWarnings("unchecked") final Class<? extends AbstractPage> pageClass = (Class<? extends AbstractPage>) clazz;
                    allClasses.add(pageClass);
                }
            } catch (final ClassCastException e) {
                running = false;
            }
        }
        /**
         * Revert classes order to bottom up
         * @todo Why? There is no reason
         */
        //Collections.reverse(allClasses);
        return allClasses;
    }

    /**
     * Empty method to be overriden. Can perform some (additional) checks on page objects.
     */
    @Deprecated
    public void assertPageIsShown() {
    }

    @Deprecated
    public void assertPageIsNotShown() {
    }

    @Override
    abstract public WebDriver getWebDriver();

    protected <T extends Component> T createComponent(Class<T> componentClass, UiElement rootElement) {
        return pageFactory.createComponent(componentClass, rootElement);
    }

    protected <T extends PageObject> T createPage(final Class<T> pageClass) {
        return pageFactory.createPage(pageClass, getWebDriver());
    }
}

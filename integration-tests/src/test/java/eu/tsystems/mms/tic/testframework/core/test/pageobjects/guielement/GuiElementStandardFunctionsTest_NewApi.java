/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann
 *     pele
 */
package eu.tsystems.mms.tic.testframework.core.test.pageobjects.guielement;

import eu.tsystems.mms.tic.testframework.AbstractTestSitesTest;
import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.core.test.TestPage;
import eu.tsystems.mms.tic.testframework.exceptions.ElementNotFoundException;
import eu.tsystems.mms.tic.testframework.execution.testng.InstantAssertion;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.Attribute;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.WebTestPage;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.ImageAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.QuantityAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.StringAssertion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuiElementStandardFunctionsTest_NewApi extends AbstractTestSitesTest implements Loggable {

    private final static InstantAssertion instantAssertion = Testerra.injector.getInstance(InstantAssertion.class);
    private WebTestPage page;

    @BeforeMethod
    private WebTestPage prepareTestPage() {
        page = pageFactory.createPage(WebTestPage.class);
        page.getWebDriver().navigate().to(TestPage.INPUT_TEST_PAGE.getUrl());
        return page;
    }

    @Test
    public void test_Page_title() {
        StringAssertion<String> title = page.title();

        title.is("Input test");
        title.contains("Input");
        title.containsNot("SuperTestPage");

        QuantityAssertion<Integer> length = page.title().length();
        length.is(10);
        length.isLowerThan(100);
        length.isGreaterThan(5);
        length.isBetween(1,11);
        length.isGreaterEqualThan(-10);
        length.isLowerEqualThan(10);
    }

    @Test
    public void test_Page_waitFor() {
        Control.withElementTimeout(0, () -> {
            if (page.waitFor().title().contains("Katzentitel")) {
                Assert.assertFalse(true);
            }

            if (page.waitFor().title().is("Input test")) {
                Assert.assertTrue(true);
            }
        });
    }

    @Test
    public void test_Page_title_matches() {
        page.title().matches("input\\s+.es.").isTrue();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void test_Page_title_matches_fails() {
        page.title().matches("input\\s+.es.").isFalse();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void test_Page_title_length_fails() {
        page.title().length().isGreaterThan(10);
    }

    @Test
    @Fails(description = "The test itself passes, but collected assertions will always fail")
    public void test_Page_title_length_fails_collected() {
        Control.collectAssertions(()->page.title().length().isGreaterThan(10));
    }

    @Test
    public void test_Page_title_length_fails_nonFunctional() {
        Control.nonFunctionalAssertions(()-> page.title().length().isGreaterThan(10));
    }

    @Test
    public void test_Page_url() {
        page.url().beginsWith("http");
        page.url().endsWith("input.html");
    }

    @Test
    public void test_GuiElement_clear() {
        UiElement element = page.findById(5);
        element.sendKeys("Test");
        element.clear().text().is("");
    }

    @Test()
    public void test_Page_url_endsWith_fails() {
        String msg = null;
        try {
            page.url().endsWith("nonexistingfile.html");
        } catch (AssertionError e) {
           msg = e.getMessage();
        }
        instantAssertion.assertEndsWith(msg, "ends with [nonexistingfile.html]", AssertionError.class.toString());
    }

    @Test
    public void test_GuiElement_displayed_false() {
        page.notDisplayedElement().value(Attribute.STYLE).contains("display: none");
        page.notDisplayedElement().displayed().isFalse();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void test_GuiElement_displayed_false_fails() {
        page.notDisplayedElement().displayed().isTrue();
    }

    @Test
    public void test_GuiElement_visible_false() {
        page.notVisibleElement().value(Attribute.STYLE).contains("hidden");
        page.notVisibleElement().value("style").contains("hidden");
        page.notVisibleElement().visible(true).isFalse();
        page.notVisibleElement().visible(false).isFalse();
        page.notDisplayedElement().css("display").is("none");
    }

    @Test
    public void test_GuiElement_waitFor() {
        Control.withElementTimeout(0, () -> {
            if (page.notVisibleElement().waitFor().value(Attribute.STYLE).is("humbug")) {
                Assert.assertFalse(true);
            }
            if (page.notVisibleElement().waitFor().value(Attribute.STYLE).contains("hidden")) {
                Assert.assertTrue(true);
            }
        });
    }

    @Test(expectedExceptions = AssertionError.class)
    public void test_GuiElement_visible_false_fails() {
        page.notVisibleElement().visible(true).isTrue();
    }

    @Test
    public void test_NonExistent_GuiElement_present() {
        page.nonExistentElement().present().isFalse();
    }

    @Test
    public void test_NonExistent_GuiElement_present_fails() {
        String msg = null;
        try {
            page.nonExistentElement().present().isTrue();
        } catch (AssertionError e) {
            msg = e.getMessage();
        }
        instantAssertion.assertEndsWith(msg, "is one of [true, 'on', '1', 'yes']", AssertionError.class.toString());
    }

    @Test
    public void test_NonExistent_GuiElement_present_fails_fast() {
        Control.withElementTimeout(0, () -> test_NonExistent_GuiElement_present_fails());
    }

    @Test
    public void test_NonExistent_GuiElement_displayed_fails() {
        String msg=null;
        try {
            page.nonExistentElement().displayed().isFalse();
        } catch (AssertionError e) {
            msg = e.getMessage();
        }
        instantAssertion.assertEndsWith(msg, "not found", AssertionError.class.toString());
    }

    @Test
    public void test_GuiElement_screenshot() {
        ImageAssertion screenshot = page.notVisibleElement().screenshot();
        screenshot.file().exists().isTrue();
    }

    @Test
    public void test_NonExistent_GuiElement_screenshot_fails() {
        String msg=null;
        try {
            page.nonExistentElement().screenshot().file().exists().isTrue();
        } catch (ElementNotFoundException e) {
            msg = e.getMessage();
        }
        instantAssertion.assertEndsWith(msg, "not found", ElementNotFoundException.class.toString());
    }

    @Test
    public void test_Component() {
        final String input = "Ich gebe etwas ein";
        page.inputForm().button().value().is("Button1");
        page.inputForm().input().clear().sendKeys(input).value().is(input);
        page.inputForm().button().numberOfElements().is(1);
    }

    @Test
    public void test_User_sendKeys() {
        final String input = "Ich bin langsam im Tippen";
        page.inputForm().input().asUser().clear().sendKeys(input).value().is(input);
    }
}

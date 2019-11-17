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
package eu.tsystems.mms.tic.testframework.core.test.layoutcheck;

import eu.tsystems.mms.tic.testframework.AbstractTestSitesTest;
import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.core.test.TestPage;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.IGuiElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LayoutCheckTest_NewApi extends AbstractTestSitesTest implements Loggable {

    @Override
    protected TestPage getStartPage() {
        return TestPage.LAYOUT;
    }

    @BeforeMethod
    private LayoutCheckPage preparePage() {
        LayoutCheckPage page = pageFactory.createPage(LayoutCheckPage.class);
        page.getWebDriver().navigate().to(TestPage.LAYOUT.getUrl());
        return page;
    }

    @Test
    public void testCheckElementLayout() {
        LayoutCheckPage page = preparePage();
        IGuiElement guiElement = page.getGuiElementQa("section/layoutTestArticle");
        guiElement.screenshot().pixelDistance("TestArticle").isLowerThan(1.3);

        guiElement = page.getGuiElementQa("section/invisibleTestArticle");
        guiElement.screenshot().pixelDistance("InvisibleTestArticle").isLowerThan(1.3);
    }

    @Test
    public void testCheckElementVisibility() {
        LayoutCheckPage page = preparePage();
        IGuiElement guiElement = page.getGuiElementQa("section/layoutTestArticle");
        guiElement.visible(true).isTrue();

        guiElement = page.getGuiElementQa("section/invisibleTestArticle");
        guiElement.visible(false).isFalse();

        // Scroll to offset doesn't work
        //guiElement.scrollToElement(300);
        //Assert.assertFalse(guiElement.isVisible(true));

        guiElement.scrollTo();
        guiElement.visible(true).isTrue();
    }

    @Test()
    @Fails(description = "This test should fail")
    public void testCheckElementLayoutDistance() {
        LayoutCheckPage page = preparePage();
        IGuiElement guiElement = page.getGuiElementQa("section/layoutTestArticle");
        Control.withElementTimeout(0, () -> guiElement.screenshot().pixelDistance("TestArticleFailed").isLowerThan(1));
    }

    @Test
    public void testCheckPageLayout() {
        LayoutCheckPage page = preparePage();
        page.screenshot()
            .toReport()
            .pixelDistance("LayoutTestPage").isLowerThan(1);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testCheckPageLayout_failed() {
        LayoutCheckPage page = preparePage();
        Control.withElementTimeout(0, () -> page.screenshot().pixelDistance("LayoutTestPage").isGreaterThan(100));
    }
}

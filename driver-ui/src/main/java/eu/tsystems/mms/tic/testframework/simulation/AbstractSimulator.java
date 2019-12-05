package eu.tsystems.mms.tic.testframework.simulation;

import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.TestableGuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.GuiElementActions;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.BinaryAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.ImageAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.QuantityAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.RectAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.StringAssertion;

public class AbstractSimulator implements GuiElementActions {
    protected final GuiElement guiElement;

    public AbstractSimulator(GuiElement guiElement) {
        this.guiElement = guiElement;
    }

    @Override
    public StringAssertion<String> text() {
        return guiElement.text();
    }

    @Override
    public QuantityAssertion<Integer> numberOfElements() {
        return guiElement.numberOfElements();
    }

    @Override
    public StringAssertion<String> value(String attribute) {
        return guiElement.value();
    }

    @Override
    public StringAssertion<String> css(String property) {
        return guiElement.css(property);
    }

    @Override
    public BinaryAssertion<Boolean> enabled() {
        return guiElement.enabled();
    }

    @Override
    public BinaryAssertion<Boolean> selected() {
        return guiElement.selected();
    }

    @Override
    public BinaryAssertion<Boolean> present() {
        return guiElement.present();
    }

    @Override
    public BinaryAssertion<Boolean> displayed() {
        return guiElement.displayed();
    }

    @Override
    public BinaryAssertion<Boolean> visible(boolean complete) {
        return guiElement.visible(complete);
    }

    @Override
    public StringAssertion<String> tagName() {
        return guiElement.tagName();
    }

    @Override
    public RectAssertion bounds() {
        return guiElement.bounds();
    }

    @Override
    public TestableGuiElement waitFor() {
        return guiElement.waitFor();
    }

    @Override
    public ImageAssertion screenshot() {
        return guiElement.screenshot();
    }

    @Override
    public TestableGuiElement highlight() {
        return guiElement.highlight();
    }

    @Override
    public GuiElementActions click() {
        guiElement.click();
        return this;
    }

    @Override
    public GuiElementActions doubleClick() {
        guiElement.doubleClick();
        return this;
    }

    @Override
    public GuiElementActions rightClick() {
        guiElement.rightClick();
        return this;
    }

    @Override
    public GuiElementActions select() {
        guiElement.select();
        return this;
    }

    @Override
    public GuiElementActions deselect() {
        guiElement.deselect();
        return this;
    }

    @Override
    public GuiElementActions sendKeys(CharSequence... charSequences) {
        guiElement.sendKeys(charSequences);
        return this;
    }

    @Override
    public GuiElementActions clear() {
        guiElement.clear();
        return this;
    }

    @Override
    public GuiElementActions hover() {
        guiElement.hover();
        return this;
    }

    @Override
    public GuiElementActions scrollTo(int yOffset) {
        guiElement.scrollTo(yOffset);
        return this;
    }
}
package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class ContextMenuPage extends BasePage {
    final String textBlock = "p";
    final String hotspot = "#hot-spot";

    public ContextMenuPage openPage() {
        open("context_menu");
        return this;
    }

    public ContextMenuPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Context Menu"));
        return this;
    }

    public ContextMenuPage getTextCorrect() {
        ElementsCollection textArea = $$(textBlock);
        textArea.shouldHave(size(2));
        for (SelenideElement paragraph : textArea) {
            paragraph
                    .should(exist)
                    .shouldBe(visible);
        }
        return this;
    }

    public ContextMenuPage getHotspotCorrect() {
        $(hotspot)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(attribute("oncontextmenu", "displayMessage()"));
        return this;
    }

    public ContextMenuPage hotspotClick() {
        $(hotspot).contextClick();
        return this;
    }

    public ContextMenuPage getAlertCorrect() {
        String alertText = switchTo().alert().getText();
        assertEquals(alertText, "You selected a context menu");
        switchTo().alert().accept();
        return this;
    }
}


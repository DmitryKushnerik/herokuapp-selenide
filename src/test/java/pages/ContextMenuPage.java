package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class ContextMenuPage extends BasePage {
    final String textBlock = "p";
    final String hotspot = "#hot-spot";

    @Step("Открыть страницу")
    public ContextMenuPage openPage() {
        open("context_menu");
        return this;
    }

    @Step("Проверить, что заголовок отображается корректно")
    public ContextMenuPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Context Menu"));
        return this;
    }

    @Step("Проверить, что текст страницы отображается корректно")
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

    @Step("Проверить, что область для нажатия отображается корректно")
    public ContextMenuPage getHotspotCorrect() {
        $(hotspot)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(attribute("oncontextmenu", "displayMessage()"));
        return this;
    }

    @Step("Нажать на область для нажатия")
    public ContextMenuPage hotspotClick() {
        $(hotspot).contextClick();
        return this;
    }

    @Step("Проверить текст всплывающего сообщения и закрыть его")
    public ContextMenuPage getAlertCorrect() {
        String alertText = switchTo().alert().getText();
        assertEquals(alertText, "You selected a context menu");
        switchTo().alert().accept();
        return this;
    }
}

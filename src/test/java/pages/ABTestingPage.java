package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ABTestingPage extends BasePage {
    final String textBlock = "p";

    @Step("Открыть страницу")
    public ABTestingPage openPage() {
        open("abtest");
        return this;
    }

    @Step("Проверить, что заголовок страницы отображается корректно")
    public ABTestingPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(oneOfExactTexts("A/B Test Control", "A/B Test Variation 1"));
        return this;
    }

    @Step("Проверить, что текст отображается корректно")
    public ABTestingPage getTextCorrect() {
        $(textBlock)
                .should(exist)
                .shouldBe(visible);
        return this;
    }
}

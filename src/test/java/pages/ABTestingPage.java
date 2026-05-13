package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ABTestingPage extends BasePage {
    final String textBlock = "p";

    public ABTestingPage openPage() {
        open("abtest");
        return this;
    }

    public ABTestingPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(oneOfExactTexts("A/B Test Control", "A/B Test Variation 1"));
        return this;
    }

    public ABTestingPage getTextCorrect() {
        $(textBlock)
                .should(exist)
                .shouldBe(visible);
        return this;
    }
}

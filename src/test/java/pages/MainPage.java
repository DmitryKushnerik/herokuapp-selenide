package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage extends BasePage {
    final static String LINK_PATTERN = "//a[contains(text(), '%s')]";
    final String header1 = "h1";
    final String header2 = "h2";
    final String linkList = "ul";
    final String link = "//li//parent::a";
    final String footer = "#page-footer";
    final String forkLink = "//a[@href='https://github.com/tourdedave/the-internet']";
    final String forkImage = "img";

    @Step("Открыть страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Проверить корректность URL")
    public MainPage getUrlIsCorect(String url) {
        webdriver().shouldHave(url(baseUrl + url));
        return this;
    }

    @Step("Перейти по ссылке с указанным текстом")
    public MainPage openLinkByText(String text) {
        $x(LINK_PATTERN.formatted(text)).click();
        return this;
    }

    @Step("Проверить, что заголовок отображается корректно")
    public MainPage getTitleCorrect() {
        $(header1)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Welcome to the-internet"));
        return this;
    }

    @Step("Проверить, что подзаголовок отображается корректно")
    public MainPage getSubtitleCorrect() {
        $(header2)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Available Examples"));
        return this;
    }

    @Step("Проверить, что список ссылок отображается корректно")
    public MainPage getLinkListCorrect() {
        $(linkList)
                .should(exist)
                .shouldBe(visible);
        $$x(link)
                .should(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить, что подвал страницы отображается корректно")
    public MainPage getFooterCorrect() {
        $(footer)
                .should(exist)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверить, что ссылка Fork корректна")
    public MainPage getForkLinkCorrect() {
        $x(forkLink)
                .should(exist);
        return this;
    }

    @Step("Проверить, что изображение в ссылке Fork корректно")
    public MainPage getForkImageCorrect() {
        $(forkImage)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(attribute("src",
                        "https://the-internet.herokuapp.com/img/forkme_right_green_007200.png"));
        return this;
    }
}

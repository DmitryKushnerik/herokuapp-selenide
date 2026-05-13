package pages;

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

    public MainPage openPage() {
        open("");
        return this;
    }

    public MainPage getUrlIsCorect(String url) {
        webdriver().shouldHave(url(baseUrl + url));
        return this;
    }

    public MainPage openLinkByText(String text) {
        $x(LINK_PATTERN.formatted(text)).click();
        return this;
    }

    public MainPage getTitleCorrect() {
        $(header1)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Welcome to the-internet"));
        return this;
    }

    public MainPage getSubtitleCorrect() {
        $(header2)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Available Examples"));
        return this;
    }

    public MainPage getLinkListCorrect() {
        $(linkList)
                .should(exist)
                .shouldBe(visible);
        $$x(link)
                .should(sizeGreaterThan(0));
        return this;
    }

    public MainPage getFooterCorrect() {
        $(footer)
                .should(exist)
                .shouldBe(visible);
        return this;
    }

    public MainPage getForkLinkCorrect() {
        $x(forkLink)
                .should(exist);
        return this;
    }

    public MainPage getForkImageCorrect() {
        $(forkImage)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(attribute("src",
                        "https://the-internet.herokuapp.com/img/forkme_right_green_007200.png"));
        return this;
    }
}

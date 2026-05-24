package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    public MainPage mainPage;
    public ABTestingPage abTestingPage;
    public AddRemovePage addRemovePage;
    public CheckboxesPage checkboxesPage;
    public ContextMenuPage contextMenuPage;
    public DragAndDropPage dragAndDropPage;

    @Step("Открыть браузер")
    @BeforeMethod
    public void setup() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";

        mainPage = new MainPage();
        abTestingPage = new ABTestingPage();
        addRemovePage = new AddRemovePage();
        checkboxesPage = new CheckboxesPage();
        contextMenuPage = new ContextMenuPage();
        dragAndDropPage = new DragAndDropPage();
    }

    @Step("Закрыть браузер")
    @AfterMethod
    public void close() {
        clearBrowserCache();
        closeWebDriver();
    }
}

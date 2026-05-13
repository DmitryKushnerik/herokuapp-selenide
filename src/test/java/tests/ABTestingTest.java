package tests;

import org.testng.annotations.Test;

public class ABTestingTest extends BaseTest {
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("A/B Testing")
                .getUrlIsCorect("abtest");
    }

    @Test(description = "Проверка корректности отображения страницы")
    public void checkIsPageCorrect() {
        abTestingPage
                .openPage()
                .getTitleCorrect()
                .getTextCorrect();
    }
}

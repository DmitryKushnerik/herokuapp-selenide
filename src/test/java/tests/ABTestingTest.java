package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Страница A/B Testing")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class ABTestingTest extends BaseTest {
    @Feature("Доступность страницы A/B Testing")
    @Story("Переход на страницу A/B Testing по ссылке с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("A/B Testing")
                .getUrlIsCorect("abtest");
    }

    @Feature("Доступность страницы A/B Testing")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы")
    public void checkIsPageCorrect() {
        abTestingPage
                .openPage()
                .getTitleCorrect()
                .getTextCorrect();
    }
}

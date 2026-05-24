package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Главная страница")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class MainTest extends BaseTest {
    @Feature("Доступность главной страницы")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы")
    public void checkIsPageCorrect() {
        mainPage
                .openPage()
                .getTitleCorrect()
                .getSubtitleCorrect()
                .getLinkListCorrect()
                .getForkLinkCorrect()
                .getForkImageCorrect()
                .getFooterCorrect();
    }
}

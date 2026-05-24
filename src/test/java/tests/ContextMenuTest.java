package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Страница Context Menu")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class ContextMenuTest extends BaseTest {
    @Feature("Доступность страницы Context Menu")
    @Story("Переход на страницу Context Menu по ссылке с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Context Menu")
                .getUrlIsCorect("context_menu");
    }

    @Feature("Доступность страницы Context Menu")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        contextMenuPage
                .openPage()
                .getTitleCorrect()
                .getTextCorrect()
                .getHotspotCorrect();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности контекстного меню")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка работоспособности контексного меню", priority = 2)
    public void checkIsContextMenuCorrect() {
        contextMenuPage
                .openPage()
                .hotspotClick()
                .getAlertCorrect();
    }
}

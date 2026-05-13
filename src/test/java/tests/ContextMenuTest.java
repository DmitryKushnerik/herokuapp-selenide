package tests;

import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Context Menu")
                .getUrlIsCorect("context_menu");
    }

    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        contextMenuPage
                .openPage()
                .getTitleCorrect()
                .getTextCorrect()
                .getHotspotCorrect();
    }

    @Test(description = "Проверка работоспособности контексного меню", priority = 2)
    public void checkIsContextMenuCorrect() {
        contextMenuPage
                .openPage()
                .hotspotClick()
                .getAlertCorrect();
    }
}

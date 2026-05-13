package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {
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

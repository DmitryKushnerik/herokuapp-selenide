package tests;

import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Checkboxes")
                .getUrlIsCorect("checkboxes");
    }

    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        checkboxesPage
                .openPage()
                .getTitleCorrect()
                .getCheckboxesCorrect()
                .getCheckboxChecked(0, false)
                .getCheckboxChecked(1, true);
    }

    @Test(description = "Проверка работоспособности чекбоксов", priority = 2)
    public void checkIsCheckboxesClickable() {
        checkboxesPage
                .openPage()
                .getCheckboxChecked(0, false)
                .checkboxClick(0)
                .getCheckboxChecked(0, true)
                .getCheckboxChecked(1, true)
                .checkboxClick(1)
                .getCheckboxChecked(1, false);
    }
}

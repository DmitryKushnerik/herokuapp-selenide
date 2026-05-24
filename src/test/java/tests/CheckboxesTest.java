package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Страница Checkboxes")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class CheckboxesTest extends BaseTest {
    @Feature("Доступность страницы Checkboxes")
    @Story("Переход на страницу Checkboxes по ссылке с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Checkboxes")
                .getUrlIsCorect("checkboxes");
    }

    @Feature("Доступность страницы Checkboxes")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        checkboxesPage
                .openPage()
                .getTitleCorrect()
                .getCheckboxesCorrect()
                .getCheckboxChecked(0, false)
                .getCheckboxChecked(1, true);
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности флажков")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка работоспособности флажков", priority = 2)
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

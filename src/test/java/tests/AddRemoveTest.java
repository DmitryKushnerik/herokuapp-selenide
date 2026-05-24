package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Страница Add/Remove Elements")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class AddRemoveTest extends BaseTest {
    @Feature("Доступность страницы Add/Remove Elements")
    @Story("Переход на страницу Add/Remove Elements по ссылке с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Add/Remove Elements")
                .getUrlIsCorect("add_remove_elements/");
    }

    @Feature("Доступность страницы Add/Remove Elements")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        addRemovePage
                .openPage()
                .getTitleCorrect()
                .getAddButtonCorrect();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности кнопок")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка работоспособности кнопки Add", priority = 2)
    public void checkIsAddButtonCorrect() {
        addRemovePage
                .openPage()
                .addButtonClick(1)
                .getDeleteButtonNumber(1);
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности кнопок")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка работоспособности кнопки Delete", priority = 3)
    public void checkIsDeleteButtonCorrect() {
        addRemovePage
                .openPage()
                .addButtonClick(1)
                .getDeleteButtonNumber(1)
                .getDeleteButtonCorrect()
                .deleteButtonClick(1)
                .getDeleteButtonNumber(0);
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности кнопок")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка работоспособности множественного нажатия на кнопки Add и Delete", priority = 4)
    public void checkMultipleClicks() {
        int num = 20;
        addRemovePage
                .openPage()
                .addButtonClick(num)
                .getDeleteButtonNumber(num)
                .deleteButtonClick(num)
                .getDeleteButtonNumber(0);
    }
}

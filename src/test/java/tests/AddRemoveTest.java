package tests;

import org.testng.annotations.Test;

public class AddRemoveTest extends BaseTest {
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Add/Remove Elements")
                .getUrlIsCorect("add_remove_elements/");
    }

    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        addRemovePage
                .openPage()
                .getTitleCorrect()
                .getAddButtonCorrect();
    }

    @Test(description = "Проверка работоспособности кнопки Add", priority = 2)
    public void checkIsAddButtonCorrect() {
        addRemovePage
                .openPage()
                .addButtonClick(1)
                .getDeleteButtonNumber(1);
    }

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

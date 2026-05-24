package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Owner("Кушнерик Дмитрий")
@Epic("Страница Drag and Drop")
@TmsLink("herokuapp-selenide")
@Issue("issues")
public class DragAndDropTest extends BaseTest {
    @Feature("Доступность страницы Drag and Drop")
    @Story("Переход на страницу Drag and Drop по ссылке с главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Drag and Drop")
                .getUrlIsCorect("drag_and_drop");
    }

    @Feature("Доступность страницы Drag and Drop")
    @Story("Проверка корректности отображения страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        dragAndDropPage
                .openPage()
                .getTitleCorrect()
                .getBlocksCorrect();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности перемещения блоков")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка перемещения блока A в блок B", priority = 2)
    public void checkDragAtoB() {
        dragAndDropPage
                .openPage()
                .dragAtoB();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности перемещения блоков")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка перемещения блока B в блок A", priority = 3)
    public void checkDragBtoA() {
        dragAndDropPage
                .openPage()
                .dragBtoA();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности перемещения блоков")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка перемещения блока A в блок B и обратно", priority = 4)
    public void checkDragAtoBandReverse() {
        dragAndDropPage
                .openPage()
                .dragAtoB()
                .dragBtoA();
    }

    @Feature("Работоспособность элементов страницы")
    @Story("Проверка работоспособности перемещения блоков")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка перемещения блока B в блок A и обратно", priority = 5)
    public void checkDragBtoAandReverse() {
        dragAndDropPage
                .openPage()
                .dragBtoA()
                .dragAtoB();
    }
}

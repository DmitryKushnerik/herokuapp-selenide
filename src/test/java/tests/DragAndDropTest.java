package tests;

import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {
    @Test(description = "Проверка открытия страницы по ссылке с главной страницы")
    public void checkIsLinkCorrect() {
        mainPage
                .openPage()
                .openLinkByText("Drag and Drop")
                .getUrlIsCorect("drag_and_drop");
    }

    @Test(description = "Проверка корректности отображения страницы", priority = 1)
    public void checkIsPageCorrect() {
        dragAndDropPage
                .openPage()
                .getTitleCorrect()
                .getBlocksCorrect();
    }

    @Test(description = "Проверка перемещения блока A в блок B", priority = 2)
    public void checkDragAtoB() {
        dragAndDropPage
                .openPage()
                .dragAtoB();
    }

    @Test(description = "Проверка перемещения блока B в блок A", priority = 3)
    public void checkDragBtoA() {
        dragAndDropPage
                .openPage()
                .dragBtoA();
    }

    @Test(description = "Проверка перемещения блока A в блок B и обратно", priority = 4)
    public void checkDragAtoBandReverse() {
        dragAndDropPage
                .openPage()
                .dragAtoB()
                .dragBtoA();
    }

    @Test(description = "Проверка перемещения блока B в блок A и обратно", priority = 5)
    public void checkDragBtoAandReverse() {
        dragAndDropPage
                .openPage()
                .dragBtoA()
                .dragAtoB();
    }
}

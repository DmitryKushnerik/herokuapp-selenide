package pages;

import com.codeborne.selenide.DragAndDropOptions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage extends BasePage {
    final String columnA = "#column-a";
    final String columnB = "#column-b";
    final String headerA = "//div[@id='column-a']//child::header";
    final String headerB = "//div[@id='column-b']//child::header";

    @Step("Открыть страницу")
    public DragAndDropPage openPage() {
        open("drag_and_drop");
        return this;
    }

    @Step("Проверить, что заголовок отображается корректно")
    public DragAndDropPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Drag and Drop"));
        return this;
    }

    @Step("Проверить, что колонки отображаются корректно")
    public DragAndDropPage getBlocksCorrect() {
        $(columnA)
                .should(exist)
                .shouldBe(visible);
        $x(headerA)
                .shouldBe(visible)
                .shouldHave(text("A"));
        $(columnB)
                .should(exist)
                .shouldBe(visible);
        $x(headerB)
                .shouldBe(visible)
                .shouldHave(text("B"));
        return this;
    }

    @Step("Перетащить колонку A в колонку B")
    public DragAndDropPage dragAtoB() {
        dragBlock(columnA, columnB);
        return this;
    }

    @Step("Перетащить колонку B в колонку A")
    public DragAndDropPage dragBtoA() {
        dragBlock(columnB, columnA);
        return this;
    }

    @Step("Перетащить конкретную колонку")
    private void dragBlock(String block, String target) {
        String textA = $x(headerA).getText();
        String textB = $x(headerB).getText();
        $(block).dragAndDrop(DragAndDropOptions.to(target));
        $x(headerA)
                .shouldBe(visible)
                .shouldHave(text(textB));
        $x(headerB)
                .shouldBe(visible)
                .shouldHave(text(textA));
    }
}

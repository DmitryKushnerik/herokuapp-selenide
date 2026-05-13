package pages;

import com.codeborne.selenide.DragAndDropOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage extends BasePage {
    final String columnA = "#column-a";
    final String columnB = "#column-b";
    final String headerA = "//div[@id='column-a']//child::header";
    final String headerB = "//div[@id='column-b']//child::header";

    public DragAndDropPage openPage() {
        open("drag_and_drop");
        return this;
    }

    public DragAndDropPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Drag and Drop"));
        return this;
    }

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

    public DragAndDropPage dragAtoB() {
        dragBlock(columnA, columnB);
        return this;
    }

    public DragAndDropPage dragBtoA() {
        dragBlock(columnB, columnA);
        return this;
    }

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

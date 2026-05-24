package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AddRemovePage extends BasePage {
    final String addButton = "//button[@onclick='addElement()']";
    final String deleteButton = "//button[@onclick='deleteElement()']";
    final String bgColor = Color.fromString("#2ba6cb").asRgba();
    final String borderColor = Color.fromString("#2284a1").asRgb();
    final String textColor = Color.fromString("white").asRgba();

    @Step("Открыть страницу")
    public AddRemovePage openPage() {
        open("add_remove_elements/");
        return this;
    }

    @Step("Проверить, что кнопка отображается корректно")
    public void getButtonAttributes(String selector, String text) {
        $x(selector)
                .shouldHave(cssValue("background-color", bgColor))
                .shouldHave(cssValue("border-color", borderColor))
                .shouldHave(cssValue("color", textColor))
                .shouldHave(text(text));

    }

    @Step("Проверить, что заголовок страницы отображается корректно")
    public AddRemovePage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Add/Remove Elements"));
        return this;
    }

    @Step("Проверить, что кнопка Add отображается корректно")
    public AddRemovePage getAddButtonCorrect() {
        $x(addButton).should(exist).shouldBe(visible);
        getButtonAttributes(addButton, "Add Element");
        return this;
    }

    @Step("Проверить, что кнопка Delete отображается корректно")
    public AddRemovePage getDeleteButtonCorrect() {
        $x(deleteButton).should(exist).shouldBe(visible);
        getButtonAttributes(deleteButton, "Delete");
        return this;
    }

    @Step("Нажать на кнопку Add")

    public AddRemovePage addButtonClick(int num) {
        for (int i = 0; i < num; i++)
            $x(addButton).click();
        return this;
    }

    @Step("Нажать на кнопку Delete")
    public AddRemovePage deleteButtonClick(int num) {
        for (int i = 0; i < num; i++)
            $x(deleteButton).click();
        return this;
    }

    @Step("Получить количество кнопок Delete")
    public AddRemovePage getDeleteButtonNumber(int num) {
        $$x(deleteButton).shouldHave(size(num));
        return this;
    }
}

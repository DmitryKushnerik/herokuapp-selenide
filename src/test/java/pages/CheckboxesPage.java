package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage extends BasePage {
    final String checkbox = "//input[@type = 'checkbox']";

    public CheckboxesPage openPage() {
        open("checkboxes");
        return this;
    }

    public CheckboxesPage getTitleCorrect() {
        $(pageTitle)
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Checkboxes"));
        return this;
    }

    public CheckboxesPage getCheckboxesCorrect() {
        $$x(checkbox).should(size(2));
        return this;
    }

    public CheckboxesPage getCheckboxChecked(int num, boolean flag) {
        SelenideElement element = $$x(checkbox).get(num);
        if (flag)
            element.shouldHave(attribute("checked"));
        else
            element.shouldNotHave(attribute("checked"));
        return this;
    }

    public CheckboxesPage checkboxClick(int num) {
        $$x(checkbox).get(num).click();
        return this;
    }
}

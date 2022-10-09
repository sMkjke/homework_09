package com.github.smkjke.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class ResultTableComponent {

    private static final String TITLE_TEXT = "Thanks for submitting the form";

    public ResultTableComponent isVisible() {
        $x(".//div[@class='modal-dialog modal-lg']").should(appear);
        $x(".//div[@class='modal-title h4']").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultTableComponent checkResult(String field, String value) {
        $x(String.format(".//td[contains(text()[normalize-space()], '%s')]/following-sibling::td", field)).shouldHave(Condition.text(value));
        return this;
    }

}

package com.github.smkjke.pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class DropDownComponent {

    public DropDownComponent setDropDown(String id, String name) {
        $x(String.format(".//div[@id='%s']", id)).click();
        $x(String.format(".//div[contains(text()[normalize-space()], '%s')]", name)).click();
        return this;
    }

}

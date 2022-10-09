package com.github.smkjke.pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class ButtonComponent {

    public ButtonComponent clickButton(String id) {
        $x(String.format(".//button[@id='%s']", id)).click();
        return this;
    }

}

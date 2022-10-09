package com.github.smkjke.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class UploadFileComponent {

    public UploadFileComponent uploadFile(String id, File file) {
        $x(String.format(".//input[@id='%s']", id)).uploadFile(file);
        return this;
    }

}

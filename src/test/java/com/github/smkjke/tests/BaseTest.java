package com.github.smkjke.tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
    }

}

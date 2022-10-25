package com.github.smkjke.tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertiyTest() {
        String browserName = System.getProperty("browser");
    }
}

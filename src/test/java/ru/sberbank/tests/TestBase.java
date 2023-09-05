package ru.sberbank.tests;

import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        executeJavaScript("$('.kitt-cookie-warning').remove()");
    }
}


package ru.sberbank.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "2880x1800";
        Configuration.baseUrl = "https://www.sberbank.ru/ru/person";
        open("");
        $(".kitt-cookie-warning__close").click();
    }

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
}


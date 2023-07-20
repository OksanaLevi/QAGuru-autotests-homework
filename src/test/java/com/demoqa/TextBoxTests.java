package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

//public class GoogleTest {
//    static {
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        Configuration.browserCapabilities = capabilities;
//    }
//
//    @Test
//    void googleTest() {
//        Selenide.open("https://google.com");
//    }
//}

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void filFromTests() {
        Selenide.open("/text-box");

        $("#userName").setValue("Oksana Levinskaya");
        $("#userEmail").setValue("oksana@ya.ru");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Oksana Levinskaya"));
        $("#output #email").shouldHave(text("oksana@ya.ru"));
        $("#output #currentAddress").shouldHave(text("Some address"));
        $("#output #permanentAddress").shouldHave(text("Another address"));

    }
}

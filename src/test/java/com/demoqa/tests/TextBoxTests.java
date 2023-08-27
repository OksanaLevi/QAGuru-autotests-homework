package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TextBoxTests extends TestBase {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        String userName = "Masha Ivanova";
        String userEmail = "masha@ivanova.com";
        String userAddress = "Some address 12";
        String userPermanentAddress = "Another address 21";

        textBoxPage
                .openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(userAddress)
                .setPermanentAddress(userPermanentAddress)
                .submit()

                .checkOutput(userName, userEmail, userAddress, userPermanentAddress);
    }
}

package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class RegistrationWithPageObjectsTests extends TestBase {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFromTests() {
        String firstName = "Ivan";
        String lastName = "Petrov";
        String userEmail = "studentt@ya.ru";
        String userNumber = "8911111111";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumber)
                .setBirthDate("29", "July", "2010")
                .setSubject("English")
                .setHobbies("Reading")
                .setPicture("1.jpeg")
                .setAddress("Current address")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()

                .resultsTableOpened()
                .checkResult(firstName, lastName, userEmail, userNumber);
    }
}

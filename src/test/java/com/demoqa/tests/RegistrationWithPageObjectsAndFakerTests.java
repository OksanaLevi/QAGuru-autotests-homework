package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.demoqa.utils.RandomUtilWithFaker.*;

class RegistrationWithPageObjectsAndFakerTests extends TestBase {

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

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(subject)
                .setHobbies(hobby)
                .setPicture("img/1.jpeg")
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitForm()

                .resultsTableOpened()
                .checkResult(firstName, lastName, userEmail, userNumber);
    }
}

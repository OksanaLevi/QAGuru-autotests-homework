package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.ResultsTableComponent;
import com.demoqa.utils.RandomUtilWithFaker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class RegistrationWithPageObjectsAndFakerTests extends TestBase {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtilWithFaker random = new RandomUtilWithFaker();
    ResultsTableComponent checkingResultInTable = new ResultsTableComponent();


    @Test
    void successfulFromTests() {

        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setUserEmail(random.userEmail)
                .setGender(random.userGender)
                .setUserNumber(random.userNumber)
                .setBirthDate(random.userBirthDay, random.userBirthMonth, random.userBirthYear)
                .setSubject(random.subject)
                .setHobbies(random.hobby)
                .setPicture(random.pictureFolder, random.pictureName)
                .setAddress(random.userAddress)
                .setState(random.userState)
                .setCity(random.userCity)
                .submitForm()

                .resultsTableOpened();
        checkingResultInTable.verificationResults(random.firstName)
                .verificationResults(random.firstName)
                .verificationResults(random.lastName)
                .verificationResults(random.userEmail)
                .verificationResults(random.userGender)
                .verificationResults(random.userNumber)
                .verificationResults(random.userBirthDay)
                .verificationResults(random.userBirthMonth)
                .verificationResults(random.userBirthYear)
                .verificationResults(random.subject)
                .verificationResults(random.hobby)
                .verificationResults(random.pictureName)
                .verificationResults(random.userAddress)
                .verificationResults(random.userState)
                .verificationResults(random.userCity);
    }
}

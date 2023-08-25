package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

class RegistrationWithPageObjectsTests extends TestBase {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    RegistrationFormPage registrationPage = new RegistrationFormPage();

    @Test
    void successfulFromTests() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setUserEmail("studentt@ya.ru")
                .setGender("Male")
                .setUserNumber("8911111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("2010")).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__day");
        $("#subjectsInput").setValue("En");
        $("#subjectsWrapper").$(byText("English")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
//      $("#uploadPicture").uploadFromClasspath("1.jpeg");
        //В таком случае картинка будет подтягиваться по имени файла из папки resources. Конечно, картинку туда нужно положить и запушить на гитхаб :)
        $("#currentAddress").setValue("Current address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#currentAddress").setValue("Current address");

        //Проверка результата
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lf").shouldHave(text("Ivan Petrov"), text("studentt@ya.ru"), text("Male"), text("8911111111"), text("English"));
        registrationPage.checkResult("Ivan Petrov")
                .checkResult("studentt@ya.ru")
                .checkResult("Male")
                .checkResult("8911111111")
                .checkResult("English ");
    }
}

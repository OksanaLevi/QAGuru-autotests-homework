package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormTests {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        browserCapabilities = capabilities;
    }

    @BeforeAll
    static void beforeAll() {
        pageLoadStrategy = "eager";
        baseUrl = "https://demoqa.com";
//        holdBrowserOpen = true;
    }

    @Test
    void filFromTests() {

        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Заполнение формы
        $("#firstName").setValue("Student");
        $("#lastName").setValue("Testovi");
        $("#userEmail").setValue("studentt@ya.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8911111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("2010")).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("En");
        $("#subjectsWrapper").$(byText("English")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
      $("#uploadPicture").uploadFromClasspath("1.jpeg");
        $("#currentAddress").setValue("Current address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#currentAddress").setValue("Current address");

        //Проверка результата
        $(".modal-content").should(appear);
        $(byTagAndText("Student Name", "Student Testovi"));
        $(byTagAndText("Student Email", "studentt@ya.ru"));
        $(byTagAndText("Gender", "Male"));
        $(byTagAndText("Mobile", "8911111111"));
        $(byTagAndText("Date of Birth", "15 July,2010"));
        $(byTagAndText("Subjects", "English"));
        $(byTagAndText("Hobbies", "Reading"));
        $(byTagAndText("Picture", "1.jpeg"));
        $(byTagAndText("Address", "Current address"));
        $(byTagAndText("State and City", "NCR Delhi"));

    }
}

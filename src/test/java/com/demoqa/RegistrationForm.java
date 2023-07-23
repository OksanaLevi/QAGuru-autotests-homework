package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationForm {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "2880x1800";
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
        $(byText("Male")).click();
        $("#userNumber").setValue("8911111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day").click();
        $("#subjectsInput").setValue("En");
        $(byText("English")).click();
        $(byText("Reading")).click();
        File file = new File("/Users/20152853/Downloads/1.jpeg");
        $(".form-control-file").uploadFile(file);
        $("#currentAddress").setValue("Current address");
//        $("option:contains('NCR'')");
        $("#react-select-3-input").setValue("N");
        $(byText("NCR")).click();
//        $("option:contains('Delhi')");
        $("#react-select-4-input").setValue("Del");
        $(byText("Delhi")).click();
        $("#submit").click();
        $("#currentAddress").setValue("Current address");

        //Проверка результата
        $(".modal-content").should(appear);
        $(byTagAndText("Student Name", "Student Testovi"));
        $(byTagAndText("Student Email", "studentt@ya.ru"));
        $(byTagAndText("Gender", "Male"));
        $(byTagAndText("Mobile", "8911111111"));
        $(byTagAndText("Subjects", "English"));
        $(byTagAndText("Hobbies", "Reading"));
        $(byTagAndText("Picture", ""));
        $(byTagAndText("Address", "Current address"));
        $(byTagAndText("State and City", "NCR Delhi"));

    }
}

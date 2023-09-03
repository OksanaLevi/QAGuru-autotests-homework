package ru.sberbank;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SB1Page {
    public static WebDriverConditions webdriverContainer = new WebDriverConditions();
    SelenideElement
            menuButton = $(".tabs-container__header"),
            pageContent = $(".tabs-container__tab-content"),
            privilegeHeader = $(".sb-include"),
            privilegeBlock = $(".bt-link");


    public void openPage() {
        Selenide.open("https://www.sberbank.ru/ru/person/sb1");
//      executeJavaScript("$('.kitt-cookie-warning__content').remove()");;
    }

    public SB1Page pressTheMenuButton(String value) {
        menuButton.$(byText(value)).click();
        return this;
    }

    public SB1Page checkBlockHeader(String value) {
        pageContent.shouldHave(text(value));
        return this;
    }

    public SB1Page checkingForPrivileges(String value) {
        privilegeHeader.shouldHave(text(value));
        return this;
    }

    public SB1Page redirectToPageOnClick(String privilegeName, String urlNewPage) {
        privilegeBlock.$(byText(privilegeName)).click();
//                webdriver().shouldHave(url(urlNewPage));
        String currentUrl = WebDriverRunner.url();
        String urlValidationError = "Открылась неожиданная страница. Проверьте корректность требуемого url для привилегии";
        if (currentUrl.equals(urlNewPage)) {
            return this;
        } else {
            return urlValidationError;
        }
    }
}

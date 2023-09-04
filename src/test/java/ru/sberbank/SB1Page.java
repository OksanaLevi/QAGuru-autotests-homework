package ru.sberbank;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SB1Page {
    SelenideElement
            menuButton = $(".tabs-container__tabs "),
            pageContent = $(".tabs-container__tab-content"),
            privilegeHeader = $(".sb-include"),
            informationAboutBonuses = $(".bli-widget");


    public void openPage() {
        Selenide.open("https://www.sberbank.ru/ru/person/sb1");
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

    public SB1Page redirectToPageOnClick(String header, String text) {
        informationAboutBonuses.$(byText(header)).parent().shouldHave(text(text));
        return this;
    }
}

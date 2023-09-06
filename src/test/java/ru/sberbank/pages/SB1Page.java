package ru.sberbank.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SB1Page {
    SelenideElement
            menuButton = $(".tabs-container__tabs "),
            pageContent = $(".tabs-container__tab-content"),
            privilegeHeader = $(".sb-include"),
            informationAboutBonuses = $(".bli-widget");
    String
            urlForClientsSB1 = "/sb1";


    public void openPage() {
        open(urlForClientsSB1);
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

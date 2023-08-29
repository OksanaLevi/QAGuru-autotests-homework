package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    SelenideElement tableResult = $(".table-responsive");

    public ResultsTableComponent verificationResults(String value) {
        tableResult.shouldHave(text(value));

        return this;
    }
}

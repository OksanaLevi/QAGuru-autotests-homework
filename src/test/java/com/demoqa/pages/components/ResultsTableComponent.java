package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    public void verificationResults (String firstName, String lastName, String userEmail, String userNumber) {
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(userNumber));
    }
}

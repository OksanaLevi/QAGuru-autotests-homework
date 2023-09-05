package ru.sberbank.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.sberbank.utils.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

class SB1WithMethodSource {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    static Stream<Arguments> menuNavigationByClientTypes() {
        return Stream.of(
                Arguments.of(Locale.ENG, List.of("Branch and ATM finder", "РУС")),
                Arguments.of(Locale.РУС, List.of("Курсы валют", "Офисы", "Банкоматы", "Москва", "ENG"))
        );}


    @BeforeAll
    static void beforeAll() {
        open("https://www.sberbank.ru/ru/person");
    }

        @MethodSource
    @ParameterizedTest
    void menuNavigationByClientTypes(Locale locale, List<String> expectedButtons) {
        $$(".kitt-header a").find(text(locale.name())).click();
        $$(".kitt-header__links a").should(CollectionCondition.texts(expectedButtons));

    }
}

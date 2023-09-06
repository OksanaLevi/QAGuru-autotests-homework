package ru.sberbank.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.sberbank.utils.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

class SB1WithMethodSourceTests extends TestBase {

    static Stream<Arguments> menuNavigationByClientTypes() {
        return Stream.of(
                Arguments.of(Locale.ENG, List.of("Branch and ATM finder", "РУС")),
                Arguments.of(Locale.RUS, List.of("Курсы валют", "Офисы", "Банкоматы", "Москва", "ENG"))
        );}

        @MethodSource("menuNavigationByClientTypes")
    @ParameterizedTest
    void menuNavigationByClientTypes(Locale locale, List<String> expectedButtons) {
        $$(".kitt-header a").find(text(locale.getName())).click();
        $$(".kitt-header__links a").should(CollectionCondition.texts(expectedButtons));

    }
}

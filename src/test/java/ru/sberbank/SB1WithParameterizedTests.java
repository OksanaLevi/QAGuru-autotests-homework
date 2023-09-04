package ru.sberbank;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class SB1WithParameterizedTests {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    SB1Page sb1Page = new SB1Page();

    @BeforeEach
    void setUp() {
        sb1Page.openPage();
    }

    @CsvFileSource(resources = "/testData/displayBlockByButton.csv")

    @ParameterizedTest(name = "На странице СберПервого при нажатии на вкладку {0} отображается заголовок {1}")
    void switchPageContentByButton(String blockName, String blockHeader) {
        sb1Page.pressTheMenuButton(blockName)
                .checkBlockHeader(blockHeader);
    }

    @ValueSource(
            strings = {"Лайфстайл-сервис", "Ожидание рейса с комфортом", "Вклады с особыми условиями", "Специальные условия обмена валюты"}
    )

    @ParameterizedTest(name = "В блоке специальных привилегий содержится привилегия {0}")
    void checkingForPrivileges(String privilegeHeader) {
        sb1Page.checkingForPrivileges(privilegeHeader);
    }

    @CsvSource(value = {
            "Как получить бонусы       |   Возвращайте бонусами от СберСпасибо до 10% в кафе",
            "Как использовать бонусы   |   Получайте скидки до 99% у партнёров программы"
    },
            delimiter = '|')

    @ParameterizedTest(name = "В блоке {0} имеется текст {1} ...")
    void checkRedirectToPageOnClick(String bonusAction, String bonusDetails) {
        sb1Page.redirectToPageOnClick(bonusAction, bonusDetails);
    }
}

package ru.sberbank.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.sberbank.pages.SB1Page;

class SB1WithParameterizedTests extends TestBase {

    SB1Page sb1Page = new SB1Page();

    @BeforeEach
    void setUp() {sb1Page.openPage();}

    @CsvFileSource(resources = "/testData/displayBlockByButton.csv")
    @ParameterizedTest(name = "На странице СберПервого при нажатии на вкладку {0} отображается заголовок {1}")
    void switchPageContentByButton(String blockName, String blockHeader) {
        sb1Page.pressTheMenuButton(blockName)
                .checkBlockHeader(blockHeader);
    }

    @ValueSource(strings = {"Лайфстайл-сервис", "Ожидание рейса с комфортом", "Вклады с особыми условиями", "Специальные условия обмена валюты"})
    @ParameterizedTest(name = "В блоке специальных привилегий содержится привилегия {0}")
    void checkingForPrivileges(String privilegeHeader) {
        sb1Page.checkingForPrivileges(privilegeHeader);
    }

    @CsvSource(value = {
            "Как получить бонусы       |   Возвращайте бонусами от СберСпасибо до 10% в кафе",
            "Как использовать бонусы   |   Получайте скидки до 99% у партнёров программы"
    }, delimiter = '|')
    @ParameterizedTest(name = "В блоке {0} имеется текст {1} ...")
    void checkingInformationAboutBonuses(String bonusAction, String bonusDetails) {
        sb1Page.redirectToPageOnClick(bonusAction, bonusDetails);
    }
}

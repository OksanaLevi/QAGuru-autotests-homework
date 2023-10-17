package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.StepsFromAllure;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTestWithAllure {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск конкретной Issue")
    @Owner("Левинская Оксана")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "тикет в Jira", url = "https://.....")
    @DisplayName("Проверка наличия конкретного Issue в репозитории")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void testAnnotatedStep() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Проверка наличия конкретного Issue в репозитории")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Поиск конкретной Issue");
        Allure.label("owner", "Левинская Оксана");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("тикет в Jira", "https://.....");

        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsFromAllure steps = new StepsFromAllure();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }

    @Test
    public void testAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        attachment("Source", webdriver().driver().source());
    }

    @Test
    public void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsFromAllure steps = new StepsFromAllure();

        steps.openMainPage();
        steps.takeScreenshot();

}
}

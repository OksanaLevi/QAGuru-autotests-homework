package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertions {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        browserCapabilities = capabilities;
    }

    @Test
    void softAssertionsTest() {
        Selenide.open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-sidebar-toggle-display .js-wiki-more-pages-link").click();
        $(".Layout-sidebar").shouldHave(text("SoftAssertions")).$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "@Test\n" +
                "void test() {\n" +
                "Configuration.assertionMode = SOFT;\n" +
                "open(\"page.html\");\n" +
                "\n" +
                "$(\"#first\").should(visible).click();\n" +
                "$(\"#second\").should(visible).click();\n" +
                "}\n" +
                "}"));
//        sleep(5000);
    }
}

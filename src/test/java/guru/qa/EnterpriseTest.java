package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EnterpriseTest {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        browserCapabilities = capabilities;
    }

    @Test
    void openEnterpriseTest() {
        Selenide.open("https://github.com/");
        $$(".header-logged-out .HeaderMenu-item").get(1).hover();
        $(".HeaderMenu-dropdown .border-bottom").$(byText("Enterprise")).click();
        $(".application-main").shouldHave(Condition.text("Build like the best"));
//        sleep(3000);
    }
}

package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void successLoginTest() {
        //   Configuration.holdBrowserOpen = true;

        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("QA_GURU_BOT"));
    }
    //Ошибка в пароле при авторизации УЗ QA_GURU_BOT

    @Test
    void negativeLoginTest() {

        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("1234123");
        $(".btn-success").click();

        $(".btn-success").shouldHave(text("Неверный пароль"));
    }
}

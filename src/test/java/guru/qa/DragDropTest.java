package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DragDropTest {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        browserCapabilities = capabilities;
    }

    @Test
    void swapRectangles() {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($(("#column-b"))));
        $("#column-a").shouldHave(Condition.text("B"));
        sleep(5000);

    }
}

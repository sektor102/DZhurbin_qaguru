import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class SearchTests3 {
    @Test
    void successfulSearchTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-blink-features=AutomationControlled",
                "--disable-infobars",
                "--disable-notifications",
                "--start-maximized",
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
        );
        Configuration.browserCapabilities = options;
        Configuration.headless = false;

        open("https://duckduckgo.com");
        $("[id=searchbox_input]").setValue("selenide").pressEnter();
        $("[data-nrn=result]").shouldHave(text("https://selenide.org"));
    }
}
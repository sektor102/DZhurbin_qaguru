import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class SearchTests {
    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\dante\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Profile 3");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");

        Configuration.browserCapabilities = options;
        Configuration.headless = false;
    }

    @Test
    void successfulSearchTest() throws InterruptedException {
        open("https://www.google.com/");
        sleep(500);
        $("[name=q]").setValue("selenide").pressEnter();
        System.out.println("Открыта страница, ищем поле2...");
        $("#search").shouldHave(text("https://selenide.org"));
    }
}

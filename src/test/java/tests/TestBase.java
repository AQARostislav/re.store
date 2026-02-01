package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://re-store.ru";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        String remote = System.getProperty("selenide.remote");
        if (remote != null && !remote.isBlank()) {
            Configuration.remote = remote;

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = caps;
        }
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener(
                "allure",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }
}
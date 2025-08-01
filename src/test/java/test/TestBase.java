package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attachments;

import java.util.Map;
import java.util.UUID;


public class TestBase {
    static String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
    static String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
    static String selenoidUrl = System.getProperty(
            "selenoidUrl", "selenoid.autotests.cloud");

    @BeforeAll
    static void setupConfig(){
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.browserSize = System.getProperty("browserResolution", "1920x1080");
        Configuration.baseUrl = "https://www.labirint.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 20000;
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidUrl + "/wd/hub";
    }

    @BeforeEach
    public void setupConfigBeforeEach(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy ="eager";
        Configuration.baseUrl = "https://www.labirint.ru/";

        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "Test: " + UUID.randomUUID()
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}

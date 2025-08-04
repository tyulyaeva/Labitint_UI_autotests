package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attachments;

import java.util.Map;
import java.util.UUID;
import config.WebProvider;

public class TestBase {
//    static String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
//    static String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
//    static String selenoidUrl = System.getProperty(
//            "selenoidUrl", "selenoid.autotests.cloud");
    public static final WebConfig webConfig = WebProvider.getWebConfig();

    @BeforeAll
    static void setupConfig(){
        ProjectConfig projectConfig = new ProjectConfig(webConfig);
        projectConfig.setConfig();

//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
//        Configuration.browserSize = System.getProperty("browserResolution", "1920x1080");
//        Configuration.baseUrl = "https://www.labirint.ru/";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 20000;
//        Configuration.remote = "https://" +
//                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidUrl + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "Test: " + UUID.randomUUID()
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setupConfigBeforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());
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

package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackWebDriver;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackWebDriver.class.getName();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        open("https://oui-webapp-dev.storemind.de/");
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}

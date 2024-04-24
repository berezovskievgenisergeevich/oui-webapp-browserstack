package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackWebDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", System.getProperty("bs_user"));
        caps.setCapability("browserstack.key", System.getProperty("bs_key"));

        caps.setCapability("browser", System.getProperty("browser"));
        caps.setCapability("browser_version", "latest");

        caps.setCapability("platformName", System.getProperty("platform"));
        caps.setCapability("browserstack.debug", "true");


        caps.setCapability("project", "First Web driver test");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

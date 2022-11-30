package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;

import static propertyReader.PropertyReader.getProperties;

@Log4j

public class FireFoxDriverManager extends DriverManager {

    protected static Properties properties;

    @Override
    public void createDriver() {
        WebDriver webDriver;
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver(getFirefoxOptions());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.set(webDriver);
    }

    private static FirefoxOptions getFirefoxOptions() {
        properties = getProperties();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(properties.getProperty("browser.configs"));
        return firefoxOptions;
    }

}

package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

import static propertyReader.PropertyReader.getProperties;

@Log4j

public class ChromeDriverManager extends DriverManager {

    protected static Properties properties;

    @Override
    public void createDriver() {
        WebDriver webDriver;
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(getChromeOptions());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.set(webDriver);
    }

    protected static ChromeOptions getChromeOptions() {
        properties = getProperties();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(properties.getProperty("browser.configs"));
        return chromeOptions;
    }
}

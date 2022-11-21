package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Log4j

public class SimpleDriver {

    private static WebDriver driver;

    private static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        log.debug("Create new driver" + getDriver().toString());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver setWebDriver() {
        createDriver();
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
    }


}

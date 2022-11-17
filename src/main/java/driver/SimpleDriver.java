package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleDriver {

    private static WebDriver driver;

    private static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
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

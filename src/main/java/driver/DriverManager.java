package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static WebDriver driver;

    {
        if (driver == null) {
            createDriver();
        }
    }

    public abstract void createDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
    }
}

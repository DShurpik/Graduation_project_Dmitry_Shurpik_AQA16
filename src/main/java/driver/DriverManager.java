package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    {
        if (driver.get() == null) {
            createDriver();
        }
    }

    public abstract void createDriver();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}

package pageObject.basePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driver.driver.*;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = setWebDriver();
    }

    @AfterMethod
    public void closeDriver(){
        closeWebDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

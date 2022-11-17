package pageObject.basePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driver.SimpleDriver.*;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp(){
        setWebDriver();
        System.out.println("Create new driver");
    }

    @AfterMethod
    public void closeDriver(){
        closeWebDriver();
        System.out.println("Close driver");
    }
}

package pageObject.basePage;

import driver.DriverFactory;
import driver.DriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import listener.Listener;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import static PropertyReader.PropertyReader.getProperties;
import static driver.DriverManager.closeWebDriver;
import static driver.DriverManager.getDriver;


@Listeners(Listener.class)
@Log4j

public abstract class BaseTest {

    protected Properties properties;

    @BeforeTest
    public void setUp() {
        log.debug("I'm started new wed driver!");
        properties = getProperties();
        DriverFactory.getManager(DriverManagerType.valueOf(properties.getProperty("browser").toUpperCase()));
    }

    @AfterMethod
    public void cleanCookies() {
        DriverManager.driver.get().manage().deleteAllCookies();
    }

    @AfterTest
    public void closeDriver() {
        log.debug("Close driver" + getDriver().toString());
        closeWebDriver();
    }
}

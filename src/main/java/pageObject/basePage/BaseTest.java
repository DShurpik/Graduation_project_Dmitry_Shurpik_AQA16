package pageObject.basePage;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import listener.Listener;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static PropertyReader.PropertyReader.getProperties;
import static driver.DriverManager.closeWebDriver;
import static driver.DriverManager.getDriver;


@Listeners(Listener.class)

@Log4j

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.getManager(DriverManagerType.valueOf(getProperties().getProperty("browser").toUpperCase()));
    }

    @AfterMethod
    public void closeDriver() {
        closeWebDriver();
        log.debug("Close driver" + getDriver().toString());
    }
}

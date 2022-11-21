package pageObject.basePage;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driver.SimpleDriver.*;

@Log4j

public abstract class BaseTest {

    @BeforeMethod
    public void setUp(){
        setWebDriver();
    }

    @AfterMethod
    public void closeDriver(){
        closeWebDriver();
        log.debug("Close driver" + getDriver().toString());
    }
}

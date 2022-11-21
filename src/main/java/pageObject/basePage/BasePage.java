package pageObject.basePage;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.SimpleDriver.getDriver;

@Log4j

public abstract class BasePage {

    protected void load(String url){
        //log.debug("Open website: " + url);
        getDriver().get(url);
    }

    public void click(By by) {
        log.debug("Driver click on element " + by);
        getDriver().findElement(by).click();
    }

    public void enterText(By by, String text) {
        log.debug("Enter text: " + text + " on field " + by.toString());
        getDriver().findElement(by).sendKeys(text);
    }

    public void elementIsDisplayed(By by) {
        log.debug("Element is displayed " + by.toString());
        Assert.assertTrue(getDriver().findElement(by).isDisplayed());
    }

    public void elementIsNotEnabled(By by) {
        log.debug("Element is enabled " + by.toString());
        Assert.assertTrue(getDriver().findElement(by).isEnabled());
    }

    public Boolean getAttributeFromElement(By by, String nameAttribute, String value) {
        log.debug("Get attribute: " + nameAttribute + ", from " + by.toString());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.attributeContains(by,nameAttribute, value));
    }

    public String getText(By by) {
        log.debug("Get text from " + by.toString());
        return getDriver().findElement(by).getText();
    }
}

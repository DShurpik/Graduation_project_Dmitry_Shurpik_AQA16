package pageObject.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.SimpleDriver.getDriver;


public abstract class BasePage {

    protected void load(String url){
        getDriver().get(url);
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public void enterText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public void elementIsDisplayed(By by) {
        Assert.assertTrue(getDriver().findElement(by).isDisplayed());
    }

    public void elementIsNotEnabled(By by) {
        Assert.assertTrue(getDriver().findElement(by).isEnabled());
    }

    public Boolean getAttributeFromElement(By by, String nameAttribute, String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.attributeContains(by,nameAttribute, value));
    }
}

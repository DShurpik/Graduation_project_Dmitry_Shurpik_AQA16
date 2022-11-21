package pageObject.apteka103Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pageObject.basePage.BasePage;

import java.util.ArrayList;
import java.util.Set;

import static driver.SimpleDriver.getDriver;

public class AccountPage extends BasePage {

    private final By settingsBtn = By.linkText("Настройки");
    private final By deleteAccountBtn = By.linkText("Удалить аккаунт");

    public AccountPage clickOnSettingBtn() {
        click(settingsBtn);
        return this;
    }

    public AccountPage clickDeleteBtn() {
        click(deleteAccountBtn);
        return this;
    }

    public AccountPage navigate() {
        //JavascriptExecutor js = (JavascriptExecutor)getDriver();
        String win1 = getDriver().getWindowHandle();
        //js.executeScript("window.open()");
        Set<String> tabs  = getDriver().getWindowHandles();
        String win2 = null;
        for (String win : tabs){
            if (!win.equals(win1)) {
                win2 = win;
                break;
            }
        }
        getDriver().switchTo().window(win2);
        return this;
    }



    private final By emailField = By.xpath("//input[@class='whsOnd zHQkBf']");
    private final By firstCheckBox = By.xpath("//div[@id='i10']//div[@class='rq8Mwb']");

    public AccountPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    public AccountPage clickOnCheckBox() {
        click(firstCheckBox);
        return this;
    }
}

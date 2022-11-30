package pageObject.apteka103Page;

import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

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

    public AccountPage navigateTo() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}

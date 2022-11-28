package pageObject.apteka103Page;

import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

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

    public AccountPage navigate() {
        String win1 = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        String win2 = null;
        for (String win : tabs) {
            if (!win.equals(win1)) {
                win2 = win;
                break;
            }
        }
        driver.switchTo().window(win2);
        return this;
    }
}

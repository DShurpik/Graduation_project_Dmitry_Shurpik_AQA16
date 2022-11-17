package pageObject.apteka103Page;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.basePage.BasePage;

public class StartPage extends BasePage {

    private final By accountWrapper = By.xpath("//span[contains(text(),'Войти')]");
    private final By favoritesBtn = By.xpath("//div[@class='widgetWrapper']");
    private final By favoriteTitle = By.xpath("//span[@class='bookmarkHeader__title']");
    private final By searchField = By.name("q");
    private final By searchBtn = By.xpath("//input[@value='Найти']");
    private final By overlay = By.xpath("//div[@class='Overlay']");
    private final String attribute = "style";
    private final String style = "display: block;";

    public StartPage open(String url) {
        load(url);
        return this;
    }

    public StartPage openWindowForRegistration() {
        click(accountWrapper);
        return this;
    }

    public StartPage openFavoritePopup() {
        click(favoritesBtn);
        return this;
    }

    public StartPage favoriteTitleIsDisplayed() {
        elementIsDisplayed(favoriteTitle);
        return this;
    }

    public StartPage displayBlockAfterPopup() {
        Assert.assertTrue(getAttributeFromElement(overlay,attribute, style));
        return this;
    }

    public StartPage searchMedicine(String medicineName) {
        enterText(searchField, medicineName);
        return this;
    }

    public StartPage clickOnSearchBtn() {
        click(searchBtn);
        return this;
    }
}

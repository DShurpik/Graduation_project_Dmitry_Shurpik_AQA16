package pageObject.apteka103selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static propertyReader.PropertyReader.getProperties;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    private final SelenideElement settingBtn = $(xpath("//a[contains(text(),'Настройки')]"));
    private final SelenideElement deleteBtn = $(By.xpath("//a[contains(text(),'Удалить аккаунт')]"));
    private final SelenideElement emailField = $(By.xpath("//input[@autocomplete='email']"));
    private final SelenideElement checkBox1 = $(By.id("i10"));
    private final SelenideElement sendBtn = $(By.xpath("//span[contains(text(),'Отправить')]"));
    private final SelenideElement sucessMsg = $(By.xpath("//div[contains(text(),'Удаление аккаунта ARTOX')]"));

    public ProfilePage alertIsDisplayed() {
        sucessMsg.shouldBe(Condition.visible);
        return this;
    }

    public ProfilePage clickOnSendBtn() {
        sendBtn.should(Condition.enabled).click();
        return this;
    }

    public ProfilePage clickOnCheckBox() {
        checkBox1.should(Condition.enabled).click();
        return this;
    }

    public ProfilePage enterEmail() {
        emailField.sendKeys(getProperties().getProperty("email"));
        return this;
    }

    public ProfilePage navigate() {
        switchTo().window(1);
        return this;
    }

    public ProfilePage clickOnDeleteBtn() {
        deleteBtn.should(Condition.enabled).click();
        return this;
    }

    public ProfilePage clickOnSetting() {
        settingBtn.should(Condition.enabled).click();
        return this;
    }

}

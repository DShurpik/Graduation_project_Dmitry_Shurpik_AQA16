package pageObject.apteka103selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Properties;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static driver.DriverManager.getDriver;

import static org.openqa.selenium.By.xpath;

import static propertyReader.PropertyReader.getProperties;

public class RegistrationPage {

    static Properties properties;

    private final SelenideElement registrationBtn = $(xpath("//a[@class='tabsItem' and contains(text(),'Регистрация')]"));
    private final SelenideElement nameField = $(By.id("firstName"));
    private final SelenideElement lastNameField = $(By.id("lastName"));
    private final SelenideElement emailField = $(By.id("email"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement passwordConfirmField = $(By.id("password-confirm"));
    private final SelenideElement submitBtn = $(By.xpath("//input[@class='button']"));
    private final SelenideElement nameLastNameOnProfile = $(By.xpath("//span[@class='header__accountTitle']"));
    private final SelenideElement emailForEnter = $(By.xpath("//input[@tabindex='1']"));
    private final SelenideElement passwordForEnter = $(By.xpath("//input[@tabindex='2']"));
    private final SelenideElement enterBtn = $(By.xpath("//input[@tabindex='4']"));

    public RegistrationPage navigate() {
        String win1 = getDriver().getWindowHandle();
        Set<String> tabs = getDriver().getWindowHandles();
        String win2 = null;
        for (String win : tabs) {
            if (!win.equals(win1)) {
                win2 = win;
                break;
            }
        }
        getDriver().switchTo().window(win2);
        return this;
    }


    public RegistrationPage clickOnEnterBtn() {
        enterBtn.should(Condition.enabled).click();
        return this;
    }

    public RegistrationPage enterPasswordForAuth() {
        passwordForEnter.sendKeys(getProperties().getProperty("password"));
        return this;
    }

    public RegistrationPage enterEmailForAuth() {
        emailForEnter.sendKeys(getProperties().getProperty("email"));
        return this;
    }

    public RegistrationPage compareNameLastName() {
        nameLastNameOnProfile.shouldHave(Condition.text(getProperties().getProperty("name") + " " + getProperties().getProperty("lastname")));
        return this;
    }

    public RegistrationPage clickOnSubmit() {
        submitBtn.should(Condition.enabled).click();
        return this;
    }

    public RegistrationPage enterConfirmPassword() {
        passwordConfirmField.sendKeys(getProperties().getProperty("password"));
        return this;
    }

    public RegistrationPage enterPassword() {
        passwordField.sendKeys(getProperties().getProperty("password"));
        return this;
    }

    public RegistrationPage enterEmail() {
        emailField.sendKeys(getProperties().getProperty("email"));
        return this;
    }

    public RegistrationPage enterLastName() {
        lastNameField.sendKeys(getProperties().getProperty("lastname"));
        return this;
    }

    public RegistrationPage enterName() {
        nameField.sendKeys(getProperties().getProperty("name"));
        return this;
    }

    public RegistrationPage clickOnRegistrationBtn() {
        registrationBtn.should(Condition.enabled).click();
        return this;
    }


}

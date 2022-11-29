package pageObject.apteka103Page;

import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

public class RegistrationPage extends BasePage {

    private final By nameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By passwordConfirmField = By.id("password-confirm");
    private final By registerBtn = By.xpath("//input[@value='Зарегистрироваться']");
    //private final By registrationBtn = By.xpath("//*[contains(text(),'Регистрация')]");
    private final By registrationBtn = By.xpath("//a[@class='tabsItem']");
    private final By enterBtn = By.xpath("//*[contains(text(),'Вход')]");
    private final By alert = By.xpath("//div[@class='alert alert--error']");
    private final By emailFieldForEnter = By.xpath("//input[@tabindex='1']");
    private final By passwordFieldForEnter = By.xpath("//input[@tabindex='2']");
    private final By enterBtnForEnter = By.id("loginButton");

    public RegistrationPage enterName(String name) {
        enterText(nameField, name);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        enterText(lastNameField, lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    public RegistrationPage enterPasswordOnConfirmField(String password) {
        enterText(passwordConfirmField, password);
        return this;
    }

    public RegistrationPage clickOnRegistrationBtn() {
        click(registrationBtn);
        return this;
    }

    public RegistrationPage clickOnRegisterBtn() {
        click(registerBtn);
        return this;
    }

    public RegistrationPage alertIsDisplayed() {
        elementIsDisplayed(alert);
        return this;
    }

    public RegistrationPage enterEmailForEnter(String email) {
        enterText(emailFieldForEnter, email);
        return this;
    }

    public RegistrationPage enterPasswordForEnter(String email) {
        enterText(passwordFieldForEnter, email);
        return this;
    }

    public RegistrationPage clickOnEnterBtn() {
        click(enterBtnForEnter);
        return this;
    }
}

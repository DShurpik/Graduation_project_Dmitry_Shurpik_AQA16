package pageObject.apteka103Page;

import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

public class DeleteUserPage extends BasePage {

    private final By emailField = By.xpath("//input[@class='whsOnd zHQkBf']");
    private final By firstCheckBox = By.xpath("//div[@id='i10']");
    private final By sendBtn = By.xpath("//span[@class='NPEfkd RveJvd snByac' and contains(text(),'Отправить')]");
    private final By succesDeleteMsg = By.xpath("//div[@role='heading']");

    public DeleteUserPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    public DeleteUserPage clickOnCheckBox() {
        click(firstCheckBox);
        return this;
    }

    public DeleteUserPage clickOnSendBtn() {
        click(sendBtn);
        return this;
    }

    public DeleteUserPage deleteWasSucces() {
        elementIsDisplayed(succesDeleteMsg);
        return this;
    }
}

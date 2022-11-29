package selenideTest;

import org.testng.annotations.Test;
import pageObject.apteka103selenide.ProfilePage;
import pageObject.apteka103selenide.RegistrationPage;
import pageObject.apteka103selenide.StartPage;
import pageObject.basePage.SelenideBaseTest;

public class test1 extends SelenideBaseTest {

    @Test(description = "registration new user and check", enabled = true)
    public void test1() {
        get(StartPage.class)
                .openProfile();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName()
                .enterLastName()
                .enterEmail()
                .enterPassword()
                .enterConfirmPassword()
                .clickOnSubmit()
                .compareNameLastName();
    }

    @Test(description = "authorization", enabled = true)
    public void test2() {
        get(StartPage.class)
                .openProfile();
        new RegistrationPage()
                .enterEmailForAuth()
                .enterPasswordForAuth()
                .clickOnEnterBtn()
                .compareNameLastName();
    }

    @Test(description = "delete user", enabled = true)
    public void test3() {
        get(StartPage.class)
                .openProfile();
        new RegistrationPage()
                .enterEmailForAuth()
                .enterPasswordForAuth()
                .clickOnEnterBtn()
                .compareNameLastName();
        new StartPage()
                .openProfile()
                .open();
        new ProfilePage()
                .clickOnSetting()
                .clickOnDeleteBtn()
                .navigate()
                .enterEmail()
                .clickOnCheckBox()
                .clickOnSendBtn()
                .alertIsDisplayed();
    }
}

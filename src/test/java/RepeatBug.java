import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class RepeatBug extends BaseTest {

    @Parameters({"name", "lastName", "email1", "password1"})
    @Test(description = "not successful registration with use only numbers in password")
    public void successful_test(String name, String lastName, String email1, String password1) {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName(name)
                .enterLastName(lastName)
                .enterEmail(email1)
                .enterPassword(password1)
                .enterPasswordOnConfirmField(password1)
                .clickOnRegisterBtn();
        new StartPage()
                .titleIsDisplayed();
    }

    @Parameters({"name", "lastName", "email2", "password2"})
    @Test(description = "successful registration with use only letters in password")
    public void test_with_bug(String name, String lastName, String email2, String password2) {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName(name)
                .enterLastName(lastName)
                .enterEmail(email2)
                .enterPassword(password2)
                .enterPasswordOnConfirmField(password2)
                .clickOnRegisterBtn();
        new StartPage()
                .titleIsDisplayed();
    }
}

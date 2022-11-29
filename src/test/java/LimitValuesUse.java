import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class LimitValuesUse extends BaseTest {

    @Parameters({"name", "lastName", "email", "password"})
    @Test(description = "Test on limit values")
    public void limit_value_test(String name, String lastName, String email, String password) {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName(name)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterPasswordOnConfirmField(password)
                .clickOnRegisterBtn()
                .alertIsDisplayed();
    }

}

import org.testng.annotations.Test;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class LimitValuesUse extends BaseTest {

    @Test(description = "Test on limit values")
    public void limit_value_test() {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName("Ddd")
                .enterLastName("Sssss")
                .enterEmail("asdasd@te.vom")
                .enterPassword("d123456")
                .enterPasswordOnConfirmField("d123456")
                .clickOnRegisterBtn()
                .alertIsDisplayed();
    }

}

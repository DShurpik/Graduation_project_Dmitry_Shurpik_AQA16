import org.testng.annotations.Test;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class IncorrectDataUse extends BaseTest {

    @Test(description = "Test with use incorrect data")
    public void incorrect_data_test() {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName("Ddd")
                .enterLastName("Sssss")
                .enterEmail("asdasd@te.vom")
                .enterPassword("!!!!!!!!")
                .enterPasswordOnConfirmField("!!!!!!!!")
                .clickOnRegisterBtn()
                .alertIsDisplayed();
    }

}

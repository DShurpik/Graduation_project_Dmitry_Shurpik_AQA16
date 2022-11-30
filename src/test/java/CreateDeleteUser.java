import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.apteka103Page.AccountPage;
import pageObject.apteka103Page.DeleteUserPage;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class CreateDeleteUser extends BaseTest {

    @Parameters({"name", "lastName", "email", "password"})
    @Test(description = "Create new user")
    public void create_user_test(String name, String lastName, String email, String password) {
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
                .clickOnRegisterBtn();
    }

    @Parameters({"name", "lastName", "email"})
    @Test(description = "delete user profile", dependsOnMethods = "create_user_test")
    public void delete_user_test(String name, String lastName, String email) {
        new StartPage()
                .getNameLastNameUser(name + " " + lastName)
                .openProfile()
                .clickOnProfileField();
        new AccountPage()
                .clickOnSettingBtn()
                .clickDeleteBtn()
                .navigateTo();
        new DeleteUserPage()
                .enterEmail(email)
                .clickOnCheckBox()
                .clickOnSendBtn()
                .deleteWasSucces();
    }
}

import org.testng.annotations.Test;
import pageObject.apteka103Page.AccountPage;
import pageObject.apteka103Page.DeleteUserPage;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class CreateDeleteUser extends BaseTest {

    @Test(description = "Create new user", priority = 1)
    public void create_user_test() {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName("Ddd")
                .enterLastName("Sssss")
                .enterEmail("asdasd@te.vom")
                .enterPassword("asdasd")
                .enterPasswordOnConfirmField("asdasd")
                .clickOnRegisterBtn();
    }

    @Test(description = "delete user profile", priority = 2)
    public void delete_user_test() {
        new StartPage()
                .open()
                .clickOnProfileBtn();
        new RegistrationPage()
                .enterEmailForEnter("gimep90923@jernang.com")
                .enterPasswordForEnter("d123456789")
                .clickOnEnterBtn();
        new StartPage()
                .getNameLastNameUser("D S")
                .openProfile()
                .clickOnProfileField();
        new AccountPage()
                .clickOnSettingBtn()
                .clickDeleteBtn().navigate();
        new DeleteUserPage().enterEmail("gimep90923@jernang.com")
                .clickOnCheckBox();

        /** Тут надо доделать, кнопку удаления */

    }
}

import org.testng.annotations.Test;

import pageObject.apteka103Page.AccountPage;
import pageObject.apteka103Page.DeleteUserPage;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class test extends BaseTest {

    /** 1 тест на создание сущности */
    @Test(description = "Create new user", enabled = false)
    public void create_user_test() {
        new StartPage()
                .open("https://apteka.103.by/")
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
    /** 1 тест на проверку поля для ввода на граничные значения
     * (Пароль должен содержать буквы, цифры и быть не менее 8 символов.)
     * Ввожу пароль с 1 буквой и 6 цифрами */
    @Test(description = "Test on limit values", enabled = false)
    public void limit_value_test() {
        new StartPage()
                .open("https://apteka.103.by/")
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

    /** 1 тест на использование некорректных данных */
    @Test(description = "Test with use incorrect data", enabled = false)
    public void incorrect_data_test() {
        new StartPage()
                .open("https://apteka.103.by/")
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

    /** 1 тест на проверку всплывающего сообщения */
    @Test(description = "popup message test",enabled = false)
    public void popup_test() {
        new StartPage()
                .open("https://apteka.103.by/")
                .openFavoritePopup()
                .favoriteTitleIsDisplayed()
                .displayBlockAfterPopup();
    }

    /** 1 тест на удаление сущности */
    @Test(description = "delete user profile", enabled = false)
    public void delete_user_test() throws InterruptedException {
        new StartPage()
                .open("https://apteka.103.by/")
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

        //Thread.sleep(6000);
    }

    @Test(enabled = true)
    public void test() {
        new StartPage()
                .open("https://apteka.103.by/")
                .searchMedicine("Кардиомагнум")
                .clickOnSearchBtn();
    }

}

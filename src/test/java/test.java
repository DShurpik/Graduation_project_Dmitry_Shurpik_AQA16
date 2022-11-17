import org.testng.annotations.Test;

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

    /* 1 тест на использование некорректных данных */
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

    /* 1 тест на проверку всплывающего сообщения */
    @Test(description = "popup message test",enabled = false)
    public void popup_test() {
        new StartPage()
                .open("https://apteka.103.by/")
                .openFavoritePopup()
                .favoriteTitleIsDisplayed()
                .displayBlockAfterPopup();
    }

    @Test
    public void test() {
        new StartPage()
                .open("https://apteka.103.by/")
                .searchMedicine("Кардиомагнум")
                .clickOnSearchBtn();
    }

}

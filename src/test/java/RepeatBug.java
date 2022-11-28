import org.testng.annotations.Test;
import pageObject.apteka103Page.RegistrationPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class RepeatBug extends BaseTest {

    /**
     * Пароль должен содержать буквы, цифры и быть не менее 8 символов.
     * <p>
     * При создании нового пользователя, при вводе пароля из 8 чисел регистрация проходит успешно
     * <p>
     * При создании нового пользователя, при вводе пароля из 8 букв регистрация не проходит успешно, появляется ошибка
     * "Некорректный пароль, должен содержать как минимум 1 цифру."
     */

    @Test(description = "successful registration with use only numbers in password", enabled = false)
    public void successful_test() {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName("John")
                .enterLastName("Doe")
                .enterEmail("asdasd@tewewe.vom")
                .enterPassword("12345678")
                .enterPasswordOnConfirmField("12345678")
                .clickOnRegisterBtn();
        new StartPage().titleIsDisplayed();
    }

    @Test(description = "not successful registration with use only letters in password", enabled = false)
    public void test_with_bug() {
        new StartPage()
                .open()
                .openWindowForRegistration();
        new RegistrationPage()
                .clickOnRegistrationBtn()
                .enterName("John")
                .enterLastName("Doe")
                .enterEmail("asdasd@teswwww.vom")
                .enterPassword("abcdefgh")
                .enterPasswordOnConfirmField("abcdefgh")
                .clickOnRegisterBtn();
        new StartPage().titleIsDisplayed();
    }
}

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObject.basePage.BaseTest;

public class FirstTest extends BaseTest {

    @Test
    public void test1(){
        getDriver().get("https://www.saucedemo.com/");
        getDriver().findElement(By.name("user-name")).sendKeys("standard_user");
        getDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.name("login-button")).click();

        getDriver().findElement(By.className("header_secondary_container")).isDisplayed();
    }



}

import org.testng.annotations.Test;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class CheckPopUpMsg extends BaseTest {

    @Test(description = "popup message test")
    public void popup_test() {
        new StartPage()
                .open()
                .openFavoritePopup()
                .favoriteTitleIsDisplayed()
                .displayBlockAfterPopup();
    }

}

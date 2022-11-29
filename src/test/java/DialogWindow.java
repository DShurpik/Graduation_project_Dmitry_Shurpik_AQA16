import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.apteka103Page.SearchResultPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class DialogWindow extends BaseTest {

    @Parameters("medicine")
    @Test
    public void dialogWindowTest(String medicine) {
        new StartPage()
                .open()
                .searchMedicine(medicine)
                .clickOnSearchBtn();
        new SearchResultPage()
                .openInstruction()
                .titleInstructionIsDisplayed()
                .closeInstuctionPage()
                .logoIsDisplayedAfterCloseInstruction();
    }

}

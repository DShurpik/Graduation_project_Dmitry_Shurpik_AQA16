import org.testng.annotations.Test;
import pageObject.apteka103Page.SearchResultPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

public class DialogWindow extends BaseTest {

    @Test
    public void dialogWindowTest() {
        String medicineName = "Аспирин кардио";
        new StartPage()
                .open()
                .searchMedicine(medicineName)
                .clickOnSearchBtn();
        new SearchResultPage()
                .openInstruction()
                .titleInstructionIsDisplayed()
                .closeInstuctionPage()
                .logoIsDisplayedAfterCloseInstruction();
    }

}

import org.testng.annotations.Test;
import pageObject.DropMeFiles.MainPage;
import pageObject.basePage.BaseTest;

public class UploadFile extends BaseTest {

    @Test(description = "Upload file")
    public void test1() {
        new MainPage()
                .open("https://dropmefiles.com/")
                .cliclOnuploadBtn()
                .succes();
    }
}

package pageObject.DropMeFiles;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

@Log4j

public class MainPage extends BasePage {

    private final By uploadBtn = By.xpath("//input[@type='file']");
    private final By successfullyUploadBtn = By.className("percent");

    public MainPage open(String url) {
        load(url);
        log.debug("Open website " + url);
        return this;
    }

    public MainPage cliclOnuploadBtn() {
        driver.findElement(uploadBtn).sendKeys(System.getProperty("user.dir") + "/src/test/resources/diplomWork.docx");
        return this;
    }

    public MainPage succes() {
        log.debug("Upload was successfully");
        elementIsDisplayed(successfullyUploadBtn);
        return this;
    }

}

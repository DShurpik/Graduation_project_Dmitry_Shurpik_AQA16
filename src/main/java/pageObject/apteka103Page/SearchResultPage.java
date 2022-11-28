package pageObject.apteka103Page;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.basePage.BasePage;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class SearchResultPage extends BasePage {

    private final By favorite = By.xpath("//div[@class='bookmarkWidget']");
    private final By listMedicineInFavorite = By.xpath("//span[@class='bookmarkList__itemTitle']");
    private final By instuctionBtn = By.xpath("//span[@class='instructionCaption']");
    private final By instructionTitle = By.xpath("//div[@class='instructionPopup__masthead']");
    private final By closeInstructionBtn = By.xpath("//button[@class='PopupWrapper__close']");
    private final By logo = By.xpath("//a[@class='b-header_inner_logo']");

    public SearchResultPage titleHasNameMedicine(String medicineName) {
        String titleActualName = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(medicineName + " Минск", titleActualName);
        log.debug("Title has name of medicine");
        return this;
    }

    public SearchResultPage addMedicineToFavorite(String nameMedicine, Integer count) {
        driver.findElement(By.xpath("//li[meta[@content='" + nameMedicine + "']][" + count + "]//label")).click();
        log.debug("Add medicine by " + nameMedicine + " to favorite");
        return this;
    }

    public SearchResultPage openFavoriteWindow() {
        click(favorite);
        return this;
    }

    public SearchResultPage openInstruction() {
        click(instuctionBtn);
        return this;
    }

    public SearchResultPage titleInstructionIsDisplayed() {
        log.debug("Title in instruction displayed");
        elementIsDisplayed(instructionTitle);
        return this;
    }

    public SearchResultPage closeInstuctionPage() {
        click(closeInstructionBtn);
        log.debug("Close instruction page");
        return this;
    }

    public SearchResultPage logoIsDisplayedAfterCloseInstruction() {
        log.debug("Title in instruction displayed");
        elementIsNotEnabled(logo);
        return this;
    }

    public SearchResultPage checkFavorite(Integer expectedSize, List<String> list) {
        log.debug("Add all medicines from favorite on list");
        List<WebElement> elements = driver.findElements(listMedicineInFavorite);

        Assert.assertEquals(driver.findElements(listMedicineInFavorite).size(), expectedSize);
        log.debug("Сomparing size expected list with actual list");

        List<String> strList = new ArrayList<>();
        for (WebElement element : elements) {
            strList.add(element.getText());
        }
        boolean bool = strList.equals(list);
        Assert.assertTrue(bool);
        return this;
    }
}

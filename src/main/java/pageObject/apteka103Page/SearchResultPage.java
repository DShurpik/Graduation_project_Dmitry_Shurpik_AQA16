package pageObject.apteka103Page;

import org.openqa.selenium.By;
import pageObject.basePage.BasePage;

public class SearchResultPage extends BasePage {

    private final By stars = By.xpath("//li[meta[@content='Аспирин кардио']]" +
            "//*[@class='bookmark__toggleFavoriteIcon bookmark__toggleFavoriteIcon--inactive']");

}

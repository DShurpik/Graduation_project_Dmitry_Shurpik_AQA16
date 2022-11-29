package pageObject.apteka103selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class StartPage {

    private final SelenideElement profileBtn = $(xpath("//div[@class='header__accountWrapper js-account']"));
    private final SelenideElement openProfile = $(xpath("//span[contains(text(),'Профиль')]"));

    public StartPage open() {
        openProfile.should(Condition.enabled).click();
        return this;
    }

    public StartPage openProfile() {
        profileBtn.should(Condition.enabled).click();
        return this;
    }
}

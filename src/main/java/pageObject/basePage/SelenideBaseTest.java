package pageObject.basePage;

import PropertyReader.SelenideListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.util.Properties;

import static PropertyReader.PropertyReader.getProperties;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;


@Listeners(SelenideListener.class)
@Log4j
public class SelenideBaseTest {

    @AfterMethod
    public void closeDriver() {
        Selenide.closeWebDriver();
        log.debug("I'm close driver");
    }

    protected Properties properties;

    protected <T> T get(Class<T> page) {
        // проверка драйвера на состояние. Если драйвер запущен то открывается page
        // иначе через метод open создается драйвер и открывается page
        return driver().hasWebDriverStarted() ? page(page) : open(Configuration.baseUrl, page);
    }

    protected <T> T get(Class<T> page, String url) {
        return driver().hasWebDriverStarted() ? page(page) : open(url, page);
    }


}

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.apteka103Page.SearchResultPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class AddMedicineOnFavorite extends BaseTest {

    @Parameters("medicine1")
    @Test
    public void test1(String medicine1) {
        List<String> expectedResult = new ArrayList<>() {{
            add("Кардиомагнум");
            add("Кардиомагнум");
        }};

        new StartPage()
                .open()
                .searchMedicine(medicine1)
                .clickOnSearchBtn();
        new SearchResultPage()
                .titleHasNameMedicine(medicine1)
                .addMedicineToFavorite(medicine1, 1)
                .addMedicineToFavorite(medicine1, 2)
                .openFavoriteWindow()
                .checkFavorite(2, expectedResult);
    }

    @Parameters("medicine2")
    @Test
    public void test2(String medicine2) {
        List<String> expectedResult = new ArrayList<>() {{
            add("Аспирин кардио");
        }};
        new StartPage()
                .open()
                .searchMedicine(medicine2)
                .clickOnSearchBtn();
        new SearchResultPage()
                .titleHasNameMedicine(medicine2)
                .addMedicineToFavorite(medicine2, 1)
                .openFavoriteWindow()
                .checkFavorite(1, expectedResult);
    }
}

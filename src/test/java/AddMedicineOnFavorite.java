import org.testng.annotations.Test;
import pageObject.apteka103Page.SearchResultPage;
import pageObject.apteka103Page.StartPage;
import pageObject.basePage.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class AddMedicineOnFavorite extends BaseTest {


    @Test
    public void test1() {
        String medicineName = "Кардиомагнум";
        List<String> expectedResult = new ArrayList<>() {{
            add("Кардиомагнум");
            add("Кардиомагнум");
        }};

        new StartPage()
                .open()
                .searchMedicine(medicineName)
                .clickOnSearchBtn();
        new SearchResultPage()
                .titleHasNameMedicine(medicineName)
                .addMedicineToFavorite("Кардиомагнум", 1)
                .addMedicineToFavorite("Кардиомагнум", 2)
                .openFavoriteWindow()
                .checkFavorite(2, expectedResult);
    }


    @Test
    public void test2() {
        String medicineName = "Аспирин кардио";
        List<String> expectedResult = new ArrayList<>() {{
            add("Аспирин кардио");
        }};
        new StartPage()
                .open()
                .searchMedicine(medicineName)
                .clickOnSearchBtn();
        new SearchResultPage()
                .titleHasNameMedicine(medicineName)
                .addMedicineToFavorite("Аспирин кардио", 1)
                .openFavoriteWindow()
                .checkFavorite(1, expectedResult);
    }
}

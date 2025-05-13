package tests.Home;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchHome;

public class TestSearch extends TestBase {

    SearchHome Home;


    @BeforeMethod

    public void setHome() {
        Home = new SearchHome(driver);
    }

    @Test
    public void TestsHomeWithValidData() throws InterruptedException {

        Home.FillSearch("chair");
        Thread.sleep(1000);
        Home.FillCategory("Chairs");
        Home.FillLocation("  ");
        Home.GoClick();
        Thread.sleep(1000);

    }


}

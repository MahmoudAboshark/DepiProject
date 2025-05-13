package tests.Home;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomeProduct;

public class TestProduct extends TestBaseProduct{
    private HomeProduct Home;


    @BeforeMethod
    public void setHome() {
        Home = new HomeProduct(driver);
    }

    @Test
    public void TestsHomeWithValidData() throws InterruptedException {

        Home.productClick();
        Thread.sleep(1000);
        driver.navigate().back();

        Home.chairsProductClick();
        Thread.sleep(1000);
        driver.navigate().back();

        Home.sellersClick();
        Thread.sleep(1000);
        driver.navigate().back();

        Home.latestClick();
        Thread.sleep(1000);
        driver.navigate().back();

        Home.returnToHome();
        Thread.sleep(1000);
        driver.navigate().back();

    }

}

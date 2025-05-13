import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase  {

    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser()
    {
        driver = new EdgeDriver();
        driver.get("https://demo.getmarketspace.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void CloseBrowser()
    {

        driver.close();
    }




}

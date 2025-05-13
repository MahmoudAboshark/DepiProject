package Pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHome extends HomeBase {

    public SearchHome(WebDriver driver){
        super(driver);
    }

    //element locating
    By Searchlocator = By.cssSelector("input[type=\"text\"]");
    By Categorylocator = By.cssSelector("span[class= \"btn btn-default form-control ui-select-toggle\"]");
    By Locationlocator = By.cssSelector("input[type=\"text\"]");
    By Golocator = By.xpath("//div[@class='criteria']");


    public void FillSearch (String search)
    {
        FillData(Searchlocator, search);
    }

    public void FillLocation (String location)
    {
        FillData(Locationlocator ,location);
    }

    public void FillCategory(String CategoryName) throws InterruptedException {
        WaitForElementTOBeClickable(Categorylocator);
        driver.findElement(Categorylocator).click();
        By specificCategory = By.xpath("//ul[contains(@class, 'ui-select-choices')]/li//*[text()='" + CategoryName + "']");
        Thread.sleep(2000);
        WaitForElementTOBeClickable(specificCategory);
        driver.findElement(specificCategory).click();
    }

    public void GoClick()
    {
        ClickButton(Golocator);
    }



}

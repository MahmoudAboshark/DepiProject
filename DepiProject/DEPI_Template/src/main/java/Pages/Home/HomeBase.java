package Pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeBase {

    WebDriver driver;

    public static Duration Wait = Duration.ofSeconds(10);


    public HomeBase (WebDriver driver) {
        this.driver = driver;
    }

    public void WaitForElementTOBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void WaitForElementTOBeClickable(By locator)
    {

        WebDriverWait wait = new WebDriverWait(driver, Wait);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }


    public void ClickButton (By locator) {
        try {
            WaitForElementTOBeVisible(locator);
            WaitForElementTOBeClickable(locator);
            driver.findElement(locator).click();
        }
        catch (Exception e)
        {
            System.out.println("فشل النقر على العنصر: " + locator + "\nالخطأ: " + e.getMessage());
        }
    }
    public void FillData (By locator,String data) {

        WaitForElementTOBeVisible(locator);
        WaitForElementTOBeClickable(locator);

        driver.findElement(locator).sendKeys(data);

    }



}

package Pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductInfo {

    WebDriver driver;
    static WebDriverWait wait;

    public ProductInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //////////////////////// * Name  * //////////////////////////////////

    public static boolean isNameDisplayed() {
        final By name = By.cssSelector("h1");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(name)).isDisplayed();
    }



    ///////////////////////* SocialCount * ///////////////////////////////////////////

    public static boolean isSocialCountDisplayed() {
        final By socialCount = By.className("product-social-counts");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(socialCount)).isDisplayed();
    }







    /////////////////////// * RatingBox * //////////////////////////////////////////

    public static boolean isRatingBoxDisplayed() {
        final By ratingBox = By.className("rating-box");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ratingBox)).isDisplayed();
    }





    ////////////////////////// * product-tag-list * //////////////////////////////////

    public static boolean isProductTagListDisplayed() {
        final By productTagList = By.className("product-tag-list");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTagList)).isDisplayed();
    }

    public void clickOnProductTagList(String productName) {
        WebElement product = driver.findElement(By.xpath("//a[contains(., '" + productName + "')]"));
        product.click();
    }


    public boolean isProductTagPageLoaded(String product) {
        return driver.getCurrentUrl().toLowerCase().contains(product.toLowerCase());
    }




}

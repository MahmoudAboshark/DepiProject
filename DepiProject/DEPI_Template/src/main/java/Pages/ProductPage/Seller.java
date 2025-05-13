package Pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Seller {

    WebDriver driver;
    static WebDriverWait wait;
    public Seller(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    ////////////////// * Displaying * ////////////////////////
    public boolean isSellerSectionDisplayed() {
        final By title = By.xpath("//h2[text()='About the seller']");
        return driver.findElement(title).isDisplayed();
    }


    ////////////////// * Shop Name * ////////////////////////

    public String getShopName() {
        final By shopName = By.cssSelector(".media-heading a");
        return driver.findElement(shopName).getText().trim();
    }


    ////////////////// * Shop Image * ////////////////////////

    public boolean isShopImageDisplayed() {
        final By shopImage = By.cssSelector(".media-object");
        return driver.findElement(shopImage).isDisplayed();
    }


    ////////////////// * Contact Button * ////////////////////////

    public boolean isContactButtonDisplayed() {
        final By contactSellerButton = By.cssSelector("a.btn[href*='/account/messages/create/']");
        return driver.findElement(contactSellerButton).isDisplayed();
    }


    ////////////////// * Shop Description * ////////////////////////

    public String getShopDescription() {
        final By shopDescription = By.cssSelector(".shop-description");
        return driver.findElement(shopDescription).getText().trim();
    }


    /////////////////////// * RatingBox * //////////////////////////////////////////

    public static boolean isRatingBoxDisplayed() {
        final By ratingBox = By.cssSelector(".rating-box img");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ratingBox)).isDisplayed();
    }


    /////////////////////// * Shipping and Return * //////////////////////////////////////////



    public boolean getShippingReturnInfo() {
        final By shippingInfo = By.cssSelector(".about-seller p small");
        return driver.findElement(shippingInfo).isDisplayed();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // * More from this seller * //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






    // * Locators * //
    private final By sectionTitle = By.xpath("//*[contains(text(), 'More from this seller')]");
    private final By productItems = By.cssSelector(".product-list li");


    // * Functions * //
    public boolean isSectionVisible() {
        return driver.findElement(sectionTitle).isDisplayed();
    }

    public int getNumberOfProducts() {
        return driver.findElements(productItems).size();
    }

    public String getProductTitleByIndex(int index) {
        List<WebElement> products = driver.findElements(productItems);
        return products.get(index).findElement(By.cssSelector(".title")).getText().trim();
    }

    public String getProductPriceByIndex(int index) {
        List<WebElement> products = driver.findElements(productItems);
        return products.get(index).findElement(By.cssSelector(".price")).getText().trim();
    }

    public String getProductViewsByIndex(int index) {
        List<WebElement> products = driver.findElements(productItems);
        return products.get(index).findElement(By.cssSelector(".views")).getText().trim();
    }

    public boolean isProductImageDisplayedByIndex(int index) {
        List<WebElement> products = driver.findElements(productItems);
        return products.get(index).findElement(By.cssSelector(".product-image")).isDisplayed();
    }









}

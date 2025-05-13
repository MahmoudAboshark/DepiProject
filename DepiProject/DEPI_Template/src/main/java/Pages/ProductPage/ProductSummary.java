package Pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProductSummary {

    WebDriver driver;
    static WebDriverWait wait;

    public ProductSummary(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By price = By.cssSelector(".price");
    private final By description = By.cssSelector(".product-summary p"); // أول <p> هو الوصف
    private final By quantityInput = By.id("quantity");
    private final By addToCartButton = By.cssSelector(".btn-add-to-cart");



    public String getPriceText() {
        return driver.findElement(price).getText().trim();
    }

    public String getDescriptionText() {
        return driver.findElements(description).get(0).getText().trim();
    }

    public void setQuantity(String quantity) {
        WebElement input = driver.findElement(quantityInput);
        input.clear();
        input.sendKeys(quantity);
    }

    public String getQuantityValue() {
        return driver.findElement(quantityInput).getAttribute("value");
    }

    public boolean isAddToCartEnabled() {
        return driver.findElement(addToCartButton).isEnabled();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }






}

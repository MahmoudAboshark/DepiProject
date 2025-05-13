package Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductsToCart() {
        System.out.println("\n⏳Adding products to the cart...");
        driver.get("https://demo.getmarketspace.com/");

        // Prod
        driver.findElement(By.xpath("//*[@id=\"product-list\"]/div/div/div/div[1]/div/div[2]/ul/li[2]/div/div/a[2]")).click();
        driver.findElement(By.className("btn-add-to-cart")).click();
        driver.navigate().back();

    }

    public void goToCartAndClickCheckout() throws InterruptedException {
        driver.get("https://demo.getmarketspace.com/cart");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.btn-success.btn-lg.btn-checkout")));
        checkoutBtn.click();

    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartProduct {
    public static void addProductsToCart(WebDriver driver) throws InterruptedException {
        System.out.println("\n⏳Adding products to the cart...");
        driver.get("https://demo.getmarketspace.com/");

        addProduct(driver, By.xpath("//*[@id=\"product-list\"]/div/div/div/div[1]/div/div[2]/ul/li[1]/div/div/a[2]"), null);
        addProduct(driver, By.xpath("//*[@id=\"product-list\"]/div/div/div/div[1]/div/div[2]/ul/li[2]/div/div/a[2]"), null);
        addProduct(driver, By.xpath("//*[@id=\"product-list\"]/div/div/div/div[1]/div/div[2]/ul/li[3]/div/div/a[2]"), "3");
        addProduct(driver, By.xpath("//*[@id=\"product-list\"]/div/div/div/div[1]/div/div[2]/ul/li[4]/div/div/a[2]"), "5");

        System.out.println("🛒Finished Adding Products to the cart\n");
        driver.get("https://demo.getmarketspace.com/cart");
    }

    private static void addProduct(WebDriver driver, By productLocator, String quantity) throws InterruptedException {
        WebElement productBtn = driver.findElement(productLocator);
        productBtn.click();

        if (quantity != null) {
            WebElement quantityInput = driver.findElement(By.id("quantity"));
            quantityInput.clear();
            quantityInput.sendKeys(quantity);
        }

        WebElement addToCartBtn = driver.findElement(By.className("btn-add-to-cart"));
        addToCartBtn.click();
        driver.navigate().back();
    }
}
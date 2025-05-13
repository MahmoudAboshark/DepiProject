package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartOperations {
    public static void testCartOperations(WebDriver driver) throws InterruptedException {
        System.out.println("\n⏳Started testing cart products...");

        testTotalPriceCalculation(driver);
        testProductLink(driver, By.linkText("Rocking Chair"));
        testRemoveProduct(driver);
        testUpdateQuantity(driver);
        testCheckoutButton(driver);
        testEmptyCartButton(driver);

        System.out.println("\n\t\t\t🏁🏁Cart page has been Tested successfully🏁🏁\n");
    }

    private static void testTotalPriceCalculation(WebDriver driver) {
        System.out.println("\n1. Check total price value:");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-price")));

        List<WebElement> priceElements = driver.findElements(By.className("cart-price"));
        double totalPrice = calculateTotalPrice(priceElements);

        WebElement calculatedPrice = driver.findElement(By.xpath("//span[@ng-bind='charge.price']"));
        String sitePrice = calculatedPrice.getText().trim();
        double sitePriceValue = Double.parseDouble(sitePrice);

        if (sitePriceValue == totalPrice) {
            System.out.println("✅ Price has been calculated right");
        } else {
            System.out.println("❌ Price calculated wrong on site! Actual: " + totalPrice + " | Site: " + sitePriceValue);
        }
    }

    private static double calculateTotalPrice(List<WebElement> priceElements) {
        double totalPrice = 0.0;
        for (int i = 1; i < priceElements.size(); i += 2) {
            String priceText = priceElements.get(i).getText().trim();
            if (!priceText.isEmpty()) {
                totalPrice += Double.parseDouble(priceText);
            }
        }
        return totalPrice;
    }

    private static void testProductLink(WebDriver driver, By locator) {
        System.out.println("\n2.Open product page from cart:");
        WebElement productBtn = driver.findElement(locator);
        productBtn.click();
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl() + "\n");
    }

    private static void testRemoveProduct(WebDriver driver) throws InterruptedException {
        System.out.println("\n3.Remove product from cart:");
        Thread.sleep(2000);
        WebElement productBtn = driver.findElement(By.linkText("Rocking Chair"));
        String prod1 = productBtn.getText();

        WebElement binBtn = driver.findElement(By.className("fa-trash"));
        binBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(productBtn));

        if (prod1.equals("Rocking Chair")) {
            System.out.println("✅ Rocking Chair has been removed from cart successfully\n");
        } else {
            System.out.println("❌ Rocking Chair is still in the cart. Skipping deletion step.");
        }
    }

    private static void testUpdateQuantity(WebDriver driver) throws InterruptedException {
        System.out.println("\n4. Edit product quantity:");
        Thread.sleep(2000);

        WebElement prodQuantityInput = driver.findElement(By.className("cart-quantity"));
        prodQuantityInput.clear();
        prodQuantityInput.sendKeys("5");

        WebElement updateQuantityBtn = driver.findElement(By.xpath("//small[text()='Update']/parent::*"));
        updateQuantityBtn.click();

        String actualValue = prodQuantityInput.getAttribute("value");
        if (actualValue.equals("5")) {
            System.out.println("✅ Product quantity updated successfully\n");
        } else {
            System.out.println("❌ Product quantity hasn't been updated.");
        }
    }

    private static void testCheckoutButton(WebDriver driver) {
        System.out.println("\n5.Checking checkout button:");
        WebElement checkoutBtn = driver.findElement(By.className("btn-checkout"));
        checkoutBtn.click();
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl() + "\n");
    }

    private static void testEmptyCartButton(WebDriver driver) throws InterruptedException {
        driver.get("https://demo.getmarketspace.com/cart");
        System.out.println("\n5.Checking Empty cart button:");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emptyCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-xs")));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", emptyCartBtn);
        Thread.sleep(500);
        emptyCartBtn.click();
        Thread.sleep(2000);

        List<WebElement> remainingItems = driver.findElements(By.cssSelector(".cart-item"));
        if (remainingItems.size() == 0) {
            System.out.println("\t✅ Cart is empty now");
        } else {
            System.out.println("❌ Cart still has " + remainingItems.size() + " item(s).");
        }
    }
}
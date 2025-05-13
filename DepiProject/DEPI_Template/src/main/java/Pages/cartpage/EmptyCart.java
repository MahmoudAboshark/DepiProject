package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyCart {
    public static void testEmptyCart(WebDriver driver) {
        System.out.println("\n⏳Starting Empty cart test...");
        WebElement startShoppingBtn = driver.findElement(By.linkText("Ready to start shopping?"));
        startShoppingBtn.click();
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl() + "\n");
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl() + "\n");
    }
}
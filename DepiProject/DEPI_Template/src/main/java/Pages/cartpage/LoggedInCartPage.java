package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInCartPage {
    public static void testLoggedInCart(WebDriver driver) throws InterruptedException {
        System.out.println("\n⏳Starting logged in cart test...");
        WebElement accountName = driver.findElement(By.className("user-display-name"));
        System.out.println("1.Account on header");

        testAccountOption(driver, accountName, By.linkText("My Account"), "My Account Page");
        testAccountOption(driver, accountName, By.linkText("Messages"), "Messages Page");
        testAccountOption(driver, accountName, By.linkText("My Purchases"), "My Purchases Page");
        testAccountOption(driver, accountName, By.linkText("Log Out"), "Log Out");

        System.out.println("🔒Logged out successfully!");
        Thread.sleep(5000);
    }

    private static void testAccountOption(WebDriver driver, WebElement accountName,
                                          By optionLocator, String optionName) {
        accountName.click();
        System.out.println("\n\t" + optionName);
        WebElement option = driver.findElement(optionLocator);
        option.click();
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        driver.navigate().back();
    }
}
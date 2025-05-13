package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartNavigation {
    public static void testNavigation(WebDriver driver) {
        System.out.println("\n⏳Starting Nav bar test...");

        testNavigationButton(driver, By.className("label-support"), "1.support Btn");
        testNavigationButton(driver, By.className("fa-shopping-cart"), "2.cart Btn");
        testNavigationButton(driver, By.className("label-login"), "3.login Btn");
        testNavigationButton(driver, By.className("signup-item"), "4.Signup Btn");

        System.out.println("✅Nav bar completed successfully\n");
    }

    private static void testNavigationButton(WebDriver driver, By locator, String buttonName) {
        WebElement button = driver.findElement(locator);
        button.click();
        System.out.println(buttonName + ":");
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl() + "\n");
    }
}
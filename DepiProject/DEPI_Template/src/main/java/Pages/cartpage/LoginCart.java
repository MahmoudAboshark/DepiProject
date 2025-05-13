package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginCart {
    public static void login(WebDriver driver, String email, String password) throws InterruptedException {
        System.out.println("\n⏳logging in...");
        WebElement loginBtn = driver.findElement(By.className("label-login"));
        loginBtn.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement usernameField = driver.findElement(By.id("email"));
        usernameField.sendKeys(email);
        passwordField.sendKeys(password);

        WebElement signLoginBtn = driver.findElement(By.xpath("/html/body/form/div[1]/button"));
        signLoginBtn.click();
        System.out.println("🔓logged in successfully!");
        driver.get("https://demo.getmarketspace.com/cart");
        System.out.println("\n⏪Back to Cart page with account\n");
    }
}
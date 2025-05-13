//package org.example;
package tests;
import org.openqa.selenium.edge.EdgeDriver;

public class cartTest {
    public static void main(String[] args) throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.getmarketspace.com/cart");


//        Cart page
        System.out.println("\n⏳Testing cart page\n");
        org.example.LanguageCart.testLanguages(driver);
        org.example.cartNavigation.testNavigation(driver);
        org.example.FooterCart.testFooter(driver);
        org.example.EmptyCart.testEmptyCart(driver);

        org.example.LoginCart.login(driver, "moaazDepi@testing.com", "mo012345");
        org.example.LoggedInCartPage.testLoggedInCart(driver);
        org.example.cartProduct.addProductsToCart(driver);
        org.example.CartOperations.testCartOperations(driver);

        driver.quit();
    }
}
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguageCart {
    public static void testLanguages(WebDriver driver) throws InterruptedException {
        System.out.println("⏳Starting Languages test...");

        // Spanish
        testLanguageSwitch(driver,
                By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]/div"),
                By.className("label-login"),
                "Iniciar sesión",
                "Spanish");

        // French
        testLanguageSwitch(driver,
                By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]/div"),
                By.className("label-login"),
                "S'identifier",
                "French");

        // English
        testLanguageSwitch(driver,
                By.xpath("//*[@id=\"navbar\"]/div[1]/a[1]/div"),
                By.className("label-login"),
                "Log In",
                "English");

        System.out.println("✅Language Testing completed successfully\n");
    }

    private static void testLanguageSwitch(WebDriver driver, By languageButtonLocator,
                                           By verificationLocator, String expectedText,
                                           String languageName) throws InterruptedException {
        WebElement languageBtn = driver.findElement(languageButtonLocator);
        languageBtn.click();
        Thread.sleep(1000);

        WebElement verificationElement = driver.findElement(verificationLocator);
        String actualText = verificationElement.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("\n🔔Switched to " + languageName + " Successfully");
            System.out.println("login --> \"" + actualText + "\"\n");
        } else {
            System.out.println("❌Failed Switching to " + languageName);
            System.out.println("login --> \"" + actualText + "\"\n");
        }
    }
}
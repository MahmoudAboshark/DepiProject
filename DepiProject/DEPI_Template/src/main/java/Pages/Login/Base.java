package Pages.Login;

import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected ChromeDriver driver;

    protected void initializeDriver() {
        driver = new ChromeDriver();
        driver.get("https://demo.getmarketspace.com/");
        System.out.println("\nWelcome to Website 😍");
    }

    protected void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
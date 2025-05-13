package Pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUp extends Base {
    public void testSignUpFlow() throws InterruptedException {
        initializeDriver();

        By SignUpLocator = By.cssSelector("a[href='/account/create']");
        WebElement SignUpBut = driver.findElement(SignUpLocator);
        SignUpBut.click();

        System.out.println("\n🔔Went to page: " + driver.getCurrentUrl());
        System.out.println("\nCheck Sign up Button");

        By SignUpEmailLocator = By.id("email");
        WebElement SignUpEmail = driver.findElement(SignUpEmailLocator);
        SignUpEmail.sendKeys("Shark7@gmail.com");

        By SignUpPassLocator = By.id("password");
        WebElement SignUpPass = driver.findElement(SignUpPassLocator);
        SignUpPass.sendKeys("@Depi_Team#5");

        By SignUpPassConfirmLocator = By.id("confirmPassword");
        WebElement SignUpPassConfirmed = driver.findElement(SignUpPassConfirmLocator);
        SignUpPassConfirmed.sendKeys("@Depi_Team#5");

        By CreateAccountButtonLocator = By.xpath("//button[@type='submit' and text()='Create account']");
        WebElement CreateAccountButton = driver.findElement(CreateAccountButtonLocator);
        CreateAccountButton.click();
        System.out.println("\nThis is the confirmation page");
        System.out.println("\n🔔Went to page: " + driver.getCurrentUrl());

        By TrueLocation = By.id("acceptCheckbox");
        WebElement True = driver.findElement(TrueLocation);
        True.click();

        By AcceptLocation = By.id("acceptButton");
        WebElement Accept = driver.findElement(AcceptLocation);
        Accept.click();
        System.out.println("\nSign Up completed successfully ✅");
        System.out.println("\nWelcome to Website 😍");
    }
}
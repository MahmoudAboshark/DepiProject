package Pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends Base {
    public void testLoginWithValidCredentials() throws InterruptedException {
        initializeDriver();

        By LoginLocator = By.className("label-login");
        WebElement LoginButton = driver.findElement(LoginLocator);
        LoginButton.click();

        By userNameFiledLocator = By.id("email");
        WebElement userNameFiled = driver.findElement(userNameFiledLocator);
        userNameFiled.sendKeys("depitester1@gmail.com");

        By passwordFiledLocator = By.id("password");
        WebElement passwordFiled = driver.findElement(passwordFiledLocator);
        passwordFiled.sendKeys("@Depi_Team#5");

        By loginButtonLocator = By.className("btn-login");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();

        System.out.println("\nLogin completed successfully ✅");
        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl()+"\n");
        driver.navigate().refresh();
    }

    public void testLoginWithInvalidCredentials() throws InterruptedException {
        By userNameFiledLocator2 = By.id("email");
        WebElement userNameFiled2 = driver.findElement(userNameFiledLocator2);
        userNameFiled2.sendKeys("depitester1@gmail.com");

        By passwordFiledLocator2 = By.id("password");
        WebElement passwordFiled2 = driver.findElement(passwordFiledLocator2);
        passwordFiled2.sendKeys("Testing20");

        Thread.sleep(2000);

        By loginButtonLocator2 = By.className("btn-login");
        WebElement loginButton2 = driver.findElement(loginButtonLocator2);
        loginButton2.click();

        System.out.println("Sorry, we couldn't log you in using this username and password");
    }

    public void testForgotPasswordFlow() throws InterruptedException {
        By forgotPasswordLinkLocator = By.cssSelector("a[href='/account/forgot-password']");
        WebElement forgotPasswordLink = driver.findElement(forgotPasswordLinkLocator);
        forgotPasswordLink.click();

        System.out.println("\n🔔Went to page: " + driver.getCurrentUrl());

        By userNameFiledLocator3 = By.id("email");
        WebElement userNameFiled3 = driver.findElement(userNameFiledLocator3);
        userNameFiled3.sendKeys("depitester1@gmail.com");

        WebElement button = driver.findElement(By.cssSelector(".btn.btn-success.btn-block"));
        button.click();
        System.out.println("\nWe've sent you a password reset email. Please click the link in that email to reset your password within the next 30 minutes.");

        Thread.sleep(2000);
    }
}
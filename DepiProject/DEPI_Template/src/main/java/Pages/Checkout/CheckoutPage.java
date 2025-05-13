package Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    //////////////* Locators *////////////
    By fullNameField = By.xpath("//input[@id='billingName']");
    By emailField = By.id("email");
    By confirmEmailField = By.id("emailConfirm");

    //////////////* Actions *////////////

    public void enterPersonalInfo(String fullName, String email, String confirmEmail) {
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(fullNameField));
        nameInput.clear();
        nameInput.sendKeys(fullName);

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement confirmEmailInput = wait.until(ExpectedConditions.elementToBeClickable(confirmEmailField));
        confirmEmailInput.clear();
        confirmEmailInput.sendKeys(confirmEmail);
    }

    public boolean isEmailConfirmedCorrectly() {
        String email = driver.findElement(emailField).getAttribute("value");
        String confirmEmail = driver.findElement(confirmEmailField).getAttribute("value");

        if (!email.equals(confirmEmail)) {
            // عرض تنبيه باستخدام JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('The email and confirm email do not match!');");
            return false;
        }
        return true;
    }

}






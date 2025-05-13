package Pages.Checkout;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    private void switchToFrameAndEnter(By frameLocator, By inputLocator, String value) {
        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator));
        driver.switchTo().frame(frame);

        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(inputLocator));
        input.sendKeys(value);

        driver.switchTo().defaultContent();}

    public void enterCardHolderName(String name) {
        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paymentName")));
        nameField.sendKeys(name);
    }

    public void enterCardNumber(String cardNumber){
        switchToFrameAndEnter(
                By.cssSelector("iframe[src*='componentName=cardNumber']"),
                By.name("cardnumber"),
                cardNumber
        );
    }
    public void enterCardExpiry(String expiryDate) {
        switchToFrameAndEnter(
                By.cssSelector("iframe[src*='componentName=cardExpiry']"),
                By.name("exp-date"),
                expiryDate
        );
    }

    public void enterCardCVC(String cvc) {
        switchToFrameAndEnter(
                By.cssSelector("iframe[src*='componentName=cardCvc']"),
                By.name("cvc"),
                cvc
        );
    }

    public void enterAllCardDetails(String name,String number, String expiry, String cvc) {
        enterCardHolderName(name);
        enterCardNumber(number);
        enterCardExpiry(expiry);
        enterCardCVC(cvc);
    }
}


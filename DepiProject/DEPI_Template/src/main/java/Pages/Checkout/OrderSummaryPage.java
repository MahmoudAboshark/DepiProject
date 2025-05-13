package Pages.Checkout;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderSummaryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    ///////////////* Locators *////////////
    By placeOrderButton = By.cssSelector("button.btn-place-order");
    By notesToSellerTextarea = By.name("notes");
    By shippingRadioBtn = By.cssSelector("input.shipping-option-radio[value='Courier']");
    By termsCheckbox = By.id("termsAccepted");
    By loadingIndicator = By.cssSelector(".loading-spinner");

    ///////////////* Actions *////////////

    public void selectCourierShippingOption() {
        try {
            waitForAngular();
            WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(shippingRadioBtn));

            if (!radioBtn.isSelected()) {
                js.executeScript("arguments[0].click();", radioBtn);
                wait.until(d -> radioBtn.isSelected());
                System.out.println("✅ Successfully selected Courier shipping option");
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to select Courier shipping option: " + e.getMessage());
            throw e;
        }
    }

    public void writeNoteToSeller(String note) {
        try {
            WebElement noteField = wait.until(ExpectedConditions.visibilityOfElementLocated(notesToSellerTextarea));
            // noteField.clear();
            noteField.sendKeys(note);
            System.out.println("✅ Note to seller added: " + note);
        } catch (Exception e) {
            System.err.println("❌ Failed to add note to seller: " + e.getMessage());
            throw e;
        }
    }

    public boolean isPlaceOrderButtonEnabled() {
        try {
            waitForAngular();
            waitForLoadingToComplete();
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderButton));
            return button.isEnabled();
        } catch (Exception e) {
            System.err.println("❌ Error checking Place Order button status: " + e.getMessage());
            return false;
        }
    }

    public void placeOrder() {
        try {
            waitForPlaceOrderButtonToBeClickable();
            WebElement button = driver.findElement(placeOrderButton);
            js.executeScript("arguments[0].click();", button);
            System.out.println("✅ Place Order button clicked");
            waitForLoadingToComplete();
        } catch (Exception e) {
            System.err.println("❌ Failed to click Place Order button: " + e.getMessage());
            throw e;
        }
    }

    public void acceptTermsAndConditions() {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));

            if (!checkbox.isSelected()) {
                js.executeScript("arguments[0].click();", checkbox);
                wait.until(d -> checkbox.isSelected());
                System.out.println("✅ Terms and conditions accepted");
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to accept terms and conditions: " + e.getMessage());
            throw e;
        }
    }

    ///////////////* Helper Methods *////////////

    private void waitForAngular() {
        try {
            js.executeAsyncScript(
                    "var callback = arguments[arguments.length - 1];" +
                            "if (window.angular) {" +
                            "  angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);" +
                            "} else { callback(); }");
        } catch (Exception e) {
            System.out.println("⚠️ Angular wait skipped (Angular not detected)");
        }
    }

    private void waitForLoadingToComplete() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
        } catch (Exception e) {
            System.out.println("⚠️ No loading indicator found or already disappeared");
        }
    }

    private void waitForPlaceOrderButtonToBeClickable() {
        wait.until(driver -> {
            try {
                WebElement button = driver.findElement(placeOrderButton);
                return button.isDisplayed() && button.isEnabled();
            } catch (Exception e) {
                return false;
            }
        });
    }
}

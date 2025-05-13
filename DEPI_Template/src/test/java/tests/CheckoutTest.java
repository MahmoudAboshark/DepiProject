package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.Checkout.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.getmarketspace.com/cart");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testFullCheckoutFlow() throws InterruptedException {

        ///////////////* CartPage*////////////////

        CartPage cartPage = new CartPage(driver);
        cartPage.addProductsToCart();
        cartPage.goToCartAndClickCheckout();
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        Thread.sleep(10000);

        ///////////////* CheckoutPage *////////////////

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterPersonalInfo("amina allam", "ali@example.com", "ali@example.com");
        Assert.assertTrue(checkout.isEmailConfirmedCorrectly(), " Emails do not match ❌!");


        /////////////* AddressPage*////////////////


        AddressPage addressPage = new AddressPage(driver);
        addressPage.enterAddress("123 Main St", "Cairo", "12345", "Egypt", "Nas City");

// تحقق إن الدولة المختارة مظبوطة
        WebElement dropdown = driver.findElement(By.id("billingCountry"));
        Select select = new Select(dropdown);
        String selected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selected, "Egypt", "✅ يجب أن تكون الدولة المختارة هي Egypt");

// التحقق من وجود حقل المحافظة بناءً على الدولة
        try {
            WebElement provinceField = driver.findElement(By.id("billingProvinceInput"));
            Assert.assertTrue(provinceField.isDisplayed(), "✅ يجب أن يظهر حقل المحافظة بعد اختيار الدولة.");
        } catch (NoSuchElementException e) {
            System.err.println("❌ لم يتم العثور على حقل المحافظة.");
            Assert.fail("❌ لم يتم العثور على حقل المحافظة.");
        }


        addressPage.toggleSameAddress(true);
        Assert.assertTrue(addressPage.isSameAddressSelected(),
                "Checkbox should be checked after toggle");

        ///////////////* PaymentPage *////////////////

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterAllCardDetails("Ali Hassan", "4242 4242 4242 4242", "12/26", "123");
        driver.switchTo().defaultContent();

        ///////////////* OrderSummury *////////////////

        OrderSummaryPage summary = new OrderSummaryPage(driver);

        try {
            // 1. Select shipping option (تم إعادة تمكينه)
            summary.selectCourierShippingOption();

            // 2. Verify shipping option is selected
            By shippingRadioBtn = By.cssSelector("input.shipping-option-radio[value='Courier']");
            Boolean radioBtn = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeSelected(shippingRadioBtn));
            System.out.println("✅ Verified Courier shipping option is selected");

            // 3. Enter note to seller
            String testNote = "Please deliver quickly.";
            summary.writeNoteToSeller(testNote);
            System.out.println("✅ Added note to seller: " + testNote);

            // 4. Accept terms and conditions (يجب أن يكون قبل التحقق من الزر)
            summary.acceptTermsAndConditions();
            System.out.println("✅ Accepted terms and conditions");

            // 5. Wait for button to become enabled (إضافة انتظار صريح)
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> summary.isPlaceOrderButtonEnabled());

            // 6. Verify place order button is enabled
            Assert.assertTrue(summary.isPlaceOrderButtonEnabled(),
                    "Place Order button should be enabled after filling all requirements");

            // 7. Place the order
            summary.placeOrder();
            System.out.println("✅ Clicked Place Order button");

            // 8. Wait for and verify order confirmation

            //✅ انتظري الصفحة الصحيحة (checkout/success)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-place-order")));

            // placeOrderBtn.click();
            wait.until(ExpectedConditions.urlContains("/checkout/success/"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/checkout/success/"),
                    "❌ ما اتحولتش للصفحة النهائية");
        } catch (Exception e) {
            // Capture screenshot for debugging
            //  takeScreenshot(driver, "order_placement_error");
            Assert.fail("❌ Test failed due to exception: " + e.getMessage());
        }

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}


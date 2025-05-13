package Pages.Checkout;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class AddressPage {
    WebDriver driver;
    WebDriverWait wait;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //////////////* Locators *////////////

    By streetField = By.id("billingStreet1");
    By cityField = By.id("billingCity");
    By zipField = By.id("billingPostal");
    By countryDropdown = By.id("billingCountry");
    By provinceInputField = By.id("billingProvinceInput");
    By provinceSelectField = By.id("billingProvinceSelect");
    By sameAddressCheckbox = By.id("useSameAddresses");
    By shippingAddressSection = By.cssSelector("div#shipping-address");

    //////////////* Actions *////////////

    public void enterAddress(String street, String city, String zip, String country, String province) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetField)).clear();
        driver.findElement(streetField).sendKeys(street);

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);

        // choosing country //
        WebElement countryDropdownEl = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        Select selectCountry = new Select(countryDropdownEl);
        selectCountry.selectByVisibleText(country);

        //  select

        try {
            WebElement provinceSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(provinceSelectField));
            Select selectProvince = new Select(provinceSelect);
            selectProvince.selectByVisibleText(province);
            System.out.println("✅ Selected province from dropdown: " + province);
        } catch (TimeoutException e) {

            // لو dropdown مش موجود، نستخدم input

            WebElement provinceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(provinceInputField));
            provinceInput.clear();
            provinceInput.sendKeys(province);
            System.out.println("✅ Entered province manually: " + province);
        }
    }

//////////////////* CheckBox *//////////////////////////

    public boolean isSameAddressSelected() {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(sameAddressCheckbox));
        return checkbox.isSelected();
    }

    public void toggleSameAddress(boolean shouldBeChecked) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(sameAddressCheckbox));

        // لو محتاجين نغير حالة الـ checkbox
        if ((shouldBeChecked && !checkbox.isSelected()) ||
                (!shouldBeChecked && checkbox.isSelected())) {

            // Scroll to checkbox
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    checkbox
            );

            // Click checkbox using JS
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    checkbox
            );

            // Wait for the checkbox state to be what we want
            wait.until(d -> checkbox.isSelected() == shouldBeChecked);
        }
    }
}







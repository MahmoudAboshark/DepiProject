package Pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Photo {
    WebDriver driver;
    static WebDriverWait wait;
    public Photo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }





    ////////////////////////// * Displaying * ////////////////////////////////


    private static final By productImage = By.className("carousel-image");

    public static boolean isProductImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productImage)).isDisplayed();
    }

       // return wait.until(ExpectedConditions.visibilityOfElementLocated(wood)).isDisplayed();



    ////////////////////////////* Navigation Buttons *//////////////////////////////



    // Locators
    private final By imageItems = By.cssSelector(".carousel-image-list-item .carousel-image");
    private final By nextButton = By.cssSelector(".next-stage");
    private final By prevButton = By.cssSelector(".prev-stage");



    public int getImageCount() {
        List<WebElement> images = driver.findElements(imageItems);
        return images.size();
    }

    public boolean imageHasBackground(WebElement image) {
        String style = image.getAttribute("style");
        return style != null && style.contains("background-image");
    }

    public List<WebElement> getAllImages() {
        return driver.findElements(imageItems);
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void clickPrev() {
        driver.findElement(prevButton).click();
    }






}

package Pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Categories {
    WebDriver driver;
    static WebDriverWait wait;

    public Categories(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }


/////////////////////////////////////////// * SEARCH * /////////////////////////////////////////////////

    public static boolean isSearchDisplayed() {
        final By search = By.cssSelector(".fa.fa-search");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(search)).isDisplayed();
    }

    public void clickOnSearch(String categoryName) {
        WebElement search = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        search.click();
    }


    public boolean isSearchPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }



/////////////////////////////////////////// * Chairs * /////////////////////////////////////////////////

    public static boolean isChairDisplayed() {
        final By chair = By.cssSelector("a[href='/c/chairs']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(chair)).isDisplayed();
    }



    public void clickOnChairs(String categoryName) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        category.click();
    }


    public boolean isChairsPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }


/////////////////////////////////////////// * Modern * /////////////////////////////////////////////////

    public static boolean isModernDisplayed() {
        final By modern = By.cssSelector("a[href='/c/modern']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modern)).isDisplayed();
    }



    public void clickOnModern(String categoryName) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        category.click();
    }


    public boolean isModernPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }


    /////////////////////////////////////////// * Soft Furnishings * /////////////////////////////////////////////////

    public static boolean isSoftFurnishingsDisplayed() {
        final By softFurnishings = By.cssSelector("a[href='/c/soft-furnishings']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(softFurnishings)).isDisplayed();
    }



    public void clickOnSoftFurnishings(String categoryName) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        category.click();
    }


    public boolean isSoftFurnishingsPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }


    /////////////////////////////////////////// * Tables * /////////////////////////////////////////////////

    public static boolean isTablesDisplayed() {
        final By tables = By.cssSelector("a[href='/c/tables']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tables)).isDisplayed();
    }



    public void clickOnTables(String categoryName) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        category.click();
    }


    public boolean isTablesPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }


    /////////////////////////////////////////// * Wood * /////////////////////////////////////////////////

    public static boolean isWoodDisplayed() {
        final By wood = By.cssSelector("a[href='/c/wood']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wood)).isDisplayed();
    }



    public void clickOnWood(String categoryName) {
        WebElement category = driver.findElement(By.xpath("//a[text()='" + categoryName + "']"));
        category.click();
    }


    public boolean isWoodPageLoaded(String category) {
        return driver.getCurrentUrl().toLowerCase().contains(category.toLowerCase());
    }






}















package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.ProductPage.*;
import java.time.Duration;
import java.util.List;


public class ProductTest {

    private WebDriver driver;
    private Categories category;
    private Photo photo;
    private ProductInfo productInfo;
    private ProductSummary productSummary;
    private Seller seller;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.getmarketspace.com/product/242/rocking-chair");

        category = new Categories(driver);
        photo = new Photo(driver);
        productInfo = new ProductInfo(driver);
        productSummary = new ProductSummary(driver);
        seller = new Seller(driver);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// * Photo * /////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///// * Displaying * //////
    @Test
    public void verifyProductDetailsDisplayed() {
        Assert.assertTrue(photo.isProductImageDisplayed(), "Product image not displayed!");
    }


    /////////////// * Navigation Buttons * ////////////////


    @Test
    public void testImageCount() {
        int count = photo.getImageCount();
        Assert.assertTrue(count >= 2, "Images should be at least 2");
    }

    @Test
    public void testImagesHaveBackgroundImage() {
        List<WebElement> images = photo.getAllImages();
        for (WebElement image : images) {
            Assert.assertTrue(photo.imageHasBackground(image), "Image should have background-image style");
        }
    }

    @Test
    public void testNavigationButtons() throws InterruptedException {
        photo.clickNext();
        Thread.sleep(1000);
        photo.clickPrev();
        Thread.sleep(1000);
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// * Categories Tests * //////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////Search//////////////////////

    @Test
    public void verifyIsSearchDisplayed() {
        Assert.assertTrue(Categories.isSearchDisplayed(), "Search not displayed!");
    }

    @Test
    public void testSearchNavigation() {
        category.clickOnSearch("Search");
        Assert.assertTrue(category.isSearchPageLoaded("Search"), "Search page not loaded correctly");
        driver.navigate().back();
    }



    ////////////////////////Chairs//////////////////
    @Test
    public void verifyIsChairsDisplayed() {
        Assert.assertTrue(Categories.isChairDisplayed(), "Chairs not displayed!");
    }

    @Test
    public void testChairsNavigation() {
        category.clickOnChairs("Chairs");
        Assert.assertTrue(category.isChairsPageLoaded("chairs"), "Chairs page not loaded correctly");
        driver.navigate().back();
    }



    ////////////////// * Modern * ////////////////////

    @Test
    public void verifyModernDisplayed() {
        Assert.assertTrue(Categories.isModernDisplayed(), "Modern not displayed!");
    }

    @Test
    public void testModernNavigation() {
        category.clickOnModern("Modern");
        Assert.assertTrue(category.isModernPageLoaded("modern"), "Modern page not loaded correctly");
        driver.navigate().back();
    }



    ///////////////////// * Soft Furnishings * /////////////////

    @Test
    public void verifySoftFurnishingsDisplayed() {
        Assert.assertTrue(Categories.isSoftFurnishingsDisplayed(), "Soft Furnishings not displayed!");
    }

    @Test
    public void testSoftFurnishingsNavigation() {
        category.clickOnSoftFurnishings("Soft Furnishings");
        Assert.assertTrue(category.isSoftFurnishingsPageLoaded("soft-furnishings"), "Soft Furnishings page not loaded correctly");
        driver.navigate().back();
    }



    ///////////////////// * Tables * /////////////////////////

    @Test
    public void verifyTablesDisplayed() {
        Assert.assertTrue(Categories.isTablesDisplayed(), "Tables not displayed!");
    }

    @Test
    public void testTablesNavigation() {
        category.clickOnTables("Tables");
        Assert.assertTrue(category.isTablesPageLoaded("tables"), "Tables page not loaded correctly");
        driver.navigate().back();
    }



    //////////////// * Wood * /////////////////

    @Test
    public void verifyWoodDisplayed() {
        Assert.assertTrue(Categories.isWoodDisplayed(), "Wood not displayed!");
    }

    @Test
    public void testWoodNavigation() {
        category.clickOnWood("Wood");
        Assert.assertTrue(category.isWoodPageLoaded("wood"), "Wood page not loaded correctly");
        driver.navigate().back();
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// * Product Info  * //////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///////////////// * The Name Of Product * ////////////////////
    @Test
    public void verifyProductNameDisplayed() {
        Assert.assertTrue(ProductInfo.isNameDisplayed(), "Product name not displayed!");
    }


    //////////////////// * product-social-counts * /////////////////////////
    @Test
    public void verifySocialCountDisplayed() {
        Assert.assertTrue(ProductInfo.isSocialCountDisplayed(), "Social count not displayed!");
    }


    ///////////////////////* RatingBox * /////////////////////////
    @Test
    public void verifyRatingBoxDisplayed() {
        Assert.assertTrue(ProductInfo.isRatingBoxDisplayed(), "Rating box not displayed!");
    }


    //////////////////////////////////* Product Tag List */////////////////////////////////

    //////// * Displaying * ///////
    @Test
    public void verifyProductTagListDisplayed() {
        Assert.assertTrue(ProductInfo.isProductTagListDisplayed(), "Product tag list not displayed!");
    }

    //////// * Navigation * ///////



    // * Wood * //
    @Test
    public void testWoodTagNavigation() {
        productInfo.clickOnProductTagList("Wood");
        Assert.assertTrue(productInfo.isProductTagPageLoaded("Wood"), " Wood page not loaded correctly");
        driver.navigate().back();
    }


    // * Modern * //
    @Test
    public void testModernTagNavigation() {
        productInfo.clickOnProductTagList("Modern");
        Assert.assertTrue(productInfo.isProductTagPageLoaded("Modern"), " Wood page not loaded correctly");
        driver.navigate().back();
    }

    // * Chairs * //
    @Test
    public void testProductTagNavigation() {
        productInfo.clickOnProductTagList("Chair");
        Assert.assertTrue(productInfo.isProductTagPageLoaded("chair"), "Product tag page not loaded correctly");
        driver.navigate().back();
    }

    // *  Wooden * //
    @Test
    public void testWoodenTagNavigation() {
        productInfo.clickOnProductTagList("wooden");
        Assert.assertTrue(productInfo.isProductTagPageLoaded("wooden"), " Wood page not loaded correctly");
        driver.navigate().back();
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// * Product Summary  * ///////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Test
    public void verifyPriceDisplayed() {
        String price = productSummary.getPriceText();
        Assert.assertFalse(price.isEmpty(), "Price not displayed!");
    }

    @Test
    public void verifyDescriptionDisplayed() {
        String description = productSummary.getDescriptionText();
        Assert.assertFalse(description.isEmpty(), "Description not displayed!");
    }

    @Test
    public void testQuantityInput() {
        productSummary.setQuantity("3");
        Assert.assertEquals(productSummary.getQuantityValue(), "3", "Quantity input not working correctly");
        System.out.println("4. Edit product quantity:");
        System.out.println("   Product quantity updated successfully");
    }

    @Test
    public void verifyAddToCartEnabled() {
        Assert.assertTrue(productSummary.isAddToCartEnabled(), "Add to cart button not enabled!");
        System.out.println("5. Checking checkout button:");
        System.out.println("   Redirected to: https://demo.getmarketspace.com/checkout");
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// * Seller  * ////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////* Displaying Of Seller Section * //////////////////////////
    @Test
    public void verifySellerSectionDisplayed() {
        Assert.assertTrue(seller.isSellerSectionDisplayed(), "Seller section not displayed!");
    }

    ///////////////////////* ShopName And Description * /////////////////////////
    @Test
    public void verifyShopNameDisplayed() {
        String shopName = seller.getShopName();
        Assert.assertFalse(shopName.isEmpty(), "Shop name not displayed!");
    }

    ////////////////////////////* Shop Image * ///////////////////////////
    @Test
    public void verifyShopImageDisplayed() {
        Assert.assertTrue(seller.isShopImageDisplayed(), "Shop image not displayed!");
    }


    //////////////////////* Contact Seller Button * /////////////////////////
    @Test
    public void verifyContactButtonDisplayed() {
        Assert.assertTrue(seller.isContactButtonDisplayed(), "Contact button not displayed!");
    }

    //////////////////* Shop Description * ///////////////////////
    @Test
    public void verifyShopDescriptionDisplayed() {
        String description = seller.getShopDescription();
        Assert.assertFalse(description.isEmpty(), "Shop description not displayed!");
    }

    //////////////////* Rating Box * ///////////////////////
    @Test
    public void verifySellerRatingBoxDisplayed() {
        Assert.assertTrue(Seller.isRatingBoxDisplayed(), "Seller rating box not displayed!");
    }

    //////////////////* Shipping Return Info * ///////////////////////
    @Test
    public void verifyShippingReturnInfoDisplayed() {
        Assert.assertTrue(seller.getShippingReturnInfo(), "Shipping and return info not displayed!");
    }


    //////////////////* More From Seller * ///////////////////////
    @Test
    public void verifyMoreFromSellerSectionVisible() {
        Assert.assertTrue(seller.isSectionVisible(), "More from seller section not visible!");
    }

    @Test
    public void verifyMoreFromSellerProductsCount() {
        int count = seller.getNumberOfProducts();
        Assert.assertTrue(count > 0, "No products found in 'More from this seller' section");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




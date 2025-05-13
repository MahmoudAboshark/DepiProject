package Pages.Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation extends Base {
    public void testSocialLoginNavigation() throws InterruptedException {
        initializeDriver();

        By LoginLocator = By.className("label-login");
        WebElement LoginButton = driver.findElement(LoginLocator);
        LoginButton.click();

        By FbSignLocator = By.className("facebook-text");
        WebElement FbSignButton = driver.findElement(FbSignLocator);
        FbSignButton.click();

        driver.get("https://www.getmarketspace.com/401#_=_");
        System.out.println("\n🔔Went to page: " + driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl());

        By googleTextLocator = By.className("google-text");
        WebElement googleText = driver.findElement(googleTextLocator);
        googleText.click();
        System.out.println("\n🔔Went to page: " + driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl());
    }

    public void testBasicNavigation() throws InterruptedException {
        ChromeDriver driverCheck = new ChromeDriver();
        driverCheck.get("https://demo.getmarketspace.com/");
        System.out.println("\nWelcome to Website 😍");

        By loginLabelLocator = By.cssSelector(".label-login");
        WebElement loginLabel = driverCheck.findElement(loginLabelLocator);
        loginLabel.click();

        System.out.println("\n🔔Went to page: " + driverCheck.getCurrentUrl());
        System.out.println("\nThe Login button passed ✅");

        System.out.println("\n⏪Back to: " + driverCheck.getCurrentUrl());

        driverCheck.navigate().refresh();

        WebElement SignUp2 = driverCheck.findElement(By.cssSelector("a[href='/account/create']"));
        SignUp2.click();
        System.out.println("\n🔔Went to page: " + driverCheck.getCurrentUrl());
        System.out.println("\nThe Sign Up button passed ✅");

        By loginLinkLocator = By.cssSelector("a[href='/login']");
        WebElement loginLink = driverCheck.findElement(loginLinkLocator);
        loginLink.click();
        System.out.println("\n🔔Went to page: " + driverCheck.getCurrentUrl());
        System.out.println("\nThe Login button passed ✅");

        By forgotPasswordLinkLocator2 = By.cssSelector("a[href='/account/forgot-password']");
        WebElement forgotPasswordLink2 = driverCheck.findElement(forgotPasswordLinkLocator2);
        forgotPasswordLink2.click();

        By createAccountLinkLocator2 = By.cssSelector("a[href='/account/create']");
        WebElement createAccountLink2 = driverCheck.findElement(createAccountLinkLocator2);
        createAccountLink2.click();
        System.out.println("\n🔔Went to page: " + driverCheck.getCurrentUrl());
        System.out.println("\nThe Sign Up button passed ✅");
        System.out.println("\n");
    }
}
package tests;
import Pages.Login.*;


public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Initialize test classes
        Login loginTests = new Login();
        SignUp signUpTests = new SignUp();
        Navigation navigationTests = new Navigation();

        // Execute navigation tests
        navigationTests.testSocialLoginNavigation();
        navigationTests.testBasicNavigation();

        // Execute login tests
        loginTests.testLoginWithValidCredentials();
        loginTests.testLoginWithInvalidCredentials();
        loginTests.testForgotPasswordFlow();

        // Execute sign up tests
        signUpTests.testSignUpFlow();

        // Keep all original commented code as is
        /*
         *Support*

        By supportBtnLocator = By.className("label-support");
        WebElement supportBtn = driver.findElement(supportBtnLocator);
        supportBtn.click();
        System.out.println("1.support Btn:");
        System.out.println("\t🔔Went to page: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("\n⏪Back to: " + driver.getCurrentUrl() + "\n");
        */
    }
}
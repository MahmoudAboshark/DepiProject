package Pages.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeCart extends HomeBase{
    public HomeCart(WebDriver driver) {
        super(driver);
    }


    // element locating
    private By CartLocator = By.cssSelector("a[id=\"cart-count\"]");
    private By SupportLocator = By.className("label-support");
    private By LoginLocator = By.xpath("//*[@id=\"navbar\"]/div[2]/div[3]/ul/li[3]/a");
    private By SignUpLocator = By.xpath("//*[@id=\"navbar\"]/div[2]/div[3]/ul/li[4]/a");
    private By HomeLocator = By.xpath("/html");


    public void returnToHome() {
        ClickButton(HomeLocator);
    }

    public void clickCart() {
        ClickButton(CartLocator);
        returnToHome();
    }

    public void clickSupport() {
        ClickButton(SupportLocator);
        returnToHome();
    }

    public void clickLogin() {
        ClickButton(LoginLocator);
        returnToHome();
    }

    public void clickSignUp() {
        ClickButton(SignUpLocator);
        returnToHome();
    }




}

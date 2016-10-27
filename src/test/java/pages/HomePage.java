package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private WebDriver driver;

    public static String Url = URL;

    @FindBy(id = "nav-link-yourAccount")
    private WebElement accountZone;

    @FindBy(xpath = "//*[@id=\"nav-flyout-ya-newCust\"]/a")
    private WebElement registerLink;

    @FindBy(xpath = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
    private WebElement loginLink;

    @FindBy(id = "nav-item-signout")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"nav-link-yourAccount\"]/span[1]")
    private WebElement userName;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        Actions action1 = new Actions(driver);
        action1.moveToElement(accountZone).clickAndHold(loginLink).build().perform();
        action1.release(accountZone).perform();
        loginLink.click();
    }

    public void clickLogoutLink() {
        Actions action1 = new Actions(driver);
        action1.moveToElement(accountZone).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public void clickRegisterLink() {
        Actions action1 = new Actions(driver);
        action1.moveToElement(accountZone).clickAndHold(registerLink).build().perform();
        action1.release(accountZone).perform();
        registerLink.click();
    }

    public boolean userNameIsDisplayed() {
        return logoutLink.isDisplayed();
    }

}

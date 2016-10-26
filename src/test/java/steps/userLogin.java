package steps;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import common.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;



public class UserLogin {
    WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    private  LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    @Step("Open Amazon homepage")
    public void navigationHomepage() {
        driver.get(HomePage.Url);
        driver.manage().window().maximize();
    }

    @Step("Input username and password")
    public void loginAmazon() {
        homePage.clickLogin();
        loginPage.inputCredentials();
    }

    @Step("Welcome words showed on page")
    public void welcomeWord() {
        Gauge.writeMessage("确认登陆成功");
        Assert.assertEquals("您好, Qa", homePage.userNameIsDisplayed());
    }

    @Step("Log out")
    public void logOut() {
        homePage.clickLogoutLink();
    }

    @Step("Input <username> and <password>")
    public void loginConcept(String username, String password) {
        driver.findElement(By.id("nav-link-yourAccount")).click();
        WebElement userName = driver.findElement(By.id("ap_email"));
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.id("ap_password"));
        passWord.sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }
}
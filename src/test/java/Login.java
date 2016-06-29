/**
 * Created by yddu on 6/17/16.
 */

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

public class Login {
    WebDriver driver = DriverFactory.getDriver();

    @Step("Open Amazon homepage")
    public void navigationHomepage() {
        driver.get("https://www.amazon.cn/");
    }

    @Step("Input username and password")
    public void loginAmazon() {
        driver.findElement(By.id("nav-link-yourAccount")).click();
        WebElement userName = driver.findElement(By.id("ap_email"));
        userName.sendKeys("yadidu813@gmail.com");
        WebElement passWord = driver.findElement(By.id("ap_password"));
        passWord.sendKeys("YD123456");
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Step("Welcome words showed on page")
    public void welcomeWord() {
        Gauge.writeMessage("确认登陆成功");
        WebElement word = driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]"));
        String sring = word.getText();
        Assert.assertEquals("您好, Yadi", sring);
    }

    @Step("Log out")
    public void logOut() {
        Actions builder = new Actions(driver);
        WebElement submenu = driver.findElement(By.id("nav-link-yourAccount"));
        builder.moveToElement(submenu).perform();
        driver.findElement(By.id("nav-item-signout")).click();
        driver.close();
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

import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.Step;

/**
 * Created by yddu on 6/20/16.
 */
public class SearchProduct {
    WebDriver driver = DriverFactory.getDriver();

    @Step("Search <mac pro>")
    public void searchProduct(String product) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(product);
        driver.findElement(By.className("nav-input")).click();
    }

    @Step("Can find <Apple MacBook Pro> in result page")
    public void searchResult(String result) {
        WebElement searchResult = driver.findElement(By.id("result_0"));
        String string = searchResult.getText();
        Assert.assertTrue(string.contains(result));
    }
}

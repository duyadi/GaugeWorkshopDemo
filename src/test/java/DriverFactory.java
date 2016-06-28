import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by yddu on 6/20/16.
 */
public class DriverFactory {
    private static WebDriver driver;

    public static final WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        try {
            driver.getWindowHandles();
        } catch (Exception exception) {
            driver = new ChromeDriver();
        }

        return driver;
    }
}

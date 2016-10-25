package common;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver;

    @BeforeScenario
    public static WebDriver getDriver() {
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

    @AfterScenario
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}

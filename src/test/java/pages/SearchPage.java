package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yddu on 10/28/16.
 */
public class SearchPage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(className = "nav-input")
    private WebElement searchButton;

    @FindBy(id = "result_1")
    private WebElement secondResult;


    public void searchPro(String prod){
        searchBox.sendKeys(prod);
        searchButton.click();
    }

    public String searchFirstResult(String result){
        return secondResult.getText();
    }
}

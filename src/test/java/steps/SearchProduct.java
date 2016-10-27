package steps;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.SearchPage;

import static common.DriverFactory.driver;


public class SearchProduct {
    private SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @Step("Search <mac pro>")
    public void searchProduct(String product) {
        searchPage.searchPro(product);
    }

    @Step("Can find <Apple MacBook Pro> in result page")
    public void searchResult(String result) {
        String string = searchPage.searchFirstResult(result);
        Assert.assertTrue(string.contains(result));
    }
}

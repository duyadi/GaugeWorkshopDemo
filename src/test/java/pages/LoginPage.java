package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "ap_email")
    private WebElement userName;

    @FindBy(id = "ap_password")
    private  WebElement userPw;

    @FindBy(id = "signInSubmit")
    private WebElement loginButton;

    @FindBy(css = ".a-icon.a-icon-logo-china")
    private WebElement homePageLink;

    @FindBy(id = "createAccountSubmit")
    private WebElement clickCreateAccountButton;


    public void inputCredentials() {
        userName.sendKeys("qalearningplan@163.com");
        userPw.sendKeys("Qa123456");
        loginButton.click();
    }

    public void clickHomePageLink() {
        homePageLink.click();
    }

    public void clickCreateAccountButton(){
        clickCreateAccountButton.click();
    }
}

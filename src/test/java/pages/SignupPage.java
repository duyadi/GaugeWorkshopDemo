package pages;

import com.thoughtworks.gauge.TableRow;
import common.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SignupPage {
    @FindBy(id = "ap_use_email")
    private WebElement mailWay;

    @FindBy(id = "ap_customer_name")
    private WebElement accountName;

    @FindBy(id = "ap_email")
    private WebElement accountEmail;

    @FindBy(id = "ap_password")
    private WebElement accountPw;

    @FindBy(name = "legalAgreementCheckBox")
    private WebElement legalAgreementCheckBox;

    @FindBy(id = "ap_register_form")
    private WebElement signUpForm;

    public void chooseEmailWay(){
        mailWay.click();
    }

    public void inputAccountInfo(String Name, String mailBox, String password){
        accountName.sendKeys(Name);
        accountEmail.sendKeys(mailBox);
        accountPw.sendKeys(password);
        legalAgreementCheckBox.click();
    }

    public void clickSignUpButton(){
        signUpForm.submit();

    }

    public void inputAccountName(String Name){
        accountName.sendKeys(Name);
    }

    public void inputAccountEmail(String mailBox){
        accountEmail.sendKeys(mailBox);
    }

    public void inputAccountPw(String password) {
        accountPw.sendKeys(password);
    }

    public void legalAgreement(){
        legalAgreementCheckBox.click();
    }
}

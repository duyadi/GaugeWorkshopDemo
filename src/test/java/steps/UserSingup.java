package steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import common.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;



import static common.DriverFactory.driver;


public class UserSingup {
    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    private SignupPage signupPage = PageFactory.initElements(driver, SignupPage.class);

    @Step("User register bundles of accounts with below information <table>")
    public void registerMultipleUser(Table table) {

        List<TableRow> rows = table.getTableRows();
        for (TableRow row : rows) {
            homePage.clickLogoutLink();
            loginPage.clickCreateAccountButton();
            DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            signupPage.chooseEmailWay();
            System.out.println("ROW >> "+row.getCell("name")+row.getCell("email")+row.getCell("password"));
            signupPage.inputAccountInfo(row.getCell("name"),row.getCell("email"),row.getCell("password"));
            DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            signupPage.legalAgreement();
            DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            signupPage.clickSignUpButton();
            homePage.clickLogoutLink();
        }
    }

    @Step("Jump to sign up page")
    public void gotoSignupPage() {
        loginPage.clickCreateAccountButton();
    }


    @Step("Choose email way")
    public void selectEmailWay() {
        DriverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        signupPage.chooseEmailWay();
    }

    @Step("Input account name <QAgauge>")
    public void inputAccountName(String name) {
        signupPage.inputAccountName(name);
    }

    @Step("Input account email <Faya001@yahoo.com>")
    public void inputAccountEmail(String mailBox) {
        signupPage.inputAccountEmail(mailBox);
    }

    @Step("Input account password <qa123456>")
    public void inputAccountPw(String passwrord) {
        signupPage.inputAccountPw(passwrord);
    }

    @Step("Agree with the legal")
    public void legalAgree() {
        signupPage.legalAgreement();

    }

    @Step("Click sign up button")
    public void clickSignup() {
        signupPage.clickSignUpButton();
    }

    @Step("Sign up successfully")
    public void signupSuccess() {
        assertTrue(homePage.userNameIsDisplayed());
    }


}

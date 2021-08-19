package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.StartPage;
import Pages.HomePage;
import Pages.LoginPage;

import static Utils.Setup.driver;

public class MyStepdefs {

    @Given("I navigate to hudl login page")
    public void iNavigateToHudlLoginPage() {
        StartPage startPage = new StartPage(driver);
        startPage.goToHudlStartPage();
        Assert.assertEquals("Performance analysis tools for sports teams and athletes at every level.",startPage.getHudlStartPageTitle());
        startPage.clickLogin_btn();
    }

    @When("I submit {string} and {string}")
    public void iEnterValidAnd(String userName, String pwd) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Log In - Hudl",loginPage.getLoginPageTitle());
        String userId = userName;
        String password = pwd;
        loginPage.enterEmail(userId);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
    }

    @Then("I can see hudl home page with my login")
    public void iCanSeeHudlHomePageWithMyLogin() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.customerNameDisplayed());
        Assert.assertEquals("Home - Hudl",homePage.getHomePageTitle());
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.errorMsgIsPresent());
    }
}

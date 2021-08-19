package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailId = By.id("email");
    By password = By.id("password");
    By login = By.id("logIn");
    By error = By.xpath("//div[@class=\"login-error-container\"]//p");

    public String getLoginPageTitle() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return(driver.getTitle());
    }

    public void enterEmail(String userName) {
        driver.findElement(emailId).sendKeys(userName);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginBtn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(login).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean errorMsgIsPresent() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(error).isDisplayed();
        return true;
    }
}

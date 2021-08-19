package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) { this.driver=driver;}

    By customerProfileName = By.xpath("//div[@class=\"user-fields-container\"]//a");

    public String getHomePageTitle() {
        return(driver.getTitle());
    }
    public boolean customerNameDisplayed() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(customerProfileName).isDisplayed();
        return true;
    }
}

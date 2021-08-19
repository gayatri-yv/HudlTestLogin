package Pages;

import Utils.BasePage;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {
    WebDriver driver;
    ConfigReader configReader;

    public StartPage(WebDriver driver) {
        this.driver=driver;
    }

    By login_btn = By.xpath("//a[@class='btn__blue login']");

    public void goToHudlStartPage() {
        configReader = new ConfigReader();
        String url = configReader.getApplicationUrl();
        driver.get(url);
        wait.forLoading(5);
    }

    public String getHudlStartPageTitle() {
        return(driver.getTitle());
    }
    public void clickLogin_btn() {
        driver.findElement(login_btn).click();
    }
}

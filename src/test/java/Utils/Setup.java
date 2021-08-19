package Utils;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Setup {

    public static WebDriver driver;
    ConfigReader configReader;

    @Before
    public void setWebDriver() throws Exception {
        //String browser = System.getProperty("browser");
        configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                String root = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver", root+"\\src\\main\\resources\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}


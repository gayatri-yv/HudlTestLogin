package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath= "src//test//java//Config//Configuration.properties";
    public ConfigReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser!= null) return browser;
        else return("chrome");
    }

    public String getdriverPath() {
        String root = System.getProperty("user.dir");
        String driver = null;
        if(getBrowser().contentEquals("chrome")) {
            driver = properties.getProperty("chromedriver");
        }
        else if(getBrowser().contentEquals("firefox")) {
            driver = properties.getProperty("geckodriver");
        }
        String driverPath = root + driver;
        return driverPath;
    }
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

}

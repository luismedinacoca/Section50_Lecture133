package Utils;

import Page_Objects.ContactUs_Page;
import Page_Objects.Products_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.Constant.*;
import static Utils.Constant.IE_DRIVER_DIRECTORY;

public class DriverFactory {
    public static WebDriver driver;
    /**adding new attribute related to each page**/
    public static ContactUs_Page contactUsPage;
    public static Products_Page productsPage;


    public WebDriver getDriver(){
        try{

            /**********************************************************************************
             **READ CONFIG FILE
             **********************************************************************************/
            //create a Yaml object
            Yaml yaml = new Yaml();

            //getting the path project
            String projectPath = System.getProperty("user.dir");

            // create a File object
            File file = new File(projectPath.concat("\\src\\test\\java\\Data\\config.yaml"));
            //System.out.println(projectPath.concat("\\src\\test\\java\\Data\\config.yaml"));

            //Create a input stream
            FileInputStream inputStream = new FileInputStream(file);

            //Parse the yaml file and create a list/map that contains inner map
            Map<String, Map<String, Object>> configMap = (Map<String, Map<String, Object>>)yaml.load(inputStream);

            //create variable
            String browserName = configMap.get("Data").get("browser").toString();
            System.out.println("browser name is: " + browserName);

            switch(browserName){
                case "firefox":
                    if(null == driver) {
                        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_DIRECTORY);
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        capabilities.setCapability("marionette", true);
                        driver = new FirefoxDriver();
                    }
                    break;
                case "chrome":
                    if(null == driver) {
                        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_DIRECTORY);
                        //Chrome options:
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }
                    break;
                case "opera":
                    if(null == driver) {
                        System.setProperty("webdriver.opera.driver", OPERA_DRIVER_DIRECTORY);
                        //Opera options:
                        driver = new OperaDriver();
                        driver.manage().window().maximize();
                    }
                    break;
                case "ie":
                    if(null == driver) {
                        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                        System.setProperty("webdriver.ie.driver", IE_DRIVER_DIRECTORY);
                        capabilities.setCapability("ignoreZoomSetting", true);
                        driver = new InternetExplorerDriver(capabilities);
                        driver.manage().window().maximize();
                    }
                    break;
            }
        } catch(Exception e){
            System.out.println("Unable to load browser: " + e.getMessage());
        } finally{
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
            productsPage = PageFactory.initElements(driver, Products_Page.class);
        }
        return driver;
    }
}

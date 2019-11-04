package Step_Definitions;

import Utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MasterHooks extends DriverFactory {
    @Before
    public void setup(){
        driver = getDriver();
    }

    @After
    public void tearDownAndScreenshotOnFailure(Scenario scenario){
        try{
            if(driver!=null && scenario.isFailed()){
                scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;  /** very important  ========> DO NOT FORGET*/
            }

            if(driver != null){
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;  /** very important  ========> DO NOT FORGET*/
            }
        } catch(Exception e){
            System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
        }
    }
}
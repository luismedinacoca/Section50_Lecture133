package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features locations
        features ={"src/test/java/Features"},
        //Step files
        glue={"Step_Definitions"},
        dryRun = false, //when dryRun is true, execute the cucumber steps but they are skipped
        monochrome = true,
        plugin ={"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
        }
)
public class Main_Runner extends AbstractTestNGCucumberTests {
        /**
        @AfterClass
        public static void writeExtentReport() {
                Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\target\\ReportsConfig.xml"));
        }
        */
}

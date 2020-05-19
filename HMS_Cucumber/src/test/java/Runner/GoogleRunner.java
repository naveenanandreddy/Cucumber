package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features\\GoogleSearch.feature",
glue="StepDefinitions",
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true)

public class GoogleRunner {
	
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("Config/ConfigFile.xml"));
    
    }

}

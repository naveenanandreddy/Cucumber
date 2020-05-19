package Runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features",
		glue="StepDefinitions",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true)



public class HMS_Runner {
	String y;
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("Config/configFile.xml"));
    
    }
	
	
	
}

	


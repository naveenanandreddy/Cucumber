package Runner1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features1\\HMS1.feature",
		glue="StepDefinitions1",
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports1/report1.html"},
		monochrome=true)
		
//com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html
		
public class TestRunnerPrac1 {

	@AfterClass
	public static void extentReportGeneration() {
	Reporter.loadXMLConfig("Config1/configFile.xml");	
	}
}

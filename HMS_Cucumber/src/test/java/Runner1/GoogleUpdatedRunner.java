package Runner1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features\\GoogleFeatureFileupdate.feature",
		glue="StepDefinitions1",
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/extent-reports9/report.html"},
		monochrome = true
		)

public class GoogleUpdatedRunner {
	@AfterClass
	public static void writeExtentReport9() {
	Reporter.loadXMLConfig("Config/configFile.xml");
		}
}

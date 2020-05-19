package Runner;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features\\GUpdate.feature",
	glue="StepDefinitions",
	plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report100/report.html"},
	monochrome=true)

public class jRunner {

	@AfterClass
	public static void test() {
	Reporter.loadXMLConfig("Config/configFile.xml");	
	}

}

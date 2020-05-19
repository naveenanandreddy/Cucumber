package Runner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\navee\\eclipse-workspace-Maven-CucumberProject\\HMS_Cucumber\\src\\test\\java\\Features\\GoogleSearchnew.feature",
		glue="StepDefinitions",
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports3/report.html"},
		monochrome=true)

public class GoogleRunnernew {
@AfterClass
public static void writeReport(){
Reporter.loadXMLConfig(new File("Config1/configFile.xml"));
	}
}

package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class sGoogleDefinition {
	
public	WebDriver driver;
	
	public void sScreenshot() throws Exception {
		
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	File targetFile=new File(System.getProperty("user.dir")+"\\target\\cucumber-report100\\Screenshots\\test.png");
	Files.copy(sourceFile, targetFile);	
	Reporter.addScreenCaptureFromPath(targetFile.toString());
	}
	
	@Given("^gGoogle$")
	public void ggoogle() throws Throwable {
	System.setProperty("webdriver.chrome.driver", ".\\Library\\L\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
	sScreenshot();
	}

	@When("^sSearch Strig$")
	public void ssearch_Strig() throws Throwable {
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	sScreenshot();
	}

	@Then("^vValidate PPage$")
	public void vvalidate_PPage() throws Throwable {
	Assert.assertEquals(driver.findElement(By.linkText("Sign in")).isDisplayed(), true);
	sScreenshot();
	}


}

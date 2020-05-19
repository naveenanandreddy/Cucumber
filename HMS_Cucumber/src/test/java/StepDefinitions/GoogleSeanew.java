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

public class GoogleSeanew {
	WebDriver driver;
	
	public void screenShot() throws Exception {
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationPath=new File(System.getProperty("user.dir")+"\\target\\cucumber-reports3\\snapshots\\test.png");
	Files.copy(sourceFile, destinationPath);
	Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}
	
	@Given("^Google Home Page$")
	public void google_Home_Page() throws Exception {
	System.setProperty("webdriver.chrome.driver", ".\\Library\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
	screenShot();
	}

	@When("^enter the string$")
	public void enter_the_string() throws Exception {
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	screenShot();
	}

	@Then("^Search related page should be displayed$")
	public void search_related_page_should_be_displayed() throws Exception {
	//driver.findElement(By.linkText("Gmail")).click();
	Assert.assertEquals(driver.findElement(By.linkText("Sign in")).isDisplayed(), true);
	screenShot();
	}

}

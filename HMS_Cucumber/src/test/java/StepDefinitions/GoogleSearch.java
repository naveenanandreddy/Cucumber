package StepDefinitions;

import java.io.File;
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

public class GoogleSearch {
	WebDriver driver;
	
	@Given("^Google Home Page should be displayed$")
	public void google_Home_Page_should_be_displayed() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\Library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/"); 
		//File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		
		//String screenshotName = scenario.getName().replaceAll(" ", "_");
		File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Building up the destination path for the screenshot to save
		//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/test.png");
		
		//Copy taken screenshot from source location to destination location
		Files.copy(sourcePath, destinationPath);   

		//This attach the specified screenshot to the test
		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	    }

	@When("^user enters search string$")
	public void user_enters_search_string() throws Throwable {
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
	    driver.findElement(By.xpath("//input[@name='q']")).submit();
	   }

	@Then("^search related pages should be displayed$")
	public void search_related_pages_should_be_displayed() throws Throwable {
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='sA5rQ']")).isDisplayed(), true);
	    System.out.println("Page displayed");
	    }
	}

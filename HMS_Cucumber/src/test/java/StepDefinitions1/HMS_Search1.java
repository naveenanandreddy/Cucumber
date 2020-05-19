package StepDefinitions1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class HMS_Search1 {
	WebDriver driver;
	public String date;
	public void captureScreenshot() throws Exception {
		
		Date objDate=new Date();
		String d="hhmmssddMMyyy";
		SimpleDateFormat sd=new SimpleDateFormat(d);
		String date=sd.format(objDate);
		
		File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationPath=new File(System.getProperty("user.dir")+"/target/cucumber-reports1/screenshots/test"+date+".png");
		Files.copy(sourcePath, destinationPath);
		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}
	
	
	@Given("^launch HMS home page$")
	public void launch_HMS_home_page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", ".\\Library\\chromedriver.exe");   
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://selenium4testing.com/hms/");
	captureScreenshot();
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("password")).sendKeys("admin");
	captureScreenshot();
	}

	@When("^user click on submit button$")
	public void user_click_on_submit_button() throws Throwable {
	driver.findElement(By.name("submit")).click();	
	captureScreenshot();
	}

	@Then("^user enters login page$")
	public void user_enters_login_page() throws Throwable {
	Assert.assertEquals(driver.findElement(By.linkText("Logout")).isDisplayed(), true);	
	captureScreenshot();
	}

}

package StepDefinitions1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchUpdated {
	public WebDriver driver;
	
	@Given("^user navigates to Google Home Page$")
	public void user_navigates_to_Google_Home_Page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", ".\\Library\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	}

	@When("^user enters String$")
	public void user_enters_String() throws Throwable {
	driver.findElement(By.name("q")).sendKeys("Selenium");
	
	}

	@Then("^user clicks on Search Button$")
	public void user_clicks_on_Search_Button() throws Throwable {
	driver.findElement(By.name("btnK")).click();	
	}

}

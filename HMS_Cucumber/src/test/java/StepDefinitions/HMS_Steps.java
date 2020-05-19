package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMS_Steps {
	WebDriver driver;
	@Given("^HMS home page is available$")
	public void hms_home_page_is_available() {
	    
		System.setProperty("webdriver.chrome.driver", ".\\Library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		
	   }

	@When("^user enters username and password$")
	public void user_enters_username_and_password() {
	    
	    driver.findElement(By.name("username")).sendKeys("admin");
	    driver.findElement(By.name("password")).sendKeys("admin");
	}

	@When("^user click on submit button$")
	public void user_click_on_submit_button() {
	   
		driver.findElement(By.name("submit")).click();
	    
	}

	@Then("^validate login page$")
	public void validate_login_page() {
		
		Assert.assertEquals(driver.findElement(By.linkText("Logout")).isDisplayed(), true);
		
		System.out.println("Element Displayed");
	   
	}



}

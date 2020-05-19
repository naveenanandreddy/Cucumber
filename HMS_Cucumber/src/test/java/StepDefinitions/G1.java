package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class G1 {
	public WebDriver driver;
	@Given("^Google Home$")
	public void google_Home() throws Throwable {
	System.setProperty("webdriver.chrome.driver", ".\\Library\\L1\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	}

	@When("^Search string$")
	public void search_string() throws Throwable {
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
	driver.findElement(By.xpath("//input[@name='btnK']")).click();
	}

	@Then("^search page should display$")
	public void search_page_should_display() throws Throwable {
	driver.close();
	}

}

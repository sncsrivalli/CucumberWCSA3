package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActtimeLoginParametersSteps {
	private WebDriver driver;
	
	@Given("Open browser and enter actitime url")
	public void open_browser_and_enter_actitime_url() {
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://demo.actitime.com/login.do");
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username+Keys.TAB+password);
	    
	}

	@And("hits on login button")
	public void hits_on_login_button() {
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("^Home page with (.*) should be displayed$")
	public void home_page_with_status_should_be_displayed(String status) {
	    System.out.println(status);
	    driver.quit();
	}


}

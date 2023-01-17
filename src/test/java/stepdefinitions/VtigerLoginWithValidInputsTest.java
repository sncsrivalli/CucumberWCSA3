package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VtigerLoginWithValidInputsTest {
	WebDriver driver;
	@Given("Navigate to vtiger application")
	public void navigate_to_vtiger_application() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.actitime.com/login.do");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
		
	    driver.findElement(By.id("username")).sendKeys("admin"+Keys.TAB+"manager");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    driver.findElement(By.id("loginButton")).click();
	}

	@Then("Vtiger home page should display")
	public void vtiger_home_page_should_display() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    boolean status = wait.until(ExpectedConditions.titleContains("Enter Time-Track")).booleanValue();
	    if(status)
	    	System.out.println("Pass");
	    else
	    	System.out.println("Fail");
	    driver.close();
	}

}

package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import genericLibraries.ExcelFileUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileUtility;
import genericLibraries.WebDriverUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPages.CreateNewOrganizationPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrganizationInfoPage;
import pomPages.OrganizationsPage;

public class OrganizationSteps {
	private WebDriverUtility web;
	private PropertyFileUtility property;
	private ExcelFileUtility excel;
	private JavaUtility javaUtil;
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private OrganizationsPage organization;
	private CreateNewOrganizationPage createOrganization;
	private NewOrganizationInfoPage newOrganization;
	private String orgName;
	
	@Given("Launch browser and enter Vtiger CRM url")
	public void launch_browser_and_enter_vtiger_crm_url() {
		web = new WebDriverUtility();
		property = new PropertyFileUtility();
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excel = new ExcelFileUtility();
		javaUtil = new JavaUtility();
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		String browser = property.getDataFromProperties("browser");
		String url = property.getDataFromProperties("url");
		long time = Long.parseLong(property.getDataFromProperties("timeouts"));
		driver = web.openApplication(browser, url, time);
	    
	}

	@And("Login to Vtiger CRM application")
	public void login_to_vtiger_crm_application() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		login.loginToApplication(property.getDataFromProperties("username"),
				property.getDataFromProperties("password"));
	}

	@When("User clicks on Organization tab")
	public void user_clicks_on_organization_tab() {
		home.clickOrganizations();
	}

	@And("Clicks on Plus button")
	public void clicks_on_plus_button() {
		organization = new OrganizationsPage(driver);
		organization.clickPlusButton();
	}

	@And("Enters name and industry and clicks on save button")
	public void enters_name_and_industry_and_clicks_on_save_button() {
		
		Map<String, String> map = excel.getDataBasedOnKey("TestData", "Create Organization");
	    createOrganization = new CreateNewOrganizationPage(driver);
	    orgName = map.get("Organization Name")+javaUtil.generateRandomNumber(100);
	    createOrganization.setOrganizationName(orgName);
	    createOrganization.selectIndustry(web, map.get("Industry"));
	    createOrganization.clickSaveButton();
	}

	@Then("New Organization Info page is displayed")
	public void new_organization_info_page_is_displayed() {
	   newOrganization = new NewOrganizationInfoPage(driver);
	   if(newOrganization.getPageHeader().contains(orgName))
		   System.out.println("Pass");
	   else
		   System.out.println("Fail");
	}

	@When("User click on organizations link")
	public void user_click_on_organizations_link() {
	   newOrganization.clickOrganizationsLink();
	}

	@Then("New organization appears on the list")
	public void new_organization_appears_on_the_list() {
	   if(organization.getNewOrganization().contains(orgName))
		   System.out.println("Test pass");
	   else
		   System.out.println("Test fail");
	}

	@And("User logs out of the application and closes the browser")
	public void user_logs_out_of_the_application_and_closes_the_browser() {
	    home.signOut(web);
	    web.closeBrowser();
	}

}

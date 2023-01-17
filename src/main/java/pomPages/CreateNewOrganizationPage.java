package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains element references and respective business libraries of Create Organization page
 * @author QPS-Basavanagudi
 *
 */
public class CreateNewOrganizationPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy(name="accountname") private WebElement organizationNameTF;
	@FindBy(name="industry") private WebElement industryDropdown;
	@FindBy(xpath="//input[contains(@value,'Save')]") private WebElement saveButton;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get Create New Organization page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to set the organization name
	 * @param orgName
	 */
	public void setOrganizationName(String orgName) {
		organizationNameTF.sendKeys(orgName);
	}
	
	/**
	 * This method is used to select the industry from drop down
	 * @param web
	 * @param value
	 */
	public void selectIndustry(WebDriverUtility web, String value) {
		web.dropdown(value, industryDropdown);
	}
	
	/**
	 * This method is used to click on save button
	 */
	public void clickSaveButton() {
		saveButton.click();
	}
}

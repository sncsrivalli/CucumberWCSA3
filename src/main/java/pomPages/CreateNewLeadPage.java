package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class CreateNewLeadPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy(name="salutationtype") private WebElement salutationDropdown;
	@FindBy(name="lastname") private WebElement lastNameTextField;
	@FindBy(name="company") private WebElement companyNameTextField;
	@FindBy(xpath="//input[contains(@value,'Save')]") private WebElement saveButton;
	
	//Initialization
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get leads page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}

	/**
	 * This method is used to select salutation 
	 * @param web
	 * @param value
	 */
	public void selectSalutation(WebDriverUtility web,String value) {
		web.dropdown(value, salutationDropdown);
	}
	
	/**
	 * This method is used to set the last name of the contact
	 * @param lastname
	 */
	public void setLastName(String lastname) {
		lastNameTextField.sendKeys(lastname);
	}
	
	/**
	 * This method is used to set the company name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		companyNameTextField.sendKeys(companyName);
	}
	

	/**
	 * This method is used to click on save button
	 */
	public void clickSave() {
		saveButton.click();
	}
	
}

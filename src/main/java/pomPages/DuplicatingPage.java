package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy(name="lastname") private WebElement lastNameTextField;
	@FindBy(xpath="//input[contains(@value,'Save')]") private WebElement saveButton;
	
	//Initialization
	public DuplicatingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get create new contact page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to set the last name of the contact
	 * @param lastname
	 */
	public void setLastName(String lastname) {
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lastname);
	}
	
	/**
	 * This method is used to click on save button
	 */
	public void clickSave() {
		saveButton.click();
	}
	


}

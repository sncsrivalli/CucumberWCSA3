package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains element references and respective business libraries of Create new contact page
 * @author QPS-Basavanagudi
 *
 */
public class CreateNewContactPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy(name="salutationtype") private WebElement salutationDropdown;
	@FindBy(name="lastname") private WebElement lastNameTextField;
	@FindBy(xpath="//img[contains(@onclick,'Accounts&action')]") private WebElement organizationPlusButton;
	@FindBy(xpath="//div[@id='ListViewContents']/descendant::table[@cellpadding='5']/descendant::tr/td[1]/a") 
	private List<WebElement> organizationsList;
	@FindBy(name="imagename") private WebElement contactImage;
	@FindBy(xpath="//input[contains(@value,'Save')]") private WebElement saveButton;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
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
	 * This method is used to select the existing organization
	 * @param web
	 * @param orgName
	 */
	public void selectExistingOrganization(WebDriverUtility web, String orgName) {
		organizationPlusButton.click();
		String parentWindow = web.getParentWindow();
		web.handeChildBrowser();
				
		for(WebElement org: organizationsList) {
			String name = org.getText();
			if(name.equals(orgName)) {
				org.click();
				break;
			}
		}
		web.switchToWindow(parentWindow);
	}
	
	/**
	 * This method is used to upload contact image
	 * @param imagePath
	 */
	public void uploadContactImage(String imagePath) {
		contactImage.sendKeys(imagePath);
	}
	
	/**
	 * This method is used to click on save button
	 */
	public void clickSave() {
		saveButton.click();
	}
	

}

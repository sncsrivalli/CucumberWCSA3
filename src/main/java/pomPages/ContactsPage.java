package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains element references and respective business libraries of Contacts page
 * @author QPS-Basavanagudi
 *
 */
public class ContactsPage {
	
	//Declaration
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement pageHeader;
	@FindBy(xpath="//img[@alt='Create Contact...']") private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/descendant::tr[last()]/td[4]/a") private WebElement newContact;
	
	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get contacts page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to click on create contact plus button
	 */
	public void clickPlusButton() {
		plusButton.click();
	}
	
	/**
	 * This method is used to get the new contact created
	 * @return
	 */
	public String getNewContact() {
		return newContact.getText();
	}
}

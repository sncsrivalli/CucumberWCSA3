package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This class contains element references and respective business libraries of HomePage
 * @author QPS-Basavanagudi
 *
 */
public class HomePage {
	
	//Declaration
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement pageHeader;
	@FindBy(xpath="//a[.='Organizations']") private WebElement organizationsTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement administratorIcon;
	@FindBy(xpath="//a[.='Sign Out']") private WebElement signOutButton;
	@FindBy(xpath="//a[.='Contacts']") private WebElement contactsTab;
	@FindBy(xpath="//a[.='Leads']") private WebElement leadsTab;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * This method is used to return home page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to click on Organizations tab
	 */
	public void clickOrganizations() {
		organizationsTab.click();
	}
	
	/**
	 * This method is used to click on the contacts tab
	 */
	public void clickContacts() {
		contactsTab.click();
	}
	
	/**
	 * This method is used to click on the leads tab
	 */
	public void clickLeads() {
		leadsTab.click();
	}
	
	/**
	 * This method is used to sign out of the application
	 * @param web
	 */
	public void signOut(WebDriverUtility web) {
		web.mouseHoverToElement(administratorIcon);
		signOutButton.click();
	}

}

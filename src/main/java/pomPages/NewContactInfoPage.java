package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains element references and respective business libraries of new contact info page
 * @author QPS-Basavanagudi
 *
 */
public class NewContactInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement pageHeader;
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement contactsLink;
	
	//Initialization
	public NewContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method is used to get new contact info page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to click on contacts link
	 */
	public void clickContactsLink() {
		contactsLink.click();
	}

}

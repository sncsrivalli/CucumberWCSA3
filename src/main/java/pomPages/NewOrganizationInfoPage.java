package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains elements references and methods of New Organization Info page
 * @author QPS-Basavanagudi
 *
 */
public class NewOrganizationInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement pageHeader;
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement organizationsLink;
	
	//Initialization
	public NewOrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method returns new organization page header 
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to click on organizations link
	 */
	public void clickOrganizationsLink() {
		organizationsLink.click();
	}

}

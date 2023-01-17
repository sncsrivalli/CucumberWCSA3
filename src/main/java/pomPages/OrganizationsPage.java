package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains element references and respective business libraries of Organizations Page
 * @author QPS-Basavanagudi
 *
 */
public class OrganizationsPage {
	
	//Declaration
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement pageHeader;
	@FindBy(xpath="//img[@alt='Create Organization...']") private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]") private WebElement newOrganization;
	
	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * This method is used to get organizations page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to click on Create New Organization plus button
	 */
	public void clickPlusButton() {
		plusButton.click();
	}
	
	/**
	 * This method is used to fetch the name of newly created organization from the list
	 * @return
	 */
	public String getNewOrganization() {
		return newOrganization.getText();
	}

}

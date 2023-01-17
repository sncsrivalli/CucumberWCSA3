package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	//Declaration
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement pageHeader;
	@FindBy(xpath="//img[@alt='Create Lead...']") private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement newLead;
	
	//Initialization
	public LeadsPage(WebDriver driver) {
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
	 * This method is used to click on create contact plus button
	 */
	public void clickPlusButton() {
		plusButton.click();
	}
	
	/**
	 * This method is used to fetch the newly added lead name
	 * @return
	 */
	public String getNewLead() {
		return newLead.getText();
	}
}

package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeadInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement pageHeader;
	@FindBy(name="Duplicate") private WebElement duplicateButton;
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement leadsLink;
	
	//Initialization
	public NewLeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
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
	 * This method is used to click on duplicate button
	 */
	public void clickDuplicateButton() {
		duplicateButton.click();
	}
	
	/**
	 * This method is used to click on leads link
	 */
	public void clickLeadsLink() {
		leadsLink.click();
	}
	

}

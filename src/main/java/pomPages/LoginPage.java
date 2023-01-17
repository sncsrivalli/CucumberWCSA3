package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains element references and respective business libraries of Login Page
 * @author QPS-Basavanagudi
 *
 */
public class LoginPage {
	
	//Declaration
	
	@FindBy(xpath="//a[@href='http://www.vtiger.com']") private WebElement pageHeader;
	@FindBy(name="user_name") private WebElement userNameTextField;
	@FindBy(name="user_password") private WebElement passwordTextField;
	@FindBy(id="submitButton") private WebElement loginButton;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	
	/**
	 * This method returns Login Page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to login to the application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}

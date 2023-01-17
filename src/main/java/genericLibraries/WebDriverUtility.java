package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class cotains all resuable methods to perform web driver actions
 * @author QPS-Basavanagudi
 * @param browser 
 *
 */

public class WebDriverUtility {
	WebDriver driver;
	
	/**
	 * This method is used to launch the browser, maximize it, navigate to application and also wait till page is loaded
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long time) {
		
		switch(browser) {
		
			case "chrome": WebDriverManager.chromedriver().setup();
			               driver = new ChromeDriver(); break;
			case "firefox": WebDriverManager.firefoxdriver().setup();
			                driver = new FirefoxDriver(); break; 
			case "edge": WebDriverManager.edgedriver().setup();
			             driver = new EdgeDriver(); break;
			default: System.out.println("Invalid browser name");break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}
	
	/**
	 * This method is used to perform mouse hover to specified element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to select an element from drop down using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to select an element from drop down using text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to select an element from drop down using value
	 * @param value
	 * @param element
	 */
	public void dropdown(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to switch to frame depending on index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch back from the frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to fetch parent window address
	 * @return
	 */
	public String getParentWindow() {
		return driver.getWindowHandle();
	}
	
	/**
	 * This method is used to handle child browser popup
	 */
	public void handeChildBrowser() {
		Set<String> windowTitles = driver.getWindowHandles();
		for(String wID: windowTitles) {
			driver.switchTo().window(wID);
		}
	}
	
	/**
	 * This method is used to switch to specified window
	 * @param windowID
	 */
	public void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
	}
	
	/**
	 * This method is used to capture the screenshot
	 * @param javaUtility
	 * @param classname
	 * @return 
	 * @return 
	 */
	public String getScreenshot(JavaUtility javaUtility, WebDriver driver, String classname) {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+classname+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	public String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}

	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
}

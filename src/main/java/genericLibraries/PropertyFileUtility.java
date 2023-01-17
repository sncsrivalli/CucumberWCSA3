package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains the methods to perform actions on properties file
 * @author QPS-Basavanagudi
 *
 */

public class PropertyFileUtility {
	Properties property;
	
	/**
	 * This method is used to initialize property file
	 * @param filePath
	 */
	
	public void propertyFileInitialization(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	
	public String getDataFromProperties(String key) {
		
		return property.getProperty(key);
		
	}

}

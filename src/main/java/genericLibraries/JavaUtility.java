package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains all java reusable methods
 * @author QPS-Basavanagudi
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	
	public int generateRandomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * This method is used to get current time
	 * @return
	 */
	public String currentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate = sdf.format(date);
		return actualDate;
	}

}

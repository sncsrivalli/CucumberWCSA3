package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods to perform actions on Excel file
 * 
 * @author QPS-Basavanagudi
 *
 */
public class ExcelFileUtility {
	Workbook workbook;
	
	/**
	 * This method is used to initialize excel file 
	 * @param excelPath 
	 * 
	 */
	
	public void excelInitialization(String excelPath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch single data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getSingleDataFromExcel(String sheetName, int rowNum, int cellNum) {

		DataFormatter df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		return df.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
	}
	
	/**
	 * This method is used to fetch multiple data from excel in key-value pairs 
	 * @param sheetName
	 * @param expectedTestCase
	 * @return
	 */
	public Map<String,String> getDataBasedOnKey(String sheetName, String expectedTestCase){
		DataFormatter df = new DataFormatter();
		Map<String,String> map = new HashMap<>();
		Sheet sheet = workbook.getSheet(sheetName);
		
		for(int i=0; i<= sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equalsIgnoreCase(expectedTestCase)) {
				for(int j=i; j<= sheet.getLastRowNum(); j++) {
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)), df.formatCellValue(sheet.getRow(j).getCell(3)));
					if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				
				}
				break;			    
			}
		}
		return map;
	}
	
	/**
	 * This method is used to update test script status in excel
	 * @param sheetName
	 * @param expectedTestCase
	 * @param status
	 * @param excelPath
	 */
	public void updateTestStatusInExcel(String sheetName, String expectedTestCase, String status, String excelPath) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equalsIgnoreCase(expectedTestCase)) {
				Cell cell = sheet.getRow(i).createCell(4);
				cell.setCellValue(status);
				break;
			}
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is to close excel workbook
	 */
	public void closeExcel() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

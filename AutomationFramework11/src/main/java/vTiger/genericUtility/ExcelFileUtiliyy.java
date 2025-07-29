package vTiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of method realted to read data from excel file
 */

public class ExcelFileUtiliyy {
	/**
	 * This method is used to read the data from excel file
	 * 
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String toReadDataFromExcelFile(String sheetname, int row, int cell)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\src\\\\test\\\\resources\\\\DemeoWebShop1.xlsx");
	//	/AutomationFramework11/src/test/resources/DemeoWebShop1.xlsx
		Workbook wb = WorkbookFactory.create(fis);

		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;

	}
	
public String toReadDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis =new FileInputStream("C:\\Users\\kumar\\git\\repository25\\AdvanceSelenium\\src\\test\\resources\\pcat.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String work = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return work;
		
		
	}
	

}

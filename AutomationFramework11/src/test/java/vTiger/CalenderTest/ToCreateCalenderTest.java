package vTiger.CalenderTest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CalendarMeetInformation;
import vTiger.ObjectRepository.CreateCalenderPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.ExcelFileUtiliyy;
import vTiger.genericUtility.WebDriverUtility;

public class ToCreateCalenderTest extends BaseClass {
	
	@Test(priority = 1)
	public void TocreateCalenderDate() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getCliclonclaenderLink().click();
		//click on addButton
		CreateCalenderPage ccp=new CreateCalenderPage(driver);
		ccp.getClickonAddButton().click();
		
		Reporter.log("sucsessfullclick on ad button",true);
		
		ccp.getClikOnMeetin().click();
		Reporter.log("sucsessfullclick on  meeting",true);
		
		
		
	
	
	//@Test(dependsOnMethods = "TocreateCalenderDate")
	//public void tocreateMeetingEvents() throws EncryptedDocumentException, IOException {
		CalendarMeetInformation cmi=new CalendarMeetInformation(driver);
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelFileUtiliyy eutil=new ExcelFileUtiliyy();
		String Eventname = eutil.toReadDataFromExcel("Sheet2", 0, 0);
		cmi.getEventName().sendKeys(Eventname);
		//cmi.getEventName().sendKeys("name");
	//	cmi.getStatus().sendKeys("");
		
		
		wutil.ToHandleDropdown(cmi.getStatus(), 1);
		
		cmi.getSaveMeeting().click();
		
		
	}
	
	

}

package vTiger.ContactTest;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.ContactsInformation;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactName;
import vTiger.ObjectRepository.HomePage;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.ExcelFileUtiliyy;
@Listeners(vTiger.genericUtility.ListenerImplimentation.class)//for monitor my test script
public class ToCreateContactTest extends BaseClass {

	@Test
	public void toCreateContactTest_001() throws EncryptedDocumentException, IOException {
		//to click on contact link
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();
       //to click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactLookupImage().click();
         //to fill mandotary filled
		ExcelFileUtiliyy eutil = new ExcelFileUtiliyy();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contact", 1, 2);
		CreateContactName ccn = new CreateContactName(driver);
		ccn.getCreateContactName().sendKeys(LASTNAME);
		ccn.getSaveButton().click();
		//Assert.fail();//it is used for to fail my test script
		
		//to validate
		ContactsInformation ci = new ContactsInformation(driver);
		String lastname = ci.getContactinformation().getText();

		if (lastname.contains(LASTNAME)) {
			Reporter.log(lastname + ".....passed...", true);
		} else {
			Reporter.log(lastname + "....failed....", true);
		}

	}

}

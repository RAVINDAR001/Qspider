package vTiger.LeadsPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LeadInformationpagesucsessfull;
import vTiger.ObjectRepository.ProductInformationPage;
import vTiger.ObjectRepository.ToProductLookupImageClick;
import vTiger.ObjectRepository.leadsInformationpage;
import vTiger.ObjectRepository.leadslookupimag;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.ExcelFileUtiliyy;
import vTiger.genericUtility.WebDriverUtility;

public class ToCreateLeadsInfo extends BaseClass {

	@Test
	public void tocreateleadsTest_001() throws EncryptedDocumentException, IOException {
		ExcelFileUtiliyy euti = new ExcelFileUtiliyy();
		WebDriverUtility wutil = new WebDriverUtility();
		HomePage hp = new HomePage(driver);
		// click on leads link
		hp.getCreateleadsPage().click();
        //click on leadslookupimage
		leadslookupimag lli= new leadslookupimag(driver);
		lli.getLeadslookupimage().click();
           //handleing dropdown of fisrname for name prefix
		leadsInformationpage lip = new leadsInformationpage(driver);

		wutil.ToHandleDropdown(lip.getFirstnamedropdown(), 1);
		
		//fill information for leads for 1st name
		
		String FirstName = euti.toReadDataFromExcel("Sheet2", 0, 0);
		lip.getFirstname().sendKeys(FirstName);
		Reporter.log("FirstNme created sucseesfully",true);
		
		//fill information for leads for last name
		String LastName = euti.toReadDataFromExcel("Sheet2", 1, 0);
		lip.getLastname().sendKeys(LastName);
		Reporter.log("lastname sucsess",true);
		
		////fill information for leads for Company name
		String CompanyName = euti.toReadDataFromExcel("Sheet2", 2 , 0);
		lip.getCompanyname().sendKeys(CompanyName);
		Reporter.log("comapny name created sucsess",true);
		
		
		lip.getSavebutton().click();
		
		//validation
		LeadInformationpagesucsessfull  sucsess=new LeadInformationpagesucsessfull(driver);
		String createdsucsess = sucsess.getPagecreatedsucsesfull().getText();
		
		Assert.assertTrue(createdsucsess.contains(FirstName));

	}

}

package vTiger.OrganizationTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CreateOrganizationName;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.ExcelFileUtiliyy;
import vTiger.genericUtility.JavaFileUtility;
import vTiger.genericUtility.WebDriverUtility;

public class ToCreateOrganizationTest extends BaseClass {
	@Test(groups = "Regression")
	public void toCreareOrganizationTest_002() throws EncryptedDocumentException, IOException {

		// to click on organization link
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();

		// to click on orglook up image
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationlookupPage().click();

		// to filled mandotary filled
		ExcelFileUtiliyy eutil = new ExcelFileUtiliyy();
		JavaFileUtility jutil = new JavaFileUtility();

		String ORGNAME = eutil.toReadDataFromExcelFile("Orgname", 1, 2) + jutil.toGetRandomNumber();
		System.out.println(ORGNAME);
		CreateOrganizationName CON = new CreateOrganizationName(driver);
		CON.getCreateOrganizationName1().sendKeys(ORGNAME);
		CON.getSaveButton().click();
		// VALIDATE
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orginformation = oip.getOrganizatininfo().getText();
		
		
		
		// if(orginformation.contains(ORGNAME)) {
		// Reporter.log("...passed...", true);
		// }else {
		// Reporter.log("..failled...", true);
		// }
		AssertJUnit.assertTrue(orginformation.contains(ORGNAME));

	}

}

package vTiger.ProductTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;


import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInformation;
import vTiger.ObjectRepository.ProductInformationPage;
import vTiger.ObjectRepository.ProductPage;
import vTiger.ObjectRepository.ToProductLookupImageClick;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.ExcelFileUtiliyy;
import vTiger.genericUtility.WebDriverUtility;

public class ToCreatProductPageTest extends  BaseClass {
	@Test
	public void tocreateProductPage() throws EncryptedDocumentException, IOException {
		//WebDriver driver =null;
		HomePage hp=new HomePage(driver);
		WebDriverUtility wutil = new WebDriverUtility();
		ExcelFileUtiliyy eutil = new ExcelFileUtiliyy();
	    ProductInformationPage pip=new ProductInformationPage(driver);

	    ProductPage pp=new ProductPage(driver);
	    
	    pp.getToclickprodbutton().click();
	    
	    ToProductLookupImageClick tpl=new ToProductLookupImageClick(driver);
	    tpl.getToclickLookupImage().click();
	    
	    
	    ProductInformation pi=new ProductInformation(driver);
	  //  pi.getProductname().sendKeys("iphone");euti
	    String productnamee = eutil.toReadDataFromExcel("Sheet1", 2, 0);
	    pi.getProductname().sendKeys(productnamee);
	    
	    wutil.ToHandleDropdown(pi.getProductCat(), 1);
	    
	    pi.getToclicksavebutton().click();
	    Reporter.log("product page created sucsessfully",true);
	    
	    String pagename = pip.getPageinfopage().getText();
	    Reporter.log(pagename,true);
	   AssertJUnit.assertTrue(pagename.contains(productnamee));
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
		}
	}




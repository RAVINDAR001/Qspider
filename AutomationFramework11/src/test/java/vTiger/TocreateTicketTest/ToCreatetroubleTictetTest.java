package vTiger.TocreateTicketTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.TroubleTicketLookupimage;
import vTiger.ObjectRepository.WindowPopup;
import vTiger.ObjectRepository.createTicketInformation;
import vTiger.genericUtility.BaseClass;
import vTiger.genericUtility.WebDriverUtility;

public class ToCreatetroubleTictetTest extends BaseClass {
	
	
	@Test
	public void ToCreateTroubleTicket() throws InterruptedException {
		WebDriverUtility wutil=new WebDriverUtility();
		HomePage hp=new HomePage(driver);
		
		hp.getTroubleTicketLink().click();
		
		Reporter.log("sucsessfully click on troubleticket link",true);
		
		TroubleTicketLookupimage TTL=new TroubleTicketLookupimage(driver);
		TTL.getTroubleTicketLookupImage().click();
		
		Reporter.log("sucsessfully click on look imgae",true);
		
		
		createTicketInformation CTI=new createTicketInformation(driver);
		CTI.getTofillTitleOfTicket().sendKeys("Facing Issue in productpage");
		Reporter.log("Facing Issue in productpage",true);
		
		wutil.ToHandleDropdown(CTI.getTicketPriority(), 2);
		wutil.ToHandleDropdown(CTI.getTicketSavirity(), 1);
		
		//CTI.getFirstWindowOpen().click();
		
		CTI.getToSaveButto().click();
		
		
//		wutil.ToSwitchWindow(driver, null);
//		Thread.sleep(3000);
//		 WindowPopup wi=new WindowPopup(driver);
//		 wutil.ToHandleDropdown(wi.getToselectLastName(), 1);
//		 wi.getSearchButton().click();
//		
		
	}

}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketLookupimage {


	public TroubleTicketLookupimage(WebDriver druver) {
		PageFactory.initElements(druver, this);
		
	
}@FindBy(xpath = "//img[@title=\"Create Ticket...\"]")
private WebElement ToClickTroubleTicketLookupImage;

public WebElement getTroubleTicketLookupImage() {
	return ToClickTroubleTicketLookupImage;
}
	
	
	
}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationpagesucsessfull {
	
	
	public LeadInformationpagesucsessfull(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement pagecreatedsucsesfull;

	public WebElement getPagecreatedsucsesfull() {
		return pagecreatedsucsesfull;
	}

}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadslookupimag {

	public leadslookupimag(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@title=\"Create Lead...\"]")
	private WebElement leadslookupimage;


	public WebElement getLeadslookupimage() {
		return leadslookupimage;
	}
}

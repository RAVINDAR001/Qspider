package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalenderPage {
	
	
	public CreateCalenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//td[@class=\"calAddButton\"]")
	private WebElement ClickonAddButton;
	
	
	@FindBy(linkText = "Meeting")
	
	private WebElement clikOnMeetin;
	
	public WebElement getClikOnMeetin() {
		return clikOnMeetin;
	}

	public WebElement getClickonAddButton() {
		return ClickonAddButton;
	}

}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarMeetInformation {
	
	public CalendarMeetInformation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@class=\"textbox\"])[1]")
	private WebElement eventName;
	
	public WebElement getEventName() {
		return eventName;
	}

	public WebElement getStatus() {
		return Status;
	}

	public WebElement getSaveMeeting() {
		return SaveMeeting;
	}

	@FindBy(xpath = "//select[@id=\"eventstatus\"]")
	private WebElement Status;
	
	@FindBy(xpath = "(//input[@alt=\"Save [Alt+S]\"])[1]")
	private WebElement SaveMeeting;
	
	
	

}

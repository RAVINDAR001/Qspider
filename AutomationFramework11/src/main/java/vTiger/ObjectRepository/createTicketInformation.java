package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createTicketInformation {

	public createTicketInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//textarea[@name=\"ticket_title\"]")
	private WebElement TofillTitleOfTicket;

	@FindBy(name = "ticketpriorities")
	private WebElement TicketPriority;
	
	@FindBy(name = "ticketseverities")
	private WebElement TicketSavirity;
	
	@FindBy(name = "ticketstatus")
	private WebElement TicketStatus;
	
	@FindBy(xpath = "(//img[@title=\"Select\"])[1]")
	private WebElement FirstWindowOpen;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement ToSaveButto;

	public WebElement getToSaveButto() {
		return ToSaveButto;
	}

	public WebElement getTofillTitleOfTicket() {
		return TofillTitleOfTicket;
	}

	public WebElement getTicketPriority() {
		return TicketPriority;
	}

	public WebElement getTicketSavirity() {
		return TicketSavirity;
	}

	public WebElement getTicketStatus() {
		return TicketStatus;
	}

	public WebElement getFirstWindowOpen() {
		return FirstWindowOpen;
	}
	
	

}

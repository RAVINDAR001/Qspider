package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(linkText = "Contacts")
		private WebElement contactslink;

		@FindBy(linkText = "Organizations")
		
		private WebElement Organizationlink;
		 @FindBy(linkText = "Leads")
		 private WebElement createleadsPage;
		 
		 @FindBy(linkText = "Calendar")
			private WebElement cliclonclaenderLink;


		
		 
	
		public WebElement getCliclonclaenderLink() {
			return cliclonclaenderLink;
		}

		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private	WebElement Logoutlink;
		
		@FindBy(linkText = "Sign Out")
	private	WebElement Logoutbutton;

		public WebElement getLogoutlink() {
			return Logoutlink;
		}

		public WebElement getLogoutbutton() {
			return Logoutbutton;
		}

		public WebElement getContactslink() {
			return contactslink;
		}

		public WebElement getOrganizations() {
			return Organizationlink;
		}

		public WebElement getOrganizationlink() {
			return Organizationlink;
		}

		public void setOrganizationlink(WebElement organizationlink) {
			Organizationlink = organizationlink;
		}
		
		public WebElement getCreateleadsPage() {
			return createleadsPage;
		}
	

}

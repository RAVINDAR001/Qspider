package vTiger.ObjectRepository;

import java.util.jar.Attributes.Name;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadsInformationpage {
	
	public leadsInformationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@name=\"salutationtype\"]")
	private WebElement firstnamedropdown;
	
	public WebElement getFirstnamedropdown() {
		return firstnamedropdown;
	}


	public WebElement getFirstname() {
		return Firstname;
	}


	public WebElement getLastname() {
		return Lastname;
	}


	public WebElement getCompanyname() {
		return companyname;
	}

	@FindBy(xpath = "//input[@name=\"firstname\"]")
	private WebElement Firstname;
	
	
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement Lastname ;

	@FindBy(xpath="//input[@name=\"company\"]")
	private WebElement companyname;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement Savebutton;

	public WebElement getSavebutton() {
		return Savebutton;
	}
	

	
	

}

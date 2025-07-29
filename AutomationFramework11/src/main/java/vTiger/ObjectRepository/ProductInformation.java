package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation {
	public ProductInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath = "//input[@name=\"productname\"]")
	private WebElement productname;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[2]")
	private WebElement toclicksavebutton;
	
	@FindBy(xpath = "//select[@name=\"productcategory\"]")
	private WebElement productCat;
	
	@FindBy(xpath = "//option[@value=\"Software\"]")
	private WebElement selectSoftware;
	
	
	

	public WebElement getSelectSoftware() {
		return selectSoftware;
	}

	public WebElement getProductCat() {
		return productCat;
	}

	public WebElement getToclicksavebutton() {
		return toclicksavebutton;
	}

	public WebElement getProductname() {
		return productname;
	}
}




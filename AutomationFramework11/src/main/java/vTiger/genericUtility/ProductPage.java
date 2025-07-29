package vTiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(linkText = "Products")
	private WebElement toclickprodbutton;
	
	


	public WebElement getToclickprodbutton() {
		return toclickprodbutton;
		
	}

}

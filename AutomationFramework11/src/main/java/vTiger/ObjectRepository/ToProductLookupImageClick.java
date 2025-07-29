package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToProductLookupImageClick {
	
	public ToProductLookupImageClick(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement toclickLookupImage;

	public WebElement getToclickLookupImage() {
		return toclickLookupImage;
	}

}

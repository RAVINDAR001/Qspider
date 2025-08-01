package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPopup {

	public WindowPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name=\"search_field\"]")
	private WebElement ToselectLastName;

	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement SearchButton;

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getToselectLastName() {
		return ToselectLastName;
	}

}

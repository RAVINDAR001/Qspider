package vTiger.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	ExcelFileUtiliyy eutil = new ExcelFileUtiliyy();
	public WebDriver driver = null;
	public static WebDriver sdDriver;//only for implementation

	@BeforeSuite(groups = { "smoke", "Regression" })
	public void beforeSuitConfig() {
		Reporter.log("data base connection established", true);

	}

	// @Parameters("browserName")
	// @BeforeTest
	@BeforeClass(groups = { "smoke", "Regression" })
	public void beforeClassConfig(/* String BROWSER */) throws IOException {// these 3 comment for crossbrowser testing
		Reporter.log("database connection established", true);
		String BROWSER = putil.toReadTheDataFromPropertyfile("browser");
		String URL = putil.toReadTheDataFromPropertyfile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		Reporter.log("Browser got launch", true);
		sdDriver = driver;//implemtation
		wutil.toMaximise(driver);
		wutil.toWaitElement(driver);
		driver.get(URL);
		Reporter.log("navigated to login page", true);

	}

	@BeforeMethod(groups = { "smoke", "Regression" })
	public void beforeMethodeConfig() throws IOException {
		String USERNAME = putil.toReadTheDataFromPropertyfile("username");
		String PASSWORD = putil.toReadTheDataFromPropertyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUserTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("sucessfully", true);

	}

	@AfterMethod(groups = { "smoke", "Regression" })
	public void afterMethodeConfig() {
		HomePage hp = new HomePage(driver);
		wutil.ToMoveToElement(driver, hp.getLogoutlink());
		hp.getLogoutbutton().click();
		Reporter.log("logout sucsessfully", true);
	}

	@AfterClass(groups = { "smoke", "Regerassion" })
	public void afterClass() {
		Reporter.log("Browser closed secssesfully", true);
		driver.quit();

	}

	@AfterSuite(groups = { "smoke", "Regerassion" })
	public void afterSuitConfig() {
		Reporter.log("---database connection disconnected--", true);

	}
}












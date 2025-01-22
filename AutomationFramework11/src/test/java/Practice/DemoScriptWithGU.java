package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vTiger.genericUtility.ExcelFileUtiliyy;
import vTiger.genericUtility.PropertyFileUtility;

public class DemoScriptWithGU {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL = putil.toReadTheDataFromPropertyfile("url");
		String BROWSER = putil.toReadTheDataFromPropertyfile("browser");
		String USERNAME = putil.toReadTheDataFromPropertyfile("username");
		String PASSWORD = putil.toReadTheDataFromPropertyfile("password");
		
		//excel
		ExcelFileUtiliyy eutil=new ExcelFileUtiliyy();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contact", 1, 2);
		
		//SCRIPT
		// launch the browser

				WebDriver driver = null;
				if (BROWSER.equalsIgnoreCase("Chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}

				System.out.println("browser got launched");
				
			driver.manage().window().maximize();
			System.out.println("browser got maximise");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

			driver.findElement(By.id("submitButton")).click();
			System.out.println("login succsesfully");
			// navigate to contact link

			driver.findElement(By.linkText("Contacts")).click();
			// click on contact lookup image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			// cfreate contact with mandotary feilds
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			// save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			// varify
			String lastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

			if (lastName.contains(lastName)) {
				System.out.println(lastName + "passs");
			} else {
				System.out.println(lastName + "failed");
			}

		     //logout
			// logout of application
			WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions action = new Actions(driver);
			action.moveToElement(logoutLink).perform();
			driver.findElement(By.linkText("Sign Out")).click();

			// close
			driver.quit();

	}

}

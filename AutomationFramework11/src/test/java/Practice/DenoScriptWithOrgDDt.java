package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DenoScriptWithOrgDDt {

	public static void main(String[] args) throws IOException {
		
		
		//to red data from propertfile
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(pfis);
		
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//To read data from excel file
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\DemeoWebShop1.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
	String ORGNAME = wb.getSheet("Orgname").getRow(1).getCell(2).toString();
	
	//launch the browser
	//script
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
       
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	// Login to application with valid credentials
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// Navigate to Organization
			driver.findElement(By.linkText("Organizations")).click();
			
			// click on create organization look up image
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

			Random r = new Random();
			int val = r.nextInt(100);

			// create organization with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME + val);

			// save and verify

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String Oragnization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

			if (Oragnization.contains("Qspider")) {
				System.out.println(Oragnization = "Organization created sucsessfully");
			} else {
				System.out.println(Oragnization + "failed");
			}
			// logout of application
			WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions action = new Actions(driver);
			action.moveToElement(logoutLink).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			//close the server
			driver.quit();
	
	
	
	}

}

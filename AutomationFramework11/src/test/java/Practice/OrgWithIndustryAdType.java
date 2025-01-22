package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrgWithIndustryAdType {

	public static void main(String[] args) {
		
		
		        //to lanuch browser
				WebDriver driver=new ChromeDriver();
				System.out.println("Browser got launched succesfully");
				driver.manage().window().maximize();
				System.out.println("browser got maximise");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("http://localhost:8888");
				
				//login with valid crendential
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");

				driver.findElement(By.id("submitButton")).click();
				System.out.println("login succsesfully");
				
				//navigate organization link
				driver.findElement(By.linkText("Organizations")).click();
				System.out.println("navigated to org link");
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				System.out.println("navigated to org lookup image");
				
				
				//create org with mandotary fields
				driver.findElement(By.name("accountname")).sendKeys("bussness39");
				
				
				//industry dropdown
			   WebElement IndustryName = driver.findElement(By.name("industry"));
			   Select dropdown=new Select(IndustryName);
			   dropdown.selectByValue("Chemicals");
			   System.out.println("succesfully selected industry");
			   
			   
			   //type dropdown
			   WebElement type = driver.findElement(By.name("accounttype"));
			   Select typedropdown=new Select(type);
			   typedropdown.selectByValue("Customer");
			   System.out.println("succesfully selected type");
			   
			   
			   //save
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			   
			   //varify
			String OrgNameWithIndustry = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(OrgNameWithIndustry.contains(OrgNameWithIndustry)) {
				System.out.println(OrgNameWithIndustry+"pass");
				
			}else {
				System.out.println(OrgNameWithIndustry+"failed");
			}
			//logout
			WebElement logoutlink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions action=new Actions(driver);
			action.moveToElement(logoutlink).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("succsefuly signout");
			//close the window
			driver.quit();


	}

}

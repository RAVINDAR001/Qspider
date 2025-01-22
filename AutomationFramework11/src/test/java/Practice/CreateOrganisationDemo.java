package Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisationDemo {

	public static void main(String[] args) {
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		System.out.println("browset got launched");
		driver.manage().window().maximize();
		System.out.println("browset got maximised");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		// navigate to organization link

		driver.findElement(By.linkText("Organizations")).click();
		// click on org look up image

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//random
		Random r = new Random();
		int value = r.nextInt(100);
		
		
		driver.findElement(By.name("accountname")).sendKeys("Busseness21" + value);
		// save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// varify
		String Organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (Organization.contains("Busseness21" + value)) {
			System.out.println(Organization + "passs");
		} else {
			System.out.println(Organization + "failed");
		}

		// logout of application
		WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// close
		driver.quit();

	}

}

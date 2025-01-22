package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactDemo {

	public static void main(String[] args) {
		// Launch the browser
		WebDriver driver = new ChromeDriver();
		System.out.println("browser got launched");
		driver.manage().window().maximize();
		System.out.println("browser got maximise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");

		// login with valid crendential
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");

		driver.findElement(By.id("submitButton")).click();
		System.out.println("login succsesfully");
		// navigate to contact link

		driver.findElement(By.linkText("Contacts")).click();
		// click on contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// cfreate contact with mandotary feilds
		driver.findElement(By.name("lastname")).sendKeys("saw");
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

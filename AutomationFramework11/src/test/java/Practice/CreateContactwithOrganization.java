package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactwithOrganization {

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
				//select org from org lookup image
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
				
				
                  //switch to child window
				String parentId = driver.getWindowHandle();
				Set<String> allwindowIds = driver.getWindowHandles();

				for (String id : allwindowIds) {
					// switch to child
					driver.switchTo().window(parentId);
					driver.findElement(By.linkText("Qspidersss")).click();
					break;

				}
				// switch back to parent
				driver.switchTo().window(parentId);
				
				
				

	}

}

package projectorangehrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInPageOrangeHRM {

	public static void main(String[] args) {
		
		//1.Launch Chrome Browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser(Method chaining)
		driver.manage().window().maximize();
		
		//2. Navigate to OrangeHRM url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//wait in Login Page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//3. Find username field
        WebElement username = driver.findElement(By.name("username"));
        
        //4. Enter username value
        username.sendKeys("Admin");
        
        //5. Find password field
        WebElement password = driver.findElement(By.name("password"));
        
        //6. Enter password value
        password.sendKeys("admin123");
        
        //7. Locate login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        
       //7. click the button
        loginButton.click();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

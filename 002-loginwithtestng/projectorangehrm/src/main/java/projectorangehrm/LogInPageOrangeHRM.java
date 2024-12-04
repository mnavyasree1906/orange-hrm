package projectorangehrm;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LogInPageOrangeHRM {
	private WebDriver driver;
    private Properties properties;
    
    
    @BeforeClass
	public void setup() {
		//Load config.properties
		properties = new Properties();
		try(InputStream input = LogInPageOrangeHRM.class.getClassLoader().getResourceAsStream("config.properties")) {
			if(input == null) {
				Assert.fail("Sorry, unable to find the config.properties file");
			}
			properties.load(input);
		} catch (Exception e) {
			Assert.fail("Error loading config.properties: " + e.getMessage());
		}
		
		// Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Set implicit wait
        String implicitWaitStr = properties.getProperty("implicit.wait.duration");
        int implicitWait = Integer.parseInt(implicitWaitStr);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        }
		
    @Test
    public void testLogin() {
        // Retrieve properties
        String appUrl = properties.getProperty("app.url");
        String usernameValue = properties.getProperty("login.username");
        String passwordValue = properties.getProperty("login.password");
		
		
		//3. Navigate to OrangeHRM url
		driver.get(appUrl);
		
		//5. Find username field
        WebElement username = driver.findElement(By.name("username"));
        
        //6. Enter username value
        username.sendKeys(usernameValue);
        
        //7. Find password field
        WebElement password = driver.findElement(By.name("password"));
        
        //8. Enter password value
        password.sendKeys(passwordValue);
        
        //9. Locate login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        
       //10. click the button
        loginButton.click();
        
     // Validate login success using an explicit wait
        String assertionWaitStr = properties.getProperty("assertion.wait.duration");
        int assertionWait = Integer.parseInt(assertionWaitStr);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(assertionWait));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-header-breadcrumb")));
        String messageText = successMessage.getText();

        // Assertion for the success message
        Assert.assertTrue(messageText.contains("Dashboard"), "Login failed: Expected 'Dashboard' in success message.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
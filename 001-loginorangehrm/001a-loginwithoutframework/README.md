# Project: OrangeHRM Login Automation

## Purpose
This project automates the login process of the OrangeHRM demo website using Selenium WebDriver. It opens the site, enters valid credentials, clicks the login button, and verifies the success of the login by checking for a success message.

## Technologies Used
- **Java**: Programming language used.
- **Selenium WebDriver**: Tool used for automating web applications.
- **ChromeDriver**: WebDriver implementation for Chrome browser.

## Code

```java
package projectorangehrm;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPageOrangeHRM {

    public static void main(String[] args) {
        
        // 1. Launch Chrome Browser
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser (Method chaining)
        driver.manage().window().maximize();
        
        // 2. Navigate to OrangeHRM URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        // Wait on the Login Page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        // 3. Find username field
        WebElement username = driver.findElement(By.name("username"));
        
        // 4. Enter username value
        username.sendKeys("Admin");
        
        // 5. Find password field
        WebElement password = driver.findElement(By.name("password"));
        
        // 6. Enter password value
        password.sendKeys("admin123");
        
        // 7. Locate login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        
        // 8. Click the button
        loginButton.click();
        
        // 9. Assert for success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-header-breadcrumb")));
        String messageText = successMessage.getText();
        
        if (messageText.contains("Dashboard") || messageText.contains("Logged In Successfully")) {
            System.out.println("Login successful: " + messageText);
        } else {
            System.out.println("Login failed or unexpected result.");
        }    
    }
}
```
## Steps of the Login Automation:
1. Launch Chrome Browser: Initializes the Chrome browser for automation.
2. Maximize Browser Window: Maximizes the browser window for easier interaction.
3. Navigate to OrangeHRM Login Page: Opens the OrangeHRM login page.
4. Wait for the Login Page to Load: Implicit wait to allow elements to load.
5. Find Username Field: Locates the username input field and enters the username.
6. Find Password Field: Locates the password input field and enters the password.
7. Locate and Click the Login Button: Locates the login button and clicks it.
8. Wait for Success Message: Explicit wait for the success message to appear.
9. Verify Login Success: Checks if the login was successful by verifying the success message text.

## Expected Outcome:
If the login is successful, the output will be
```java
Login successful: Dashboard
```
![image](https://github.com/user-attachments/assets/181051f2-bd25-47bd-9d0f-502289924953)

## If the login fails, the output will be:
```java
Login failed or unexpected result.
```
## How to Run:
1. Ensure Java and Selenium WebDriver are installed.
2. Download ChromeDriver for your system and set it up.
3. Set up the project with Selenium libraries.
4. Run the LogInPageOrangeHRM.java file.

---

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

    ChromeDriver CD;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        CD = new ChromeDriver();
        CD.get("http://localhost:1002/orangehrm/web/index.php/auth/login");
    }

    @Test
    // Test Case: LILO-02 - Verify login successfully with valid credentials
    public void loginSuccessfullyWithValidCredentials() {
        String Username = "Admin";
        String Password = "0123456Huy***";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement inputUS = CD.findElement(By.name("username"));
        inputUS.sendKeys(Username);
        WebElement inputPS = CD.findElement(By.name("password"));
        inputPS.sendKeys(Password);
        WebElement btLogin = CD.findElement(By.cssSelector("button[type='submit']"));
        btLogin.click();
    }
}
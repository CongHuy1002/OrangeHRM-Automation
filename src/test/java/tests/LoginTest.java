package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LoginTest {

    ChromeDriver CD;
    WebDriverWait wait ;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        CD = new ChromeDriver();
        CD.get("http://localhost:1002/orangehrm/web/index.php/auth/login");
    }

    @AfterTest
    public void clean(){
        CD.quit();
    }

    @Test
    // Test Case: LILO-02 - Verify login successfully with valid credentials
    public void loginSuccessfullyWithValidCredentials() {
        String Username = "Admin";
        String Password = "0123456Huy***";
        // wait chờ tối đa 10s cho đến khi ô username hiển thị trên UI trước khi thao tác
        wait = new WebDriverWait(CD, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement inputUS = CD.findElement(By.name("username"));
        inputUS.sendKeys(Username);
        WebElement inputPS = CD.findElement(By.name("password"));
        inputPS.sendKeys(Password);
        WebElement btLogin = CD.findElement(By.cssSelector("button[type='submit']"));
        btLogin.click();
    }

    @Test
    // Test Case: LILO-03 - Verify system shows error message when login with username only (password is empty)
    public void loginWithUsernameOnly_ShowErrorMessage(){
        String Username = "Admin";
        String errormessagePS = "Required";
        // wait chờ tối đa 10s cho đến khi ô username hiển thị trên UI trước khi thao tác
        wait = new WebDriverWait(CD, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement inputUS = CD.findElement(By.name("username"));
        inputUS.sendKeys(Username);
        WebElement btLogin = CD.findElement(By.cssSelector("button[type='submit']"));
        btLogin.click();
        WebElement messagePS = CD.findElement(By.cssSelector("span[class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'"));
        messagePS.getText();
        Assert.assertEquals(messagePS.getText(), errormessagePS);
        System.out.println(messagePS.getText());
        System.out.println(errormessagePS);
    }

    @Test
    // Test Case: LILO-04 - Verify system shows error message when login with password only (admin is empty)
    public void loginWithPasswordOnly_ShowErrorMessage(){
        String Password = "0123456Huy***";
        String errormessageUS = "Required";
        // wait chờ tối đa 10s cho đến khi ô username hiển thị trên UI trước khi thao tác
        wait = new WebDriverWait(CD, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement inputPS = CD.findElement(By.name("password"));
        inputPS.sendKeys(Password);
        WebElement btLogin = CD.findElement(By.cssSelector("button[type='submit']"));
        btLogin.click();
        WebElement messageUS = CD.findElement(By.cssSelector("span[class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        messageUS.getText();
        Assert.assertEquals(messageUS.getText(),errormessageUS);
        System.out.println(messageUS.getText());
        System.out.println(errormessageUS);
    }
}
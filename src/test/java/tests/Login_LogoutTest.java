package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login_LogoutPage;

import java.time.Duration;
import java.util.List;


public class Login_LogoutTest extends BaseTest {

    Login_LogoutPage login_logoutPage;
    String Username = "Admin";
    String Password = "123456Huy***";
    String UsernameWrong = "Admin12";
    String PasswordWrong = "0123456HUy***";
    String errormessageUS = "Required";
    String errormessagePS = "Required";
    String invalidmessage = "Invalid credentials";

    @BeforeMethod
    public void initPage(){
        login_logoutPage = new Login_LogoutPage(driver);
    }

    @Test(priority = 1)
    // Test Case: LILO-01 - Check UI Login page
    public void CheckUILoginPage(){
        // Check Username Input
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'oxd-input-group')]//input[@name = 'username']")).isEnabled());
        // Check Password Input
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'oxd-input-group')]//input[@name = 'password']")).isEnabled());
        // Check Button Login
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'oxd-form-actions orangehrm-login-action']//button")).isEnabled());
        // Check Hyperlink Forgot Password
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")).isEnabled());
        // Check Hyperlink OrangeHRM, Inc
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-copyright']//a[@target = '_blank']")).isEnabled());
    }

    @Test(priority = 2)
    // Test Case: LILO-02 - Verify login successfully with valid credentials
    public void loginSuccessfullyWithValidCredentials() {
        login_logoutPage.enterUsername(Username);
        login_logoutPage.enterPassword(Password);
        login_logoutPage.clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Dashboard","Login fail!");
    }

    @Test(priority = 3)
    // Test Case: LILO-03 - Verify system shows error message when login with username only (password is empty)
    public void loginWithUsernameOnly_ShowErrorMessage(){
        login_logoutPage.enterUsername(Username);
        login_logoutPage.clickLogin();
        Assert.assertEquals(login_logoutPage.getErrorMessage(),errormessagePS);
    }

    @Test(priority = 4)
    // Test Case: LILO-04 - Verify system shows error message when login with password only (username is empty)
    public void loginWithPasswordOnly_ShowErrorMessage(){
        login_logoutPage.enterPassword(Password);
        login_logoutPage.clickLogin();
        Assert.assertEquals(login_logoutPage.getErrorMessage(),errormessageUS);
    }

    @Test(priority = 5)
    // Test Case: LILO-05 - Verify system shows error message when login with username and password is empty
    public void loginWithAdminandPasswordIsEmpty_ShowErrorMessage(){
        login_logoutPage.clickLogin();
        List<String> messages = login_logoutPage.getAllErrorMessages();
        Assert.assertEquals(messages.size(),2);
        Assert.assertTrue(messages.contains(errormessageUS));
    }

    @Test(priority = 6)
    // Test Case: LILO-06 - Verify system shows error message when login with username is invalid
    public void loginWithAdminInvalid_ShowErrorMessage(){
        login_logoutPage.login(UsernameWrong,Password);
        Assert.assertEquals(login_logoutPage.getInvalidLoginMessage(),invalidmessage);
    }

    @Test(priority = 7)
    // Test Case: LILO-07 - Verify system shows error message when login with password is invalid
    public void loginWithPasswordInvalid_ShowErrorMessage(){
        login_logoutPage.login(Username,PasswordWrong);
        Assert.assertEquals(login_logoutPage.getInvalidLoginMessage(),invalidmessage);
    }

    @Test(priority = 8)
    // Test Case: LILO-08 - Verify logout successfully after login
    public void logoutSuccessfullyAfterLogin(){
        login_logoutPage.login(Username,Password);
        login_logoutPage.logout();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class = 'oxd-text oxd-text--h5 orangehrm-login-title']")));
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Login","Logout fail!");
    }
}
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login_LogoutPage;

import java.util.List;


public class Login_LogoutTest {

    WebDriver driver;
    WebDriverWait wait ;
    Login_LogoutPage login_logoutPage;

    String Username = "Admin";
    String Password = "0123456Huy***";
    String UsernameWrong = "Admin12";
    String PasswordWrong = "0123456HUy***";
    String errormessageUS = "Required";
    String errormessagePS = "Required";
    String invalidmessage = "Invalid credentials";

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:1002/orangehrm/web/index.php/auth/login");
        login_logoutPage = new Login_LogoutPage(driver);
    }

    @AfterMethod
    public void clean(){
        driver.quit();
    }

    @Test
    // Test Case: LILO-02 - Verify login successfully with valid credentials
    public void loginSuccessfullyWithValidCredentials() {
        login_logoutPage.enterUsername(Username);
        login_logoutPage.enterPassword(Password);
        login_logoutPage.clickLogin();
    }

    @Test
    // Test Case: LILO-03 - Verify system shows error message when login with username only (password is empty)
    public void loginWithUsernameOnly_ShowErrorMessage(){
        login_logoutPage.enterUsername(Username);
        login_logoutPage.clickLogin();
        Assert.assertEquals(login_logoutPage.getErrorMessage(),errormessagePS);
    }

    @Test
    // Test Case: LILO-04 - Verify system shows error message when login with password only (admin is empty)
    public void loginWithPasswordOnly_ShowErrorMessage(){
        login_logoutPage.enterPassword(Password);
        login_logoutPage.clickLogin();
        Assert.assertEquals(login_logoutPage.getErrorMessage(),errormessageUS);
    }

    @Test
    // Test Case: LILO-05 - Verify system shows error message when login with admin and password is empty
    public void loginWithAdminandPasswordIsEmpty_ShowErrorMessage(){
        login_logoutPage.clickLogin();
        List<String> messages = login_logoutPage.getAllErrorMessages();
        Assert.assertEquals(messages.size(),2);
        Assert.assertTrue(messages.contains(errormessageUS));
    }

    @Test
    // Test Case: LILO-06 - Verify system shows error message when login with admin is invalid
    public void loginWithAdminInvalid_ShowErrorMessage(){
        login_logoutPage.login(UsernameWrong,Password);
        Assert.assertEquals(login_logoutPage.getInvalidLoginMessage(),invalidmessage);
    }

    @Test
    // Test Case: LILO-07 - Verify system shows error message when login with password is invalid
    public void loginWithPasswordInvalid_ShowErrorMessage(){
        login_logoutPage.login(Username,PasswordWrong);
        Assert.assertEquals(login_logoutPage.getInvalidLoginMessage(),invalidmessage);
    }

    @Test
    // Test Case: LILO-08 - Verify logout successfully after login
    public void logoutSuccessfullyAfterLogin(){
        login_logoutPage.login(Username,Password);
        login_logoutPage.logout();
    }

}
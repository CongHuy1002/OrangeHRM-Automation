package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Login_LogoutPage;

public class BaseTestLogin extends BaseTest {
    protected Login_LogoutPage loginPage;

    @BeforeMethod
    public void login(){
        driver.get("http://localhost:8080/orangehrm/web/index.php/auth/login");
        loginPage = new Login_LogoutPage(driver);
        loginPage.login("Admin","123456Huy***");
    }
}

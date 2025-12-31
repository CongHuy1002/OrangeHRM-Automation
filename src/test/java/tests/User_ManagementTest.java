package tests;

import base.BaseTestLogin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.User_ManagementPage;

public class User_ManagementTest extends BaseTestLogin {
    User_ManagementPage user_managementPage;
    @BeforeMethod
    public void initPage(){
        user_managementPage = new User_ManagementPage(driver);
    }

    @Test
    // Test Case: ADM-02 - Verify search successfully with valid credentials
    public void searchSuccessfullyWithValidCredentials(){
        user_managementPage.Search("Admin","Công Huy Trương");
    }
}

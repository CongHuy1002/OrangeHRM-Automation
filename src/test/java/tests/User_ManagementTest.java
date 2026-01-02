package tests;

import base.BaseTestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.User_ManagementPage;

import java.time.Duration;
import java.util.List;

public class User_ManagementTest extends BaseTestLogin {
    User_ManagementPage user_managementPage;

    public void verifyAllRowsHaveUsername(String expectedUsername) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0,"Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][2]")
            ).getText();
            Assert.assertEquals(actualRole, expectedUsername,"Username không đúng");
        }
    }

    public void verifyAllRowsHaveUserRole(String expectedRole) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0,"Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][3]")
            ).getText();
            Assert.assertEquals(actualRole, expectedRole, "User Role không đúng");
        }
    }

    public void verifyAllRowsHaveEmployeeName(String expectedEmployeeName) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0,"Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][4]")
            ).getText();
            Assert.assertEquals(actualRole,expectedEmployeeName,"Employee Name không đúng");
        }
    }
    public void verifyAllRowsHaveStatus(String expectedStatus) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0,"Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][5]")
            ).getText();
            Assert.assertEquals(actualRole, expectedStatus, "Status không đúng");
        }
    }
    @BeforeMethod
    public void initPage(){
        user_managementPage = new User_ManagementPage(driver);
    }

    @Test
    // Test Case: ADM-02 - Verify search successfully with valid credentials
    public void searchSuccessfullyWithValidCredentials(){
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("PHTPhat");
        user_managementPage.setselectESSUserRole();
        user_managementPage.enterEmployeeName("Huỳnh Tấn Phát Phạm");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("PHTPhat");
        verifyAllRowsHaveUserRole("ESS");
        verifyAllRowsHaveEmployeeName("Huỳnh Tấn Phát Phạm");
        verifyAllRowsHaveStatus("Enabled");
    }

    @Test
    // Test Case: ADM-03 - Verify search successfully with Username only
    public void searchSuccessfullyWithUsernameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("MLTDat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Test Case: ADM-04 - Verify search successfully with Username only case_insensitive
    public void searchSuccessfullyWithUsernameOnlyCase_Insensitive(){
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("mltdat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Test Case: ADM-05 - Verify search successfully with User Role only is Admin
    public void searchSuccessfullyWithUserRoleOnlyIsAdmin(){
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectAdminUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("Admin");
    }

    @Test
    // Test Case: ADM-06 - Verify search successfully with User Role only is ESS
    public void searchSuccessfullyWithUserRoleOnlyIsESS(){
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectESSUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("ESS");
    }

    @Test
    // Test Case: ADM-07 - Verify search successfully with Employee Name only
    public void searchSuccessfullyWithEmployeeNameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.enterEmployeeName("Công Huy Trương");
        user_managementPage.clickSearch();
        verifyAllRowsHaveEmployeeName("Công Huy Trương");
    }
}

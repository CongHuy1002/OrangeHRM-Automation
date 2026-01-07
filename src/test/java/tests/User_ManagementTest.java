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
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][2]")
            ).getText();
            Assert.assertEquals(actualRole, expectedUsername, "Username không đúng");
        }
    }

    public void verifyAllRowsHaveUserRole(String expectedRole) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
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
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][4]")
            ).getText();
            Assert.assertEquals(actualRole, expectedEmployeeName, "Employee Name không đúng");
        }
    }

    public void verifyAllRowsHaveStatus(String expectedStatus) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][5]")
            ).getText();
            Assert.assertEquals(actualRole, expectedStatus, "Status không đúng");
        }
    }

    public void CheckUsernameInput(){
        WebElement usernameInput = driver.findElement(By.xpath("//div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')] / " +
                ".//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')] / .//input[contains(@class, 'oxd-input oxd-input--active')]"));

        String value = usernameInput.getAttribute("value");
        System.out.println(value);

        Assert.assertTrue(value== null || value.isEmpty(),
                "Username input should be empty");
    }

    public void CheckUserRoleDropdown(){
        WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));

        String selectedText = userRoleDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "-- Select --";
        Assert.assertEquals(selectedText,text,"User Role should be empty by default");
    }

    public void CheckEmployeeNameInput(){
        WebElement employeeInput = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));

        String value = employeeInput.getAttribute("value");
        System.out.println(value);

        Assert.assertTrue(value == null || value.isEmpty(),
                "Employee Name should be empty");
    }

    public void CheckStatusDropdown(){
        WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));

        String selectedText = statusDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "-- Select --";
        Assert.assertEquals(selectedText,text,"User Role should be empty by default");
    }

    @BeforeMethod
    public void initPage() {
        user_managementPage = new User_ManagementPage(driver);
    }


    // Search Function
    @Test
    // Test Case: ADM-01 - Check UI User Management page
    public void CheckUIUserManagementPage(){
        user_managementPage.setModuleAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
            (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@role='rowgroup']//div[@role='row']"))
            );
        // check Username input
        Assert.assertTrue( driver.findElement(By.xpath("//div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')] /" +
                ".//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')] / .//input[contains(@class, 'oxd-input oxd-input--active')]")).isEnabled());
        // check User Role input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // check Employee Name input
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).isEnabled());
        // check Status input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // check button Reset
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']")).isEnabled());
        // check button Search
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).isEnabled());
        // check button Add
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']")).isEnabled());
        // checkbox Username
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Admin123']]//span[contains(@class,'oxd-checkbox-input')]")).isEnabled());
        // check Icon button delete
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Admin123']]//i[contains(@class,'bi-trash')]")).isEnabled());
        // check Icon button edit
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Admin123']]//button[contains(@class,'oxd-icon-button')][1]")).isEnabled());
        user_managementPage.clickCheckBox();
        By deleteBtn = By.xpath("//button[normalize-space()='Delete Selected']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn)).isDisplayed());
    }
    @Test
    public void checkboxUsername(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickCheckBox();
    }

    @Test
    // Test Case: ADM-02 - Verify search successfully with valid credentials
    public void searchSuccessfullyWithValidCredentials() {
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
    public void searchSuccessfullyWithUsernameOnly() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("MLTDat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Test Case: ADM-04 - Verify search successfully with Username only case_insensitive
    public void searchSuccessfullyWithUsernameOnlyCase_Insensitive() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("mltdat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Test Case: ADM-05 - Verify search successfully with User Role only is Admin
    public void searchSuccessfullyWithUserRoleOnlyIsAdmin() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectAdminUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("Admin");
    }

    @Test
    // Test Case: ADM-06 - Verify search successfully with User Role only is ESS
    public void searchSuccessfullyWithUserRoleOnlyIsESS() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectESSUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("ESS");
    }

    @Test
    // Test Case: ADM-07 - Verify search successfully with Employee Name only
    public void searchSuccessfullyWithEmployeeNameOnly() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterEmployeeName("Công Huy Trương");
        user_managementPage.clickSearch();
        verifyAllRowsHaveEmployeeName("Công Huy Trương");
    }

    @Test
    // Test Case: ADM-08 - Verify search successfully with Employee Name only case_insensitive
    public void searchSuccessfullyWithEmployeeNameOnlyCase_Insensitive() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterEmployeeName("công huy trương");
        user_managementPage.clickSearch();
        verifyAllRowsHaveEmployeeName("Công Huy Trương");
    }

    @Test
    // Test Case: ADM-09 - Verify search successfully with Status only is Enabled
    public void searchSuccessfullyWithStatusOnlyIsEnabled() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clickSearch();
        verifyAllRowsHaveStatus("Enabled");
    }

    @Test
    // Test Case: ADM-10 - Verify search successfully with Status only is Disabled
    public void searchSuccessfullyWithStatusOnlyIsDisabled() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setSelectDisabledStatus();
        user_managementPage.clickSearch();
        verifyAllRowsHaveStatus("Disabled");
    }

    @Test
    // Test Case: ADM-11 - Verify search successfully with empty values
    public void searchSuccessfullyWithEmptyValues() {
        user_managementPage.setModuleAdmin();
        user_managementPage.clickSearch();
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
    }


    // Reset Function
    @Test
    // Test Case: ADM-12 - Verify reset successfully with enter all the information and do not search
    public void resetSuccessfullyWithEnterAllTheInformationAndDoNotSearch() {
        user_managementPage.ResetBeforeSearch("Admin","Công Huy Trương");
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");

        CheckUsernameInput();
        CheckUserRoleDropdown();
        CheckEmployeeNameInput();
        CheckStatusDropdown();
    }

    @Test
    // Test Case: ADM-13 - Verify reset successfully with enter all the information and completing the search
    public void resetSuccessfullyWithEnterAllTheInformationAndCompletingTheSearch(){
        user_managementPage.ResetAfterSearch("Admin123","Việt Thành Mai");
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");

        CheckUsernameInput();
        CheckUserRoleDropdown();
        CheckEmployeeNameInput();
        CheckStatusDropdown();
    }

    @Test
    // Test Case: ADM-14 - Verify navigate to Add User page
    public void verifyNavigateToAddUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
        (ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
        );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Add User","It's not Add User page");
    }

    @Test
    // Test Case: ADM-15 - Check UI Add User page
    public void CheckUIAddUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
            (ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
            );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Add User","It's not Add User page");

       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='User Role']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Employee Name']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Status']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Username']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Confirm Password']")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Save']")).isEnabled());
       Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).isEnabled());
    }

    @Test
    // Test Case: ADM-16 - Verify add user successfully with valid credentials
    public void addSuccessfullyWithValidCredentials(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
                );
        user_managementPage.setESSUserRoleAU();
        user_managementPage.enterEmployeeNameAU("Phong Mai Lê Tiến");
        user_managementPage.setEnabledStatusAU();
        user_managementPage.enterUsernameAU("MLTPhong");
        user_managementPage.enterPasswordAU("123456Phong*");
        user_managementPage.enterConfirmPasswordAU("123456Phong*");
        user_managementPage.ClickButtonSave();
    }

    @Test
    // Test Case: ADM-17 - Verify add user fail with password and confirm password did not match
    public void addUserFailWithPasswordAndConfirmPasswordDidNotMatch(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
            (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
            );
        user_managementPage.setESSUserRoleAU();
        user_managementPage.enterEmployeeNameAU("Hùng Mai Lê Tiến");
        user_managementPage.setEnabledStatusAU();
        user_managementPage.enterUsernameAU("MLTHung");
        user_managementPage.enterPasswordAU("123456Hung***");
        user_managementPage.enterConfirmPasswordAU("123456Hung*");
        user_managementPage.ClickButtonSave();
        Assert.assertEquals(user_managementPage.getDidNotMatchMessage(),"Passwords do not match");
    }

    @Test
    // Test Case: ADM-18 - Verify add user fail with User Role only
    public void addUserFailWithUserRoleOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setESSUserRoleAU();
        user_managementPage.ClickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Test Case: ADM-19 - Verify add user fail with Employee Name only
    public void addUserFailWithEmployeeNameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterEmployeeNameAU("Việt Thành Mai");
        user_managementPage.ClickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Test Case: ADM-20 - Verify add user fail with Employee Name only case_insensitive
    public void addUserFailWithEmployeeNameOnlyCase_Insensitive(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterEmployeeNameAU("việt thành mai");
        user_managementPage.ClickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Test Case: ADM-21 - Verify add user fail with Status only
    public void addUserFailWithStatusOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setEnabledStatusAU();
        user_managementPage.ClickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }
}

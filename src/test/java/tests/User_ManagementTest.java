package tests;

import base.BaseTestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.User_ManagementPage;

import java.time.Duration;
import java.util.List;

public class User_ManagementTest extends BaseTestLogin {
    User_ManagementPage user_managementPage;

    // Kiểm tra giá trị sau khi search
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

    // Kiểm tra giá trị sau khi delete
    public void verifyUserIsDeleted(String username) {
        By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));
        List<WebElement> rows = driver.findElements(tableRows);
        if (rows.size() == 0) {
            System.out.println("Delete user '" + username + "' thành công");
        } else {
            Assert.fail("Delete user '" + username + "' KHÔNG thành công, vẫn còn trong danh sách");
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

    public void Sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void CheckTitleIsSystemUsers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h5[contains(@class, 'oxd-table-filter-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"System Users","It's not System Users Page");
    }

    public void CheckTitleIsAddUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Add User","It's not Add User Page");
    }

    public void CheckTitleIsEditUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class,'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Edit User","It's not Edit User Page");
    }

    @BeforeMethod
    public void initPage() {
        user_managementPage = new User_ManagementPage(driver);
    }

    /*@BeforeMethod
    public void createUser(){
            user_managementPage.setModuleAdmin();
            user_managementPage.clickAdd();
            user_managementPage.setselectESSUserRole();
            user_managementPage.enterEmployeeName("Lê Tiến Hùng Mai");
            user_managementPage.setSelectEnabledStatus();
            user_managementPage.enterUsername("MLTHung");
            user_managementPage.enterPassword("123456Hung***");
            user_managementPage.enterConfirmPassword("123456Hung***");
            user_managementPage.clickButtonSave();
    }

    @AfterMethod
    public void deleteUser(){
        user_managementPage.enterUsername("Lê Tiến Hùng Mai");
        user_managementPage.clickSearch();
        By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));
        List<WebElement> rows = driver.findElements(tableRows);
        if (rows.size() > 0) {
            user_managementPage.clickIconButtonDeleteMLTHung();
            user_managementPage.clickConfirmDelete();
        }
    }*/

    @Test
    // Check UI
    // Test Case: ADM-01 - Check UI User Management page
    public void CheckUIUserManagementPage(){
        user_managementPage.setModuleAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='rowgroup']//div[@role='row']")));
        // check Username input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
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
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Admin123']]//button[contains(@class,'oxd-icon-button')][2]")).isEnabled());
        user_managementPage.clickCheckBoxUsernameAdmin123();
        By deleteBtn = By.xpath("//button[normalize-space()='Delete Selected']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn)).isDisplayed());
    }

    @Test
    // Search Function
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
    // Search Function
    // Test Case: ADM-03 - Verify search successfully with Username only
    public void searchSuccessfullyWithUsernameOnly() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("MLTDat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Search Function
    // Test Case: ADM-04 - Verify search successfully with Username only case_insensitive
    public void searchSuccessfullyWithUsernameOnlyCase_Insensitive() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterUsername("mltdat");
        user_managementPage.clickSearch();
        verifyAllRowsHaveUsername("MLTDat");
    }

    @Test
    // Search Function
    // Test Case: ADM-05 - Verify search successfully with User Role only is Admin
    public void searchSuccessfullyWithUserRoleOnlyIsAdmin() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectAdminUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("Admin");
    }

    @Test
    // Search Function
    // Test Case: ADM-06 - Verify search successfully with User Role only is ESS
    public void searchSuccessfullyWithUserRoleOnlyIsESS() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setselectESSUserRole();
        user_managementPage.clickSearch();
        verifyAllRowsHaveUserRole("ESS");
    }

    @Test
    // Search Function
    // Test Case: ADM-07 - Verify search successfully with Employee Name only
    public void searchSuccessfullyWithEmployeeNameOnly() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterEmployeeName("Công Huy Trương");
        user_managementPage.clickSearch();
        verifyAllRowsHaveEmployeeName("Công Huy Trương");
    }

    @Test
    // Search Function
    // Test Case: ADM-08 - Verify search successfully with Employee Name only case_insensitive
    public void searchSuccessfullyWithEmployeeNameOnlyCase_Insensitive() {
        user_managementPage.setModuleAdmin();
        user_managementPage.enterEmployeeName("công huy trương");
        user_managementPage.clickSearch();
        verifyAllRowsHaveEmployeeName("Công Huy Trương");
    }

    @Test
    // Search Function
    // Test Case: ADM-09 - Verify search successfully with Status only is Enabled
    public void searchSuccessfullyWithStatusOnlyIsEnabled() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clickSearch();
        verifyAllRowsHaveStatus("Enabled");
    }

    @Test
    // Search Function
    // Test Case: ADM-10 - Verify search successfully with Status only is Disabled
    public void searchSuccessfullyWithStatusOnlyIsDisabled() {
        user_managementPage.setModuleAdmin();
        user_managementPage.setSelectDisabledStatus();
        user_managementPage.clickSearch();
        verifyAllRowsHaveStatus("Disabled");
    }

    @Test
    // Search Function
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


    @Test
    // Reset Function
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
    // Reset Function
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
    // Check nagivate
    // Test Case: ADM-14 - Verify navigate to Add User page
    public void verifyNavigateToAddUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        CheckTitleIsAddUser();
    }

    @Test
    // Check UI
    // Test Case: ADM-15 - Check UI Add User page
    public void CheckUIAddUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        CheckTitleIsAddUser();
        // Check User Role Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Employee Name Input
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).isEnabled());
        // Check Status Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Username Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Password Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Confirm Password Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check button Save
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']")).isEnabled());
        // Check button Cancel
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']")).isEnabled());
    }

    @Test
    // Add Function
    // Test Case: ADM-16 - Verify add user successfully with valid credentials
    public void addSuccessfullyWithValidCredentials(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setselectESSUserRole();
        user_managementPage.enterEmployeeName("Lê Tiến Phong Mai");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.enterUsername("MLTPhong");
        user_managementPage.enterPassword("123456Phong***");
        user_managementPage.enterConfirmPassword("123456Phong***");
        user_managementPage.clickButtonSave();
    }

    @Test
    // Add Function
    // Test Case: ADM-17 - Verify add user fail with password and confirm password did not match
    public void addUserFailWithPasswordAndConfirmPasswordDidNotMatch(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setselectESSUserRole();
        user_managementPage.enterEmployeeName("Lê Tiến Hùng Mai");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.enterUsername("MLTHung");
        user_managementPage.enterPassword("123456Hung***");
        user_managementPage.enterConfirmPassword("123456Hung*");
        user_managementPage.clickButtonSave();
        Assert.assertEquals(user_managementPage.getDidNotMatchMessage(),"Passwords do not match");
    }

    @Test
    // Add Function
    // Test Case: ADM-18 - Verify add user fail with User Role only
    public void addUserFailWithUserRoleOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setselectESSUserRole();
        user_managementPage.clickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-19 - Verify add user fail with Employee Name only
    public void addUserFailWithEmployeeNameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterEmployeeName("Việt Thành Mai");
        user_managementPage.clickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-20 - Verify add user fail with Employee Name only case_insensitive
    public void addUserFailWithEmployeeNameOnlyCase_Insensitive(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterEmployeeName("việt thành mai");
        user_managementPage.clickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-21 - Verify add user fail with Status only
    public void addUserFailWithStatusOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-22 - Verify add user fail with Ussername only
    public void addUserFailWithUssernameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterUsername("MVThanh");
        user_managementPage.clickButtonSave();
        Sleep();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-23 - Verify add user fail with Password only
    public void addUserFailWithPasswordOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterPassword("123456Thanh***");
        user_managementPage.clickButtonSave();
        Sleep();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test
    // Add Function
    // Test Case: ADM-24 - Verify add user fail with Confirm Password only
    public void addUserFailWithConfirmPasswordOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.enterConfirmPassword("123456Thanh***");
        user_managementPage.clickButtonSave();
        Sleep();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),6);
        Assert.assertTrue(messages.contains("Required"));
        Assert.assertTrue(messages.contains("Passwords do not match"));
    }

    @Test
    // Add Function
    // Test Case: ADM-25 - Verify add user fail with valid credentials and Cancel
    public void addUserFailWithValidCredentialsAndCancel(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.setselectESSUserRole();
        user_managementPage.enterEmployeeName("Lê Tiến Hùng Mai");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.enterUsername("MLTHung");
        user_managementPage.enterPassword("123456Hung***");
        user_managementPage.enterConfirmPassword("123456Hung***");
        Sleep();
        user_managementPage.clickButtonCancel();
        CheckTitleIsSystemUsers();
    }

    @Test
    // Add Function
    // Test Case: ADM-26 - Verify add user fail with empty values
    public void addUserFailWithEmptyValues(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickAdd();
        user_managementPage.clickButtonSave();
        Sleep();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),6);
        Assert.assertTrue(messages.contains("Required"));
        Assert.assertTrue(messages.contains("Passwords do not match"));
    }

    @Test
    // Check navigate
    // Test Case: ADM-27 - Verify navigate to Edit User page
    public void verifyNavigateToEditUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        CheckTitleIsEditUser();
    }

    @Test
    // Check UI
    // Test Case: ADM-28 - Check UI Edit User page
    public void CheckUIEditUserPage(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        CheckTitleIsEditUser();
        // Check User Role Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Employee Name Input
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).isEnabled());
        // Check Status Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Username Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check button Change Password?
        Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='Yes']//span[contains(@class,'oxd-checkbox-input')]")).isEnabled());
        user_managementPage.clickCheckBoxChangePassword();
        // Check Password Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Confirm Password Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check button Save
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']")).isEnabled());
        // Check button Cancel
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']")).isEnabled());
    }

    @Test
    // Edit Function
    // Test Case: ADM-29 - Verify edit user with User Role only
    public void editUserWithUserRoleOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        Sleep();
        user_managementPage.setselectESSUserRole();
        user_managementPage.clickButtonSave();
        CheckTitleIsSystemUsers();
        user_managementPage.clickIconButtonEditAdmin123();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UserRole = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"))
                );
        System.out.println(UserRole.getText());
        Assert.assertEquals(UserRole.getText(),"ESS","Edit User fail!!");
    }

    @Test
    // Edit Function
    // Test Case: ADM-30 - Verify edit user with Status only
    public void editUserWithStatusOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        Sleep();
        user_managementPage.setSelectDisabledStatus();
        user_managementPage.clickButtonSave();
        CheckTitleIsSystemUsers();
        user_managementPage.clickIconButtonEditAdmin123();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Status = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"))
                );
        System.out.println(Status.getText());
        Assert.assertEquals(Status.getText(),"Disabled","Edit User fail!!");
    }

    @Test
    // Edit Function
    // Test Case: ADM-31 - Verify edit user with Employee Name only
    public void editUserWithEmployeeNameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        Sleep();
        user_managementPage.clearAndEnterEmployeeName("Thu Giang Vũ");
        user_managementPage.clickButtonSave();
        CheckTitleIsSystemUsers();
        user_managementPage.clickIconButtonEditAdmin123();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement EmployeeName = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@placeholder='Type for hints...']"))
                );
        String EmployeeNameValue = EmployeeName.getAttribute("value");
        Assert.assertEquals(EmployeeNameValue,"Thu Giang  Vũ","Edit User fail!");
    }

    @Test
    // Edit Function
    // Test Case: ADM-32 - Verify edit user with Username only
    public void editUserWithUsernameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        Sleep();
        user_managementPage.clearAndEnterUsername("Admin12");
        user_managementPage.clickButtonSave();
    }

    @Test
    // Edit Function
    // Test Case: ADM-33 - Verify edit user with Password and Confirm Password are the same only
    public void editUserWithPasswordAndConfirmPasswordAreTheSameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditMLTPhong();
        Sleep();
        user_managementPage.clickCheckBoxChangePassword();
        user_managementPage.clearAndEnterPassword("123456Phong***");
        user_managementPage.clearAndEnterConfirmPassword("123456Phong***");
        user_managementPage.clickButtonSave();
        CheckTitleIsSystemUsers();
    }

    @Test
    // Edit Function
    // Test Case: ADM-34 - Verify edit user with Password and Confirm Password are not the same only
    public void editUserWithPasswordAndConfirmPasswordAreNotTheSameOnly(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditMLTPhong();
        user_managementPage.clickCheckBoxChangePassword();
        user_managementPage.enterPassword("123456Phong*");
        user_managementPage.enterConfirmPassword("123457Phong*");
        user_managementPage.clickButtonSave();
        Assert.assertEquals(user_managementPage.getDidNotMatchMessage(),"Passwords do not match");
    }


    @Test
    // Edit Function
    // Test Case: ADM-35 - Verify edit user fail with valid credentials and Cancel
    public void editUserFailWithValidCredentialsAndCancel(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditMLTPhong();
        user_managementPage.setselectAdminUserRole();
        user_managementPage.clearAndEnterEmployeeName("Việt Thành Mai");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clearAndEnterUsername("Admin1");
        user_managementPage.clickCheckBoxChangePassword();
        user_managementPage.clearAndEnterPassword("123456Thanh***");
        user_managementPage.clearAndEnterConfirmPassword("123456Thanh***");
        user_managementPage.clickButtonCancel();
        CheckTitleIsSystemUsers();
    }

    @Test
    // Edit Function
    // Test Case: ADM-36 - Verify edit user with valid credentials
    public void editUserWithValidCredentials(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditMLTPhong();
        user_managementPage.setselectAdminUserRole();
        user_managementPage.clearAndEnterEmployeeName("Việt Thành Mai");
        user_managementPage.setSelectEnabledStatus();
        user_managementPage.clearAndEnterUsername("Admin1");
        user_managementPage.clickCheckBoxChangePassword();
        user_managementPage.clearAndEnterPassword("123456Thanh***");
        user_managementPage.clearAndEnterConfirmPassword("123456Thanh***");
        user_managementPage.clickButtonSave();
        CheckTitleIsSystemUsers();
        user_managementPage.enterUsername("Admin1");
        user_managementPage.clickSearch();
        Sleep();
        verifyAllRowsHaveUsername("Admin1");
        verifyAllRowsHaveEmployeeName("Việt Thành Mai");
    }

    @Test
    // Edit Function
    // ID Bug: OTP-126
    // Test Case: ADM-37 - Verify edit user with empty values
    public void editUserWithEmptyValues(){
        user_managementPage.setModuleAdmin();
        user_managementPage.clickIconButtonEditAdmin123();
        user_managementPage.clickButtonSave();
        List<String> messages = user_managementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("The values not change"));
    }

    @Test
    // Delete Function
    // Test Case: ADM-38 - Verify delete user with Icon button
    public void deleteUserWithIconButton(){
        user_managementPage.DeleteAndConfirmDeleteIcon();
        CheckTitleIsSystemUsers();
        user_managementPage.enterUsername("Admin123");
        user_managementPage.clickSearch();
        verifyUserIsDeleted("Admin123");
    }

    @Test
    // Delete Function
    // Test Case: ADM-39 - Verify delete Cancel user with Icon button
    public void deleteCancelUserWithIconButton(){
        user_managementPage.DeleteAndConfirmCancelIcon();
        CheckTitleIsSystemUsers();
        user_managementPage.enterUsername("MLTPhong");
        user_managementPage.clickSearch();
        Sleep();
        verifyAllRowsHaveUsername("MLTPhong");
    }

    @Test
    // Delete Function
    // Test Case: ADM-40 - Verify delete user with checkbox Username
    public void deleteUserWithCheckBoxUsername(){
        user_managementPage.DeleteAndConfirmDeleteCheckBox();
        CheckTitleIsSystemUsers();
        user_managementPage.enterUsername("MLTPhong");
        user_managementPage.clickSearch();
        Sleep();
        verifyUserIsDeleted("MLTPhong");
    }

    @Test
    // Delete Function
    // Test Case: ADM-41 - Verify delete Cancel user with checkbox Username
    public void deleteCancelUserWithCheckBoxUsername(){
        user_managementPage.DeleteAndConfirmCancelCheckBox();
        CheckTitleIsSystemUsers();
        user_managementPage.enterUsername("MLTHung");
        user_managementPage.clickSearch();
        Sleep();
        verifyAllRowsHaveUsername("MLTHung");
    }

}

package tests;

import base.BaseTestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Leave_EntitlementPage;

import java.time.Duration;
import java.util.List;

public class Leave_EntitlementTest extends BaseTestLogin {
    Leave_EntitlementPage leaveEntitlementPage;

    @BeforeMethod
    public void initPage() {
        leaveEntitlementPage = new Leave_EntitlementPage(driver);
    }

    public void CheckThisLeaveTypeRequiredInRows(String expectedFirstName) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        int count = 0;
        Assert.assertTrue(rows.size() > 0, "Không có kết quả");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][2]")
            ).getText();
            if (actualRole.equals(expectedFirstName)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 1);
    }
    public void CheckThisDaysRequiredInRows(String expectedFirstName) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        int count = 0;
        Assert.assertTrue(rows.size() > 0, "Không có kết quả");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][6]")
            ).getText();
            if (actualRole.equals(expectedFirstName)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 1);
    }


    @Test(priority = 1)
    // Check UI
    // Test Case: LEA-29 - Check UI Add Leave Entitlement
    public void CheckUIAddLeaveEntitlement(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Add Leave Entitlement","It's not a Add Leave Entitlement page");
        // Check Radio Button Individual Employee
        Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='Individual Employee']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check Radio Button Multiple Employees
        Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='Multiple Employees']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check Employee Name Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input")).isEnabled());
        // Check Leave Type Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Leave Period Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leave Period']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Entitlement Input
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Entitlement']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Button Cancel
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']")).isEnabled());
        // Check Button Save
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']")).isEnabled());
    }

    @Test(priority = 2)
    // Add function
    // Test Case: LEA-30 - Verify add leave entitlement for employee with valid credentials
    public void addLeaveEntitlementWithValidCredentials(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.enterEmployeeName("Thu Giang Vũ");
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperiod1();
        leaveEntitlementPage.enterEntitlement("12");
        leaveEntitlementPage.ClickButtonSave();
        leaveEntitlementPage.ClickButtonConfirm1();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h5[contains(@class, 'oxd-table-filter-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Leave Entitlements","It's not a Leave Entitlements page");
        leaveEntitlementPage.ClickButtonSearch();
        CheckThisLeaveTypeRequiredInRows("Nghỉ việc cá nhân");
        CheckThisDaysRequiredInRows("12");
    }

    @Test(priority = 3)
    // Add function
    // Test Case: LEA-31 - Verify add leave entitlement for employee with Employee Name only
    public void addLeaveEntitlementForEmployeeWithEmployeeNameOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.enterEmployeeName("Thu Giang Vũ");
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 4)
    // Add function
    // Test Case: LEA-32 - Verify add leave entitlement for employee with Add to only
    public void addLeaveEntitlementForEmployeeWithAddToOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),4);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 5)
    // Add function
    // Test Case: LEA-33 - Verify add leave entitlement for employee with Leave Type only
    public void addLeaveEntitlementForEmployeeWithLeaveTypeOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 6)
    // Add function
    // Test Case: LEA-34 - Verify add leave entitlement for employee with Leave Period only
    public void addLeaveEntitlementForEmployeeWithLeavePeriodOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.setSelectperiod1();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 7)
    // Add function
    // Test Case: LEA-35 - Verify add leave entitlement for employee with Entitlement only
    public void addLeaveEntitlementForEmployeeWithEntitlementOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonIndividualEmployee();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.enterEntitlement("6");
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 8)
    // Add function
    // Test Case: LEA-36 - Verify add leave entitlement for multiple employees with valid credentials
    public void addLeaveEntitlementForMultipleEmployeesWithValidCredentials(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonMultipleEmployees();
        leaveEntitlementPage.setSelectHaNoiLocation();
        leaveEntitlementPage.setSelectQASubunit();
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperiod1();
        leaveEntitlementPage.enterEntitlement("5");
        leaveEntitlementPage.ClickButtonSave();
        leaveEntitlementPage.ClickButtonConfirm2();
        leaveEntitlementPage.enterEmployeeName("Anh Đạt   Huỳnh");
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperiod1();
        leaveEntitlementPage.ClickButtonSearch();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h5[contains(@class, 'oxd-table-filter-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Leave Entitlements","It's not a Leave Entitlements page");
        leaveEntitlementPage.ClickButtonSearch();
        CheckThisLeaveTypeRequiredInRows("Nghỉ việc cá nhân");
        CheckThisDaysRequiredInRows("5");
        leaveEntitlementPage.clearandenterEmployeeName("Lê Tiến Hùng  Mai");
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperiod1();
        leaveEntitlementPage.ClickButtonSearch();
        leaveEntitlementPage.ClickButtonSearch();
        CheckThisLeaveTypeRequiredInRows("Nghỉ việc cá nhân");
        CheckThisDaysRequiredInRows("5");
    }

    @Test(priority = 9)
    // Add function
    // Test Case: LEA-37 - Verify add leave entitlement for multiple employees with Location only
    public void addLeaveEntitlementForMultipleEmployeesWithLocationOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonMultipleEmployees();
        leaveEntitlementPage.setSelectHaNoiLocation();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 10)
    // Add function
    // Test Case: LEA-38 - Verify add leave entitlement for multiple employees with Sub Unit only
    public void addLeaveEntitlementForMultipleEmployeesWithSubUnitOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonMultipleEmployees();
        leaveEntitlementPage.setSelectITSubunit();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 11)
    // Add function
    // Test Case: LEA-39 - Verify add leave entitlement for multiple employees with Leave Type only
    public void addLeaveEntitlementForMultipleEmployeesWithLeaveTypeOnly(){
        leaveEntitlementPage.setModuleLeave();
        leaveEntitlementPage.setSelectAddEntitlements();
        leaveEntitlementPage.ClickRadioButtonMultipleEmployees();
        leaveEntitlementPage.setSelectNVCN();
        leaveEntitlementPage.setSelectperioddefault();
        leaveEntitlementPage.ClickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = leaveEntitlementPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),2);
        Assert.assertTrue(messages.contains("Required"));
    }
}

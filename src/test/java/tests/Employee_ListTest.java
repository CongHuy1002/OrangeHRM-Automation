package tests;

import base.BaseTestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Employee_ListPage;

import java.time.Duration;
import java.util.List;

public class Employee_ListTest extends BaseTestLogin {
    Employee_ListPage employeeListPage;

    public void CheckTitleIsEmployeeInformation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h5[contains(@class, 'oxd-table-filter-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not Employee List Page");
    }
    public void verifyAllRowsHaveId(String expectedId) {
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
            Assert.assertEquals(actualRole, expectedId, "Id không đúng");
        }
    }
    public void verifyAllRowsHaveFirstName(String expectedFirstName) {
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
            Assert.assertEquals(actualRole, expectedFirstName, "FirstName không đúng");
        }
    }
    public void verifyAllRowsHaveLastName(String expectedLastName) {
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
            Assert.assertEquals(actualRole, expectedLastName, "LastName không đúng");
        }
    }
    public void verifyAllRowsHaveJobTitle(String expectedJobTitle) {
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
            Assert.assertEquals(actualRole, expectedJobTitle, "Job Title không đúng");
        }
    }
    public void verifyAllRowsHaveEmploymentStatus(String expectedEmploymentStatus) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][6]")
            ).getText();
            Assert.assertEquals(actualRole, expectedEmploymentStatus, "Employment Status không đúng");
        }
    }
    public void verifyAllRowsHaveSubUnit(String expectedSubUnit) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][7]")
            ).getText();
            Assert.assertEquals(actualRole, expectedSubUnit, "Sub Unit không đúng");
        }
    }
    public void verifyAllRowsHaveSupervisor(String expectedSupervisor) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][8]")
            ).getText();
            Assert.assertEquals(actualRole, expectedSupervisor, "Supervisor không đúng");
        }
    }

    public void CheckThisIDRequiredInRows(String expectedId) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        int count = 0;
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][2]")
            ).getText();
            if (actualRole.equals(expectedId)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 1);
    }

    public void CheckThisIDRequiredIsNotInRows(String expectedId) {
        By tableBody = By.xpath("//div[@class='oxd-table-body']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        List<WebElement> rows = driver.findElements(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")
        );
        int count = 0;
        Assert.assertTrue(rows.size() > 0, "Không có kết quả Search");
        for (WebElement row : rows) {
            String actualRole = row.findElement(
                    By.xpath(".//div[@role='cell'][2]")
            ).getText();
            if (actualRole.equals(expectedId)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 0);
    }

    public void CheckEmployeeNameInput(){
        WebElement employeenameInput = driver.findElement(By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input"));
        String value = employeenameInput.getAttribute("value");
        System.out.println(value);
        Assert.assertTrue(value== null || value.isEmpty(),
                "Employee Name input should be empty");
    }

    public void CheckIdInput(){
        WebElement idInput = driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        String value = idInput.getAttribute("value");
        System.out.println(value);
        Assert.assertTrue(value== null || value.isEmpty(),
                "Id input should be empty");
    }

    public void CheckEmploymentStatusDropdown(){
        WebElement employmentstatusDropdown = driver.findElement(By.xpath("//label[text()='Employment Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        String selectedText = employmentstatusDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "-- Select --";
        Assert.assertEquals(selectedText,text,"Employment Status should be empty by default");
    }

    public void CheckIncludeDropdown(){
        WebElement includeDropdown = driver.findElement(By.xpath("//label[text()='Include']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        String selectedText = includeDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "Current Employees Only";
        Assert.assertEquals(selectedText,text,"Include should be 'Current Employees Only' by default");
    }

    public void CheckSupervisorNameInput(){
        WebElement supervisornameInput = driver.findElement(By.xpath("//label[text()='Supervisor Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input"));
        String value = supervisornameInput.getAttribute("value");
        System.out.println(value);
        Assert.assertTrue(value== null || value.isEmpty(),
                "Supervisor Name input should be empty");
    }

    public void CheckJobTitleDropdown(){
        WebElement jobtitleDropdown = driver.findElement(By.xpath("//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        String selectedText = jobtitleDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "-- Select --";
        Assert.assertEquals(selectedText,text,"Job Title should be empty by default");
    }

    public void CheckSubUnitDropdown(){
        WebElement subunitDropdown = driver.findElement(By.xpath("//label[text()='Sub Unit']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));
        String selectedText = subunitDropdown.getText().trim();
        System.out.println(selectedText);
        String text = "-- Select --";
        Assert.assertEquals(selectedText,text,"Sub Unit should be empty by default");
    }

    public void Sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void initPage() {
        employeeListPage = new Employee_ListPage(driver);
    }

    @Test(priority = 1)
    // Check UI
    // Test Case: PIM-01 - Check UI Employee List page
    public void checkUIEmployeeListPage(){
        employeeListPage.setModulePIM();
        CheckTitleIsEmployeeInformation();
        // Check Employee Name Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]")).isEnabled());
        // Check Employee id Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Employee Status Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Employment Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Include Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Include']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Supervisor Name Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Supervisor Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]")).isEnabled());
        // Check Job Title Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Sub Unit Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Sub Unit']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Button Reset
        Assert.assertTrue( driver.findElement(By.xpath("//button[@type='reset']")).isEnabled());
        // Check Button Search
        Assert.assertTrue( driver.findElement(By.xpath("//button[@type='submit']")).isEnabled());
        // Check Button Add
        Assert.assertTrue( driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']")).isEnabled());
        Sleep();
        // Check Checkbox All id
        Assert.assertTrue( driver.findElement(By.xpath("//div[contains(@class,'oxd-table-header')]//label")).isEnabled());
        // Check Checkbox id
        Assert.assertTrue( driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Anh Đạt  ']]//span[contains(@class,'oxd-checkbox-input')]")).isEnabled());
        // Check Icon Button Edit
        Assert.assertTrue( driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Anh Đạt  ']]//button[contains(@class,'oxd-icon-button')][2]")).isEnabled());
        // Check Icon Button Delete
        Assert.assertTrue( driver.findElement(By.xpath("//div[@role='row'][.//div[text()='Anh Đạt  ']]//i[contains(@class,'bi-trash')]")).isEnabled());
    }

    @Test(priority = 2)
    // Test Case: PIM-02 - Check the default value of the Include field
    public void checkTheDefaultValueOfTheIncludeField(){
        employeeListPage.setModulePIM();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Include']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Current Employees Only","The default value isn't 'Current Employees Only'.");
    }

    @Test(priority = 3)
    // Test Case: PIM-03 - Verify search successfully with valid credentials
    public void searchSuccessfullyWithValidCredentials(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeName("Huỳnh Tấn Phát  Phạm");
        employeeListPage.enterEmployeeId("0003");
        employeeListPage.setSelectPartTimeEmploymentStatus();
        employeeListPage.setSelectCurrentInclude();
        employeeListPage.enterSupervisorName("Công Huy Trương");
        employeeListPage.setSelectHRJobtitle();
        employeeListPage.setSelectHRSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveId("0003");
        verifyAllRowsHaveFirstName("Huỳnh Tấn Phát");
        verifyAllRowsHaveLastName("Phạm");
        verifyAllRowsHaveJobTitle("HR Administrator");
        verifyAllRowsHaveEmploymentStatus("Part-Time");
        verifyAllRowsHaveSubUnit("HR Department");
        verifyAllRowsHaveSupervisor("Công Huy Trương");
    }

    @Test(priority = 4)
    // Search function
    // Test Case: PIM-04 - Verify search successfully with Employee Name Only
    public void searchSuccessfullyWithEmployeeNameOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeName("Thu Giang Vũ");
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveFirstName("Thu Giang");
        verifyAllRowsHaveLastName("Vũ");
    }

    @Test(priority = 5)
    // Search function
    // Test Case: PIM-05 - Verify search successfully with Employee Name Only case_insensitive
    public void searchSuccessfullyWithEmployeeNameOnlyCase_insensitive(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeName("thu giang vũ");
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveFirstName("Thu Giang");
        verifyAllRowsHaveLastName("Vũ");
    }

    @Test(priority = 6)
    // Search function
    // Test Case: PIM-06 - Verify search successfully with Employee id Only
    public void searchSuccessfullyWithEmployeeIdOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeId("0005");
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveId("0005");
    }

    @Test(priority = 7)
    // Search function
    // Test Case: PIM-07 - Verify search successfully with Employment Status is Full-Time Only
    public void searchSuccessfullyWithEmploymentStatusIsFullTimeOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectFullTimeEmploymentStatus();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveEmploymentStatus("Full-Time");
    }

    @Test(priority = 8)
    // Search function
    // Test Case: PIM-08 - Verify search successfully with Employment Status is Part-Time Only
    public void searchSuccessfullyWithEmploymentStatusIsPartTimeOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectPartTimeEmploymentStatus();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveEmploymentStatus("Part-Time");
    }

    @Test(priority = 9)
    // Search function
    // Test Case: PIM-09 - Verify search successfully with Employment Status is Intern Only
    public void searchSuccessfullyWithEmploymentStatusIsInternOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectInternEmploymentStatus();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveEmploymentStatus("Intern");
    }

    @Test(priority = 10)
    // Search function
    // Test Case: PIM-10 - Verify search successfully with Include Is Current Only
    public void searchSuccessfullyWithIncludeIsCurrentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectCurrentInclude();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredInRows("0009");
        CheckThisIDRequiredIsNotInRows("0007");
    }

    @Test(priority = 11)
    // Search function
    // Test Case: PIM-11 - Verify search successfully with Include Is Current And Past Only
    public void searchSuccessfullyWithIncludeIsCurrentAndPastOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectCurrentAndPastInclude();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredInRows("0009");
        CheckThisIDRequiredInRows("0007");
    }

    @Test(priority = 12)
    // Search function
    // Test Case: PIM-12 - Verify search successfully with Include Is Past Only
    public void searchSuccessfullyWithIncludeIsPastOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectPastInclude();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredInRows("0007");
        CheckThisIDRequiredIsNotInRows("0009");
    }

    @Test(priority = 13)
    // Search function
    // Test Case: PIM-13 - Verify search successfully with Supervisor Name Only
    public void searchSuccessfullyWithSupervisorNameOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.enterSupervisorName("Công Huy Trương");
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSupervisor("Công Huy Trương");
    }

    @Test(priority = 14)
    // Search function
    // Test Case: PIM-14 - Verify search successfully with Supervisor Name Only case_insensitive
    public void searchSuccessfullyWithSupervisorNameOnlyCase_insensitive(){
        employeeListPage.setModulePIM();
        employeeListPage.enterSupervisorName("công huy trương");
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSupervisor("Công Huy Trương");
    }

    @Test(priority = 15)
    // Search function
    // Test Case: PIM-15 - Verify search successfully with Job Title Is Fullstack Developer Only
    public void searchSuccessfullyWithJobTitleIsFullstackDeveloperOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectFullstackJobtitle();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveJobTitle("Fullstack Developer");
    }

    @Test(priority = 16)
    // Search function
    // Test Case: PIM-16 - Verify search successfully with Job Title Is HR Administrator Only
    public void searchSuccessfullyWithJobTitleIsHRAdministratorOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectHRJobtitle();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveJobTitle("HR Administrator");
    }

    @Test(priority = 17)
    // Search function
    // Test Case: PIM-17 - Verify search successfully with Job Title Is Project Manager Only
    public void searchSuccessfullyWithJobTitleIsProjectManagerOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectPMJobtitle();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveJobTitle("Project Manager");
    }

    @Test(priority = 18)
    // Search function
    // Test Case: PIM-18 - Verify search successfully with Job Title Is QA Engineer Only
    public void searchSuccessfullyWithJobTitleIsQAEngineerOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectQAJobtitle();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveJobTitle("QA Engineer");
    }

    @Test(priority = 19)
    // Search function
    // Test Case: PIM-19 - Verify search successfully with Sub Unit Is QA Department Only
    public void searchSuccessfullyWithSubUnitIsQADepartmentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectQASubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("QA Department");
    }

    @Test(priority = 20)
    // Search function
    // Test Case: PIM-20 - Verify search successfully with Sub Unit Is IT Department Only
    public void searchSuccessfullyWithSubUnitIsITDepartmentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectITSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("IT Department");
    }

    @Test(priority = 21)
    // Search function
    // Test Case: PIM-21 - Verify search successfully with Sub Unit Is Recruitment Team Only
    public void searchSuccessfullyWithSubUnitIsRecruitmentTeamOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectRecruitmentSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("Recruitment Team");
    }

    @Test(priority = 22)
    // Search function
    // Test Case: PIM-22 - Verify search successfully with Sub Unit Is HR Department Only
    public void searchSuccessfullyWithSubUnitIsHRDepartmentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectHRSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("HR Department");
    }

    @Test(priority = 23)
    // Search function
    // Test Case: PIM-23 - Verify search successfully with Sub Unit Is Sales Department Only
    public void searchSuccessfullyWithSubUnitIsSalesDepartmentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectSalesSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("Sales Department");
    }

    @Test(priority = 24)
    // Search function
    // Test Case: PIM-24 - Verify search successfully with Sub Unit Is Marketing Department Only
    public void searchSuccessfullyWithSubUnitIsMarketingDepartmentOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.setSelectMaketingSubunit();
        employeeListPage.clickButtonSearch();
        verifyAllRowsHaveSubUnit("Marketing Department");
    }

    @Test(priority = 25)
    // Search function
    // Test Case: PIM-25 - Verify search successfully with Values Is Empty
    public void searchSuccessfullyWithValuesIsEmpty(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredInRows("0001");
        CheckThisIDRequiredInRows("0002");
        CheckThisIDRequiredInRows("0003");
        CheckThisIDRequiredInRows("0004");
        CheckThisIDRequiredInRows("0005");
        CheckThisIDRequiredInRows("0006");
        CheckThisIDRequiredInRows("0008");
        CheckThisIDRequiredInRows("0009");
        CheckThisIDRequiredIsNotInRows("0007");
    }

    @Test(priority = 26)
    // Reset function
    // Test Case: PIM-26 - Verify reset successfully with valid credentials before search
    public void resetSuccessfullyWithValidCredentialsBeforeSearch(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeName("Huỳnh Tấn Phát Phạm");
        employeeListPage.enterEmployeeId("0003");
        employeeListPage.setSelectPartTimeEmploymentStatus();
        employeeListPage.setSelectCurrentInclude();
        employeeListPage.enterSupervisorName("Công Huy Trương");
        employeeListPage.setSelectHRJobtitle();
        employeeListPage.setSelectRecruitmentSubunit();
        employeeListPage.clickButtonReset();
        CheckTitleIsEmployeeInformation();
        CheckEmployeeNameInput();
        CheckIdInput();
        CheckEmploymentStatusDropdown();
        CheckIncludeDropdown();
        CheckSupervisorNameInput();
        CheckJobTitleDropdown();
        CheckSubUnitDropdown();
    }

    @Test(priority = 27)
    // Reset function
    // Test Case: PIM-26 - Verify reset successfully with valid credentials after search
    public void resetSuccessfullyWithValidCredentialsAfterSearch(){
        employeeListPage.setModulePIM();
        employeeListPage.enterEmployeeName("Huỳnh Tấn Phát Phạm");
        employeeListPage.enterEmployeeId("0003");
        employeeListPage.setSelectPartTimeEmploymentStatus();
        employeeListPage.setSelectCurrentInclude();
        employeeListPage.enterSupervisorName("Công Huy Trương");
        employeeListPage.setSelectHRJobtitle();
        employeeListPage.setSelectRecruitmentSubunit();
        employeeListPage.clickButtonSearch();
        employeeListPage.clickButtonReset();
        CheckTitleIsEmployeeInformation();
        CheckEmployeeNameInput();
        CheckIdInput();
        CheckEmploymentStatusDropdown();
        CheckIncludeDropdown();
        CheckSupervisorNameInput();
        CheckJobTitleDropdown();
        CheckSubUnitDropdown();
    }

    @Test(priority = 28)
    // Reset function
    // Test Case: PIM-28 - Verify reset successfully with value is empty
    public void resetSuccessfullyWithValueIsEmpty(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonReset();
        CheckTitleIsEmployeeInformation();
        CheckEmployeeNameInput();
        CheckIdInput();
        CheckEmploymentStatusDropdown();
        CheckIncludeDropdown();
        CheckSupervisorNameInput();
        CheckJobTitleDropdown();
        CheckSubUnitDropdown();
    }
}

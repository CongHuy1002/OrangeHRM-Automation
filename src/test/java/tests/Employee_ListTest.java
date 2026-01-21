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

    public void CheckTitleIsAddEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Add Employee","It's not Add Employee Page");
    }

    public void CheckTitleIsPersonalDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Personal Details","It's not Personal Details Page");
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

    public void CheckThisFirstNameRequiredInRows(String expectedFirstName) {
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
                    By.xpath(".//div[@role='cell'][3]")
            ).getText();
            if (actualRole.equals(expectedFirstName)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 1);
    }

    public void CheckThisFirstNameRequiredIsNotInRows(String expectedFirstName) {
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
                    By.xpath(".//div[@role='cell'][3]")
            ).getText();
            if (actualRole.equals(expectedFirstName)){
                count +=1;
            }
        }
        Assert.assertEquals(count , 0);
    }

    public void CheckThisIDRequiredInRows(String expectedId) {
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
        Assert.assertTrue(rows.size() > 0, "Không có kết quả");
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

    @Test(priority = 29)
    // Check navigate
    // Test Case: PIM-29 - Verify navigate to Add Employee page
    public void VerifyNavigateToAddEmployeePage(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        CheckTitleIsAddEmployee();
    }

    @Test(priority = 30)
    // Check UI
    // Test Case: PIM-30 - Check UI Add Employee Page
    public void CheckUIAddEmployeePage(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        Sleep();
        // Check button Avatar
        Assert.assertTrue( driver.findElement(By.xpath("//div[@class = 'employee-image-wrapper']")).isEnabled());
        // Check Employee First Name Input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-firstname']")).isEnabled());
        // Check Employee Middle Name Input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-middlename']")).isEnabled());
        // Check Employee Last Name Input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-lastname']")).isEnabled());
        // Check Employee id Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-grid-item')]//input")).isEnabled());
        // Check button Create Login Details
        Assert.assertTrue( driver.findElement(By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']")).isEnabled());
        employeeListPage.clickCheckboxCreateLoginDetails();
        // Check Username Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check radio button Enabled
        Assert.assertTrue( driver.findElement(By.xpath("//label[normalize-space()='Enabled']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check radio button Disabled
        Assert.assertTrue( driver.findElement(By.xpath("//label[normalize-space()='Disabled']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check Password Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Confirm Password Input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check button Cancel
        Assert.assertTrue( driver.findElement(By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']")).isEnabled());
        // Check button Save
        Assert.assertTrue( driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']")).isEnabled());
    }

    @Test(priority = 31)
    // Add function
    // Test Case: PIM-31 - Verify add user successfully with valid credentials
    public void addUserSuccessfullyWithValidCredentials(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.enteremployeefirstname("Đức Huy");
        employeeListPage.enteremployeelastname("Bùi");
        employeeListPage.clearandenterEmployeeId("0018");
        String imagePath = System.getProperty("user.dir")
                + "/src/test/java/images/Avatar.jpg";
        employeeListPage.uploadEmployeePhoto(imagePath);
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterusername("BDHuy");
        employeeListPage.clickButtonDisabled();
        employeeListPage.enterpassword("123456Huy***");
        employeeListPage.enterconfirmpassword("123456Huy***");
        employeeListPage.clickButtonSave();
        Sleep();
        CheckTitleIsPersonalDetails();
    }

    @Test(priority = 32)
    // Add function
    // Bug ID: OTP-129
    // Test Case: PIM-32 - Verify add user fail with Employee Full Name only and clear Employee id
    public void addUserFailWithEmployeeFullNameOnlyAndClearEmployeeId(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.enteremployeefirstname("Minh Tâm");
        employeeListPage.enteremployeelastname("Nguyễn");
        employeeListPage.clearandenterEmployeeId("");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 33)
    // Add function
    // Test Case: PIM-33 - Verify add user fail with Employee id only
    public void addUserFailWithEmployeeIdOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),2);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 34)
    // Add function
    // Bug ID: OTP-129
    // Test Case: PIM-34 - Verify add user fail with upload Avatar only and clear Employee id
    public void addUserFailWithUploadAvatarOnlyAndClearEmployeeId(){
        employeeListPage.setModulePIM();
        String imagePath = System.getProperty("user.dir")
                + "/src/test/java/images/Avatar.jpg";
        employeeListPage.clickButtonAdd();
        employeeListPage.enteremployeefirstname("");
        employeeListPage.enteremployeelastname("");
        employeeListPage.uploadEmployeePhoto(imagePath);
        employeeListPage.clearandenterEmployeeId("");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),3);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 35)
    // Add function
    // Test Case: PIM-36 - Verify add user fail with Status only
    public void addUserFailWithStatusOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 36)
    // Add function
    // Test Case: PIM-37 - Verify add user fail with Username only
    public void addUserFailWithUsernameOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterusername("TCHuy");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),4);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 37)
    // Add function
    // Test Case: PIM-38 - Verify add user fail with Password only
    public void addUserFailWithPasswordOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterpassword("123456Huy***");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),4);
        Assert.assertTrue(messages.contains("Required"));
    }

    @Test(priority = 38)
    // Add function
    // Test Case: PIM-39 - Verify add user fail with Confirm Password only
    public void addUserFailWithConfirmPasswordOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterconfirmpassword("123456Huy***");
        employeeListPage.clickButtonSave();
        Sleep();
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),5);
        Assert.assertTrue(messages.contains("Required"));
        Assert.assertTrue(messages.contains("Passwords do not match"));
    }

    @Test(priority = 39)
    // Add function
    // Test Case: PIM-40 - Verify add user fail with valid credentials but an id matching an existing user
    public void addUserFailWithValidCredentialsButAnIdMatchingAnExistingUser(){
        employeeListPage.setModulePIM();
        String imagePath = System.getProperty("user.dir")
                + "/src/test/java/images/Avatar.jpg";
        employeeListPage.clickButtonAdd();
        employeeListPage.enteremployeefirstname("Công Vinh");
        employeeListPage.enteremployeelastname("Lê");
        employeeListPage.clearandenterEmployeeId("0008");
        employeeListPage.uploadEmployeePhoto(imagePath);
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterusername("LCVinh");
        employeeListPage.clickButtonDisabled();
        employeeListPage.enterpassword("123456Vinh***");
        employeeListPage.enterconfirmpassword("123456Vinh***");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("Employee Id already exists"));
    }

    @Test(priority = 40)
    // Add function
    // Test Case: PIM-41 - Verify add user fail with valid credentials but the confirmpassword is not match with the password
    public void addUserFailWithValidCredentialsButTheConfirmpasswordIsNotMatchWithThePassword(){
        employeeListPage.setModulePIM();
        String imagePath = System.getProperty("user.dir")
                + "/src/test/java/images/Avatar.jpg";
        employeeListPage.clickButtonAdd();
        employeeListPage.enteremployeefirstname("Công Vinh");
        employeeListPage.enteremployeelastname("Lê");
        employeeListPage.uploadEmployeePhoto(imagePath);
        employeeListPage.clickCheckboxCreateLoginDetails();
        employeeListPage.enterusername("LCVinh");
        employeeListPage.clickButtonDisabled();
        employeeListPage.enterpassword("123456Vinh***");
        employeeListPage.enterconfirmpassword("Vinh***123456");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("Passwords do not match"));
    }

    @Test(priority = 41)
    // Add function
    // Test Case: PIM-42 - Verify cancel with values is empty
    public void cancelWithValuesIsEmpty(){
        employeeListPage.setModulePIM();
        employeeListPage.clickButtonAdd();
        employeeListPage.clickButtonCancel();
        CheckTitleIsEmployeeInformation();
    }

    @Test(priority = 42)
    // Check navigate
    // Test Case: PIM-43 - Check navigate to Personal Details page
    public void CheckNavigateToPersonalDetailsPage(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditPHTPhat();
        CheckTitleIsPersonalDetails();
    }

    @Test(priority = 43)
    // Check UI
    // Test Case: PIM-44 - Check UI Personal Details page
    public void CheckUIPersonalDetailsPage(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditPHTPhat();
        Sleep();
        // Check Employee first name input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-firstname']")).isEnabled());
        // Check Employee middle name input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-middlename']")).isEnabled());
        // Check Employee last name input
        Assert.assertTrue( driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-lastname']")).isEnabled());
        // Check Employee id input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Other id input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Driver's License Number input
        //Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Driver's License Number']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class, 'oxd-input oxd-input--active')]//input")).isEnabled());
        // Check License Expiry Date input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Nationality input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).isEnabled());
        // Check Marital Status input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class = 'oxd-select-text oxd-select-text--active']")).isEnabled());
        // Check Date of Birth input
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input")).isEnabled());
        // Check Gender radio Male
        Assert.assertTrue( driver.findElement(By.xpath("//label[normalize-space()='Male']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check Gender radio Female
        Assert.assertTrue( driver.findElement(By.xpath("//label[normalize-space()='Female']//span[contains(@class,'oxd-radio-input')]")).isEnabled());
        // Check Save button
        Assert.assertTrue( driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']")).isEnabled());
        // Check Add button
        Assert.assertTrue( driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--text']")).isEnabled());
        // Check Avatar button
        Assert.assertTrue( driver.findElement(By.xpath("//div[@class = 'orangehrm-edit-employee-image']")).isEnabled());
        // CheckPersonal Details button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Personal Details']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Contact Details button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Contact Details']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Emergency Contacts button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Emergency Contacts']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Dependents button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Dependents']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Immigration button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Immigration']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Job button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Job']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Salary button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Salary']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Report-to button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Report-to']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Qualifications button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Qualifications']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
        // Check Memberships button Menu
        Assert.assertTrue( driver.findElement(By.xpath("//a[text()='Memberships']/ancestor::div[contains(@class,'orangehrm-tabs-wrapper')]")).isEnabled());
    }

    @Test(priority = 44)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-45 - Verify edit information employee with Employee Full Name only
    public void editInformationEmployeeWithEmployeeFullNameOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditPHTPhat();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-firstname']"))
                );
        employeeListPage.clearandenterEmployeeFirstName("Vinh");
        employeeListPage.clearandenterEmployeeMiddleName("Công");
        employeeListPage.clearandenterEmployeeLastName("Lê");
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 45)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-46 - Verify edit information employee with Employee ID valid only
    public void editInformationEmployeeWithEmployeeIDValidOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTDat();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.clearandenterEmployeeId("0036");
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 46)
    // Edit function
    // Test Case: PIM-47 - Verify edit information employee with Employee ID is matching an existing user only
    public void editInformationEmployeeWithEmployeeIDIsMatchingAnExistingUserOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTDat();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.clearandenterEmployeeId("0003");
        employeeListPage.clickButtonSave();
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[contains(@class, 'oxd-input-group__message')]"))
                );
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("Employee Id already exists"));
    }

    @Test(priority = 47)
    // Edit function
    // Test Case: PIM-48 - Verify edit information employee with Other ID valid only
    public void editInformationEmployeeWithOtherIDValidOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTDat();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.clearandenterOtherId("1123");
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 48)
    // Edit function
    // Bug ID: OTP-131
    // Test Case: PIM-49 - Verify edit information employee with Other ID is matching an existing user only
    public void editInformationEmployeeWithOtherIDIsMatchingAnExistingUserOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.clearandenterOtherId("1123");
        employeeListPage.clickButtonSave();
        List<String> messages = employeeListPage.getAllRequiredMessages();
        System.out.println(messages);
        Assert.assertEquals(messages.size(),1);
        Assert.assertTrue(messages.contains("Other Id already exists"));
    }

    @Test(priority = 49)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-52 - Verify edit information employee with License Expiry Date only
    public void editInformationEmployeeWithLicenseExpiryDateOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        employeeListPage.enterlicenseexpirydate("2025-12-20");
        employeeListPage.clickButtonSave();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 50)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-53 - Verify edit information employee with Nationality only
    public void editInformationEmployeeWithNationalityOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"))
                );
        employeeListPage.setSelectVietnameseNationlity();
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 51)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-54 - Verify edit information employee with Marital Status only
    public void editInformationEmployeeWithMaritalStatusOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"))
                );
        employeeListPage.setSelectSingleMaritalStatus();
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 52)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-55 - Verify edit information employee with Date of Birth only
    public void editInformationEmployeeWithDateOfBirthOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.enterdateofbirth("2004-09-09");
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 53)
    // Edit function
    // Bug ID: OTP-130
    // Test Case: PIM-56 - Verify edit information employee with Gender only
    public void editInformationEmployeeWithGenderOnly(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonEditMLTPhong();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input"))
                );
        employeeListPage.clickMaleRadioButton();
        employeeListPage.clickButtonSave();
        WebElement title = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h6[contains(@class, 'orangehrm-main-title')]"))
                );
        System.out.println(title.getText());
        Assert.assertEquals(title.getText(),"Employee Information","It's not navigate to Employee List Page");
    }

    @Test(priority = 54)
    // Delete function
    // Test Case: PIM-57 - Verify delete employee with Icon Button Delete and Confirm Delete
    // Employee: ID-0036, first name - Lê Tiến Đạt, last name - Mai, Sub Unit - Sales, Status - Intern
    public void deleteEmployeeWithIconButtonDeleteAndConfirmDelete(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonDeleteMLTDat();
        employeeListPage.clickButtonconfirmDelete();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredIsNotInRows("0036");
    }

    @Test(priority = 55)
    // Delete function
    // Test Case: PIM-58 - Verify delete employee with Icon Button Delete and Confirm Cancel
    public void deleteEmployeeWithIconButtonDeleteAndConfirmCancel(){
        employeeListPage.setModulePIM();
        employeeListPage.clickIconButtonDeleteVTGiang();
        employeeListPage.clickButtonconfirmCancel();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredInRows("0005");
    }

    @Test(priority = 56)
    // Delete function
    // Test Case: PIM-59 - Verify delete employee with Checkbox ID and Confirm Delete
    // Employee: ID-0006, first name - Lê Tiến Phong, last name - Mai, Job Title - FullStack, Sub Unit - IT, Status - Intern
    public void deleteEmployeeWithCheckboxIDAndConfirmDelete() {
        employeeListPage.setModulePIM();
        employeeListPage.clickCheckboxMLTPhong();
        employeeListPage.clickButtonconfirmDeleteCheckbox();
        employeeListPage.clickButtonconfirmDelete();
        employeeListPage.clickButtonSearch();
        CheckThisIDRequiredIsNotInRows("0006");
    }
}

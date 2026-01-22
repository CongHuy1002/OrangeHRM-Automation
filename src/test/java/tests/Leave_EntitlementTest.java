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

public class Leave_EntitlementTest extends BaseTestLogin {
    Leave_EntitlementPage leaveEntitlementPage;

    @BeforeMethod
    public void initPage() {
        leaveEntitlementPage = new Leave_EntitlementPage(driver);
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



}

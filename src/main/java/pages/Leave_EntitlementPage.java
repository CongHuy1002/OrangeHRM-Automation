package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Leave_EntitlementPage extends BasePage {

    public Leave_EntitlementPage(WebDriver driver) {super(driver);}

    // Locators
    private By moduleLeave = By.xpath("//span[text()='Leave']/ancestor::a");
    private By entitlementsButton = By.xpath("//span[text()='Entitlements ']/ancestor::li[contains(@class,'oxd-topbar-body-nav-tab')]");
    private By selectAddEntitlements = By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='Add Entitlements']");
    private By individualemployeeRadioButton = By.xpath("//label[normalize-space()='Individual Employee']//span[contains(@class,'oxd-radio-input')]");
    private By multipleemployeesRadioButton = By.xpath("//label[normalize-space()='Multiple Employees']//span[contains(@class,'oxd-radio-input')]");
    private By employeenameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input");
    private By employeenameSuggestion = By.xpath("//div[@role='listbox']//span");
    private By leavetypeInput = By.xpath("//label[text()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectNVCN = By.xpath("//div[@role='listbox']//span[text()='Nghỉ việc cá nhân']");
    private By leaveperiodInput = By.xpath("//label[text()='Leave Period']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectperiod1 = By.xpath("//div[@role='listbox']//span[text()='2026-01-01 - 2026-12-31']");
    private By entitlementInput = By.xpath("//label[text()='Entitlement']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By cancleButton = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By saveButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");
    private By confirmAddButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Confirm']");
    private By confirmCancelButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Cancel']");
    private By searchButton = By.xpath("//button[@type='submit']");


    // Actions
    public void setModuleLeave(){click(moduleLeave);}
    public void setSelectAddEntitlements(){
        click(entitlementsButton);
        click(selectAddEntitlements);
    }
    public void setSelectNVCN(){
        click(leavetypeInput);
        click(selectNVCN);
    }
    public void setSelectperiod1(){
        click(leaveperiodInput);
        click(selectperiod1);
    }
    public void enterEmployeeName(String employeename){
        type(employeenameInput,employeename);
        click(employeenameSuggestion);
    }
    public void enterEntitlement(String entitlement){type(entitlementInput,entitlement);}

    public void ClickRadioButtonIndividualEmployee(){click(individualemployeeRadioButton);}
    public void ClickRadioButtonMultipleEmployees(){click(multipleemployeesRadioButton);}
    public void ClickButtonCancel(){click(cancleButton);}
    public void ClickButtonSave(){click(saveButton);}
    public void ClickButtonConfirm(){click(confirmAddButton);}
    public void ClickButtonConfirmCancel(){click(confirmCancelButton);}
    public void ClickButtonSearch(){click(searchButton);}
}

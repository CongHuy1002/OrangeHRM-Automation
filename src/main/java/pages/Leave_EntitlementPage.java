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
    private By leaveperiodInput = By.xpath("//label[text()='Leave Period']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By entitlementInput = By.xpath("//label[text()='Entitlement']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By cancleButton = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By saveButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");


    // Actions
    public void setModuleLeave(){click(moduleLeave);}
    public void setSelectAddEntitlements(){
        click(entitlementsButton);
        click(selectAddEntitlements);
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
}

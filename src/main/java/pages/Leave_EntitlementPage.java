package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    private By selectperioddefault = By.xpath("//label[text()='Leave Period']/ancestor::div[contains(@class,'oxd-input-group')]//div[text()='-- Select --']");
    private By entitlementInput = By.xpath("//label[text()='Entitlement']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By locationInput = By.xpath("//label[text()='Location']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectHaNoiLocation = By.xpath("//div[@role='listbox']//span[text()='Ha Noi Office']");
    private By selectHoChiMinhLocation = By.xpath("//div[@role='listbox']//span[text()='Ho Chi Minh Office']");
    private By subunitInput = By.xpath("//label[text()='Sub Unit']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectQASubunit = By.xpath("//div[@role='listbox']//span[text()='QA Department']");
    private By selectITSubunit = By.xpath("//div[@role='listbox']//span[text()='IT Department']");
    private By selectHRSubunit = By.xpath("//div[@role='listbox']//span[text()='HR Department']");
    private By selectRecruitmentSubunit = By.xpath("//div[@role='listbox']//span[text()='Recruitment Team']");
    private By selectSalesSubunit = By.xpath("//div[@role='listbox']//span[text()='Sales Department']");
    private By selectMaketingSubunit = By.xpath("//div[@role='listbox']//span[text()='Marketing Department']");
    private By cancleButton = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By saveButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");
    private By confirmAddButton1 = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Confirm']");
    private By confirmCancelButton1 = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Cancel']");
    private By confirmAddButton2 = By.xpath("//button[text()=' Confirm ']");
    private By confirmCancelButton2 = By.xpath("//button[text()=' Cancel ']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By requiredmessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");


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
    public void setSelectperioddefault(){
        click(leaveperiodInput);
        click(selectperioddefault);
    }
    public void setSelectHaNoiLocation(){
        click(locationInput);
        click(selectHaNoiLocation);
    }
    public void setSelectHoChiMinhLocation(){
        click(locationInput);
        click(selectHoChiMinhLocation);
    }
    public void setSelectQASubunit(){
        click(subunitInput);
        click(selectQASubunit);
    }
    public void setSelectITSubunit(){
        click(subunitInput);
        click(selectITSubunit);
    }
    public void setSelectHRSubunit(){
        click(subunitInput);
        click(selectHRSubunit);
    }
    public void setSelectRecruitmentSubunit(){
        click(subunitInput);
        click(selectRecruitmentSubunit);
    }
    public void setSelectSalesSubunit(){
        click(subunitInput);
        click(selectSalesSubunit);
    }
    public void setSelectMaketingSubunit(){
        click(subunitInput);
        click(selectMaketingSubunit);
    }
    public void enterEmployeeName(String employeename){
        type(employeenameInput,employeename);
        click(employeenameSuggestion);
    }
    public void clearandenterEmployeeName(String employeeName) {
        WebElement input = driver.findElement(employeenameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(employeeName);
    }
    public void enterEntitlement(String entitlement){type(entitlementInput,entitlement);}
    public List<String> getAllRequiredMessages() {
        List<WebElement> elements = driver.findElements(requiredmessage);
        List<String> messages = new ArrayList<>();

        for (WebElement el : elements) {
            messages.add(el.getText());
        }
        return messages;
    }

    public void ClickRadioButtonIndividualEmployee(){click(individualemployeeRadioButton);}
    public void ClickRadioButtonMultipleEmployees(){click(multipleemployeesRadioButton);}
    public void ClickButtonCancel(){click(cancleButton);}
    public void ClickButtonSave(){click(saveButton);}
    public void ClickButtonConfirm1(){click(confirmAddButton1);}
    public void ClickButtonConfirmCancel1(){click(confirmCancelButton1);}
    public void ClickButtonConfirm2(){click(confirmAddButton2);}
    public void ClickButtonConfirmCancel2(){click(confirmCancelButton2);}
    public void ClickButtonSearch(){click(searchButton);}
}

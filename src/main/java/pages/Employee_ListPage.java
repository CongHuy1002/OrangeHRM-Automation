package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Employee_ListPage extends BasePage {

    public Employee_ListPage(WebDriver driver) {super(driver);}

    // Locators
    private By modulePIM = By.xpath("//span[text()='PIM']/ancestor::a");
    private By employeenameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input");
    private By employeenameSuggestion = By.xpath("//div[@role='listbox']//span");
    private By employeeidInput  = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By employmentstatus = By.xpath("//label[text()='Employment Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectFullTimeEmploymentStatus = By.xpath("//div[@role='listbox']//span[text()='Full-Time']");
    private By selectPartTimeEmploymentStatus = By.xpath("//div[@role='listbox']//span[text()='Part-Time']");
    private By selectInternEmploymentStatus = By.xpath("//div[@role='listbox']//span[text()='Intern']");
    private By includeInput = By.xpath("//label[text()='Include']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectCurrentInclude = By.xpath("//div[@role='listbox']//span[text()='Current Employees Only']");
    private By selectCurrentAndPastInclude = By.xpath("//div[@role='listbox']//span[text()='Current and Past Employees']");
    private By selectPastInclude = By.xpath("//div[@role='listbox']//span[text()='Past Employees Only']");
    private By supervisornameInput = By.xpath("//label[text()='Supervisor Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]//input");
    private By supervisornameSuggestion = By.xpath("//div[@role='listbox']//span");
    private By jobtitleInput = By.xpath("//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectFullstackJobtitle = By.xpath("//div[@role='listbox']//span[text()='Fullstack Developer']");
    private By selectHRJobtitle = By.xpath("//div[@role='listbox']//span[text()='HR Administrator']");
    private By selectPMJobtitle = By.xpath("//div[@role='listbox']//span[text()='Project Manager']");
    private By selectQAJobtitle = By.xpath("//div[@role='listbox']//span[text()='QA Engineer']");
    private By subunitInput = By.xpath("//label[text()='Sub Unit']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectQASubunit = By.xpath("//div[@role='listbox']//span[text()='QA Department']");
    private By selectITSubunit = By.xpath("//div[@role='listbox']//span[text()='IT Department']");
    private By selectHRSubunit = By.xpath("//div[@role='listbox']//span[text()='HR Department']");
    private By selectRecruitmentSubunit = By.xpath("//div[@role='listbox']//span[text()='Recruitment Team']");
    private By selectSalesSubunit = By.xpath("//div[@role='listbox']//span[text()='Sales Department']");
    private By selectMaketingSubunit = By.xpath("//div[@role='listbox']//span[text()='Marketing Department']");
    private By employeenameFirstNameInput = By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-firstname']");
    private By employeenameMiddleNameInput = By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-middlename']");
    private By employeenameLastNameInput = By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-lastname']");
    private By usernameInput = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By passwordInput = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By confirmpasswordInput = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By otheridInput = By.xpath("//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By licenseexpirydateInput = By.xpath("//label[text()='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By nationlityInput = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectVietnameseNationlity = By.xpath("//div[@role='listbox']//span[text()='Vietnamese']");
    private By maritalstatusInput = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectSingleMaritalStatus = By.xpath("//div[@role='listbox']//span[text()='Single']");
    private By dateofbirthInput = By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By maleRadioButton = By.xpath("//label[normalize-space()='Male']//span[contains(@class,'oxd-radio-input')]");


    private By enabledRadioButton = By.xpath("//label[normalize-space()='Enabled']//span[contains(@class,'oxd-radio-input')]");
    private By disabledRadioButton = By.xpath("//label[normalize-space()='Disabled']//span[contains(@class,'oxd-radio-input')]");
    private By cancleButton = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By saveButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");
    private By resetButton = By.xpath("//button[@type='reset']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By addButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']");
    private By iconButtonDeleteAdmin123 = By.xpath("//div[@role='row'][.//div[text()='Việt Thành ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeletePHTPhat = By.xpath("//div[@role='row'][.//div[text()='Huỳnh Tấn Phát ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteVTGiang = By.xpath("//div[@role='row'][.//div[text()='Thu Giang ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteHADat = By.xpath("//div[@role='row'][.//div[text()='Anh Đạt  ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTHung = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Hùng ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTDat = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Đạt ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTPhong = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Phong ']]//i[contains(@class,'bi-trash')]");
    private By iconButtonEditAdmin123 = By.xpath("//div[@role='row'][.//div[text()='Việt Thành ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditPHTPhat = By.xpath("//div[@role='row'][.//div[text()='Huỳnh Tấn Phát ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditVTGiang = By.xpath("//div[@role='row'][.//div[text()='Thu Giang ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditHADat = By.xpath("//div[@role='row'][.//div[text()='Anh Đạt  ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditMLTHung = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Hùng ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditMLTDat = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Đạt ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By iconButtonEditMLTPhong = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Phong ']]//button[contains(@class,'oxd-icon-button')][1]");
    private By confirmDeleteButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Yes, Delete']");
    private By confirmCancelButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='No, Cancel']");
    private By checkboxAllId = By.xpath("//div[contains(@class,'oxd-table-header')]//label");
    private By checkboxIdThanh = By.xpath("//div[@role='row'][.//div[text()='Việt Thành ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdPhat = By.xpath("//div[@role='row'][.//div[text()='Huỳnh Tấn Phát ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdGiang = By.xpath("//div[@role='row'][.//div[text()='Thu Giang ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdHADat = By.xpath("//div[@role='row'][.//div[text()='Anh Đạt ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdMLTHung = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Hùng ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdMLTDat = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Đạt ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxIdMLTPhong = By.xpath("//div[@role='row'][.//div[text()='Lê Tiến Phong ']]//span[contains(@class,'oxd-checkbox-input')]");
    private By confirmDeleteCheckBox = By.xpath("//button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");
    private By checkboxCreateLoginDetails = By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']");
    private By avatarButton = By.xpath("//div[@class = 'employee-image-wrapper']");
    private By requiredmessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");

    // Actions
    public void setModulePIM(){
        click(modulePIM);
    }
    public void enterEmployeeName(String employeeName){
        type(employeenameInput, employeeName);
        click(employeenameSuggestion);
    }
    public void enterEmployeeId (String employeeId){type(employeeidInput, employeeId);}
    public void clearandenterEmployeeId(String employeeId) {
        WebElement input = driver.findElement(employeeidInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(employeeId);
    }
    public void setSelectFullTimeEmploymentStatus (){
        click(employmentstatus);
        click(selectFullTimeEmploymentStatus);
    }
    public void setSelectPartTimeEmploymentStatus (){
        click(employmentstatus);
        click(selectPartTimeEmploymentStatus);
    }
    public void setSelectInternEmploymentStatus (){
        click(employmentstatus);
        click(selectInternEmploymentStatus);
    }
    public void setSelectCurrentInclude (){
        click(includeInput);
        click(selectCurrentInclude);
    }
    public void setSelectCurrentAndPastInclude (){
        click(includeInput);
        click(selectCurrentAndPastInclude);
    }
    public void setSelectPastInclude (){
        click(includeInput);
        click(selectPastInclude);
    }
    public void enterSupervisorName(String supervisorName){
        type(supervisornameInput, supervisorName);
        click(supervisornameSuggestion);
    }
    public void setSelectFullstackJobtitle (){
        click(jobtitleInput);
        click(selectFullstackJobtitle);
    }
    public void setSelectHRJobtitle (){
        click(jobtitleInput);
        click(selectHRJobtitle);
    }
    public void setSelectPMJobtitle (){
        click(jobtitleInput);
        click(selectPMJobtitle);
    }
    public void setSelectQAJobtitle (){
        click(jobtitleInput);
        click(selectQAJobtitle);
    }
    public void setSelectQASubunit (){
        click(subunitInput);
        click(selectQASubunit);
    }
    public void setSelectITSubunit (){
        click(subunitInput);
        click(selectITSubunit);
    }
    public void setSelectHRSubunit (){
        click(subunitInput);
        click(selectHRSubunit);
    }
    public void setSelectRecruitmentSubunit (){
        click(subunitInput);
        click(selectRecruitmentSubunit);
    }
    public void setSelectSalesSubunit (){
        click(subunitInput);
        click(selectSalesSubunit);
    }
    public void setSelectMaketingSubunit (){
        click(subunitInput);
        click(selectMaketingSubunit);
    }
    public void uploadEmployeePhoto(String filePath) {
        WebElement uploadInput = driver.findElement(
                By.xpath("//input[@type='file']")
        );
        uploadInput.sendKeys(filePath);
    }
    public List<String> getAllRequiredMessages() {
        List<WebElement> elements = driver.findElements(requiredmessage);
        List<String> messages = new ArrayList<>();

        for (WebElement el : elements) {
            messages.add(el.getText());
        }
        return messages;
    }
    public void enteremployeefirstname(String firstname){type(employeenameFirstNameInput,firstname);}
    public void clearandenterEmployeeFirstName(String employeefirstname) {
        WebElement input = driver.findElement(employeenameFirstNameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(employeefirstname);
    }
    public void enteremployeemiddlename(String middlename){type(employeenameMiddleNameInput,middlename);}
    public void clearandenterEmployeeMiddleName(String employeemiddlename) {
        WebElement input = driver.findElement(employeenameMiddleNameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(employeemiddlename);
    }
    public void enteremployeelastname(String lastname){type(employeenameLastNameInput,lastname);}
    public void clearandenterEmployeeLastName(String employeelastname) {
        WebElement input = driver.findElement(employeenameLastNameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(employeelastname);
    }
    public void enterusername(String username){type(usernameInput,username);}
    public void enterpassword(String password){type(passwordInput,password);}
    public void enterconfirmpassword(String confirmpassword){type(confirmpasswordInput,confirmpassword);}
    public void enterotherid(String otherid){type(otheridInput,otherid);}
    public void clearandenterOtherId(String otherid) {
        WebElement input = driver.findElement(otheridInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(otherid);
    }
    public void enterlicenseexpirydate(String licenseexpirydate){type(licenseexpirydateInput,licenseexpirydate);}
    public void clearandenterlicenseexpirydate(String licenseexpirydate) {
        WebElement input = driver.findElement(licenseexpirydateInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(licenseexpirydate);
    }
    public void setSelectVietnameseNationlity (){
        click(nationlityInput);
        click(selectVietnameseNationlity);
    }
    public void setSelectSingleMaritalStatus (){
        click(maritalstatusInput);
        click(selectSingleMaritalStatus);
    }
    public void enterdateofbirth(String dateofbirth){type(dateofbirthInput,dateofbirth);}
    public void clearandenterdateofbirth(String dateofbirth) {
        WebElement input = driver.findElement(dateofbirthInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(dateofbirth);
    }

    public void clickMaleRadioButton(){click(maleRadioButton);}
    public void clickButtonCancel(){click(cancleButton);}
    public void clickButtonSave(){click(saveButton);}
    public void clickButtonEnabled(){click(enabledRadioButton);}
    public void clickButtonDisabled(){click(disabledRadioButton);}
    public void clickButtonReset(){
        click(resetButton);
    }
    public void clickButtonSearch(){
        click(searchButton);
    }
    public void clickButtonAdd(){
        click(addButton);
    }
    public void clickButtonconfirmDelete(){click(confirmDeleteButton);}
    public void clickButtonconfirmCancel(){click(confirmCancelButton);}
    public void clickButtonconfirmDeleteCheckbox(){click(confirmDeleteCheckBox);}
    public void clickIconButtonEditAdmin123(){click(iconButtonEditAdmin123);}
    public void clickIconButtonEditHADat(){
        click(iconButtonEditHADat);
    }
    public void clickIconButtonEditVTGiang(){
        click(iconButtonEditVTGiang);
    }
    public void clickIconButtonEditPHTPhat(){click(iconButtonEditPHTPhat);}
    public void clickIconButtonEditMLTPhong(){click(iconButtonEditMLTPhong);}
    public void clickIconButtonEditMLTDat(){click(iconButtonEditMLTDat);}
    public void clickIconButtonEditMLTHung(){click(iconButtonEditMLTHung);}
    public void clickIconButtonDeleteAdmin123(){
        click(iconButtonDeleteAdmin123);
    }
    public void clickIconButtonDeleteHADat(){
        click(iconButtonDeleteHADat);
    }
    public void clickIconButtonDeleteVTGiang(){
        click(iconButtonDeleteVTGiang);
    }
    public void clickIconButtonDeletePHTPhat(){click(iconButtonDeletePHTPhat);}
    public void clickIconButtonDeleteMLTPhong(){
        click(iconButtonDeleteMLTPhong);
    }
    public void clickIconButtonDeleteMLTDat(){
        click(iconButtonDeleteMLTDat);
    }
    public void clickIconButtonDeleteMLTHung(){
        click(iconButtonDeleteMLTHung);
    }
    public void clickCheckboxAllId(){
        click(checkboxAllId);
    }
    public void clickCheckboxThanh(){
        click(checkboxIdThanh);
    }
    public void clickCheckboxHADat(){
        click(checkboxIdHADat);
    }
    public void clickCheckboxVTGiang(){
        click(checkboxIdGiang);
    }
    public void clickCheckboxPHTPhat(){click(checkboxIdPhat);}
    public void clickCheckboxMLTPhong(){
        click(checkboxIdMLTPhong);
    }
    public void clickCheckboxMLTDat(){click(checkboxIdMLTDat);}
    public void clickCheckboxMLTHung(){
        click(checkboxIdMLTHung);
    }
    public void clickCheckboxCreateLoginDetails(){click(checkboxCreateLoginDetails);}
    public void clickAvatarButton(){click(avatarButton);}
}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Employee_ListPage extends BasePage {

    public Employee_ListPage(WebDriver driver) {super(driver);}

    // Locators
    private By modulePIM = By.xpath("//span[text()='PIM']/ancestor::a");
    private By employeenameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]");
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
    private By supervisornameInput = By.xpath("//label[text()='Supervisor Name']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-autocomplete-text-input')]");
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
    private By resetButton = By.xpath("//button[@type='reset']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By addButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']");
    private By iconButtonDeleteAdmin123 = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeletePHTPhat = By.xpath("//div[@role='row'][.//div[text()='PHTPhat']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteVTGiang = By.xpath("//div[@role='row'][.//div[text()='VTGiang']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteHADat = By.xpath("//div[@role='row'][.//div[text()='HADat']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTHung = By.xpath("//div[@role='row'][.//div[text()='MLTHung']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTDat = By.xpath("//div[@role='row'][.//div[text()='MLTDat']]//i[contains(@class,'bi-trash')]");
    private By iconButtonDeleteMLTPhong = By.xpath("//div[@role='row'][.//div[text()='MLTPhong']]//i[contains(@class,'bi-trash')]");
    private By iconButtonEditAdmin123 = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditPHTPhat = By.xpath("//div[@role='row'][.//div[text()='PHTPhat']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditVTGiang = By.xpath("//div[@role='row'][.//div[text()='VTGiang']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditHADat = By.xpath("//div[@role='row'][.//div[text()='HADat']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditMLTHung = By.xpath("//div[@role='row'][.//div[text()='MLTHung']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditMLTDat = By.xpath("//div[@role='row'][.//div[text()='MLTDat']]//button[contains(@class,'oxd-icon-button')][2]");
    private By iconButtonEditMLTPhong = By.xpath("//div[@role='row'][.//div[text()='MLTPhong']]//button[contains(@class,'oxd-icon-button')][2]");
    private By confirmDeleteButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='Yes, Delete']");
    private By confirmCancelButton = By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[normalize-space()='No, Cancel']");
    private By checkboxAllUsername = By.xpath("//div[contains(@class,'oxd-table-header')]//label");
    private By checkboxUsernameAdmin123 = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernamePHTPhat = By.xpath("//div[@role='row'][.//div[text()='PHTPhat']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernameVTGiang = By.xpath("//div[@role='row'][.//div[text()='VTGiang']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernameHADat = By.xpath("//div[@role='row'][.//div[text()='HADat']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernameMLTHung = By.xpath("//div[@role='row'][.//div[text()='MLTHung']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernameMLTDat = By.xpath("//div[@role='row'][.//div[text()='MLTDat']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxUsernameMLTPhong = By.xpath("//div[@role='row'][.//div[text()='MLTPhong']]//span[contains(@class,'oxd-checkbox-input')]");
    private By confirmDeleteCheckBox = By.xpath("//button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");

    // Actions
    public void setModulePIM(){
        click(modulePIM);
    }
    public void enterEmployeeName(String employeeName){
        type(employeenameInput, employeeName);
        click(employeenameSuggestion);
    }
    public void enterEmployeeId (String employeeId){type(employeeidInput, employeeId);}
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

    public void clickButtonReset(){
        click(resetButton);
    }
    public void clickButtonSearch(){
        click(searchButton);
    }
    public void clickButtonAdd(){
        click(addButton);
    }
    public void clickIconButtonEditAdmin123(){
        click(iconButtonEditAdmin123);
    }
    public void clickIconButtonEditHADat(){
        click(iconButtonEditHADat);
    }
    public void clickIconButtonEditVTGiang(){
        click(iconButtonEditVTGiang);
    }
    public void clickIconButtonEditPHTPhat(){
        click(iconButtonEditPHTPhat);
    }
    public void clickIconButtonEditMLTPhong(){
        click(iconButtonEditMLTPhong);
    }
    public void clickIconButtonEditMLTDat(){
        click(iconButtonEditMLTDat);
    }
    public void clickIconButtonEditMLTHung(){
        click(iconButtonEditMLTHung);
    }
    public void clickIconButtonDeleteAdmin123(){
        click(iconButtonDeleteAdmin123);
    }
    public void clickIconButtonDeleteHADat(){
        click(iconButtonDeleteHADat);
    }
    public void clickIconButtonDeleteVTGiang(){
        click(iconButtonDeleteVTGiang);
    }
    public void clickIconButtonDeletePHTPhat(){
        click(iconButtonDeletePHTPhat);
    }
    public void clickIconButtonDeleteMLTPhong(){
        click(iconButtonDeleteMLTPhong);
    }
    public void clickIconButtonDeleteMLTDat(){
        click(iconButtonDeleteMLTDat);
    }
    public void clickIconButtonDeleteMLTHung(){
        click(iconButtonDeleteMLTHung);
    }
    public void clickCheckboxAllUsername(){
        click(checkboxAllUsername);
    }
    public void clickCheckboxUsernameAdmin123(){
        click(checkboxUsernameAdmin123);
    }
    public void clickCheckboxUsernameHADat(){
        click(checkboxUsernameHADat);
    }
    public void clickCheckboxUsernameVTGiang(){
        click(checkboxUsernameVTGiang);
    }
    public void clickCheckboxUsernamePHTPhat(){
        click(checkboxUsernamePHTPhat);
    }
    public void clickCheckboxUsernameMLTPhong(){
        click(checkboxUsernameMLTPhong);
    }
    public void clickCheckboxUsernameMLTDat(){
        click(checkboxUsernameMLTDat);
    }
    public void clickCheckboxUsernameMLTHung(){
        click(checkboxUsernameMLTHung);
    }
}

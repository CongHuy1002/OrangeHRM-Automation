package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User_ManagementPage extends BasePage {
    public User_ManagementPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By moduleAdmin = By.xpath("//span[text()='Admin']/ancestor::a");
    private By usernameInput = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By userroleInput = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectESSUserrole = By.xpath("//span[text()='ESS']");
    private By selectAdminUserrole = By.xpath("//span[text()='Admin']");
    private By employeenameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By statusInput = By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectEnabledStatus = By.xpath("//span[text()='Enabled']");
    private By selectDisabledStatus = By.xpath("//span[text()='Disabled']");
    private By resetButton = By.xpath("//button[.='Reset']");
    private By searchButton = By.xpath("//button[.='Search']");
    private By addButton = By.xpath("//button[.='Add']");
    private By iconButtonDelete = By.xpath("(//button[contains(@class,'oxd-table-cell-action-space')])[3]");
    private By iconButtonEdit = By.xpath("//input[contains(@class, 'oxd-icon-button')][4]");
    private By confirmDeleteButton = By.xpath("button[containns(@class, 'oxd-button--label-danger')]");
    private By confirmCancelButton = By.xpath("button[contains(@class, 'oxd-button--ghost')][2]");
    private By checkboxUsername = By.xpath("//i[contains(@class, 'bi-check oxd-checkbox-input-icon')][3]");
    private By confirmDeleteCheckBox = By.xpath("button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");

    // Actions
    public void setModuleAdmin(){
        click(moduleAdmin);
    }
    public void enterUsername (String username){type(usernameInput, username);}
    public void setselectESSUserRole (){
        click(userroleInput);
        click(selectESSUserrole);
    }
    public void setselectAdminUserRole (){
        click(userroleInput);
        click(selectAdminUserrole);
    }
    public void enterEmployeeName(String employeeName){
        type(employeenameInput, employeeName);
    }
    public void setSelectEnabledStatus (){
        click(statusInput);
        click(selectEnabledStatus);
    }
    public void setSelectDisabledStatus (){
        click(statusInput);
        click(selectDisabledStatus);
    }
    public void clickSearch(){
        click(searchButton);
    }
    public void clickReset(){
        click(resetButton);
    }
    public void clickAdd(){
        click(addButton);
    }
    public void clickIconButtonEdit(){
        click(iconButtonEdit);
    }
    public void clickIconButtonDelete(){
        click(iconButtonDelete);
    }
    public void clickConfirmDelete(){
        click(confirmDeleteButton);
    }
    public void clickConfirmCancel(){
        click(confirmCancelButton);
    }
    public void clickCheckBox(){
        click(checkboxUsername);
    }
    public void clickDeleteCheckBox(){
        click(confirmDeleteCheckBox);
    }

    public void Search(String username,String employeeName ){
        setModuleAdmin();
        enterUsername(username);
        setselectAdminUserRole();
        enterEmployeeName(employeeName);
        setSelectEnabledStatus();
        clickSearch();
    }
    public void ResetBeforeSearch(String username,String employeeName ){
        setModuleAdmin();
        enterUsername(username);
        setselectAdminUserRole();
        enterEmployeeName(employeeName);
        setSelectDisabledStatus();
        clickReset();
    }
    public void ResetAfterSearch(String username,String employeeName ){
        setModuleAdmin();
        enterUsername(username);
        setselectAdminUserRole();
        enterEmployeeName(employeeName);
        setSelectEnabledStatus();
        clickSearch();
        clickReset();
    }
    public void DeleteAndConfirmDeleteIcon(){
        setModuleAdmin();
        clickIconButtonDelete();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelIcon(){
        setModuleAdmin();
        clickIconButtonDelete();
        clickConfirmCancel();
    }
    public void DeleteAndConfirmDeleteCheckBox(){
        setModuleAdmin();
        clickCheckBox();
        clickDeleteCheckBox();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelCheckBox(){
        setModuleAdmin();
        clickCheckBox();
        clickDeleteCheckBox();
        clickConfirmCancel();
    }
}

package pages.Admin;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User_ManagementPage extends BasePage {
    public User_ManagementPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By usernameInput = By.xpath("//input[contains(@class,'oxd-input')][2]");
    private By userroleInput = By.xpath("//div[contains(@class, 'oxd-select-text')]");
    private By selectESSUserrole = By.xpath("button[text()='ESS']");
    private By selectAdminUserrole = By.xpath("button[text()='Admin']");
    private By employeenameInput = By.xpath("//input[contains(@class, 'oxd-autocomplete-text-input')]");
    private By statusInput = By.xpath("//input[contains(@class, 'oxd-select-text')]");
    private By selectEnabledStatus = By.xpath("button[text()='Enabled']");
    private By selectDisabledStatus = By.xpath("button[text()='Disabled']");
    private By resetButton = By.xpath("//input[contains(@class, 'oxd-button')]");
    private By searchButton = By.xpath("//input[contains(@class, 'oxd-button')][2]");
    private By addButton = By.xpath("//input[contains(@class, 'oxd-button')][3]");
    private By iconButtonDelete = By.xpath("//input[contains(@class, 'oxd-icon-button')][3]");
    private By iconButtonEdit = By.xpath("//input[contains(@class, 'oxd-icon-button')][4]");
    private By confirmDeleteButton = By.className("oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin");
    private By confirmCancelButton = By.className("oxd-button oxd-button--medium oxd-button--ghost orangehrm-button-margin");
    private By checkboxUsername = By.xpath("//i[contains(@class, 'bi-check oxd-checkbox-input-icon')][3]");
    private By confirmDeleteCheckBox = By.xpath("//button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");

    // Actions
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
        enterUsername(username);
        setselectESSUserRole();
        enterEmployeeName(employeeName);
        setSelectEnabledStatus();
        clickSearch();
    }
    public void ResetBeforeSearch(String username,String employeeName ){
        enterUsername(username);
        setselectAdminUserRole();
        enterEmployeeName(employeeName);
        setSelectDisabledStatus();
        clickReset();
    }
    public void ResetAfterSearch(String username,String employeeName ){
        enterUsername(username);
        setselectAdminUserRole();
        enterEmployeeName(employeeName);
        setSelectEnabledStatus();
        clickSearch();
        clickReset();
    }
    public void DeleteAndConfirmDeleteIcon(){
        clickIconButtonDelete();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelIcon(){
        clickIconButtonDelete();
        clickConfirmCancel();
    }
    public void DeleteAndConfirmDeleteCheckBox(){
        clickCheckBox();
        clickDeleteCheckBox();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelCheckBox(){
        clickCheckBox();
        clickDeleteCheckBox();
        clickConfirmCancel();
    }
}

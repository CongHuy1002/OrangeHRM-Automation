package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class User_ManagementPage extends BasePage {
    public User_ManagementPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By moduleAdmin = By.xpath("//span[text()='Admin']/ancestor::a");
    private By usernameInput = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By userroleInput = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectAdminUserrole = By.xpath("//div[@role='option']//span[text()='Admin']");
    private By selectESSUserrole = By.xpath("//div[@role='option']//span[text()='ESS']");
    private By employeenameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By employeeSuggestion = By.xpath("//div[@role='listbox']//span");
    private By statusInput = By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectEnabledStatus = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    private By selectDisabledStatus = By.xpath("//div[@role='listbox']//span[text()='Disabled']");
    private By passwordInput = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By confirmpasswordInput = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By saveButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");
    private By cancleButon = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By resetButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']");
    private By searchButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By addButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']");
    private By iconButtonDelete = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//i[contains(@class,'bi-trash')]");
    private By iconButtonEdit = By.xpath("//div[@role='row'][.//div[text()='MLTPhong']]//button[contains(@class,'oxd-icon-button')][2]");
    private By confirmDeleteButton = By.xpath("button[containns(@class, 'oxd-button--label-danger')]");
    private By confirmCancelButton = By.xpath("button[contains(@class, 'oxd-button--ghost')][2]");
    private By checkboxAllUsername = By.xpath("//div[contains(@class,'oxd-table-header')]//label");
    private By checkboxUsername = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//span[contains(@class,'oxd-checkbox-input')]");
    private By checkboxChangePassword = By.xpath("//label[normalize-space()='Yes']//span[contains(@class,'oxd-checkbox-input')]");
    private By confirmDeleteCheckBox = By.xpath("button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");
    private By confirmpassworderrormessage = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    private By requiredmessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");


    // Actions
    public void setModuleAdmin(){
        click(moduleAdmin);
    }
    public void enterUsername (String username){type(usernameInput, username);}
    public void setselectAdminUserRole (){
        click(userroleInput);
        click(selectAdminUserrole);
    }
    public void setselectESSUserRole (){
        click(userroleInput);
        click(selectESSUserrole);
    }
    public void enterEmployeeName(String employeeName){
        type(employeenameInput, employeeName);
        click(employeeSuggestion);
    }
    public void setSelectEnabledStatus (){
        click(statusInput);
        click(selectEnabledStatus);
    }
    public void setSelectDisabledStatus (){
        click(statusInput);
        click(selectDisabledStatus);
    }
    public void enterPassword(String password){
        type(passwordInput, password);
    }
    public void enterConfirmPassword(String confirmpassword){
        type(confirmpasswordInput, confirmpassword);
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
    public void clickIconButtonEdit(){click(iconButtonEdit);}
    public void clickIconButtonDelete(){click(iconButtonDelete);}
    public void clickConfirmDelete(){
        click(confirmDeleteButton);
    }
    public void clickConfirmCancel(){
        click(confirmCancelButton);
    }
    public void clickCheckBoxAllUsername(){click(checkboxAllUsername);}
    public void clickCheckBoxUsername(){click(checkboxUsername);}
    public void clickCheckBoxChangePassword(){click(checkboxChangePassword);}
    public void clickDeleteCheckBox(){
        click(confirmDeleteCheckBox);
    }
    public void clickButtonSave(){click(saveButton);}
    public void clickButtonCancel(){
        click(cancleButon);
    }
    public String getDidNotMatchMessage() {
        return getText(confirmpassworderrormessage);
    }
    public List<String> getAllRequiredMessages() {
        List<WebElement> elements = driver.findElements(requiredmessage);
        List<String> messages = new ArrayList<>();

        for (WebElement el : elements) {
            messages.add(el.getText());
        }
        return messages;
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
        clickCheckBoxUsername();
        clickDeleteCheckBox();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelCheckBox(){
        setModuleAdmin();
        clickCheckBoxUsername();
        clickDeleteCheckBox();
        clickConfirmCancel();
    }
}

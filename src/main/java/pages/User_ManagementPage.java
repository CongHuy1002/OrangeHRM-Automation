package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By checkboxChangePassword = By.xpath("//label[normalize-space()='Yes']//span[contains(@class,'oxd-checkbox-input')]");
    private By confirmDeleteCheckBox = By.xpath("//button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");
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

    public void clearAndEnterUsername(String username) {
        WebElement input = driver.findElement(usernameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(username);
    }
    public void clearAndEnterEmployeeName(String employeename) {
        WebElement input = driver.findElement(employeenameInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        type(employeenameInput, employeename);
        click(employeeSuggestion);
    }
    public void clearAndEnterPassword(String password) {
        WebElement input = driver.findElement(passwordInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(password);
    }
    public void clearAndEnterConfirmPassword(String confirmpassword) {
        WebElement input = driver.findElement(confirmpasswordInput);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(confirmpassword);
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
    public void clickIconButtonEditAdmin123(){click(iconButtonEditAdmin123);}
    public void clickIconButtonEditPHTPhat(){click(iconButtonEditPHTPhat);}
    public void clickIconButtonEditVTGiang(){click(iconButtonEditVTGiang);}
    public void clickIconButtonEditHADat(){click(iconButtonEditHADat);}
    public void clickIconButtonEditMLTHung(){click(iconButtonEditMLTHung);}
    public void clickIconButtonEditMLTDat(){click(iconButtonEditMLTDat);}
    public void clickIconButtonEditMLTPhong(){click(iconButtonEditMLTPhong);}
    public void clickIconButtonDeleteAdmin123(){click(iconButtonDeleteAdmin123);}
    public void clickIconButtonDeletePHTPhat(){click(iconButtonDeletePHTPhat);}
    public void clickIconButtonDeleteVTGiang(){click(iconButtonDeleteVTGiang);}
    public void clickIconButtonDeleteHADat(){click(iconButtonDeleteHADat);}
    public void clickIconButtonDeleteMLTHung(){click(iconButtonDeleteMLTHung);}
    public void clickIconButtonDeleteMLTDat(){click(iconButtonDeleteMLTDat);}
    public void clickIconButtonDeleteMLTPhong(){click(iconButtonDeleteMLTPhong);}
    public void clickConfirmDelete(){
        click(confirmDeleteButton);
    }
    public void clickConfirmCancel(){
        click(confirmCancelButton);
    }
    public void clickCheckBoxAllUsername(){click(checkboxAllUsername);}
    public void clickCheckBoxUsernameAdmin123(){click(checkboxUsernameAdmin123);}
    public void clickCheckBoxUsernamePHTPhat(){click(checkboxUsernamePHTPhat);}
    public void clickCheckBoxUsernameVTGiang(){click(checkboxUsernameVTGiang);}
    public void clickCheckBoxUsernameHADat(){click(checkboxUsernameHADat);}
    public void clickCheckBoxUsernameMLTHung(){click(checkboxUsernameMLTHung);}
    public void clickCheckBoxUsernameMLTDat(){click(checkboxUsernameMLTDat);}
    public void clickCheckBoxUsernameMLTPhong(){click(checkboxUsernameMLTPhong);}
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
        clickIconButtonDeleteAdmin123();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelIcon(){
        setModuleAdmin();
        clickIconButtonDeleteMLTDat();
        clickConfirmCancel();
    }
    public void DeleteAndConfirmDeleteCheckBox(){
        setModuleAdmin();
        clickCheckBoxUsernameMLTDat();
        clickDeleteCheckBox();
        clickConfirmDelete();
    }
    public void DeleteAndConfirmCancelCheckBox(){
        setModuleAdmin();
        clickCheckBoxUsernameMLTHung();
        clickDeleteCheckBox();
        clickConfirmCancel();
    }
}

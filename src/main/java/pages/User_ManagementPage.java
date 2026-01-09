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

    // Locators User page
    private By moduleAdmin = By.xpath("//span[text()='Admin']/ancestor::a");
    private By usernameInput = By.xpath("//div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')] / " +
            ".//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')] / .//input[contains(@class, 'oxd-input oxd-input--active')]");
    private By userroleInput = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectESSUserrole = By.xpath("//div[@role='option']//span[text()='ESS']");
    private By selectAdminUserrole = By.xpath("//div[@role='option']//span[text()='Admin']");
    private By employeenameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By employeeSuggestion = By.xpath("//div[@role='listbox']//span");
    private By statusInput = By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectEnabledStatus = By.xpath("//span[text()='Enabled']");
    private By selectDisabledStatus = By.xpath("//span[text()='Disabled']");
    private By resetButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']");
    private By searchButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By addButton = By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']");
    private By iconButtonDeleteAD = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//i[contains(@class,'bi-trash')]");
    private By iconButtonEditAD = By.xpath("//div[@role='row'][.//div[text()='MLTPhong']]//button[contains(@class,'oxd-icon-button')][2]");
    private By confirmDeleteButton = By.xpath("button[containns(@class, 'oxd-button--label-danger')]");
    private By confirmCancelButton = By.xpath("button[contains(@class, 'oxd-button--ghost')][2]");
    private By checkboxUsernameAD = By.xpath("//div[@role='row'][.//div[text()='Admin123']]//span[contains(@class,'oxd-checkbox-input')]");
    private By confirmDeleteCheckBox = By.xpath("button[contains(@class, 'oxd-button--medium oxd-button--label-danger')]");

    // Locators Add User page
    private By userroleInputAU = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectAdminUserroleAU = By.xpath("//div[@role='listbox']//span[text()='Admin']");
    private By selectESSUserroleAU = By.xpath("//div[@role='listbox']//span[text()='ESS']");
    private By employeenameInputAU = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By employeeSuggestionAU = By.xpath("//div[@role='listbox']//span");
    private By statusInputAU = By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private By selectEnabledStatusAU = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    private By selectDisabledStatusAU = By.xpath("//div[@role='listbox']//span[text()='Disabled']");
    private By usernameInputAU = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By passwordInputAU = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By confirmpasswordInputAU = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By saveButtonAU = By.xpath("//button[contains(@class,'oxd-button--secondary') and normalize-space()='Save']");
    private By cancleButonAU = By.xpath("//button[contains(@class,'oxd-button--ghost') and normalize-space()='Cancel']");
    private By confirmpassworderrormessage = By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    private By passworderrormessage = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    private By requiredmessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");

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
        click(iconButtonEditAD);
    }
    public void clickIconButtonDelete(){
        click(iconButtonDeleteAD);
    }
    public void clickConfirmDelete(){
        click(confirmDeleteButton);
    }
    public void clickConfirmCancel(){
        click(confirmCancelButton);
    }
    public void clickCheckBox(){
        click(checkboxUsernameAD);
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

    public void enterUsernameAU (String username){type(usernameInputAU, username);}
    public void setESSUserRoleAU (){
        click(userroleInputAU);
        click(selectESSUserroleAU);
    }
    public void setAdminUserRoleAU (){
        click(userroleInputAU);
        click(selectAdminUserroleAU);
    }
    public void enterEmployeeNameAU(String employeeName){
        type(employeenameInputAU, employeeName);
        click(employeeSuggestionAU);
    }
    public void setEnabledStatusAU () {
        click(statusInputAU);
        click(selectEnabledStatusAU);
    }
    public void setDisabledStatusAU () {
        click(statusInputAU);
        click(selectDisabledStatusAU);
    }
    public void enterPasswordAU(String password){
        type(passwordInputAU, password);
    }
    public void enterConfirmPasswordAU(String confirmpassword){
        type(confirmpasswordInputAU, confirmpassword);
    }
    public void ClickButtonSave(){
        click(saveButtonAU);
    }
    public void ClickButtonCancel(){
        click(cancleButonAU);
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
    public void ClickUserRole(){
        click(userroleInputAU);
    }
    public void ClickEmployeeName(){
        click(employeenameInputAU);
    }
    public void ClickStatus(){
        click(statusInputAU);
    }
    public void ClickUsername(){
        click(usernameInputAU);
    }
    public void ClickPassword(){
        click(passwordInputAU);
    }
    public void ClickConfirmPassword(){
        click(confirmpasswordInputAU);
    }

    public void blurCurrentField() {
        click(employeenameInputAU);
    }
    public void WaitRequiredMessages(){
        wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) requiredmessage));
    }
}

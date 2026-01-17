package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Login_LogoutPage extends BasePage {

    public Login_LogoutPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton   = By.cssSelector("button[type='submit']");
    private By logoutButton   = By.xpath("//a[text()='Logout']");
    private By avatarButton = By.cssSelector("span[class='oxd-userdropdown-tab']");
    private By errorMessage  = By.cssSelector("span.oxd-input-field-error-message");
    private By errorMessages  = By.cssSelector("span.oxd-input-field-error-message");
    private By invalidAlert  = By.cssSelector("p.oxd-alert-content-text");


    // Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void logout(){
        click(avatarButton);
        click(logoutButton);
    }

    public String getInvalidLoginMessage() {
        return getText(invalidAlert);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public List<String> getAllErrorMessages() {
        List<WebElement> elements = driver.findElements(errorMessages);
        List<String> messages = new ArrayList<>();

        for (WebElement el : elements) {
            messages.add(el.getText());
        }
        return messages;
    }
}

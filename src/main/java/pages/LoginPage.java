package pages;

import base.PageBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class LoginPage extends PageBase {

    private static final By USERNAME_FIELD = get("LoginPage.UsernameField");
    private static final By PASSWORD_FIELD = get("LoginPage.PasswordField");
    private static final By LOGIN_BUTTON = get("LoginPage.LoginButton");
    public static final By VALIDATION_MESSAGE = get("LoginPage.ValidationMessage");

    private static final Log LOG = LogFactory.getLog(LoginPage.class);

    public LoginPage(WebDriver driver) { super(driver); }

    private LoginPage enterUsername(String username) {
        actionBot.waitFor(USERNAME_FIELD);
        actionBot.sendKeys(USERNAME_FIELD, username);
        return this;
    }

    private LoginPage enterPassword(String password) {
        actionBot.waitFor(PASSWORD_FIELD);
        actionBot.sendKeys(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        actionBot.click(LOGIN_BUTTON);
        return new LoginPage(driver);
    }

    public EmployeesPage loginValid(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        actionBot.click(LOGIN_BUTTON);
        return new EmployeesPage(driver);
    }

    public LoginPage loginInvalid(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    public boolean checkLoginButtonIsDisplayed() {
        actionBot.waitFor(LOGIN_BUTTON);
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public String getValidationMessage(){
        actionBot.waitFor(VALIDATION_MESSAGE);
        return actionBot.read(VALIDATION_MESSAGE);
    }

}

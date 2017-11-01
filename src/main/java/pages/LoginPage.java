package pages;

import base.PageBase;
import base.TestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private WebDriverWait wait = new WebDriverWait(driver, 15);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private LoginPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        return this;
    }

    private LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    public EmployeesPage loginValid(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new EmployeesPage(driver);
    }

    public LoginPage loginInvalid(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    public boolean checkLoginButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public String getValidationMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VALIDATION_MESSAGE));
        return driver.findElement(VALIDATION_MESSAGE).getText();
    }

}

package pages;

import base.PageBase;
import base.TestBase;
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public EmployeesPage login(String username, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new EmployeesPage(driver);
    }
}

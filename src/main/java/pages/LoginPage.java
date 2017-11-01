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

    private static final Log LOG = LogFactory.getLog(LoginPage.class);
    private WebDriverWait wait = new WebDriverWait(driver, 15);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public EmployeesPage login(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        LOG.info("Fill the fields and click Login button");
        return new EmployeesPage(driver);
    }
}

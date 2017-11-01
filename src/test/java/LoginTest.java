import base.TestBase;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeesPage;

import java.util.UUID;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class LoginTest extends TestBase {

    private EmployeesPage employeesPage;
    private static final String USERNAME ="Luke";
    private static final String PASSWORD = "Skywalker";
    private static final String EXP_VALIDATION_MESSAGE = "Invalid username or password!";


    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"smoke", "login"})
    @Feature("Login")
    public void loginTest() throws InterruptedException {
        employeesPage=loginPage.loginValid(USERNAME, PASSWORD);
        softAssert.assertTrue(employeesPage.checkCreateButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkEditButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkDeleteButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.getHeader().checkLogoutButtonIsDisplayed());
        softAssert.assertEquals(employeesPage.getHeader().getGreetingText(), "Hello " + USERNAME);
        softAssert.assertAll();

    }

    @Test(groups = {"smoke", "login"})
    @Feature("Logout")
    public void logoutTest() throws InterruptedException {
        employeesPage=loginPage.loginValid(USERNAME, PASSWORD);
        loginPage = employeesPage.getHeader().clickLogoutButton();
        Assert.assertTrue(loginPage.checkLoginButtonIsDisplayed());
    }

    @Test(groups = {"login"})
    @Feature("Login with empty username")
    public void loginWithInvalidUsername() throws InterruptedException {
        String usernameInvalid = UUID.randomUUID().toString();
        loginPage.loginInvalid(usernameInvalid, PASSWORD);
        Assert.assertEquals(loginPage.getValidationMessage(), EXP_VALIDATION_MESSAGE );

    }
}


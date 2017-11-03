import base.TestBase;

import io.qameta.allure.Feature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeesPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.UUID;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class LoginTest extends TestBase {

    private static final Log LOG = LogFactory.getLog(LoginTest.class);

    private EmployeesPage employeesPage;
    private static final String USERNAME ="Luke";
    private static final String PASSWORD = "Skywalker";
    private static final String EXP_VALIDATION_MESSAGE = "Invalid username or password!";

    SoftAssert softAssert = new SoftAssert();

    @Test
    @TestCaseId("LO-1")
    @Feature("Valid Login")
    public void loginTest() throws InterruptedException {
        employeesPage=loginPage.loginValid(USERNAME, PASSWORD);
        softAssert.assertTrue(employeesPage.getHeader().checkLogoutButtonIsDisplayed(), "Logout button is not displayed");
        softAssert.assertEquals(employeesPage.getHeader().getGreetingText(), "Hello " + USERNAME);
        softAssert.assertAll();
        LOG.info("Valid Login passed");
    }

    @Test
    @TestCaseId("LO-6")
    @Features("Login with invalid username")
    public void loginWithInvalidUsername() throws InterruptedException {
        String usernameInvalid = UUID.randomUUID().toString();
        loginPage.loginInvalid(usernameInvalid, PASSWORD);
        Assert.assertEquals(loginPage.getValidationMessage(), EXP_VALIDATION_MESSAGE );
        LOG.info("Login with invalid username test passed");
    }

    @Test
    @TestCaseId("LO-7")
    @Features("Login with invalid password")
    public void loginWithInvalidPassword_Fails() throws InterruptedException {
        String invalidPassword = UUID.randomUUID().toString();
        loginPage.loginInvalid(USERNAME, invalidPassword);
        Assert.assertEquals(loginPage.getValidationMessage(), EXP_VALIDATION_MESSAGE);
        LOG.info("Login with invalid password test passed");
    }

    @Test
    @TestCaseId("LO-2")
    @Feature("Logout")
    public void logoutTest() throws InterruptedException {
        employeesPage=loginPage.loginValid(USERNAME, PASSWORD);
        softAssert.assertEquals(employeesPage.getHeader().getGreetingText(), "Hello " + USERNAME);
        Thread.sleep(1000);
        loginPage = employeesPage.logout();
        softAssert.assertTrue(loginPage.checkLoginButtonIsDisplayed());
        softAssert.assertAll();
        LOG.info("Logout passed");
    }
}


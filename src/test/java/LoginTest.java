import base.TestBase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeesPage;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class LoginTest extends TestBase {

    private EmployeesPage employeesPage;
    private static final String USERNAME ="Luke";
    private static final String PASSWORD = "Skywalker";


    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"smoke", "login_tests"})
    public void loginTest() throws InterruptedException {
        employeesPage=loginPage.login(USERNAME, PASSWORD);
        softAssert.assertTrue(employeesPage.checkCreateButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkEditButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkDeleteButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.getHeader().checkLogoutButtonIsDisplayed());
        softAssert.assertEquals(employeesPage.getHeader().getGreetingText(), "Hello " + USERNAME);
        softAssert.assertAll();
    }
}


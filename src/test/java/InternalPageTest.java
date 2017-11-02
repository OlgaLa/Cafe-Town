import base.InternalPage;

import base.TestBase;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmployeesPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;


/**
 * Created by Olga Lapanovich on 02.11.2017.
 */

public abstract class InternalPageTest<TPage extends InternalPage> extends TestBase {

    private static final String USERNAME ="Luke";
    private static final String PASSWORD = "Skywalker";

    protected TPage pageUnderTest;

    private EmployeesPage givenImLoggedIn() throws InterruptedException {
        return loginPage.loginValid(USERNAME, PASSWORD);
    }

    @BeforeMethod
    public void init() throws InterruptedException {
        pageUnderTest = setCurrentPage(givenImLoggedIn());
    }

    @Test(groups = {"logout"})
    @TestCaseId("LO-2")
    @Feature("Logout")
    public void logoutTest() throws InterruptedException {
        Assert.assertEquals(pageUnderTest.getHeader().getGreetingText(), "Hello " + USERNAME);
        Thread.sleep(1000);
        loginPage = pageUnderTest.logout();
        Assert.assertTrue(loginPage.checkLoginButtonIsDisplayed());
    }

    protected abstract TPage setCurrentPage(EmployeesPage page);
}

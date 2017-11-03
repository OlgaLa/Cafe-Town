import base.InternalPage;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import pages.EmployeesPage;


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

    protected abstract TPage setCurrentPage(EmployeesPage page);
}

import helpers.EmployeeDataProvider;
import io.qameta.allure.Feature;
import org.testng.Assert;
import helpers.EmployeeDataProvider;
import org.testng.annotations.Test;
import pages.EmployeeCreationPage;
import pages.EmployeesPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class EmployeeCreationTest extends InternalPageTest<EmployeeCreationPage>{

    @Override
    protected EmployeeCreationPage setCurrentPage(EmployeesPage page) {
        return page.clickCreateButton();
    }

    @Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "createNewDataProvider", groups = {"employee"})
    @TestCaseId("CE-2")
    @Feature("Create an employee")
    public void createEmployeeTest(String firstName, String lastName, String startDate, String email) {
        String name = firstName + " " + lastName;
        EmployeesPage page = pageUnderTest.createEmployee(firstName, lastName, startDate, email);
        Assert.assertTrue(page.checkEmployeeInList(name), "Employee is not in the list");
    }

    @Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "createNewDataProvider", groups = {"employee"})
    @TestCaseId("CE-5")
    @Feature("Create an employee")
    public void cancelEmployeeCreationTest(String firstName, String lastName, String startDate, String email) {
        String name = firstName + " " + lastName;
        pageUnderTest.fillFields(firstName, lastName, startDate, email);
        EmployeesPage page = pageUnderTest.clickCancelButton();
        Assert.assertFalse(page.checkEmployeeInList(name), "Employee is in the list");
    }

}

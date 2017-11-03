import helpers.EmployeeDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeCreationPage;
import pages.EmployeesPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class EmployeesTest extends InternalPageTest<EmployeesPage> {

    @Override
    protected EmployeesPage setCurrentPage(EmployeesPage page) {
        return page;
    }

    @Test
    @TestCaseId("CE-1")
    @Feature("Open employee page")
    public void openCreateEmployeePage() throws InterruptedException {
        EmployeeCreationPage employeeCreationPage = pageUnderTest.clickCreateButton();
        Assert.assertTrue(employeeCreationPage.addButtonIsDisplayed(), "Add button is not displayed on Creation Page.");
    }

    @Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "createNewDataProvider")
    @TestCaseId("DE-1")
    @Feature("Delete employee")
    public void deleteEmployee(String firstName, String lastName, String startDate, String email) throws InterruptedException {
        String name = firstName + " " + lastName;
        EmployeeCreationPage employeeCreationPage = pageUnderTest.clickCreateButton();
        EmployeesPage employeesPage = employeeCreationPage.createEmployee(firstName, lastName, startDate, email).deleteByName(name);
        Thread.sleep(2000);
        Assert.assertFalse(employeesPage.checkEmployeeInList(name), "Employee is in the list");
    }
}

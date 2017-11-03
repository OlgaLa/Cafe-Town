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
public class EmployeeCreationTest extends InternalPageTest<EmployeeCreationPage>{

    @Override
    protected EmployeeCreationPage setCurrentPage(EmployeesPage page) {
        return page.clickCreateButton();
    }

    @Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "createNewDataProvider")
    @TestCaseId("CE-2")
    @Feature("Create a new employee")
    public void createEmployeeTest(String firstName, String lastName, String startDate, String email) {
        String name = firstName + " " + lastName;
        EmployeesPage page = pageUnderTest.createEmployee(firstName, lastName, startDate, email);
        Assert.assertTrue(page.checkEmployeeInList(name), "Employee is not in the list");
    }

    @Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "createNewDataProvider")
    @TestCaseId("CE-5")
    @Feature("Cancel employee creation")
    public void cancelEmployeeCreationTest(String firstName, String lastName, String startDate, String email) {
        String name = firstName + " " + lastName;
        pageUnderTest.fillFields(firstName, lastName, startDate, email);
        EmployeesPage page = pageUnderTest.clickCancelButton();
        Assert.assertFalse(page.checkEmployeeInList(name), "Employee is in the list");
    }

}

package pages;

import base.InternalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class EmployeeCreationPage extends InternalPage {

    private static final By ADD_BUTTON = get("EmployeeCreationPage.AddButton");
    private static final By CANCEL_BUTTON = get("EmployeeCreationPage.CancelButton");
    private static final By  FIRST_NAME_FIELD = get("EmployeeCreationPage.FirstNameField");
    private static final By  LAST_NAME_FIELD = get("EmployeeCreationPage.LastNameField");
    private static final By  START_DATE_FIELD = get("EmployeeCreationPage.StartDateField");
    private static final By  EMAIL_FIELD = get("EmployeeCreationPage.EmailField");


    public EmployeeCreationPage(WebDriver driver) {
        super(driver);
    }

    private EmployeeCreationPage enterFirstName(String firstName) {
        actionBot.sendKeys(FIRST_NAME_FIELD, firstName);
        return this;
    }

    private EmployeeCreationPage enterLastName(String lastName) {
        actionBot.sendKeys(LAST_NAME_FIELD, lastName);
        return this;
    }

    private EmployeeCreationPage enterStartDate(String startDate) {
        actionBot.sendKeys(START_DATE_FIELD, startDate);
        return this;
    }

    private EmployeeCreationPage enterEmail(String email) {
        actionBot.sendKeys(EMAIL_FIELD, email);
        return this;
    }

    public boolean addButtonIsDisplayed() {
        actionBot.waitFor(ADD_BUTTON);
        return driver.findElement(ADD_BUTTON).isDisplayed();
    }

    public EmployeeCreationPage clickAddButton() {
        actionBot.waitFor(ADD_BUTTON);
        actionBot.click(ADD_BUTTON);
        return new EmployeeCreationPage(driver);
    }

    public EmployeesPage clickCancelButton() {
        actionBot.waitFor(CANCEL_BUTTON);
        actionBot.click(CANCEL_BUTTON);
        return new EmployeesPage(driver);
    }

    public void fillFields(String firstName, String lastName, String startDate, String email) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterStartDate(startDate);
        enterEmail(email);
    }

    public EmployeesPage createEmployee(String firstName, String lastName, String startDate, String email) {
        fillFields(firstName, lastName, startDate, email);
        actionBot.click(ADD_BUTTON);
        return new EmployeesPage(driver);
    }
}

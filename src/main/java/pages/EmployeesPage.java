package pages;

import base.InternalPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class EmployeesPage extends InternalPage {

    private static final By CREATE_BUTTON = get("EmployeesPage.CreateButton");
    private static final By EDIT_BUTTON = get("EmployeesPage.EditButton");
    private static final By DELETE_BUTTON = get("EmployeesPage.DeleteButton");
    private static final By EMPLOYEES_LIST = get("EmployeesPage.EmployeeList");

    List<WebElement> employees;

    private static final Log LOG = LogFactory.getLog(EmployeesPage.class);

    public EmployeesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCreateButtonIsDisplayed() {
        actionBot.waitFor(CREATE_BUTTON);
        return driver.findElement(CREATE_BUTTON).isDisplayed();
    }

    public boolean checkEditButtonIsDisplayed() {
        actionBot.waitFor(EDIT_BUTTON);
        return driver.findElement(EDIT_BUTTON).isDisplayed();
    }

    public boolean checkDeleteButtonIsDisplayed() {
       actionBot.waitFor(DELETE_BUTTON);
        return driver.findElement(DELETE_BUTTON).isDisplayed();
    }

    public EmployeeCreationPage clickCreateButton() {
        actionBot.click(CREATE_BUTTON);
        return new EmployeeCreationPage(driver);
    }

    public boolean checkEmployeeInList(String name) {
        employees = driver.findElements(EMPLOYEES_LIST);
        WebElement elementByName = findElementByName(name);
        if (elementByName == null) {
            LOG.info("Employee is not found in the list.");
            return  false;
        }
        LOG.info("Employee is found in the list " + name);
        return true;
    }

    public EmployeesPage deleteByName(String name) {
        WebElement elementByName = findElementByName(name);
        if (elementByName != null) {
            elementByName.click();
            actionBot.clickAndConfirm(DELETE_BUTTON);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new EmployeesPage(driver);
    }


    private WebElement findElementByName(String name) {
        employees = driver.findElements(EMPLOYEES_LIST);
        for (WebElement employee : employees) {
            String employeeName = employee.getText();
            if (Objects.equals(employeeName, name)) {
                return employee;
            }
        }
        return null;
    }
}


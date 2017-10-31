package pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class EmployeesPage extends PageBase {

    private static final By CREATE_BUTTON = get("EmployeesPage.CreateButton");
    private static final By EDIT_BUTTON = get("EmployeesPage.EditButton");
    private static final By DELETE_BUTTON = get("EmployeesPage.DeleteButton");

    public EmployeesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCreateButtonIsDisplayed() {
        return driver.findElement(CREATE_BUTTON).isDisplayed();
    }

    public boolean checkEditButtonIsDisplayed() {
        return driver.findElement(EDIT_BUTTON).isDisplayed();
    }

    public boolean checkDeleteButtonIsDisplayed() {
        return driver.findElement(DELETE_BUTTON).isDisplayed();
    }
}
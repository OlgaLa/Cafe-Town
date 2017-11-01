package pages;

import base.PageBase;
import base.TestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.part.Header;

import java.security.PublicKey;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class EmployeesPage extends PageBase {

    private static final By CREATE_BUTTON = get("EmployeesPage.CreateButton");
    private static final By EDIT_BUTTON = get("EmployeesPage.EditButton");
    private static final By DELETE_BUTTON = get("EmployeesPage.DeleteButton");
    private WebDriverWait wait = new WebDriverWait(driver, 15);
    private static final Log LOG = LogFactory.getLog(EmployeesPage.class);

    public EmployeesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCreateButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        return driver.findElement(CREATE_BUTTON).isDisplayed();
    }

    public boolean checkEditButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        return driver.findElement(EDIT_BUTTON).isDisplayed();
    }

    public boolean checkDeleteButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        return driver.findElement(DELETE_BUTTON).isDisplayed();
    }
}
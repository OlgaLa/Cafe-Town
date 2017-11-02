package pages.part;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class Header extends PageBase{

    private static final By LOGOUT_BUTTON = get("Header.LogoutButton");
    private static final By GREETING_TEXT = get("Header.GreetingText");

    public Header(WebDriver driver) { super(driver); }

    public LoginPage clickLogoutButton() {
        actionBot.waitFor(GREETING_TEXT);
        actionBot.click(LOGOUT_BUTTON);
        return new LoginPage(driver);
    }

    public boolean checkLogoutButtonIsDisplayed() {
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public String getGreetingText() {
        return actionBot.read(GREETING_TEXT);
    }
}



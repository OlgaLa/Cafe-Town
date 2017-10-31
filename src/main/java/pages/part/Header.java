package pages.part;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class Header {

    private WebDriver driver;
    private static final By LOGOUT_BUTTON = get("Header.LogoutButton");
    private static final By GREETING_TEXT = get("Header.GreetingText");

    public Header(WebDriver driver) { this.driver = driver; }

    public LoginPage clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    public boolean checkLogoutButtonIsDisplayed() {
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public String getGreetingText() {
        return driver.findElement(GREETING_TEXT).getText();
    }
}

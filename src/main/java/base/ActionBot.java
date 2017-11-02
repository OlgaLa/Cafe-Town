package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class ActionBot {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String read(By locator) {
        return driver.findElement(locator).getText();
    }

    public void waitFor(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilClickable(By locator) {
        waitFor(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickAndConfirm(By locator) {
        click(locator);
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        driver.findElement(By.xpath("//body")).sendKeys(Keys.RETURN);
    }
}

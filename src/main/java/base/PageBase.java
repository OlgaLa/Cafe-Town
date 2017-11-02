package base;

import org.openqa.selenium.WebDriver;
import pages.part.Header;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public abstract class PageBase {

    protected WebDriver driver;
    protected ActionBot actionBot;

    public PageBase(WebDriver driver) {
        actionBot = new ActionBot(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() { return driver; }
}

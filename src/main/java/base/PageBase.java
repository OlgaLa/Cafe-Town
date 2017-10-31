package base;

import org.openqa.selenium.WebDriver;
import pages.part.Header;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public abstract class PageBase {

    private final Header HEADER;
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        HEADER = new Header(driver);
    }

    public WebDriver getDriver() { return driver; }

    public Header getHeader() {
        return HEADER;
    }
}

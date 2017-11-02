package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class TestBase {

    private static final String URL = "http://cafetownsend-angular-rails.herokuapp.com";
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {

        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "chrome";

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(URL);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @AfterMethod
    public void cleanUp() {
        driver.get(URL);
        loginPage = new LoginPage(driver);
    }

}

package base;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.part.Header;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class InternalPage extends PageBase {

    public InternalPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public LoginPage logout() {
        return getHeader().clickLogoutButton();
    }

}

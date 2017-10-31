import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmployeesPage;

import java.net.Socket;

/**
 * Created by Olga Lapanovich on 31.10.2017.
 */
public class LoginTest extends TestBase {

    private EmployeesPage employeesPage;
    private static final String USERNAME ="Luke";
    private static final String PASSWORD = "Skywalker";

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginTest(){
        employeesPage=loginPage.login(USERNAME, PASSWORD);
        softAssert.assertTrue(employeesPage.checkCreateButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkEditButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.checkDeleteButtonIsDisplayed());
        softAssert.assertTrue(employeesPage.getHeader().checkLogoutButtonIsDisplayed());
        softAssert.assertEquals(employeesPage.getHeader().getGreetingText(), "Hello " + USERNAME);
        softAssert.assertAll();
    }

}


//@Listeners(FailListener.class)
//public class ProductPageTest extends TestBase {
//
//    private ProductPage productPage;
//    private static final String PRODUCT_CATEGORY = "T-shirts";
//
//    @Test(groups = {"smoke", "product"})
//    @TestCaseId("E-6")
//    @Stories("Verify that the T-shirt is in Women catalog")
//    @Features("CatalogTest")
//    public void productPageTest() {
//        productPage = homePage.getHeader().clickTShirtsSubcategory();
//        Assert.assertTrue(productPage.getProduct().getProductTitle().contains(PRODUCT_CATEGORY), "Product name doesn't contain T-shirts");
//    }
//}
package helpers;


import org.testng.annotations.DataProvider;

import java.util.UUID;

/**
 * Created by Olga Lapanovich on 02.11.2017.
 */
public class EmployeeDataProvider {

    @DataProvider(name = "createNewDataProvider")
    public static Object[][] createNewDataProvider() {
        return new Object[][]{
                new Object[]{UUID.randomUUID().toString(), "Organa", "2017-10-10", "d@d.com"}
        };
    }
}


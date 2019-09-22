package _PrettyPrintingwithTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class SimpleDataDriven {  //Scenario 1: DataProvider feeds simple data to the @Test annotated test method.
    @Test(dataProvider = "dp")
    public void myTestMethod(int age, String s) {
        assertNotNull(s);
        assertTrue(age != 0);
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { 25, "John" }, new Object[] { 27, "Rambo" }, };
    }
}
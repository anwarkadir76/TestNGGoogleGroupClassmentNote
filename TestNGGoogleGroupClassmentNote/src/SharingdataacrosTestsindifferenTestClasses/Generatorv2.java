package SharingdataacrosTestsindifferenTestClasses;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
 
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class Generatorv2 {
    public static final String MY_ATTRIBUTE = "sumOfValues";
    private List<Integer> sumValue;
 
    @AfterClass(alwaysRun = true)
    public void insertValueIntoAttribute(ITestContext ctx) {
        ctx.setAttribute(MY_ATTRIBUTE, sumValue);
    }
 
    public Generatorv2() {
        sumValue = new ArrayList<Integer>();
    }
 
    @Test(groups = "parent", dataProvider = "generateNumbers")
    public void testNumbers(Integer a, Integer b) {
        assertTrue(a != 0);
        assertTrue(b != 0);
        sumValue.add(a + b);
    }
 
    @DataProvider
    public Object[][] generateNumbers() {
        return new Object[][] { { 1, 2 }, { 3, 4 } };
    }
 
}
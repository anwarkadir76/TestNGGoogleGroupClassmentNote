package _SharingdataacrossTestsindifferentTestClasses;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import static org.testng.Assert.assertTrue;
 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class Generator implements DataGrabber {
    private List<Integer> sumValue;
 
    public List<Integer> getSumValue() {
        return Collections.unmodifiableList(sumValue);
    }
 
    public Generator() {
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
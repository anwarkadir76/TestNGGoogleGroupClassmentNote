package _Approach2Viathetestattributes;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
 
import java.util.List;
 
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Consumerv2 {
    private List<Integer> allTheValues = null;
 
    @BeforeClass(alwaysRun=true)
    @SuppressWarnings("unchecked")
    public void fetchData(ITestContext ctx) {
        allTheValues = (List<Integer>) ctx.getAttribute(Generatorv2.MY_ATTRIBUTE);
    }
 
    @Test(dependsOnGroups = "parent", groups = "child")
    public void myCrazyTest() {
        assertNotNull(allTheValues);
        assertFalse(allTheValues.isEmpty());
        assertTrue(allTheValues.contains(new Integer(3)));
        assertTrue(allTheValues.contains(new Integer(7)));
 
    }
}
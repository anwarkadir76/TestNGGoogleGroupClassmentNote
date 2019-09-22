package SharingdataacrosTestsindifferenTestClasses;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
 
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class Consumer { ///Approach 1: Via the TestClass’s instance.
    private List<Integer> allTheValues = null;
 
    @BeforeMethod(alwaysRun = true)
    public void dataGrabber(ITestContext ctx) {
        for (ITestNGMethod eachMethod : ctx.getAllTestMethods()) {
            //We are specifically looking for the method testNumbers() because we know that once we find this method,
            //the instance of the class to which this method belongs to will have our details. 
            if (eachMethod.getConstructorOrMethod().getName().equals("testNumbers")) {
                //First we query the method to give out its instance
                Object testClassObject = eachMethod.getInstance();
                //Now we check if the instance implements our interface. We do this because we will cast the instance into the 
                //interface type to access our data
                if (testClassObject instanceof DataGrabber) {
                    allTheValues = ((DataGrabber) testClassObject).getSumValue();
                    //Ok.. now that we found our data, lets break out of the loop. No point in continuing further.
                    break;
                }
            }
        }
 
    }
 
    @Test(dependsOnGroups = "parent", groups = "child")
    public void myCrazyTest() {
        assertNotNull(allTheValues);
        assertFalse(allTheValues.isEmpty());
        assertTrue(allTheValues.contains(new Integer(3)));
        assertTrue(allTheValues.contains(new Integer(7)));
 
    }
}
package _WorkingwithTestInstanceannotation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class LocalDataProvider {
    @DataProvider (name="data-provider")
    public static Object[][] getData(@TestInstance Object object) {
        System.err.println("The instance passed in was " + object.getClass().getCanonicalName());
        return new Object[][] {
            {1},
            {2}
        };
    }
}
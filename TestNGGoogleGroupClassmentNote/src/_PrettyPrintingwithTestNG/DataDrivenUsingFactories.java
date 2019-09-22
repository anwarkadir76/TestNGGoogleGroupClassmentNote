package _PrettyPrintingwithTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataDrivenUsingFactories {
    private String name;
    private int age;

    @Factory(dataProvider = "dp")
    public DataDrivenUsingFactories(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Test
    public void testName() {
        assertNotNull(name);
    }

    @Test
    public void testAge() {
        assertTrue(age != 0);
    }

    @DataProvider
    public static Object[][] dp() {
        return new Object[][] {
            { "John", 30 },
            { "Rambo", 40 }
        };
    }
}

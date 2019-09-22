package _PrettyPrintingwithTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class sampletestNG implements ITest {
    private String name;
    private int age;

    @Factory(dataProvider = "dp")
    public sampletestNG(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Test
    public void testName() {
        assertNotNull(name, "Name validation successful");
    }

    @Test
    public void testAge() {
        assertTrue(age != 0, "Age validation successful");
    }

    @DataProvider
    public static Object[][] dp() {
        return new Object[][] {
            { "John", 30 },
            { "Rambo", 40 }
        };
    }

    public String getTestName() {
        StringBuilder builder = new StringBuilder();
        builder.append("[name=")
        .append(name)
        .append(", age=")
        .append(age)
        .append("]");
        return builder.toString();
    }
}
The output would look as below

[TestNG] Running:
  /private/var/folders/47/hs5x_y397rsf8vbfqmqrmngm0000gn/T/testng-eclipse-336434888/testng-customsuite.xml

PASSED: [name=John, age=30]
PASSED: [name=Rambo, age=40]
PASSED: [name=John, age=30]
PASSED: [name=Rambo, age=40]
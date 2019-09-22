package _DynamicparameterizationinTestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisedSampleTestClass {
    @Test
    @Parameters("name")
    public void hello(String name) {
        System.err.println("Hello " + name + " !");
    }
}
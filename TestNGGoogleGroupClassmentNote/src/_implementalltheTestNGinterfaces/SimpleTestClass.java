package _implementalltheTestNGinterfaces;

import org.testng.annotations.Test;

public class SimpleTestClass {
    @Test
    public void helloWorld() {
        System.err.println("Hello World from " + getClass().getName());
    }
}
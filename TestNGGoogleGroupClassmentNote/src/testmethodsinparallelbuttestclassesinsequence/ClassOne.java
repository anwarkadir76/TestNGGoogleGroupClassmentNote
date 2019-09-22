package testmethodsinparallelbuttestclassesinsequence;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ClassOne {
    @Test
    public void testMethod() {
        String method = Reporter.getCurrentTestResult().getMethod().getMethodName();
        System.err.println("Running " + getClass().getName() + "." + method + "() on Thread [" + Thread.currentThread().getId() + "]");
    }
 
    @Test
    public void anotherTestMethod() {
        String method = Reporter.getCurrentTestResult().getMethod().getMethodName();
        System.err.println("Running " + getClass().getName() + "." + method + "() on Thread [" + Thread.currentThread().getId() + "]");
    }
}
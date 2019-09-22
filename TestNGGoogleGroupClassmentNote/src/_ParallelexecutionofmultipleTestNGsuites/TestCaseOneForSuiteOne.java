package _ParallelexecutionofmultipleTestNGsuites;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCaseOneForSuiteOne {
    @Test
    public void testMethodOneForSuiteOne() {
        printer();
    }
 
    @Test
    public void testMethodTwoForSuiteOne() {
        printer();
    }
 
    private void printer() {
        ITestResult result = Reporter.getCurrentTestResult();
        String name = result.getTestClass().getName() + "." 
        + result.getMethod().getMethodName() + "()  on Thread #" 
        + Thread.currentThread().getId();
        Reporter.log(name + " ran.", true);
    }
}
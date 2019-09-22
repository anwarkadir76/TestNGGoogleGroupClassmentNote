package _ReportingconsolidatedTestNGresultforteststhatusedataproviders;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IListen implements IInvokedMethodListener {
    private Map<String, Boolean> results = new ConcurrentHashMap<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
      String key = testResult.getInstanceName() + "." + method.getTestMethod().getMethodName();
      if (!results.containsKey(key)) {
        results.put(key, Boolean.TRUE);
      }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
       //If no marker annotation do nothing
      if (method
              .getTestMethod()
              .getConstructorOrMethod()
              .getMethod()
              .getAnnotation(NeedConsolidatedResults.class)
          == null) {
        return;
      }
      // If not data driven do nothing
      if (!method.getTestMethod().isDataDriven()) {
        return;
      }
      String key = testResult.getInstanceName() + "." + method.getTestMethod().getMethodName();
      Boolean result = results.get(key);
      result = result && (testResult.getStatus() == ITestResult.SUCCESS);
      results.put(key, result);
      if (method.getTestMethod().hasMoreInvocation()) {
        return;
      }
      if (results.get(key)) {
      //This is where we report pass for a data driven test
        System.err.println("All invocations passed for " + testResult.getMethod().getMethodName());
      } else {
      //This is where we report failure for a data driven test
        System.err.println("Some invocations failed for " + testResult.getMethod().getMethodName());
      }
    }
}
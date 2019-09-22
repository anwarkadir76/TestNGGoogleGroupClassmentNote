package TestSuiteWithoutUsingBeforeSuiteBeforeTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
 
public class TestLevelBrowserCreator implements ITestListener {
    private static final String DRIVER = "driver";
    @Override
    public void onTestStart(ITestResult result) { }
 
    @Override
    public void onTestSuccess(ITestResult result) { }
 
    @Override
    public void onTestFailure(ITestResult result) { }
 
    @Override
    public void onTestSkipped(ITestResult result) { }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
 
    @Override
    public void onStart(ITestContext context) {
        RemoteWebDriver driver;
        String browserType = context.getCurrentXmlTest().getParameter("browserType");
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }
        context.setAttribute(DRIVER, driver);
    }
 
    @Override
    public void onFinish(ITestContext context) {
        Object driver = context.getAttribute(DRIVER);
        if (driver == null) {
            return;
        }
        if (!(driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        ((RemoteWebDriver) driver).quit();
        context.setAttribute(DRIVER, null);
    }
 
    /**
     * @return - A valid {@link RemoteWebDriver} instance only when invoked from within a <code>@Test</code> annotated
     * test method.
     */
    public static RemoteWebDriver getDriver() {
        ITestResult result = Reporter.getCurrentTestResult();
        if (result == null) {
            throw new UnsupportedOperationException("Please invoke only from within an @Test method");
        }
        Object driver = result.getTestContext().getAttribute(DRIVER);
        if (driver == null) {
            throw new IllegalStateException("Unable to find a valid webdriver instance");
        }
        if (!(driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        return (RemoteWebDriver) driver;
    }
}
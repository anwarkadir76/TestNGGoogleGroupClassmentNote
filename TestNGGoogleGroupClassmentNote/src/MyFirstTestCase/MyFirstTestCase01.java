package MyFirstTestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import TestcasespecificlogsforaSeleniumproject.LogAwareWebDriverEventListener;

public class MyFirstTestCase01 {
	@Test
    public void testMethod1() {
        runTest("http://www.google.com");
    }
 
    @Test
    public void testMethod2() {
        runTest("http://newtours.demoaut.com/");
    }
 
    private void runTest(String url) {
        ChromeDriver cd = new ChromeDriver();
        EventFiringWebDriver driver = new EventFiringWebDriver(cd);
        LogAwareWebDriverEventListener listener = new LogAwareWebDriverEventListener();
        String outputFolder = Reporter.getCurrentTestResult().getTestContext().getSuite().getOutputDirectory();
        listener.bindLogName(Reporter.getCurrentTestResult().getName(), outputFolder);
        driver.register(listener);
        driver.get(url);
        driver.quit();
        listener.unbind();
    }
}
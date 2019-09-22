package TestSuiteWithoutUsingBeforeSuiteBeforeTest;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
@Listeners(SuiteLevelBrowserCreator.class)
public class MyFirstTestCase {
 
    @Test
    public void testGooglePage() {
        launchPage("http://www.google.com");
    }
 
    @Test
    public void testFaceBookPage() {
        launchPage("http://www.facebook.com");
    }
 
    private void launchPage(String url) {
        RemoteWebDriver driver = SuiteLevelBrowserCreator.getDriver();
        driver.get(url);
        System.err.println("Page Title :" + driver.getTitle());
    }
}
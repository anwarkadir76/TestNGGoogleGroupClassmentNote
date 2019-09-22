package EavesdroppingintoWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EavesdropEventsUsingWebDriver {
    WebDriver fd;
 
    @BeforeClass
    public void setup() {
        fd = new FirefoxDriver();
    }
 
    @AfterClass
    public void cleanup() {
        fd.quit();
    }
 
    @Test
    public void testMethod() throws NoSuchMethodException {
        //Lets inject our CmmandExecutor into the newly created WebDriver instance.
        appendListenerToWebDriver((RemoteWebDriver) fd);
        fd.get("http://www.yahoo.com");
        System.out.println(fd.getTitle());
    }
}

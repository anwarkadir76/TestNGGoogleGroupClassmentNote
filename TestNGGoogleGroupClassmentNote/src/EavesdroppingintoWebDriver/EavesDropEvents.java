package EavesdroppingintoWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EavesDropEvents {
    WebDriver rwd;
 
    @BeforeClass
    public void setup() throws MalformedURLException {
        rwd = new EavesdroppingWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
    }
 
    @Test
    public void testMethod() {
        rwd.get("http://www.yahoo.com");
        System.out.println("Title : " + rwd.getTitle());
    }
 
    @AfterClass
    public void cleanup() {
        rwd.quit();
    }
}
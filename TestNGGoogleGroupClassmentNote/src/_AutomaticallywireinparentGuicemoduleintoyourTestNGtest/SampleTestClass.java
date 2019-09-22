package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
 
import javax.inject.Inject;
 
@Guice(modules = WebDriverModule.class)
@Test
public class SampleTestClass {
 
    private RemoteWebDriver driver;
 
    @Inject
    public SampleTestClass(WebDriverProducer producer) {
        driver = producer.newInstance();
    }
 
    public void testMethod() {
        driver.get("http://the-internet.herokuapp.com/");
        Assert.assertEquals("The Internet", driver.getTitle());
    }
 
    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
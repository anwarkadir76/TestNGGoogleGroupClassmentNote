package _TestNGprovidedannotation;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SeleniumStarterListener.class)
public class IUseListeners {
 
    private Selenium selenium = null;
 
    @BeforeClass
    public void setup() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com");
        selenium.start();
    }
 
    @Test
    public void f() {
        selenium.open("http://www.facebook.com   }
 
    @AfterClass
    public void tearDown() {
        selenium.stop();
    }
}
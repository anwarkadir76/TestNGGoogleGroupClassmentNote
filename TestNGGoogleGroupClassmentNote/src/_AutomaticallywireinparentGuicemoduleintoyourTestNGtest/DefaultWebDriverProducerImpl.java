package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import javax.inject.Inject;
 
public class DefaultWebDriverProducerImpl implements WebDriverProducer {
 
    private String flavor;
 
    @Inject
    public DefaultWebDriverProducerImpl(EnvInfo info) {
        this.flavor = info.getBrowserFlavor().trim().toLowerCase();
    }
 
    @Override
    public RemoteWebDriver newInstance() {
        switch (flavor) {
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
 
    }
}
package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverProducer {
    RemoteWebDriver newInstance();
}
package EavesdroppingintoWebDriver;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class EavesdroppingWebDriver extends RemoteWebDriver {
    public EavesdroppingWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        setCommandExecutor(new MyFunkyExecutor(new HttpCommandExecutor(remoteAddress)));
    }
}
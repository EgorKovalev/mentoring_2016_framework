package webdriver.browserFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFoxDriverCreator extends DriverCreator {

    @Override
    public RemoteWebDriver setUp(){
        DesiredCapabilities capability = new DesiredCapabilities().firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WINDOWS);

        return new FirefoxDriver(capability);
    }
}

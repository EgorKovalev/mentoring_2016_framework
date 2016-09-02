package core.webdriver.browserFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator extends DriverCreator {

    @Override
    public RemoteWebDriver setUp(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        DesiredCapabilities capability = new DesiredCapabilities().chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);

        return new ChromeDriver(capability);
    }
}

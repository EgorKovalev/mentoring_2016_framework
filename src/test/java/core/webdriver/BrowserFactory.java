package core.webdriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import core.webdriver.Browser.*;
import core.webdriver.browserFactory.ChromeDriverCreator;
import core.webdriver.browserFactory.DriverCreator;
import core.webdriver.browserFactory.FireFoxDriverCreator;

public abstract class BrowserFactory {
    //factory pattern example
    public static RemoteWebDriver setUp(final Browsers browser) {
        DriverCreator driverCreator = new FireFoxDriverCreator();

        switch(browser){
            case FIREFOX:
                //has already implemented
                break;

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                driverCreator = new ChromeDriverCreator();
                break;

            case IEXPLORE:
                //TODO: in progress
                break;

            case OPERA:
                //TODO: in progress
                break;

            case SAFARI:
                //TODO: in progress
                break;

            default:
                //use FireFox driver
                break;
        }

        return driverCreator.setUp();
    }
}

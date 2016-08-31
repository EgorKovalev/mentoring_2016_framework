package webdriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.Browser.*;
import webdriver.browserFactory.ChromeDriverCreator;
import webdriver.browserFactory.DriverCreator;
import webdriver.browserFactory.FireFoxDriverCreator;

public abstract class BrowserFactory {

    public static RemoteWebDriver setUp(final Browsers browser) {
        DriverCreator driverCreator = new FireFoxDriverCreator();

        switch(browser){
            case FIREFOX:
                //has already implemented
                break;

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "grid\\chromedriver.exe");
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

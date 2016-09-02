package core.webdriver.browserFactory;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverCreator {

    public abstract RemoteWebDriver setUp();
}

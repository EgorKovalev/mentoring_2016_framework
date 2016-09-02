package core.webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static Browser browser = Browser.getInstance();

    @BeforeClass
    public void before() {
        browser = Browser.getInstance();
        browser.windowMaximise();
        browser.navigate(Browser.getBaseUrl());
    }

    @AfterClass
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}

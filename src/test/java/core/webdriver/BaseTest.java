package core.webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Random;

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

    public static int getRandomNumber(){
        Random rn = new Random();
        int max = 999;
        int min = 100;

        return rn.nextInt(max - min + 1) + min;
    }
}

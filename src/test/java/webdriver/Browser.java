package webdriver;

import com.google.common.base.Strings;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final String PROPERTIES_FILE = "selenium.properties";
    private static final String BROWSER_PROP = "browser";
    private static final long IMPLICITY_WAIT = 10L;

    private static Browser instance;
    private static WebDriver driver;

    public static PropertiesManager props;
    public static Browsers currentBrowser;

    private Browser() {  }

    public static String getBaseUrl(){
        return System.getProperty("urlLoginPage", props.getProperty("urlLoginPage"));
    }

    public static Browser getInstance() {
        //singleton patter example
        if (instance == null) {
            initProperties();
            driver = BrowserFactory.setUp(currentBrowser);
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            instance = new Browser();
        }
        return instance;
    }

    private static void initProperties() {
        props = new PropertiesManager(PROPERTIES_FILE);

        if (!Strings.isNullOrEmpty(props.getProperty(BROWSER_PROP))) {
            String proper = props.getProperty(BROWSER_PROP);
            currentBrowser = Browsers.valueOf(proper.toUpperCase());
        } else {
            //TODO: run default browser
        }
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public void windowMaximise() {
        driver.manage().window().maximize();
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    public enum Browsers {
        FIREFOX("firefox"),
        IEXPLORE("iexplore"),
        CHROME("chrome"),
        OPERA("opera"),
        SAFARI("safari");

        public String value;

        Browsers(final String values) {
            value = values;
        }

        public String toString() {
            return value;
        }
    }
}

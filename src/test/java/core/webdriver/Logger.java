package core.webdriver;

import org.testng.Assert;
import org.testng.Reporter;

public final class Logger {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void debug(final String message) {
        logger.debug(message);
    }

    public void info(final String message) {
        logger.info(message);
        Reporter.log(message + "<br>");
    }

    public void error(final String message) {
        String msg = message;
        logger.error(message);
        msg = "<div class=\"failedConfig\">" + msg + "</div>"; // red color from reporting css
        Reporter.log(msg + "<br>");
    }

    public void fatal(final String message) {
        String msg = message;
        logger.fatal(message);
        msg = "<div class=\"failedConfig\">" + msg + "</div>"; // red color from reporting css
        Reporter.log(msg + "<br>");
        Assert.assertTrue(false, message);
    }
}

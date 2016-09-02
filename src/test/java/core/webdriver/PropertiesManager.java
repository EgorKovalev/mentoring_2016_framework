package core.webdriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {
    private Properties properties = new Properties();

    public PropertiesManager(final String resourceName) {
        properties = getFromResource(properties, resourceName);
    }

    private Properties getFromResource(final Properties objProperties, final String resourceName) {
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inStream != null) {
            try {
                objProperties.load(inStream);
                inStream.close();
            } catch (IOException e) {
            }
        } else {
        }
        return objProperties;
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}

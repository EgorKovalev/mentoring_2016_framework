package core.businessLogic;

import core.webdriver.PropertiesManager;

public class User {
    private PropertiesManager props = new PropertiesManager("selenium.properties");

    public User(){ }

    public String getUsername(){
        return System.getProperty("userName", props.getProperty("userName"));
    }

    public String getPassword(){
        return System.getProperty("password", props.getProperty("password"));
    }
}

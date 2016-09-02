package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsDroplist extends BaseForm {
    private final static By titleLocator = By.id("user-dropdown-popup");
    private String itemPath = "//div[@class='b-mail-dropdown__item']/a[.='%s']";

    public UserSettingsDroplist() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public WebElement getItem(String name){
        return driver.findElement(By.xpath(String.format(itemPath, name)));
    }
}

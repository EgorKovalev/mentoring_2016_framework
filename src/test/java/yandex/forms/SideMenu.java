package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SideMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[@class='block-left-box']");
    private String itemsPath = "//div[@class='block-folders']/div/div/div[contains(.,'%s')]";
    private String itemsNumberPath = itemsPath + "/span/span/span";

    public SideMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public String getItemsNumber(String name){
        try {
            return driver.findElement(By.xpath(String.format(itemsNumberPath, name))).getText();
        }
        catch(NoSuchElementException ex){
            return "0";
        }
    }

    public WebElement getItem(String name){
        return driver.findElement(By.xpath(String.format(itemsPath, name)));
    }
}

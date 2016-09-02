package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ToolbarMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[@class='block-toolbar-box']");
    private String itemPath = "//div[@class='block-toolbar']/div/div/div/a[contains(@title,'%s')]";

    public ToolbarMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public WebElement getItem(String name){
        return driver.findElement(By.xpath(String.format(itemPath, name)));
    }
}

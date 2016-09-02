package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PopupBox extends BaseForm {
    private final static By titleLocator = By.xpath("//*[@class='b-popup__box']");
    private String itemPath = "//div[@class='b-popup__confirm']/button[contains(.,'%s')]";

    public PopupBox() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickButton(String name){
        WebElement element = driver.findElement(By.xpath(String.format(itemPath, name)));
        if(element.isEnabled()){
            element.click();
        }
    }

    public boolean isDisplayed(){
        return driver.findElement(titleLocator).isDisplayed();
    }
}

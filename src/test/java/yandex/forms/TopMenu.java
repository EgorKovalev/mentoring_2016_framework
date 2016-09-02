package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[@class='b-header']");
    private String itemPath = "//div[@class='b-header']/div[@class='b-header__middle']/a[contains(.,'%s')]";
    private UserSettingsDroplist userSettingsDroplist = new UserSettingsDroplist();

    public TopMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='b-header__right']/a/span[contains(@class,'header-user-name')]")
    private WebElement userSettingDropList;

    public WebElement getItem(String name){
        return driver.findElement(By.xpath(String.format(itemPath, name)));
    }

    public void logOut(){
        userSettingDropList.click();
        userSettingsDroplist.getItem("Выход").click();
    }
}

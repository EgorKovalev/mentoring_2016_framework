package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandex.menus.MenuMaker;
import yandex.menus.TopMenu;

public class NewMessagePage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[@class='b-compose-head']");
    private MenuMaker menuMaker = new MenuMaker();

    public NewMessagePage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "compose-subj")
    private WebElement subjectInput;

    public void clickTopmenuItem(String name){
        menuMaker.getTopMenuItem(name).click();
    }

    public void createNewMessage(){
        subjectInput.sendKeys("test email");
    }

    public void createNewMessage(String to, String text){
        waitForPageToLoad();
        sendKeyViaActions(to);
        subjectInput.sendKeys(text);
    }
}

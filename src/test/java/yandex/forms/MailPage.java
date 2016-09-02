package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandex.menus.MenuMaker;
import yandex.menus.SideMenu;
import yandex.menus.ToolbarMenu;

import java.util.ArrayList;
import java.util.List;

public class MailPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'b-toolbar__block_chevron')]");
    private PopupBox popupBox = new PopupBox();
    private MenuMaker menuMaker = new MenuMaker();
    private final String messageTopic = "//div[@class='b-messages']//span[@class='b-messages__subject' and .='%s']";

    public MailPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='block-messages-title']/span/span/span[@class='js-messages-title-dropdown-name']")
    private WebElement mailBoxName;

    @FindBy(xpath = "//div[@class='b-messages']//span[@class='b-messages__subject']")
    private List<WebElement> messageTopics;

    @FindBy(xpath = "//table[@class='b-compose-head']//button")
    private WebElement sendMessage;

    public String getCurrentEmailBoxName(){
        return mailBoxName.getText();
    }

    public void clickToolbarItem(String name){
        menuMaker.getToolbarItem(name).click();
    }

    public void saveChanges(){
        popupBox.clickButton("Сохранить");
        popupBox.waitForPageToLoad();
    }

    public void doNotSaveChanges(){
        popupBox.clickButton("Не сохранять");
        popupBox.waitForPageToLoad();
    }

    public int getItemsNumber(String name){
        return Integer.valueOf(menuMaker.getItemsNumber(name));
    }

    public void clickSidebarItem(String name){
        menuMaker.getSideMenuItem(name).click();
    }

    public List<String> getMessageTopics(){
        List<String> topics = new ArrayList<String>();
        for (WebElement messageTopic: messageTopics) {
            topics.add(messageTopic.getText());
        }
        return topics;
    }

    public void clickMessage(String name){
        driver.findElement(By.xpath(String.format(messageTopic, name))).click();
    }

    public void sendMessage(String to){
        waitForPageToLoad();
        sendKeyViaActions(to);
        sendMessage.click();
    }
}

package yandex.menus;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuMaker extends BaseForm {
    //facade pattern example
    private final static By titleLocator = By.xpath("");
    private BaseMenu topMenu = new TopMenu();
    private BaseMenu toolbarMenu = new ToolbarMenu();
    private BaseMenu sideMenu = new SideMenu();

    public MenuMaker() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void logOut(){
        topMenu.logOut();
    }

    public String getItemsNumber(String name){
        return sideMenu.getItemsNumber(name);
    }

    public WebElement getSideMenuItem(String name){
        return sideMenu.getItem(name);
    }

    public WebElement getTopMenuItem(String name){
        return topMenu.getItem(name);
    }

    public WebElement getToolbarItem(String name){
        return toolbarMenu.getItem(name);
    }
}

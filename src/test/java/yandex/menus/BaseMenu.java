package yandex.menus;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;

public abstract class BaseMenu extends BaseForm implements BaseMenuInterface {
    protected BaseMenu(By titleLoc) {
        super(titleLoc);
    }
    protected void logOut(){}
    protected String getItemsNumber(String name) {return null;}
}

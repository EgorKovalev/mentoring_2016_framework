package yandex.forms;

import core.webdriver.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'container__search container__line')]");
    private TopMenu topMenu = new TopMenu();

    public MainPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'auth__button')]")
    private WebElement submitButton;

    public void authorizeUser(){
        loginInput.clear();
        loginInput.sendKeys(user.getUsername());
        passwordInput.clear();
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void authorizeUser(String username, String password){
        loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void logOutUser(){
        topMenu.waitForPageToLoad();
        topMenu.logOut();
    }
}

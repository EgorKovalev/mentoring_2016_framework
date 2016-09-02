package yandex;

import core.businessLogic.User;
import core.webdriver.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import yandex.forms.MailPage;
import yandex.forms.MainPage;
import yandex.forms.NewMessagePage;

import java.util.List;

public class TestRunner extends BaseTest {
    private static User user = new User();

    @Test (priority = 1)
    public void checkMailBoxFullName(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        Assert.assertTrue(mailPage.isDisplayedNameCorrect(user));
        mainPage.logOutUser();
    }

    @Test (priority = 1)
    public void successfulAuthorization(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        Assert.assertTrue(mailPage.getCurrentEmailBoxName().contains(user.getUsername()));
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void createNewMessageAndSaveInDraft(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage();
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") != itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void createNewMessageAndDoNotSave(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage();
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.doNotSaveChanges();

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") == itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void verifyDraftTopic(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        List<String> topics = mailPage.getMessageTopics();

        Assert.assertTrue(topics.contains(topicName), "Can't find \"" + topicName + "\" in the topics");
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void sendMessageFromDraft(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        mailPage.clickMessage(topicName);
        mailPage.sendMessage(to);

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") != itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void verifySentMessage(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Отправленные");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        mailPage.clickMessage(topicName);
        mailPage.sendMessage(to);

        Assert.assertTrue(mailPage.getItemsNumber("Отправленные") == itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void searchingTest(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser(user);

        MailPage mailPage = new MailPage();
        mailPage.runFreeSearch("Яндекс");
        Assert.assertTrue(mailPage.isSearchPopupVisible());

        mailPage.searchButton().click();    //to close the popup
        mainPage.logOutUser();
    }
}

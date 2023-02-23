package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomatedMessagesClientsPage extends PageBasics {

    @FindBy(css = "a[data-qa='nav-d-clients']")
    protected WebElement clientsIcon;

    @FindBy(css = "a[data-qa='navtabs-item-automated-messages']")
    protected WebElement automatedMessagesMenu;

    @FindBy(css = "span[data-qa='badge-emailChannelAvailability-enabled']")
    protected WebElement selectEmail;

    @FindBy(name = "reminderNotice")
    protected WebElement reminderTimeframe;

    @FindBy(css = "button[data-qa='header-next-button']")
    protected WebElement nextStepOrSaveChanges;

    @FindBy(css = "form > div > div > div > div > div > div > div > div > div > div > div > div > div > p")
    protected WebElement setupMessage;

    public AutomatedMessagesClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String setupAutomatedMessage() {
        clickOnElement(clientsIcon);
        clickOnElement(automatedMessagesMenu);
        clickOnElement(selectEmail);
        waitUntilElementToBeClickable(reminderTimeframe);
        chooseItemFromDDWithSelect(reminderTimeframe, "72 hours");
        clickOnElement(nextStepOrSaveChanges);
        clickOnElement(nextStepOrSaveChanges);
        waitForVisibilityOfElement("form > div > div > div > div > div > div > div > div > div > div > div > div > div > p");
        return setupMessage.getText();
    }
}

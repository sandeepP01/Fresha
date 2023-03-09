package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewAppointmentCalendarPage extends PageBasics  {

    @FindBy (css = "button[data-qa='floating-menu-button']")
    protected WebElement add;

    @FindBy (css = "div[data-qa='calendar-new-appointment']")
    protected WebElement newAppointment;

    @FindBy (css = "div[data-qa='appointment-item-card'] > div:nth-child(3) > div:nth-child(2) > select")
    protected WebElement startTimeDropDown;

    @FindBy (css = "input[data-qa='selected-service']")
    protected WebElement serviceDropDown;

    @FindBy (css = "div > ul > div:nth-child(2) > div > div > div > div > p > div > span")
    protected WebElement serviceOption;

    @FindBy (css = "select[name='items[0].duration']")
    protected WebElement durationDropDown;

    @FindBy (css = "select[name='items[0].employee']")
    protected WebElement teamMemberDropDown;

    @FindBy(name = "notes")
    protected WebElement notes;

    @FindBy (css = "button[data-qa='save-appointment-button']")
    protected WebElement saveAppointment;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public AddNewAppointmentCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String createAppointment() {
        webDriverWait.until(ExpectedConditions.visibilityOf(add));
        clickOnElement(add);
        waitUntilElementToBeClickable(newAppointment);
        clickOnElement(newAppointment);
        waitForVisibilityOfElement(("div[data-qa='appointment-item-card'] > div:nth-child(3) > div:nth-child(2) > select"));
        chooseItemFromDDWithSelect(startTimeDropDown,"3:00pm");
        clickOnElement(serviceDropDown);
        waitUntilElementToBeClickable(serviceOption);
        clickOnElement(serviceOption);
        chooseItemFromDDWithSelect(durationDropDown,"5min");
        waitUntilElementToBeClickable(teamMemberDropDown);
        chooseItemFromDDWithSelect(teamMemberDropDown, "Wendy Smith (Demo)");
        enterText(notes, "Hello");
        clickOnElement(saveAppointment);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

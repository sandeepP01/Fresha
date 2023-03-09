package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBlockedTimeCalendarPage extends PageBasics {

    @FindBy(css = "div:nth-child(5) > div > div:nth-child(4) > div:first-child > div")
    protected WebElement employeeIcon;

    @FindBy(css = "button[data-qa='staff-actions-blocked-time']")
    protected WebElement addBlockedTimeOption;

    @FindBy(css = "div[data-qa='blocked-time-date-picker']")
    protected WebElement dateDropDown;

    @FindBy(css ="select[name='employeeId']")
    protected WebElement teamMemberDropDown;

    @FindBy(css = "select[name='start']")
    protected WebElement startTimeDropDown;

    @FindBy(css = "select[name='end']")
    protected WebElement endTimeDropDown;

    @FindBy(css = "label[data-qa='allowOnlineBooking-label']")
    protected WebElement allowOnlineBookingCheckBox;

    @FindBy(name = "note" )
    protected WebElement description;

    @FindBy(css = "button[data-qa='blocked-time-save-button']")
    protected WebElement save;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public AddBlockedTimeCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String addBlockedTime () {
        waitForVisibilityOfElement("div:nth-child(5) > div > div:nth-child(4) > div:first-child > div");
        clickOnElement(employeeIcon);
        waitUntilElementToBeClickable(addBlockedTimeOption);
        clickOnElement(addBlockedTimeOption);
        waitUntilElementToBeClickable(dateDropDown);
        clickOnElement(dateDropDown);
        WebElement desiredDateElement = driver.findElement(By.xpath("//*[@id='app']/div[6]/div/div/div[2]" +
                "/div/div/div/div[2]/div/div[3]/div[3]/div[5]"));
        desiredDateElement.click();
        chooseItemFromDDWithSelect(teamMemberDropDown, "Sean TestLio");
        chooseItemFromDDWithSelect(startTimeDropDown, "12:30pm");
        chooseItemFromDDWithSelect(endTimeDropDown, "1:00pm");
        waitForVisibilityOfElement ( "label[data-qa='allowOnlineBooking-label']");
        clickOnElement(allowOnlineBookingCheckBox);
        enterText(description, "Tea break");
        clickOnElement(save);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

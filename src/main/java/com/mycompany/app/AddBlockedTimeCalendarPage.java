package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddBlockedTimeCalendarPage extends PageBasics {

    @FindBy (css = "div:nth-child(5) > div > div:nth-child(4) > div:first-child > div")
    protected WebElement employeeIcon;

    @FindBy (css = "button[data-qa='staff-actions-blocked-time']")
    protected WebElement addBlockedTimeOption;

    @FindBy (css = "div[data-qa='blocked-time-date-picker']")
    protected WebElement dateDropDown;

    @FindBy (css ="select[name='employeeId']")
    protected WebElement teamMemberDropDown;

    @FindBy (css = "select[name='start']")
    protected WebElement startTimeDropDown;

    @FindBy (css = "select[name='end']")
    protected WebElement endTimeDropDown;

    @FindBy  (css = "label[data-qa='allowOnlineBooking-label'] > div:first-child")
    protected WebElement allowOnlineBookingCheckBox;

    @FindBy (name = "note" )
    protected WebElement description;

    @FindBy (css = "button[data-qa='blocked-time-save-button']")
    protected WebElement save;

    public AddBlockedTimeCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addBlockedTime () {
        webDriverWait.until(ExpectedConditions.visibilityOf(employeeIcon));
        clickOnElement(employeeIcon);
        waitUntilElementToBeClickable(addBlockedTimeOption);
        clickOnElement(addBlockedTimeOption);
        waitUntilElementToBeClickable(dateDropDown);
        clickOnElement(dateDropDown);
        WebElement desiredDateElement = driver.findElement(By.xpath("//*[@id='app']/div[6]/div/div/div[2]/div/div/div/div[2]/div/div[3]/div[3]/div[5]"));
        desiredDateElement.click();
        chooseItemFromDDWithSelect(teamMemberDropDown, "Tom");
        chooseItemFromDDWithSelect(startTimeDropDown, "12:30pm");
        chooseItemFromDDWithSelect(endTimeDropDown, "1:00pm");
        waitForVisibilityOfElement ( "label[data-qa='allowOnlineBooking-label'] > div:first-child");
        clickOnElement(allowOnlineBookingCheckBox);
        enterText(description, "Tea break");
        clickOnElement(save);
    }
}

package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CancelAppointmentCalendarPage extends PageBasics {

    @FindBy (css = "div[data-qa='swipeable-timelines'] > div:nth-child(13) > div")
    protected WebElement countAppoinments;

    @FindBy (css = "div[data-qa='swipeable-timelines'] > div:nth-child(13) > div > div:first-child")
    protected WebElement selectAppointment;

    @FindBy (css = "button[data-qa='more-options-button']")
    protected WebElement moreOptionsButton;

    @FindBy (css = "div[data-qa='cancel-drop-down']")
    protected WebElement cancelButton;

    @FindBy (css = "select[name='cancellationReasonId']")
    protected WebElement cancellationReasonDD;

    @FindBy (css = "button[data-qa='cancel-appointment-button']")
    protected WebElement cancelAppointmentButton;

    public CancelAppointmentCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean cancelAppointment() {
        waitForPageToLoad();
        pauseForAWhile(2000);
        int countStart = countChildElements(countAppoinments);
        System.out.println(countStart);
        waitForVisibilityOfElement("div[data-qa='swipeable-timelines'] > div:nth-child(13) > div > div:first-child");
        moveToElementActions(selectAppointment);
        waitUntilElementToBeClickable(moreOptionsButton);
        clickOnElement(moreOptionsButton);
        clickOnElement(cancelButton);
        waitUntilElementToBeClickable(cancellationReasonDD);
        chooseItemFromDDWithSelect(cancellationReasonDD, "Duplicate appointment");
        clickOnElement(cancelAppointmentButton);
        List<WebElement> elements = driver.findElements(By.cssSelector("div[data-qa='swipeable-timelines'] > div:nth-child(13) > div"));
        System.out.println(elements.size());
        if (elements.size() > 0 ) {
            int countEnd = countChildElements(countAppoinments);
            System.out.println(countEnd);
            return (countStart - 1 == countEnd);
        } else
        return true;
    }
}

package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelAppointmentCalendarPage extends PageBasics {

    @FindBy (css = "div[data-qa='swipeable-timelines'] > div:nth-child(13) > div")
    protected WebElement selectAppointment;

    @FindBy (css = "button[data-qa='more-options-button']")
    protected WebElement moreOptionsButton;

    @FindBy (css = "div[data-qa='cancel-drop-down']")
    protected WebElement cancelButton;

    @FindBy (css = "select[name='cancellationReasonId']")
    protected WebElement cancellationReasonDD;

    @FindBy (css = "button[data-qa='cancel-appointment-button']")
    protected WebElement cancelAppointmentButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public CancelAppointmentCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String cancelAppointment() {
        waitForPageToLoad();
        waitForVisibilityOfElement("div[data-qa='swipeable-timelines'] > div:nth-child(13) > div");
        WebElement firstChildElement = selectAppointment.findElement(By.xpath(".//div[contains(@data-qa, " +
                "'calendar-event-booking-')][1]"));
        clickOnElement(firstChildElement);
        waitUntilElementToBeClickable(moreOptionsButton);
        clickOnElement(moreOptionsButton);
        clickOnElement(cancelButton);
        waitUntilElementToBeClickable(cancellationReasonDD);
        chooseItemFromDDWithSelect(cancellationReasonDD, "Duplicate appointment");
        clickOnElement(cancelAppointmentButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

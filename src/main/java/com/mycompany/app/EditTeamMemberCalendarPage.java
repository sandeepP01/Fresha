package com.mycompany.app;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTeamMemberCalendarPage extends PageBasics {

    @FindBy(css = "div:nth-child(5) > div > div:nth-child(4) > div:first-child > div")
    protected WebElement employeeIcon;

    @FindBy(css = "button[data-qa='staff-actions-edit-details']")
    protected WebElement editTeamMember;

    @FindBy(name = "title")
    protected WebElement teamMemberTitle;

    @FindBy(name = "email")
    protected WebElement email;

    @FindBy(css = "button[data-qa='save-edit-button']")
    protected WebElement saveButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public EditTeamMemberCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String editTeamMember() {
        waitForPageToLoad();
        waitForVisibilityOfElement("div:nth-child(5) > div > div:nth-child(4) > div:first-child > div");
        clickOnElement(employeeIcon);
        clickOnElement(editTeamMember);
        waitUntilElementToBeClickable(teamMemberTitle);
        teamMemberTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        teamMemberTitle.sendKeys(Keys.DELETE);
        enterText(teamMemberTitle, "Hair-Dresser");
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

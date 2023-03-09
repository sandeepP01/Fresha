package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteTeamMemberBusinessPage extends PageBasics {

    @FindBy(css = "a[data-qa='nav-d-business-settings']")
    protected WebElement businessTab;

    @FindBy(css = "div:nth-child(3) >div > div > a:nth-child(1) > div")
    protected WebElement teamMember;

    @FindBy(css = "div[data-qa='staff-grid'] > a:first-child")
    protected WebElement selectTeamMember;

    @FindBy(css = "button[data-qa='staff-list-options']" )
    protected WebElement optionsButton;

    @FindBy(css = "a[data-qa='staff-form-dropdown-delete']")
    protected WebElement deleteTeamMember;

    @FindBy(css = "button[data-qa='delete-employee-confirm-button']")
    protected WebElement confirmDelete;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public DeleteTeamMemberBusinessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String deleteTeamMember() {
        clickOnElement(businessTab);
        clickOnElement(teamMember);
        clickOnElement(selectTeamMember);
        clickOnElement(optionsButton);
        clickOnElement(deleteTeamMember);
        clickOnElement(confirmDelete);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

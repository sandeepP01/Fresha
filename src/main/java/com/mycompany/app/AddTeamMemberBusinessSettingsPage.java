package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTeamMemberBusinessSettingsPage extends PageBasics {

    @FindBy(css = "a[data-qa='nav-d-business-settings']")
    protected WebElement businessTab;

    @FindBy(css = "div:nth-child(3) >div > div > a:nth-child(1) > div")
    protected WebElement teamMember;

    @FindBy(css = "button[data-qa='add-staff-button']")
    protected WebElement addTeamMember;

    @FindBy(css = "div[data-qa='add-manually']")
    protected WebElement addManually;

    @FindBy(name = "firstName")
    protected WebElement firstName;

    @FindBy(name = "lastName")
    protected WebElement lastName;

    @FindBy(name = "email")
    protected WebElement email;

    @FindBy(name = "mobileNumber")
    protected WebElement mobileNumber;

    @FindBy(css = "div[data-qa='employment-start-date']")
    protected WebElement startDate;

    @FindBy(css = "div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2)")
    protected WebElement selectStartDate;

    @FindBy(css = "div[title='Orange']")
    protected WebElement selectColor;

    @FindBy(css = "button[data-qa='add-new-staff-button']")
    protected WebElement addTeamMemberButton;

    public AddTeamMemberBusinessSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String addTeamMember() {
        clickOnElement(businessTab);
        clickOnElement(teamMember);
        clickOnElement(addTeamMember);
        clickOnElement(addManually);
        enterText(firstName, "Adam");
        enterText(lastName, "Cor");
        enterText(email, "adamcor1@gmail.com");
        enterText(mobileNumber, "438 575 0771");
        clickOnElement(startDate);
        clickOnElement(selectStartDate);
        clickOnElement(selectColor);
        clickOnElement(addTeamMemberButton);
        pauseForAWhile(2000);
        waitForPageToLoad();
        return driver.getCurrentUrl();
    }
}

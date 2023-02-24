package com.mycompany.app;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateBusinessDetailsBusinessSettingsPage extends PageBasics {

    @FindBy(css = "a[data-qa='nav-d-business-settings']")
    protected WebElement businessTab;

    @FindBy(css = "div:nth-child(1) > div > div:nth-child(1) > div > div > a:nth-child(1) > div")
    protected WebElement businessDetailsOption;

    @FindBy(css = "input[name='name']")
    protected WebElement businessName;

    @FindBy(name = "weekStart")
    protected WebElement weekStartDropDown;

    @FindBy(css = "button[data-qa='account-settings-form-submit']")
    protected WebElement saveButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public UpdateBusinessDetailsBusinessSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String updateBusinessDetails() {
        clickOnElement(businessTab);
        clickOnElement(businessDetailsOption);
        waitForVisibilityOfElement("input[name='name']");
        businessName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        businessName.sendKeys(Keys.DELETE);
        enterText(businessName, "Montreal Saloon");
        chooseItemFromDDWithSelect(weekStartDropDown, "Monday");
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

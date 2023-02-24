package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMembershipCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-memberships']")
    protected WebElement membershipsTab;

    @FindBy(css = "button[data-qa='paid-plan-new-button']")
    protected WebElement createMembershipButton;

    @FindBy(name = "name")
    protected WebElement membershipName;

    @FindBy(name = "description")
    protected WebElement membershipDescription;

    @FindBy(css = "a[data-qa='open-select-services-modal']")
    protected WebElement includedServices;

    @FindBy(css = "label[data-qa='all-services-label']")
    protected WebElement allServicesCheckBox;

    @FindBy(css = "button[data-qa='select-services-save-button']")
    protected WebElement selectServicesButton;

    @FindBy(name = "unlimitedSessions")
    protected WebElement selectSessionsDD;

    @FindBy(name = "price")
    protected WebElement enterPrice;

    @FindBy(css = "div[data-qa='color-sample-orange']")
    protected WebElement selectColor;

    @FindBy(css = "button[data-qa='save-paidPlan-button']")
    protected WebElement saveMembershipButton;

    @FindBy (css = "table > tbody")
    protected WebElement countMembership;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public CreateMembershipCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String createMembership() {
        clickOnElement(catalogueTab);
        clickOnElement(membershipsTab);
        clickOnElement(createMembershipButton);
        enterText(membershipName, "Yearly Plan");
        enterText(membershipDescription, "Yearly Plan");
        clickOnElement(includedServices);
        waitUntilElementToBeClickable(allServicesCheckBox);
        clickOnElement(allServicesCheckBox);
        clickOnElement(selectServicesButton);
        waitUntilElementToBeClickable(selectSessionsDD);
        chooseItemFromDDWithSelect(selectSessionsDD, "Unlimited");
        enterText(enterPrice, "100");
        clickOnElement(selectColor);
        clickOnElement(saveMembershipButton);
        waitForVisibilityOfElement("table > tbody");
        int endMembershipCount = countChildElements(countMembership);
        System.out.println(endMembershipCount);
        return toastNotification.getText();
    }
}

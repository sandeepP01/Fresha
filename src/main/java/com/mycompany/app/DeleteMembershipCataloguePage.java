package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMembershipCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-memberships']")
    protected WebElement membershipsTab;

    @FindBy(css = "table > tbody > tr:nth-child(1)")
    protected WebElement selectMembership;

    @FindBy(css = "button[data-qa='delete-paidPlan-button']")
    protected WebElement deleteButton;

    @FindBy(css = "button[data-qa='delete-service-confirm-button']")
    protected WebElement confirmDeleteButton;

    @FindBy(css = "div > table > tbody")
    protected WebElement countMembership;

    public DeleteMembershipCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean deleteMembership() {
        clickOnElement(catalogueTab);
        clickOnElement(membershipsTab);
        waitForVisibilityOfElement("div > table > tbody");
        int countStart = countChildElements(countMembership);
        System.out.println(countStart);
        clickOnElement(selectMembership);
        clickOnElement(deleteButton);
        clickOnElement(confirmDeleteButton);
        waitForVisibilityOfElement("div > table > tbody");
        int countEnd = countChildElements(countMembership);
        System.out.println(countEnd);
        return (countStart-1 == countEnd);
    }
}

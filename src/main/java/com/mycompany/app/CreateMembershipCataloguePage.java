package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = "div[data-qa='settings-nav-header-title'] > h1")
    protected WebElement pageHeader;

    @FindBy (css = "#react > div > div > div > div > div > div > div > div > div > table > tbody")
    protected WebElement countMembership;

    @FindBy(css = "button[data-qa='fresha-profile-overview-start-button']")
    protected WebElement startNowButton;

    public CreateMembershipCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean createMembership() {
        int startMembershipCount;
        clickOnElement(catalogueTab);
        clickOnElement(membershipsTab);
        pauseForAWhile(2000);
        List<WebElement> elements = driver.findElements(By.cssSelector("div[data-qa='settings-nav-header-title'] > h1"));
        if (!elements.isEmpty()) {
            startMembershipCount = countChildElements(countMembership);
            System.out.println(startMembershipCount);
            clickOnElement(createMembershipButton);
        } else {
            clickOnElement(startNowButton);
            startMembershipCount = 0;
            System.out.println(startMembershipCount);
        }
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
        waitForVisibilityOfElement("#react > div > div > div > div > div > div > div > div > div > table > tbody");
        int endMembershipCount = countChildElements(countMembership);
        System.out.println(endMembershipCount);
        return (startMembershipCount+1 == endMembershipCount);
    }
}

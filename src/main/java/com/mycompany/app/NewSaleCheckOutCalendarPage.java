package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSaleCheckOutCalendarPage extends PageBasics {

    @FindBy(css = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:first-child > div > div:first-child > div:nth-child(3) > button:last-child > div:nth-child(2)")
    protected WebElement add;

    @FindBy (css = "div[data-qa='calendar-new-sale']")
    protected WebElement newSale;

    @FindBy (css = "a[data-qa='tab-services']")
    protected WebElement toCheckOutTab;

    @FindBy (css = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div > div > div > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(1)")
    protected WebElement itemToCheckOut;

    @FindBy (css = "button[data-qa='cart-continue-button']")
    protected WebElement continueButton;

    @FindBy (css = "div[data-qa='no-tip-button']")
    protected WebElement tipOption;

    @FindBy (css = "button[data-qa='cart-continue-button']")
    protected WebElement continueButton2;

    @FindBy (css = "div[data-qa='cash-payment-method']")
    protected WebElement paymentOption;

    @FindBy (css = "button[data-qa='collect-cash']")
    protected WebElement collectCash;

    @FindBy (css = "button[data-qa='cart-continue-button'] > div:nth-child(2) ")
    protected WebElement chargeButton;

    @FindBy (css = "p[data-qa='invoice-status-title']")
    protected WebElement completedSaleLogo;

    public NewSaleCheckOutCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean newSaleCheckOut () {
        pauseForAWhile(2000);
        clickOnElement(add);
        clickOnElement(newSale);
        waitUntilElementToBeClickable(toCheckOutTab);
        clickOnElement(toCheckOutTab);
        pauseForAWhile(2000);
        waitUntilElementToBeClickable(itemToCheckOut);
        retryingFindClick(itemToCheckOut);
        waitUntilElementToBeClickable(continueButton);
        clickOnElement(continueButton);
        clickOnElement(tipOption);
        waitUntilElementToBeClickable(continueButton);
        clickOnElement(continueButton2);
        waitUntilElementToBeClickable(paymentOption);
        clickOnElement(paymentOption);
        waitUntilElementToBeClickable(paymentOption);
        clickOnElement(collectCash);
        pauseForAWhile(2000);
        clickOnElement(chargeButton);
        waitForVisibilityOfElement("p[data-qa='invoice-status-title']");
        return completedSaleLogo.getText().equalsIgnoreCase("Completed");
    }
}
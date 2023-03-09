package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSaleCheckOutCalendarPage extends PageBasics {

    @FindBy(css = "button:last-child > div:nth-child(2)")
    protected WebElement add;

    @FindBy (css = "div[data-qa='calendar-new-sale']")
    protected WebElement newSale;

    @FindBy (css = "a[data-qa='tab-services']")
    protected WebElement productsTab;

    @FindBy (css = "tbody > tr:nth-child(1) > td:nth-child(1)")
    protected WebElement selectItemToCheckOut;

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
        waitForPageToLoad();
        clickOnElement(add);
        clickOnElement(newSale);
        waitUntilElementToBeClickable(productsTab);
        clickOnElement(productsTab);
        waitForPageToLoad();
        waitForVisibilityOfElement("tbody > tr:nth-child(1) > td:nth-child(1)");
        waitUntilElementToBeClickable(selectItemToCheckOut);
        clickOnElement(selectItemToCheckOut);
        waitUntilElementToBeClickable(continueButton);
        clickOnElement(continueButton);
        clickOnElement(tipOption);
        waitUntilElementToBeClickable(continueButton);
        clickOnElement(continueButton2);
        waitUntilElementToBeClickable(paymentOption);
        clickOnElement(paymentOption);
        waitUntilElementToBeClickable(paymentOption);
        clickOnElement(collectCash);
        waitUntilElementToBeClickable(chargeButton);
        clickOnElement(chargeButton);
        waitForVisibilityOfElement("p[data-qa='invoice-status-title']");
        return completedSaleLogo.getText().equalsIgnoreCase("Completed");
    }
}
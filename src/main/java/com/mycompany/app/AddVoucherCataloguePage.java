package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVoucherCataloguePage extends PageBasics {
    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy (css = "[data-qa='navtabs-item-vouchers']")
    protected WebElement vouchersTab;

    @FindBy (css = "#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody")
    protected WebElement countVouchers;

    @FindBy (css = "button[data-qa='vouchers-new-button']")
    protected WebElement addVoucherType;

    @FindBy (name = "name")
    protected WebElement voucherName;

    @FindBy (name = "value")
    protected WebElement voucherValue;

    @FindBy (name = "retailPrice")
    protected WebElement retailPrice;

    @FindBy (css = "select[name='expirationPeriod']")
    protected WebElement validForDropDown;

    @FindBy (css = "label[data-qa='sales-limit-switch']")
    protected WebElement salesLimitSwitch;

    @FindBy (css = "a[data-qa='open-select-services-modal']")
    protected WebElement serviceIncludedButton;

    @FindBy (css = "#app > div:nth-child(8) > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(1) > button")
    protected WebElement unSelectService1;

    @FindBy (css = "#app > div:nth-child(8) > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(7) > button")
    protected WebElement unSelectService2;

    @FindBy (css = "button[data-qa='select-services-save-button']")
    protected WebElement selectServiceButton;

    @FindBy (css = "button[data-qa='next-button']")
    protected WebElement nextStep;

    @FindBy (name = "title")
    protected WebElement voucherTitle;

    @FindBy (name = "description")
    protected WebElement voucherDescription;

    @FindBy (css = "div[title = 'green']")
    protected WebElement voucherColor;

    @FindBy (css = "label[data-qa='enable-book-now-switch']")
    protected WebElement bookNowButton;

    @FindBy (css = "label[data-qa='enable-notes-switch']")
    protected WebElement enableNotesCheckbox;

    @FindBy (name = "notes")
    protected WebElement notes;

    @FindBy (css = "button[data-qa='save-button']")
    protected WebElement saveButton;


    public AddVoucherCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean addVoucher () {
        waitForVisibilityOfElement("a[data-tip='Catalogue']");
        clickOnElement(catalogueTab);
        waitUntilElementToBeClickable(vouchersTab);
        clickOnElement(vouchersTab);
        waitForVisibilityOfElement("#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody");
        int startCount = countChildElements(countVouchers);
        System.out.println(startCount);
        clickOnElement(addVoucherType);
        waitUntilElementToBeClickable(voucherName);
        enterText(voucherName, "New Year Special");
        enterText(voucherValue, "50");
        enterText(retailPrice, "50");
        chooseItemFromDDWithSelect(validForDropDown, "1 year");
        clickOnElement(salesLimitSwitch);
        clickOnElement(serviceIncludedButton);
        waitUntilElementToBeClickable(unSelectService1);
        clickOnElement(unSelectService1);
        clickOnElement(unSelectService2);
        clickOnElement(selectServiceButton);
        pauseForAWhile(2000);
        clickOnElement(nextStep);
        waitUntilElementToBeClickable(voucherTitle);
        enterText(voucherTitle, "Gift Pack");
        enterText(voucherDescription, "Special Gift Voucher" );
        clickOnElement(voucherColor);
        clickOnElement(bookNowButton);
        clickOnElement(enableNotesCheckbox);
        enterText(notes, "Gift Pack" );
        clickOnElement(saveButton);
        pauseForAWhile(2000);
        waitForVisibilityOfElement("#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody");
        int endCount = countChildElements(countVouchers);
        System.out.println(endCount);
        return (startCount+1 == endCount);
    }
}

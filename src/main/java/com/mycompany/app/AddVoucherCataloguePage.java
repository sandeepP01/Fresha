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

    @FindBy (css = "div:nth-child(2) > table > tbody")
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

    @FindBy (css = "div:nth-child(2) > button")
    protected WebElement unSelectService1;

    @FindBy (css = "div:nth-child(4) > button")
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

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public AddVoucherCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String addVoucher() {
        waitForVisibilityOfElement("a[data-tip='Catalogue']");
        clickOnElement(catalogueTab);
        waitUntilElementToBeClickable(vouchersTab);
        clickOnElement(vouchersTab);
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
        waitUntilElementToBeClickable(nextStep);
        clickOnElement(nextStep);
        waitUntilElementToBeClickable(voucherTitle);
        enterText(voucherTitle, "Gift Pack");
        enterText(voucherDescription, "Special Gift Voucher" );
        clickOnElement(voucherColor);
        clickOnElement(bookNowButton);
        clickOnElement(enableNotesCheckbox);
        enterText(notes, "Gift Pack" );
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

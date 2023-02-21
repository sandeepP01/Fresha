package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteVoucherCataloguePage extends  PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy (css = "[data-qa='navtabs-item-vouchers']")
    protected WebElement vouchersTab;

    @FindBy (css = "#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody")
    protected WebElement countVouchers;

    @FindBy (css = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > table > tbody > tr:nth-child(1)")
    protected WebElement selectVoucher;

    @FindBy (css = "button[data-qa='button-voucher-remove']")
    protected WebElement deleteVoucherButton;

    @FindBy (css = "button[data-qa='voucher-template-delete-confirm-button']")
    protected WebElement confirmDeleteButton;

    public DeleteVoucherCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean deleteVoucher () {
        clickOnElement(catalogueTab);
        clickOnElement(vouchersTab);
        waitForVisibilityOfElement("#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody");
        int startCount = countChildElements(countVouchers);
        System.out.println(startCount);
        scrollToElement(selectVoucher);
        clickOnElement(selectVoucher);
        clickOnElement(deleteVoucherButton);
        clickOnElement(confirmDeleteButton);
        pauseForAWhile(2000);
        waitForVisibilityOfElement("#react > div > div.h0dwgm > div.dijn9G._4kaAnr > div._3on5gM > div > div._06c6bcd31._7691f5d31 > div > div > div > div > div:nth-child(2) > table > tbody");
        int endCount = countChildElements(countVouchers);
        System.out.println(endCount);
        return (startCount-1 == endCount);
    }
}

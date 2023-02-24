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

    @FindBy (css = "div:nth-child(2) > table > tbody")
    protected WebElement countVouchers;

    @FindBy (css = "div:nth-child(2) > table > tbody > tr:nth-child(1)")
    protected WebElement selectVoucher;

    @FindBy (css = "button[data-qa='button-voucher-remove']")
    protected WebElement deleteVoucherButton;

    @FindBy (css = "button[data-qa='voucher-template-delete-confirm-button']")
    protected WebElement confirmDeleteButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public DeleteVoucherCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String deleteVoucher() {
        clickOnElement(catalogueTab);
        clickOnElement(vouchersTab);
        waitForVisibilityOfElement("div:nth-child(2) > table > tbody");
        int startCount = countChildElements(countVouchers);
        System.out.println(startCount);
        scrollToElement(selectVoucher);
        clickOnElement(selectVoucher);
        clickOnElement(deleteVoucherButton);
        clickOnElement(confirmDeleteButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

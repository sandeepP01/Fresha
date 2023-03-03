package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSupplierCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-suppliers']")
    protected WebElement supplierTab;

    @FindBy(css = "table > tbody > tr:nth-child(1)")
    protected WebElement selectSupplier;

    @FindBy(css = "button[data-qa='drawer-actions-dropdown']")
    protected WebElement actionsButton;

    @FindBy(css = "div[data-qa='delete-supplier']")
    protected WebElement deleteSupplier;

    @FindBy(css = "button[data-qa='save-button']")
    protected WebElement deleteButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public DeleteSupplierCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String deleteSupplier() {
        clickOnElement(catalogueTab);
        clickOnElement(supplierTab);
        waitForPageToLoad();
        clickOnElement(selectSupplier);
        clickOnElement(actionsButton);
        clickOnElement(deleteSupplier);
        clickOnElement(deleteButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

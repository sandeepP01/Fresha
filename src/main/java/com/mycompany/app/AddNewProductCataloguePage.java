package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProductCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-products']")
    protected WebElement productsTab;

    @FindBy(css = "button[data-qa='add-new-product'] > div:nth-child(2)")
    protected WebElement addNewProduct;

    @FindBy(name = "name")
    protected WebElement productName;

    @FindBy(css = "div[data-qa='select-brand'] > a")
    protected WebElement productBrand;

    @FindBy(css = "div > div:nth-child(4) > p:first-child")
    protected WebElement selectBrand;

    @FindBy(name = "measureType")
    protected WebElement measure;

    @FindBy(name = "measureValue")
    protected WebElement amount;

    @FindBy(name = "shortDescription")
    protected WebElement shortDescription;

    @FindBy(name = "costPrice")
    protected WebElement supplyPrice;

    @FindBy(name = "fullPrice")
    protected WebElement retailPrice;

    @FindBy(name = "stock[0].productQuantity")
    protected WebElement currentStockQuantity;

    @FindBy(css = "button[data-qa='save-button']")
    protected WebElement saveButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public AddNewProductCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String addNewProduct() {
        clickOnElement(catalogueTab);
        clickOnElement(productsTab);
        clickOnElement(addNewProduct);
        enterText(productName, "Hair Shampoo");
        clickOnElement(productBrand);
        clickOnElement(selectBrand);
        chooseItemFromDDWithSelect(measure, "Pounds (lb)");
        enterText(amount, "2");
        enterText(shortDescription, "Hair care product");
        enterText(supplyPrice, "10.00");
        enterText(retailPrice, "15.00");
        enterText(currentStockQuantity, "145");
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

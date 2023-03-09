package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewStockOrderCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-stock-orders']")
    protected WebElement stockOrders;

    @FindBy(css = "button[data-qa='empty-state-button'] > div:nth-child(2) > p")
    protected WebElement addNewButton;

    @FindBy(css = "form > div > div > div > div > div > div > div > div > div > div > div > div")
    protected WebElement selectSupplier;

    @FindBy(css = "button[data-qa='empty-state-button'] > div:nth-child(2) > p")
    protected WebElement addProductsButton;

    @FindBy(css = "td:nth-child(2) > div > div")
    protected WebElement selectProduct;

    @FindBy(css = "button[data-qa='add-products-button']")
    protected WebElement addProduct;

    @FindBy(css = "div > div > div > div > div > input")
    protected WebElement orderQty;

    @FindBy(css = "button[data-qa='wizard-main-action']")
    protected WebElement createOrderButton;

    @FindBy(css = "p[data-qa='content-title']")
    protected WebElement confirmationMessage;

    public NewStockOrderCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String NewStockOrder() {
        clickOnElement(catalogueTab);
        clickOnElement(stockOrders);
        clickOnElement(addNewButton);
        clickOnElement(selectSupplier);
        clickOnElement(addProductsButton);
        waitForVisibilityOfElement("td:nth-child(2) > div > div");
        clickOnElement(selectProduct);
        clickOnElement(addProduct);
        waitUntilElementToBeClickable(orderQty);
        enterText(orderQty, "3");
        clickOnElement(createOrderButton);
        waitForVisibilityOfElement("p[data-qa='content-title']");
        return confirmationMessage.getText();
    }
}

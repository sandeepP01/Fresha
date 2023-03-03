package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewSupplierCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "a[data-qa='navtabs-item-suppliers']")
    protected WebElement supplierTab;

    @FindBy(css = "button[data-qa='add-new-supplier']")
    protected WebElement addNew;

    @FindBy(name = "name")
    protected WebElement supplierName;

    @FindBy(name = "description")
    protected WebElement supplierDescription;

    @FindBy(name = "firstName")
    protected WebElement firstName;

    @FindBy(name = "lastName")
    protected WebElement lastName;

    @FindBy(name = "mobileNumber")
    protected WebElement mobileNumber;

    @FindBy(name = "telephoneNumber")
    protected WebElement telephoneNumber;

    @FindBy(name = "email")
    protected WebElement email;

    @FindBy(css = "button[data-qa='save-button']")
    protected WebElement saveButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastMessage;

    public AddNewSupplierCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String addNewSupplier() {
        clickOnElement(catalogueTab);
        clickOnElement(supplierTab);
        clickOnElement(addNew);
        enterText(supplierName, "Dove");
        enterText(supplierDescription, "best Products");
        enterText(firstName, "Michael");
        enterText(lastName, "steve");
        enterText(mobileNumber, "4387255147");
        enterText(telephoneNumber, "4752541");
        enterText(email, "sean.testlio@gmail.com");
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastMessage.getText();
    }
}

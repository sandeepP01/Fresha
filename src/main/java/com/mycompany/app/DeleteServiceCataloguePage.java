package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteServiceCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy (css = "#react > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(1) > div > div")
    protected WebElement selectService;

    @FindBy (css = "button[data-qa='delete-service-button']")
    protected WebElement deleteButton;

    @FindBy (css = "button[data-qa='delete-service-confirm-button']")
    protected WebElement confirmDelete;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public DeleteServiceCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String deleteService () {
        clickOnElement(catalogueTab);
        clickOnElement(selectService);
        clickOnElement(deleteButton);
        clickOnElement(confirmDelete);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

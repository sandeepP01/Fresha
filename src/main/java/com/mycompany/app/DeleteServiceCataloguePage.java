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

    @FindBy (css = "div:nth-child(3) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div")
    protected WebElement countServices;

    public DeleteServiceCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean deleteService () {
        clickOnElement(catalogueTab);
        waitForVisibilityOfElement("div:nth-child(3) > div > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div");
        int countStart = countChildElements(countServices);
        System.out.println(countStart);
        clickOnElement(selectService);
        clickOnElement(deleteButton);
        clickOnElement(confirmDelete);
        pauseForAWhile(2000);
        int countEnd = countChildElements(countServices);
        System.out.println(countEnd);
        return (countStart-1 == countEnd);
    }
}

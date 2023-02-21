package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewServiceCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy (css ="button[data-qa='floating-menu-button']")
    protected WebElement addNewButton;

    @FindBy (css = "div[data-qa='new-item']")
    protected WebElement addNewService;

    @FindBy (css ="a[data-qa='tile-button-single-service']")
    protected WebElement singleServiceButton;

    @FindBy (css = "input[data-qa='service-name-input']")
    protected WebElement serviceName;

    @FindBy (css = "input[data-qa='treatment-type']")
    protected WebElement treatmentTypeDropdown;

    @FindBy (css = "div:nth-child(3) > p > span")
    protected WebElement treatmentTypeName;

    @FindBy (css ="a[data-qa='open-offer-item-category-modal']")
    protected WebElement serviceCategoryEditButton;

    @FindBy (css = "div[data-qa='category:hair']")
    protected WebElement serviceCategoryOption;

    @FindBy (css ="textarea[name='description']")
    protected WebElement serviceDescription;

    @FindBy (css = "textarea[name='aftercare']")
    protected WebElement afterCareDescription;

    @FindBy (css = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div > form > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(3) > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > button > label")
    protected WebElement teamCheckBox;

    @FindBy (css = "input[name='servicePricingLevels[0].price']")
    protected WebElement price;

    @FindBy (css = "button[data-qa='save-service-button']")
    protected WebElement saveButton;

    @FindBy (css = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div > div > div > div > div.BpP7K7 > div > div > div > div:nth-child(2) > div > div > div")
    protected WebElement countServices;

    public AddNewServiceCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean addNewService () {
        clickOnElement(catalogueTab);
        waitForVisibilityOfElement("#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div > div > div > div > div.BpP7K7 > div > div > div > div:nth-child(2) > div > div > div");
        int countStart = countChildElements(countServices);
        System.out.println(countStart);
        clickOnElement(addNewButton);
        clickOnElement(addNewService);
        waitUntilElementToBeClickable(singleServiceButton);
        clickOnElement(singleServiceButton);
        waitUntilElementToBeClickable(serviceName);
        enterText(serviceName,"Women's Haircut");
        clickOnElement(treatmentTypeDropdown);
        pauseForAWhile(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(treatmentTypeName).click().perform();
        pauseForAWhile(2000);
        clickOnElement(serviceCategoryEditButton);
        clickOnElement(serviceCategoryOption);
        scrollDown(2);
        enterText(serviceDescription, "Skin-care");
        enterText(afterCareDescription, "Skin-care Treatment" );
        clickOnElement(teamCheckBox);
        waitUntilElementToBeClickable(price);
        enterText(price, "30");
        clickOnElement(saveButton);
        pauseForAWhile(2000);
        waitForVisibilityOfElement("#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(3) > div > div > div > div > div.BpP7K7 > div > div > div > div:nth-child(2) > div > div > div");
        int countEnd = countChildElements(countServices);
        System.out.println(countEnd);
        return (countStart+1 == countEnd);
    }
}

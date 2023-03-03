package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditServiceCataloguePage extends PageBasics {

    @FindBy(css = "a[data-tip='Catalogue']")
    protected WebElement catalogueTab;

    @FindBy(css = "#react > div > div > div > div > div > div > div > div > div > div > div > div > div > div > div > " +
            "div > div > div > div:nth-child(1) > div > div > div > div > div > div > div > p")
    protected WebElement selectService;

    @FindBy(name = "name")
    protected WebElement serviceName;

    @FindBy(css = "input[data-qa='treatment-type']")
    protected WebElement treatmentTypeDropdown;

    @FindBy(css = "div:nth-child(5) > p > span")
    protected WebElement treatmentTypeName;

    @FindBy(name = "description")
    protected WebElement serviceDescription;

    @FindBy(css = "button[data-qa='save-service-button']")
    protected WebElement saveButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public EditServiceCataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String editService() {
        clickOnElement(catalogueTab);
        clickOnElement(selectService);
        enterText(serviceName, "My Service");
        clickOnElement(treatmentTypeDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(treatmentTypeName).click().perform();
        enterText(serviceDescription, "Hair-Treatment");
        waitUntilElementToBeClickable(saveButton);
        clickOnElement(saveButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteClientClientsPage extends PageBasics {

    @FindBy (css = "a[data-qa='nav-d-clients']")
    protected WebElement clientsIcon;

    @FindBy (css = "tr:nth-child(1) > td:nth-child(1) > label > div")
    protected WebElement selectClient;

    @FindBy (css = "div:nth-child(2) > div > button > div > p")
    protected WebElement deleteClient;

    @FindBy (name = "confirmDelete")
    protected WebElement confirmDelete;

    @FindBy (css = "button[data-qa='confirm-bulk-delete']")
    protected WebElement deleteButton;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public DeleteClientClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String deleteClient () {
        clickOnElement(clientsIcon);
        waitForVisibilityOfElement("tr:nth-child(1) > td:nth-child(1) > label > div");
        waitUntilElementToBeClickable(selectClient);
        selectClient.click();
        deleteClient.click();
        List<WebElement> elements = driver.findElements(By.name("confirmDelete"));
        if (elements.size() > 0) {
            confirmDelete.sendKeys("DELETE");
        }
        clickOnElement(deleteButton);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

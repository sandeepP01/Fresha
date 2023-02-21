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

    @FindBy(css =  "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:first-child > div > div > div > div > div > div > div > div > p" )
    protected WebElement clientList;

    protected String countClients = "#react > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:first-child > div > div > div > div > div > div > div > div > p";

    @FindBy (css = "td:nth-child(1) > label")
    protected WebElement selectClient;

    @FindBy (css = "div:nth-child(2) > div > button > div > p")
    protected WebElement deleteClient;

    @FindBy (name = "confirmDelete")
    protected WebElement confirmDelete;

    @FindBy (css = "button[data-qa='confirm-bulk-delete']")
    protected WebElement deleteButton;

    public DeleteClientClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean deleteClient () {
        clickOnElement(clientsIcon);
        waitForVisibilityOfElement(countClients);
        int clientNum = Integer.parseInt(clientList.getText());
        System.out.println(clientNum);
        selectClient.click();
        deleteClient.click();
        List<WebElement> elements = driver.findElements(By.name("confirmDelete"));
        if (elements.size() > 0) {
            confirmDelete.sendKeys("DELETE");
        }
            clickOnElement(deleteButton);
            pauseForAWhile(2000);
            waitForVisibilityOfElement(countClients);
            int clientNumEnd = Integer.parseInt(clientList.getText());
            System.out.println(clientNumEnd);
            return (clientNum != clientNumEnd);
    }
}

package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClientClientsPage extends PageBasics {

    @FindBy (css = "a[data-qa='nav-d-clients']")
    protected WebElement clientsIcon;

    @FindBy (css = "button[data-qa='add-new-client']" )
    protected WebElement addClient;

    @FindBy (name = "firstName")
    protected WebElement firstName;

    @FindBy (name = "lastName")
    protected WebElement lastName;

    @FindBy (css = "Input[name='contactNumber']")
    protected WebElement contactNumber;

    @FindBy(name = "email")
    protected WebElement email;

    @FindBy(css = "select[name='gender']")
    protected WebElement genderDropdown;

    @FindBy (css = "div[data-qa='birthday']")
    protected WebElement dateOfBirth;

    @FindBy (css = "div:nth-child(3) > div:nth-child(6)")
    protected WebElement selectDate;

    @FindBy(name = "birthdayYear")
    protected WebElement year;

    @FindBy(name = "note")
    protected WebElement cleintInfo;

    @FindBy(css = "button[data-qa='save-button']")
    protected WebElement button;

    @FindBy(css = "#react > div > div:first-child > div > div > div:nth-child(2)")
    protected WebElement toastNotification;

    public AddClientClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String addClient() {
        clickOnElement(clientsIcon);
        waitUntilElementToBeClickable(addClient);
        clickOnElement(addClient);
        waitUntilElementToBeClickable(firstName);
        enterText(firstName, "David");
        enterText(lastName, "Miller");
        enterText(contactNumber, " 438 523 7715 ");
        enterText(email, "Sean.Testlio@gmail.com");
        chooseItemFromDDWithSelect(genderDropdown, "Male");
        clickOnElement(dateOfBirth);
        pauseForAWhile(2000);
        waitForVisibilityOfElement("div:nth-child(3) > div:nth-child(6)");
        selectDate.click();
        enterText(year, "2001");
        enterText(cleintInfo, "Allergy to conditioner");
        clickOnElement(button);
        waitForVisibilityOfElement("#react > div > div:first-child > div > div > div:nth-child(2)");
        return toastNotification.getText();
    }
}

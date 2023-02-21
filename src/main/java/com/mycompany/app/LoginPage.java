package com.mycompany.app;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBasics {

    @FindBy(css = "input[name='email']")
    protected WebElement userName;

    @FindBy(css = "#react > div > div:nth-child(2) > div > div:nth-child(2) > div > div > form > div > button")
    protected WebElement continueButton;

    @FindBy(css = "input[name='password']")
    protected WebElement userPassword;

    @FindBy(css = "button[data-qa='login']")
    protected WebElement loginButton;

    @FindBy(css = "button[data-qa='cookie-accept-btn']")
    protected WebElement acceptCookies;

    @FindBy(css = ("a[data-tip='Home']"))
    protected WebElement homeIcon;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void tryToLogin(String email, String password) {
        waitUntilElementToBeClickable(userName);
        enterText(userName, email);
        clickOnElement(continueButton);
        pauseForAWhile(2000);
        enterText(userPassword, password);
        clickOnElement(loginButton);
        waitUntilElementToBeClickable(acceptCookies);
        clickOnElement(acceptCookies);
        isLoginSuccessful();
    }

    public void isLoginSuccessful() {
        try {
            waitForVisibilityOfElement("a[data-tip='Home']");
            if (homeIcon.isDisplayed()) {
                System.out.println("Login is successful");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Login is failed " +e.getMessage() );
        }
    }
}
package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAppointmentCustomerAcc extends PageBasics {
    @FindBy (css ="#view-container-inner > div > div:nth-child(6) >  div > div > div > div > div:nth-child(2) > div > div > div:first-child > div ")
    protected WebElement selectService;

    @FindBy (css = "a[data-qa='bottom-bar-button']")
    protected WebElement bookNowButton;

    @FindBy (css = "a:nth-child(2) > div:nth-child(2)")
    protected WebElement selectStaffOptions;

    @FindBy (css = "div:nth-child(3) > button")
    protected WebElement selectAppointmentDate;

    @FindBy (css = "div > li:nth-child(1) > div > p")
    protected WebElement appointmentTime;

    @FindBy (css ="textarea[name='notes']")
    protected WebElement notes;

    @FindBy(css ="[data-qa='bottom-bar-button']")
    protected WebElement confirmButton;

    @FindBy (css ="a[data-qa='login']")
    protected WebElement logInNowButton;

    @FindBy (css = "input[name='email']")
    protected WebElement emailInputField;

    @FindBy (css = "input[name='password']")
    protected WebElement passwordInputField;

    @FindBy (css = "button[data-qa='login-button']")
    protected WebElement loginButton;

    @FindBy (css ="a[data-action='sign in']")
    protected WebElement gmailSignIn;

    public AddAppointmentCustomerAcc(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addAppointmentByCustomer () {
        driver.get("https://www.fresha.com/a/salon-montreal-montreal-botanical-garden-sherbrooke-street-east-montreal-4101-rue-sherbrooke-est-oc2k8lk3/booking");
        pauseForAWhile(2000);
        clickOnElement(selectService);
        pauseForAWhile(2000);
        waitUntilElementToBeClickable(bookNowButton);
        clickOnElement(bookNowButton);
        pauseForAWhile(2000);
        clickOnElement(selectStaffOptions);
        waitUntilElementToBeClickable(selectAppointmentDate);
        clickOnElement(selectAppointmentDate);
        clickOnElement(appointmentTime);
        clickOnElement(logInNowButton);
        emailInputField.sendKeys("Sean.Testlio@gmail.com");
        passwordInputField.sendKeys("123123Aa@");
        clickOnElement(loginButton);
        waitUntilElementToBeClickable(notes);
        notes.sendKeys("Thank you");
        clickOnElement(confirmButton);
    }

    public void openGmail() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.gmail.com");
        clickOnElement(gmailSignIn);
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sean.testlio@gmail.com");
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
        WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
        passwordButton.sendKeys("Montreal@143");
        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
    }
}

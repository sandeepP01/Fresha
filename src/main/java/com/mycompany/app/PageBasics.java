package com.mycompany.app;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class PageBasics {

    protected WebDriver driver;

    protected JavascriptExecutor jse;

    protected WebElement webElement;

    protected Actions actions;

    protected String pageTitle;

    protected Select select;

    protected WebDriverWait webDriverWait;

    public PageBasics (WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getWebElementCssSelector (String selector) {
        webElement = driver.findElement(By.cssSelector(selector));
        return webElement;
    }

    public WebElement getWebElementXPath (String selector) {
        webElement = driver.findElement(By.xpath(selector));
        return webElement;
    }

    public String getPageTitle (WebDriver driver) {
        pageTitle = driver.getTitle();
        return pageTitle;
    }
    public void clickOnElement (WebElement webElement) {
        waitUntilElementToBeClickable(webElement);
        webElement.click();
    }

    public void clickOnElementWithAction (WebElement webElement) {
        actions.click(webElement).build().perform();
    }

    public void pauseForAWhile (long milliSeconds) {
        try
        {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDown(int numberOfTimes) {
        jse.executeScript("window.scrollBy(0,arguments[0]*350)", numberOfTimes);
    }

    public void scrollToElement (WebElement webElement) {
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollUp () {
        jse.executeScript("window.scrollBy(0, -200)");
    }

    public void waitUntilElementToBeClickable (WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForVisibilityOfElement (String cssPath) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssPath)));
    }

    public void enterText (WebElement webElement, String text) {
        waitUntilElementToBeClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void moveToElementActions (WebElement webElement) {
        actions.moveToElement(webElement);
        actions.perform();
        webElement.click();
    }

    public int countChildElements (WebElement webElement) {
        List<WebElement> childElements = webElement.findElements(By.xpath("*"));
        return childElements.size();
    }

    public boolean retryingFindClick(WebElement webElement) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                webElement.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public void chooseItemFromDDWithSelect (WebElement webElement, String textToSelect) {
        Select select = new Select(webElement);
        select.selectByVisibleText(textToSelect);
    }

    public void waitForPageToLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public void waitUntilPresenceOfElement(String webElement) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(webElement)));
    }
}

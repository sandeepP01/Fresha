package com.mycompany.app;

import dataprovider.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicTest extends ConfigReader {

    protected WebDriver driver;

    protected DesiredCapabilities caps;

    protected String sauceLab_username = "oauth-sandeepk.ralh-e9183";

    protected String sauceLab_access_key = "da3ac58f-f233-4ea7-b02a-dd9e6cc5e221";

    protected String sauceLabURL = "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";

    protected String lambdatest_username = "sandeepk.ralh";

    protected String lambdatest_access_key = "c2wZzpRaBJ2U7NhORYd0wPojNnrLx0vSrWKRBjUFUAtm351TLJ";

    protected String lambdaURL = "@hub.lambdatest.com/wd/hub";

    protected URL url;

    @BeforeMethod
    public void browserSetup () {
//        String platform = System.getProperty("platform");
//        String browser = System.getProperty("browser");
//        String operatingSystem = System.getProperty("os");
//        String version = System.getProperty("version");

        String platform = System.getenv("platform");
        String browser = System.getenv("browser");
        String operatingSystem = System.getenv("OS");
        String version = System.getenv("version");

        if (platform.equalsIgnoreCase("sauceLab")) {
            try {
                caps = new DesiredCapabilities();
                if (browser.equalsIgnoreCase("safari")) {
                    caps.setCapability("browserName", "safari");
                    caps.setCapability("version", version);
                } else {
                    caps.setCapability("browserName", browser);
                    caps.setCapability("version", version);
                }
                caps.setCapability("platform", operatingSystem);
                caps.setCapability("name", "<Fresha>");

                url = new URL("https://" + sauceLab_username + ":" + sauceLab_access_key +"" +
                        sauceLabURL);
                driver = new RemoteWebDriver(url, caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else if (platform.equalsIgnoreCase("LambdaTest")) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("version", "106");
                capabilities.setCapability("platform", "win10");
                capabilities.setCapability("build", "Fresha");
                capabilities.setCapability("name", "Fresha");
                driver = new RemoteWebDriver(new URL("https://" + lambdatest_username + ":" + lambdatest_access_key
                        + lambdaURL), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (platform.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            }
        }
        driver.get(getBaseUrl());
    }

   @BeforeMethod
   public void testLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.tryToLogin(getUserID(), getPassword());
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (org.openqa.selenium.WebDriverException e) {
            driver.quit();
        }
    }
}


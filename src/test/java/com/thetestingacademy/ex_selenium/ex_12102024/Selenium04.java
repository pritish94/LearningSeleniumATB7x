package com.thetestingacademy.ex_selenium.ex_12102024;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium04 {

    @Test
    public void testMethod(){

        //Import Concept of OOPs ->
        // Upcasting -> Dynamic Dispatch - Poly

        // In Selenium 3 -
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // In Selenium 4
        // Opera Remove - No usage of the setProperty

//        WebDriver driver = new EdgeDriver();
////        WebDriver driver2 = new ChromeDriver();
////        WebDriver driver3 = new FirefoxDriver();
////        WebDriver driver4 = new InternetExplorerDriver();
////        WebDriver driver5 = new SafariDriver();


        //        SearchContext(I) (2) -> WebDriver(I)( 10) -> RemoteWebDriver(C) (15) -> ChromiumDriver(C) 25 -> EdgeDriver(C) (45)
        //        SearchContext(I) -> WebDriver(I) -> RemoteWebDriver(C) -> ChromiumDriver(C) -> ChromeDriver(C)


        // SearchContext - Interface - findElement, and findElements - GGF
        // WebDriver - Interface - some incomplete functions - GF
        // RemoteWebDriver - Class- It also has some functions - F
        // ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S

        // Selenium - Arch - API
        // Create Session, Commands or Functions -> API Request to Browser Driver (
        // Pass the commands as API

        //SearchContext driver = new ChromeDriver();
        //WebDriver driver = new ChromeDriver();
        //RemoteWebDriver driver1 = new ChromeDriver();
        // driver1 = new EdgeDriver()


        //ChromeDriver  driver = new ChromeDriver();

        // Scenarios
        // 1. Do want to run on  Chrome or Edge?
        //ChromeDriver driver = new ChromeDriver(); ~1%

        // 2  Do you want to run on Chrome then change to Edge ?
        // WebDriver driver = new ChromeDriver();
        // driver = new EdgeDriver(); 97% -


        // 3. do you want to run on multiple browsers, aws machine, ? 2%
        // RemoteWebDriver driver (with GRID) - Advance (Last 2 Sessions)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-optimized");
        options.addArguments("--disable-notifications");

        String url = "https://localhost.4004";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url),capabilities);
            driver.get("https://www.google.com");
            System.out.println("title this page is " + driver.getTitle());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {
            if(driver != null){
                driver.quit();
            }
        }


    }
}

package com.thetestingacademy.ex_selenium.Project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium12 {
    // Open the app.vwo.com
    // We want to verify the title by using the TestNG assertion.

    @Test
    public void testVWOLoginPageTitle(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
//        driver.manage().window().maximize();
//        driver.manage().window().minimize();

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        Assert.assertTrue(driver.getPageSource().contains("Sign in using SSO"));
        driver.quit();





    }






}

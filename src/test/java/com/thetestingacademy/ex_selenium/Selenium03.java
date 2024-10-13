package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium03 {

    @Test
    public void test_001(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();






    }

}

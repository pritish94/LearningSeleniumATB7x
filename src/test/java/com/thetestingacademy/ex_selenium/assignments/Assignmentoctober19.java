package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignmentoctober19 {
    @Test
    public void test(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--set-maximized");
        firefoxOptions.addArguments("--incognito");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");

        driver.findElement(By.name("firstname")).sendKeys("Pritish");
        driver.findElement(By.name("lastname")).sendKeys("Bharat");
        driver.findElement(By.id("input-email")).sendKeys("pritishManiha1@email.com");
        driver.findElement(By.name("telephone")).sendKeys("1234567890");

        driver.findElement(By.id("input-password")).sendKeys("TestPass");
        driver.findElement(By.id("input-confirm")).sendKeys("TestPass");

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"));

        driver.quit();
    }
}

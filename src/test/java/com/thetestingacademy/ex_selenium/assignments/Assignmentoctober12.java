package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignmentoctober12 {
    private WebDriver driver;
    private String errorMsg = "";
    @Test
    public void test(){
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);
            driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

            driver.findElement(By.id("btn-make-appointment")).click();
            driver.findElement(By.id("txt-username")).sendKeys("British");
            driver.findElement(By.id("txt-password")).sendKeys("password");
            driver.findElement((By.id("btn-login"))).click();
            errorMsg = driver.findElement(By.xpath("//p[@class='lead text-danger']")).getText();

        }catch (Exception exception){
            exception.printStackTrace();

        }finally {
            if (driver != null){
                driver.quit();
               }
            Assert.assertTrue(errorMsg.startsWith("Login failed"));
        }


    }
}

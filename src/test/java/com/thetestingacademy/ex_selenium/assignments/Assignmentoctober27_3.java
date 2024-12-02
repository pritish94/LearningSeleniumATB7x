package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignmentoctober27_3 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void orangeHRM(){
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("Hacker@4321");
        driver.findElement(By.cssSelector("button[class$= 'login-button']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[1]//button[1]")).click();
    }

    @AfterTest
    public void afterTest(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        driver.quit();
    }

}

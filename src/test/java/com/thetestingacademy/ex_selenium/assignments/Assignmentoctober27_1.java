package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignmentoctober27_1 {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void flipcartSearchSVG(){
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.name("q")).sendKeys("macmini");
        List<WebElement> svgList = driver.findElements(By.xpath("//*[name() = 'svg']"));
        svgList.get(0).click();

        List<WebElement> macminis = driver.findElements(By.xpath("//div[starts-with(@data-id,'CPU')]//a[2]"));
        for(WebElement macmini: macminis){
            System.out.println(macmini.getText());
        }

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

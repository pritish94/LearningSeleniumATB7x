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

public class Assignmentoctober27_2 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void odishaSearchSVG(){
        driver.navigate().to("https://www.amcharts.com/svg-maps/");

        WebElement element = driver.findElement(By.xpath("//a [@title='India']"));

        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        je.executeScript("arguments[0].click();",element);

        driver.findElement(By.xpath("//input[starts-with(@value,'I agr')]")).click();

        List<WebElement> states = driver.findElements(By.xpath("//*[local-name() ='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g'][1]/*[name()='path']"));

        for(WebElement state: states){
            if(state.getDomAttribute("aria-label").contains("Odisha")){
                state.click();
            }
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

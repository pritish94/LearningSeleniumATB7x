package com.thetestingacademy.ex_selenium.assignments;

import io.qameta.allure.Description;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Assignmentoctober20_2 {

    @Description("Test for VWO login")
    @Test
    public void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.linkText("Start a free trial")).click();

        driver.findElement(By.id("page-v1-step1-email")).sendKeys(generateRandomEmail());
        driver.findElement(By.xpath("//form[@id='page-free-trial-signup-form-step1']/div[2]/input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button")).click();;
        driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']")).click();

        //Thread.sleep(5000);

        driver.findElement(By.id("page-v1-fname")).sendKeys("QA");
        driver.findElement(By.id("page-v1-lname")).sendKeys("UAT");
        driver.findElement(By.id("page-v1-pnumber")).sendKeys("8894345782");
        driver.findElement(By.id("page-v1-pwd")).sendKeys("Pritish95@");
        driver.findElement(By.xpath("//button[contains(@class,'button btn-modal-form-submit') and @data-qa='page-su-submit']")).click();

        driver.findElement(By.xpath("//span[text()='Next']")).click();

        driver.findElement(By.xpath("//li[@ng-repeat='product in onboardingAllProducts'][1]")).click();
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        WebElement connectButton = driver.findElement(By.xpath("//button[text()='Connect your website']"));
        connectButton.click();

        driver.findElement(By.xpath("//button[text()=' Cancel ']")).click();
        driver.findElement(By.xpath("//a[@class='navbar-group-btn']/span[text()='Dashboard']")).click();
        String actualName = driver.findElement(By.xpath("//p[@class='page-sub-title']/span[1]")).getText();

        Assert.assertEquals(actualName, "QA UAT");

        driver.quit();
    }

    @NotNull
    public static StringBuilder generateRandomEmail(){
        String characters = "abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVWEXYZ";
        Random random = new Random();
        StringBuilder email = new StringBuilder();
        for(int i=0; i<8; i++){
         email.append(characters.charAt(random.nextInt(characters.length())));
        }
        return email.append("@gmail.com");
    }
}

package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class InfosysLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--set-maximize");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }


    private void performLogin(String userName, String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[starts-with(@id,'passw')]")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
    }


    @Test
    public void PosLoginTest(){
        //Login with valid credential
        performLogin("student","Password123");

        //validations
        Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));
        Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(normalize-space(),'Congratulations student. You successfully logged in!')]")).getText().contains("Congratulations"));
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).isDisplayed());
    }


    @Test
    public void NegUserNameTest() throws InterruptedException {
        //Login with invalid userName
        performLogin("incorrect userName","Password123");

        //wait
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error' and text()='Your username is invalid!']")));

        //validation
        Assert.assertEquals(errorElement.getText(),"Your username is invalid!");
    }


    @Test
    public void NegPasswordTest() throws InterruptedException {
        //Login with invalid password
        performLogin("student","incorrect password");

        //wait
        WebElement errorElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='login']/descendant :: div[@id='error']")));

        //validation
        Assert.assertTrue(errorElement.getText().contains("Your password is invalid!"));
    }


    @AfterTest
    public void afterTest() {
        if(driver != null) {
            driver.quit();
        }
    }
}

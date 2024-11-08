package com.thetestingacademy.ex_selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignmentoctober20_1 {

    @Test
    public void test() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        List<WebElement> itemList = driver.findElements(By.xpath("//li[contains(@id,'item')]"));

        printTitleAndPrice(itemList);
        printMinPrice(itemList);

        driver.quit();
    }

    private static void printTitleAndPrice(List<WebElement> itemList) {

        // Loop through each item in the itemList
        for (WebElement item : itemList) {
            // Retrieve the title of the item
            String title = item.findElement(By.cssSelector(".s-item__title")).getText();

            // Retrieve the price of the item
            String price = item.findElement(By.cssSelector(".s-item__price")).getText();

            // Print the title and price
            System.out.printf("%s: %s%n", title, price);
        }
    }

    private static void printMinPrice(List<WebElement> itemList) {
        ArrayList<BigDecimal> priceList = new ArrayList<>();

        // Loop through each item in the itemList
        for (WebElement item : itemList) {
            // Retrieve the price of the item
            String price = item.findElement(By.cssSelector(".s-item__price")).getText();

            // Check if the price contains a comma and any currency symbol then remove it
            price = price.replaceAll("[$,]","");

            // Check if the price contains "to" and add the first part to the price list otherwise add the price as it is
            if (price.contains("to")) {
                priceList.add(new BigDecimal(price.split("to")[0].trim()));
            }else if (!price.isEmpty()) {
                priceList.add(new BigDecimal(price));
            }
        }
        //printing minimum price from priceList
        if (!priceList.isEmpty()) {
            // Find and print the minimum price from priceList
            BigDecimal minPrice = Collections.min(priceList);
            System.out.printf("Minimum Price: %s%n", minPrice);
        } else {
            System.out.println("Price list is empty.");
        }
    }
}

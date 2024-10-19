package com.thetestingacademy.ex_selenium.ex_19102024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium15 {

    @Test
    public void vwoLogin() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();




    }

}

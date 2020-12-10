package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitLib {

    WebDriverWait wait;

    public void implicitWait(WebDriver driver, int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); // in seconds

    }

    public void explicitWait(WebDriver driver, int time, By ele)
    {
        wait  = new WebDriverWait(driver,time); // in seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

    }

    public void sleepThread(int milliSec) throws InterruptedException {
        Thread.sleep(milliSec); // in milliseconds
    }
}

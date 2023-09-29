package com.educative.test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCheckBox  {

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

    @Test
    public void testCheckBox() {

        // Create a WebDriver object
        WebDriver driver = getWebDriver();

        // open the web url
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // Create a Javascript executor object.
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

        // Scroll down to the element
        jsDriver.executeScript("document.getElementById('checked').scrollIntoViewIfNeeded()");

        // find the check-box element
        WebElement checked = driver.findElement(By.id("checked"));

        // Assert that if it's already selected
        Assert.assertFalse(checked.isSelected());

        // find the element to avoid any Stale element exception before performing
        // any new operation
        checked = driver.findElement(By.id("checked"));
        checked.click();

        // find the element to avoid any Stale element exception before performing
        // any new operation
        checked = driver.findElement(By.id("checked"));

        // Assert the selection
        Assert.assertTrue(checked.isSelected());

        driver.close();
    }

}

package com.educative.test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestDropDown {

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

    @Test
    public void testDropDownDeSelect() {

        // Create a WebDriver object
        WebDriver driver = getWebDriver();

        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // Create a Javascript executor object.
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

        // Scroll down to the element
        jsDriver.executeScript("document.getElementById('my-select').scrollIntoViewIfNeeded()");

        // Identify the drop down - select element
        Select select = new Select(driver.findElement(By.id("my-select")));

        // select by value.
        String value = "Orange";
        select.selectByValue(value);
        select.deselectByValue(value);

        // Click on the print selected option button
        WebElement button = driver.findElement(By.id("select-button"));
        button.click();

        // Verify the printed option == empty
        WebElement result = driver.findElement(By.id("demo1"));
        Assert.assertTrue(result.getText().trim().isEmpty());

        // Select by Index
        select.selectByIndex(2);
        select.deselectByIndex(2);

        // Select by Visible text
        select.selectByVisibleText("Banana");
        select.deselectByVisibleText("Banana");

        driver.close();
    }

}

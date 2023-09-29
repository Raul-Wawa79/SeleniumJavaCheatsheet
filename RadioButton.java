package com.educative.test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRadioButton {

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

    @Test
    public void testRadioButton() {

        // Create a webdriver object
        WebDriver driver = getWebDriver();

        // Open the web URL
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        String value = "Cricket";

        // Find the radioButton WebElement with value Cricket.
        WebElement source = driver
                .findElement(By.xpath(String.format("//input[@name = 'sports' and @value = '%s']", value)));
        // Click on the element to select that radio button option
        source.click();

        // Find the submit button
        WebElement button = driver.findElement(By.id("radio-button-submit"));
        // Click the submit button
        button.click();

        // Find the displayed results text WebElement
        WebElement result = driver.findElement(By.id("result"));

        // Assert selected radio button and displayed are the same.
        Assert.assertEquals(result.getText().trim(), String.format("Sports: %s", value));

        driver.close();
    }
}
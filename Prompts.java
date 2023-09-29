package com.educative.test.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestPrompt  {

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

    @Test
    public void testPrompt() {

        // create a WebDriver object
        WebDriver driver = getWebDriver();

        // open the web URL
        driver.get("http://codetoautomate.com/educative-selenium-demo/");

        // Click the element to activate the prompt popup
        driver.findElement(By.id("prompt")).click();

        // Wait for the alert to be displayed and switch to the alert popup
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Enter your message/text
        alert.sendKeys("Educative");

        // Press the OK button
        alert.accept();

        driver.close();

    }

}
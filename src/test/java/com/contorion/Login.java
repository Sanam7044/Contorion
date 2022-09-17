package com.contorion;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class Login {
    static ConfigFileReader configFileReader;
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        configFileReader = new ConfigFileReader();
        System.setProperty(configFileReader.getWebDriverName(),
                new File(configFileReader.getFileURI(configFileReader.getWebDriverLocation())).getAbsolutePath());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void login() {
        driver.manage().window().maximize();
        // Navigate to contorion website
        driver.navigate().to(configFileReader.getApplicationUrl());
        // Accept privacy settings
        driver.findElement(By.id(ElementLocator.Login.PRIVACY_BUTTON)).click();

        WebElement element = driver.findElement(By.linkText(ElementLocator.Login.REGISTER_BUTTON));

        // Creating object of an Actions class
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        // Input username and password and Click on the login button
        driver.findElement(By.id("login_email")).sendKeys(configFileReader.getEmail());
        driver.findElement(By.id("login_password")).sendKeys(configFileReader.getPassword());
        driver.findElement(By.cssSelector(ElementLocator.Login.LOGIN_BUTTON)).click();

        WebElement welcomeText = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ElementLocator.MainPage.WELCOME_TEXT)));
        // Assertion to check welcome message
        Assert.assertEquals(configFileReader.getWelcomeText(), welcomeText.getText());
        System.out
                .println("Expected text: " + configFileReader.getWelcomeText() + " Actual text: " + welcomeText.getText());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

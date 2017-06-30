package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class CalculatorTest {

    //Member Variables
    WebElement element;
    WebDriver driver;

    //Member Functions
    @Before
    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        driver.get("http://www.calculator.net/math-calculator.html");

    }

    @After
    public void tearDown() throws Exception {
        //new WebDriverWait(driver,10);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testShouldCheckCalculatedPercentageIsCorrect() throws Exception {

        element = driver.findElement(By.xpath(".//*[@id='content']/ul[1]/li[3]/a"));
        element.click();
        element = driver.findElement(By.name("cpar1"));
        element.sendKeys("10");
        element = driver.findElement(By.name("cpar2"));
        element.sendKeys("200");
        element = driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
        element.click();
        String actual = driver.findElement(By.xpath(".//*[@id='content']/h2[1]")).getText();
        String expected = "Result: 20";
        Assert.assertEquals(actual, expected);
    }

}
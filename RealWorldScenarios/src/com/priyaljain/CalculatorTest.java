package com.priyaljain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    @Test
    public void testShouldCheckAdditionOfTwoNumbers() throws Exception {
        element = driver.findElement(By.xpath(".//*[@id='content']/ul[1]/li[2]/a"));
        element.click();
        element = driver.findElement(By.name("t1"));
        element.sendKeys("1");
        element = driver.findElement(By.name("b1"));
        element.sendKeys("3");
        element = driver.findElement(By.name("t2"));
        element.sendKeys("4");
        element = driver.findElement(By.name("b2"));
        element.sendKeys("3");
        element = driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[4]/td/input[2]"));
        element.click();
        String actual1 = driver.findElement(By.xpath(".//*[@id='content']/table[6]/tbody/tr[1]/td[5]")).getText();
        String actual2 = driver.findElement(By.xpath(".//*[@id='content']/table[6]/tbody/tr[3]/td[3]")).getText();
        String expected1="5";
        String expected2="3";
        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);
    }

}
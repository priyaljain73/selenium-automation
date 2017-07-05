package com.priyaljain;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class AmazonTest {

    //Member Variables
    WebElement element;
    WebDriver driver;

    //Member Functions

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testShouldLoginAndOpenCart() throws Exception {

        driver=new FirefoxDriver();
        driver.get("http://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("nav-link-yourAccount")).click();
        driver.findElement(By.name("email")).sendKeys("Username");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("nav-cart")).click();

    }

    @Test
    public void testShouldAddItemToCart() throws Exception {

        driver=new HtmlUnitDriver();
        driver.get("http://www.amazon.in/");
        driver.findElement(By.id("nav-link-yourAccount")).click();
        driver.findElement(By.name("email")).sendKeys("Username");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("nav-link-shopall")).click();
        driver.findElement(By.xpath("//a[contains(text(),'All Mobile Phones')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Samsung')]")).click();
        driver.findElement(By.xpath(".//*[@id='result_6']/div/div[3]/div[1]/a/h2")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart")).click();
    }



    @Test
    public void testShouldRemoveItemFromCart() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Appium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("nav-link-yourAccount")).click();
        //driver.findElement(By.xpath("./[@id='nav-link-yourAccount']/span[1]")).click();
        driver.findElement(By.name("email")).sendKeys("Username");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("nav-cart")).click();
        String s=driver.findElement(By.id("nav-cart-count")).getText();
        List<WebElement> elements = driver.findElements(By.xpath("//input[@value='Delete']"));
        for (int i=0; i < elements.size(); i++){
            elements.get(i).click();
            Thread.sleep(5000);
        }
    }


}


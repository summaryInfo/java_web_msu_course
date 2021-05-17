package org.jbes.storage.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductPageTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    //driver.get("http://127.0.0.1:8080/app/productcat");
    driver.get("http://192.168.1.39:8080/app/product");
    driver.manage().window().maximize();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void doTest() {
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Potatoes");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "Killogram");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(1)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(2)")).getText(), "Lemon juice (1 liter)");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(4)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(5)")).getText(), "Item");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(1)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(2)")).getText(), "Soap");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(4)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(5)")).getText(), "Item");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(1)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(2)")).getText(), "T-Short");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(4)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(5)")).getText(), "Item");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(1)")).getText(), "105");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(2)")).getText(), "Electric teapot");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(4)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(5)")).getText(), "Item");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-106+label span:nth-child(1)")).getText(), "106");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-106+label span:nth-child(2)")).getText(), "Refrigerator");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-106+label span:nth-child(4)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-106+label span:nth-child(5)")).getText(), "Box");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-106+label span:nth-child(6)")).getText(), "true");

    driver.findElement(By.id("query_id")).sendKeys("101");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Potatoes");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "Killogram");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("Po%");
    driver.findElement(By.id("query_category")).clear();
    driver.findElement(By.id("query_category")).sendKeys("101");
    driver.findElement(By.id("query_unit")).clear();
    driver.findElement(By.id("query_unit")).sendKeys("%m");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Potatoes");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "Killogram");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "false");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("A");
    driver.findElement(By.id("query_description")).clear();
    driver.findElement(By.id("query_description")).sendKeys("B");
    driver.findElement(By.id("query_category")).clear();
    driver.findElement(By.id("query_category")).sendKeys("101");
    driver.findElement(By.id("query_unit")).clear();
    driver.findElement(By.id("query_unit")).sendKeys("C");
    (new Select(driver.findElement(By.id("query_oversized")))).selectByVisibleText("True");
    driver.findElement(By.id("query_create")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(2)")).getText(), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(3)")).getText(), "B");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(4)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(5)")).getText(), "C");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(6)")).getText(), "true");

    driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(1)")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")));

    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).getAttribute("value"), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).getAttribute("value"), "B");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(3) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(4) input")).getAttribute("value"), "C");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(5) input")).getAttribute("checked"), "true");

    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).sendKeys("c");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).sendKeys("c");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(3) input")).clear();
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(3) input")).sendKeys("102");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(4) input")).sendKeys("c");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(5) input")).click();
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(2)")).click();
    String newid = driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(1)")).getText();

    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(2)")).getText(), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(3)")).getText(), "Bc");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(4)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(5)")).getText(), "Cc");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(6)")).getText(), "false");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).getAttribute("value"), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).getAttribute("value"), "Bc");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(3) input")).getAttribute("value"), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(4) input")).getAttribute("value"), "Cc");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(5) input")).getAttribute("checked"), null);

    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 7);

    driver.findElement(By.cssSelector(".toggle-label:last-of-type")).click();
    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(3)")));
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(3)")).click();
    
    try {
        driver.findElement(By.id("collapsible-" + newid));
        Assert.fail("Did not delete");
    } catch (NoSuchElementException e) { }
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 6);
  }
}

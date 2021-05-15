package org.jbes.storage.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductCategoryPageTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    driver.get("http://127.0.0.1:8080/app/productcat");
    //driver.get("http://192.168.1.39:8080/app/productcat");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Food");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(1)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(2)")).getText(), "Household chemicals");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(3)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(1)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(2)")).getText(), "Clothes");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(3)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(1)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(2)")).getText(), "Consumer electronics");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(3)")).getText(), "");

    driver.findElement(By.id("query_id")).sendKeys("101");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Food");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_id")).sendKeys("");
    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("Fo%");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-of-type(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-of-type(2)")).getText(), "Food");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-of-type(3)")).getText(), "");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("A");
    driver.findElement(By.id("query_description")).clear();
    driver.findElement(By.id("query_description")).sendKeys("B");
    driver.findElement(By.id("query_create")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(2)")).getText(), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(3)")).getText(), "B");

    driver.findElement(By.cssSelector(".toggle-label:last-of-type")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")));

    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).getAttribute("value"), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).getAttribute("value"), "B");

    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).clear();
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).sendKeys("Ac");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).clear();
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).sendKeys("Bc");
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(2)")).click();
    String newid = driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(1)")).getText();

    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(2)")).getText(), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector(".toggle-label:last-of-type span:nth-of-type(3)")).getText(), "Bc");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(1) input")).getAttribute("value"), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form span:nth-of-type(2) input")).getAttribute("value"), "Bc");

    driver.findElement(By.cssSelector(".toggle-label:last-of-type")).click();
    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(3)")));
    driver.findElement(By.cssSelector(".collapsible-content:last-of-type div form input:nth-of-type(3)")).click();
    
    try {
        driver.findElement(By.id("collapsible-" + newid));
        Assert.fail("Did not delete");
    } catch (NoSuchElementException e) { }
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 4);
  }
}

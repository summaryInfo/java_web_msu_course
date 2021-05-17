package org.jbes.storage.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class ProductInstancePageTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    //driver.get("http://127.0.0.1:8080/app/instance");
    driver.get("http://192.168.1.39:8080/app/instance");
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
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(7)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(9)")).getText(), "102");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(1)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(7)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(9)")).getText(), "102");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(1)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(7)")).getText(), "2");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(9)")).getText(), "102");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(1)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(7)")).getText(), "2");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(9)")).getText(), "103");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(1)")).getText(), "105");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(3)")).getText(), "15.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(4)")).getText(), "2020-11-17 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(5)")).getText(), "2021-04-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(7)")).getText(), "3");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(8)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-105+label span:nth-child(9)")).getText(), "103");

    driver.findElement(By.id("query_id")).sendKeys("101");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(7)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(9)")).getText(), "102");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_product")).clear();
    driver.findElement(By.id("query_product")).sendKeys("101");
    driver.findElement(By.id("query_amount")).sendKeys("9");
    driver.findElement(By.id("query_amounthi")).sendKeys("11");
    driver.findElement(By.id("query_arrival")).sendKeys("2020-12-21 00:00:00");
    driver.findElement(By.id("query_arrivalhi")).sendKeys("2020-12-21 00:00:00");
    driver.findElement(By.id("query_expires")).sendKeys("2021-06-03 00:00:00");
    driver.findElement(By.id("query_expireshi")).sendKeys("2021-06-03 00:00:00");
    driver.findElement(By.id("query_room")).sendKeys("1");
    driver.findElement(By.id("query_shelf")).sendKeys("1");
    driver.findElement(By.id("query_source")).sendKeys("101");
    driver.findElement(By.id("query_destination")).sendKeys("102");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "10.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "2020-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2021-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(7)")).getText(), "1");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(9)")).getText(), "102");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_product")).clear();
    driver.findElement(By.id("query_product")).sendKeys("101");
    driver.findElement(By.id("query_amount")).clear();
    driver.findElement(By.id("query_amount")).sendKeys("123");
    driver.findElement(By.id("query_expires")).clear();
    driver.findElement(By.id("query_expires")).sendKeys("2022-06-03 00:00:00");
    driver.findElement(By.id("query_room")).clear();
    driver.findElement(By.id("query_room")).sendKeys("567");
    driver.findElement(By.id("query_shelf")).clear();
    driver.findElement(By.id("query_shelf")).sendKeys("890");
    driver.findElement(By.id("query_source")).clear();
    driver.findElement(By.id("query_source")).sendKeys("101");
    driver.findElement(By.id("query_destination")).clear();
    driver.findElement(By.id("query_destination")).sendKeys("101");
    driver.findElement(By.id("query_create")).click();

    List<WebElement> els = driver.findElements(By.cssSelector(".toggle-label span:nth-of-type(1)"));
    String newid = null;
    for (WebElement el : els) {
        Long l = Long.parseLong(el.getText());
        if (l < 100L) {
            newid = el.getText();
            break;
        }
    }
    Assert.assertNotNull(newid);

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(3)")).getText(), "123.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(5)")).getText(), "2022-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(6)")).getText(), "567");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(7)")).getText(), "890");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(8)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(9)")).getText(), "101");

    driver.findElement(By.cssSelector("#collapsible-" + newid + " + label")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")));

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(2) input")).getAttribute("value"), "123.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(4) input")).getAttribute("value"), "2022-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(5) input")).getAttribute("value"), "567");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(6) input")).getAttribute("value"), "890");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(7) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(8) input")).getAttribute("value"), "101");

    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")).sendKeys("102");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(2) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(2) input")).sendKeys("1234.0");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(3) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(3) input")).sendKeys("2025-12-21 00:00:00");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(4) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(4) input")).sendKeys("2025-06-03 00:00:00");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(5) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(5) input")).sendKeys("5670");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(6) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(6) input")).sendKeys("8900");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(7) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(7) input")).sendKeys("102");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(8) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(8) input")).sendKeys("102");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(2)")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(2)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(3)")).getText(), "1234.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(4)")).getText(), "2025-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(5)")).getText(), "2025-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(6)")).getText(), "5670");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(7)")).getText(), "8900");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(8)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-child(9)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")).getAttribute("value"), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(2) input")).getAttribute("value"), "1234.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(3) input")).getAttribute("value"), "2025-12-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(4) input")).getAttribute("value"), "2025-06-03 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(5) input")).getAttribute("value"), "5670");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(6) input")).getAttribute("value"), "8900");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(7) input")).getAttribute("value"), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(8) input")).getAttribute("value"), "102");

    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 20);

    driver.findElement(By.cssSelector("#collapsible-" + newid + " + label")).click();
    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")));
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")).click();
    
    try {
        driver.findElement(By.id("collapsible-" + newid));
        Assert.fail("Did not delete");
    } catch (NoSuchElementException e) { }
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 19);
  }
}

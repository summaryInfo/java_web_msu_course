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

public class OrderPageTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    //driver.get("http://127.0.0.1:8080/app/order");
    driver.get("http://192.168.1.39:8080/app/order");
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
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "30.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2020-01-20 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "true");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(1)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(4)")).getText(), "30.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(5)")).getText(), "2020-05-20 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(6)")).getText(), "false");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(1)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(4)")).getText(), "40.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(5)")).getText(), "2020-05-21 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(6)")).getText(), "false");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(1)")).getText(), "104");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(3)")).getText(), "106");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(4)")).getText(), "1.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(5)")).getText(), "2020-07-01 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-104+label span:nth-child(6)")).getText(), "false");

    driver.findElement(By.id("query_id")).sendKeys("101");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "30.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2020-01-20 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "true");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_consumer")).clear();
    driver.findElement(By.id("query_consumer")).sendKeys("101");
    driver.findElement(By.id("query_product")).clear();
    driver.findElement(By.id("query_product")).sendKeys("101");
    driver.findElement(By.id("query_amount")).clear();
    driver.findElement(By.id("query_amount")).sendKeys("29.0");
    driver.findElement(By.id("query_amounthi")).clear();
    driver.findElement(By.id("query_amounthi")).sendKeys("31.0");
    driver.findElement(By.id("query_time")).clear();
    driver.findElement(By.id("query_time")).sendKeys("2020-01-20 00:00:00");
    driver.findElement(By.id("query_timehi")).clear();
    driver.findElement(By.id("query_timehi")).sendKeys("2020-01-20 00:00:00");
    (new Select(driver.findElement(By.id("query_completed")))).selectByVisibleText("True");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "30.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "2020-01-20 00:00:00");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "true");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_consumer")).clear();
    driver.findElement(By.id("query_consumer")).sendKeys("101");
    driver.findElement(By.id("query_product")).clear();
    driver.findElement(By.id("query_product")).sendKeys("101");
    driver.findElement(By.id("query_amount")).clear();
    driver.findElement(By.id("query_amount")).sendKeys("101.0");
    driver.findElement(By.id("query_time")).clear();
    driver.findElement(By.id("query_time")).sendKeys("1010-10-10 10:10:10");
    (new Select(driver.findElement(By.id("query_completed")))).selectByVisibleText("True");
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

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(3)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(4)")).getText(), "101.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(5)")).getText(), "1010-10-10 10:10:10");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(6)")).getText(), "true");

    driver.findElement(By.cssSelector("#collapsible-" + newid +" + label")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")));

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).getAttribute("value"), "101.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).getAttribute("value"), "1010-10-10 10:10:10");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).getAttribute("checked"), "true");

    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).sendKeys("101");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).sendKeys("102");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).sendKeys("1010.0");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).sendKeys("2010-10-10 10:10:10");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).click();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form input:nth-of-type(2)")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(2)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(3)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(4)")).getText(), "1010.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(5)")).getText(), "2010-10-10 10:10:10");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(6)")).getText(), "false");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).getAttribute("value"), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).getAttribute("value"), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).getAttribute("value"), "1010.0");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).getAttribute("value"), "2010-10-10 10:10:10");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).getAttribute("checked"), null);

    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 5);

    driver.findElement(By.cssSelector("#collapsible-" + newid + " + label")).click();
    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")));
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")).click();

    try {
        driver.findElement(By.id("collapsible-" + newid));
        Assert.fail("Did not delete");
    } catch (NoSuchElementException e) { }
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 4);
  }
}

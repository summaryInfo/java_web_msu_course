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

public class ProviderPageTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new FirefoxDriver();
    //driver.get("http://127.0.0.1:8080/app/provider");
    driver.get("http://192.168.1.39:8080/app/provider");
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
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Food source");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "Test description for food provider");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "1(111)111-11-11");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "food@source.com");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(1)")).getText(), "102");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(2)")).getText(), "Chemicals source");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(3)")).getText(), "Test description for chemicals source");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(4)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(5)")).getText(), "2(222)222-22-22");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-102+label span:nth-child(6)")).getText(), "contact@chemicals123.com");

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(1)")).getText(), "103");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(2)")).getText(), "Electronics provider");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(3)")).getText(), "Test description for electronics provider");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(4)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(5)")).getText(), "3(333)333-33-33");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-103+label span:nth-child(6)")).getText(), "mail@allelectronics.net");

    driver.findElement(By.id("query_id")).sendKeys("101");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Food source");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "Test description for food provider");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "1(111)111-11-11");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "food@source.com");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_id")).clear();
    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("Foo%");
    driver.findElement(By.id("query_description")).clear();
    driver.findElement(By.id("query_description")).sendKeys("Test%");
    driver.findElement(By.id("query_phone")).clear();
    driver.findElement(By.id("query_phone")).sendKeys("1(111)111-11-11");
    driver.findElement(By.id("query_email")).clear();
    driver.findElement(By.id("query_email")).sendKeys("food@source.com");
    driver.findElement(By.id("query_query")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(1)")).getText(), "101");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(2)")).getText(), "Food source");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(3)")).getText(), "Test description for food provider");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(4)")).getText(), "");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(5)")).getText(), "1(111)111-11-11");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-101+label span:nth-child(6)")).getText(), "food@source.com");
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 1);

    driver.findElement(By.id("query_name")).clear();
    driver.findElement(By.id("query_name")).sendKeys("A");
    driver.findElement(By.id("query_description")).clear();
    driver.findElement(By.id("query_description")).sendKeys("B");
    driver.findElement(By.id("query_address")).clear();
    driver.findElement(By.id("query_address")).sendKeys("C");
    driver.findElement(By.id("query_phone")).clear();
    driver.findElement(By.id("query_phone")).sendKeys("D");
    driver.findElement(By.id("query_email")).clear();
    driver.findElement(By.id("query_email")).sendKeys("D@E");
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

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(2)")).getText(), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(3)")).getText(), "B");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(4)")).getText(), "C");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(5)")).getText(), "D");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid +" + label span:nth-of-type(6)")).getText(), "D@E");

    driver.findElement(By.cssSelector("#collapsible-" + newid +" + label")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form span:nth-of-type(1) input")));

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).getAttribute("value"), "A");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).getAttribute("value"), "B");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).getAttribute("value"), "C");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).getAttribute("value"), "D");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).getAttribute("value"), "D@E");


    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).sendKeys("Ac");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).sendKeys("Bc");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).sendKeys("Cc");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).sendKeys("Dc");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).clear();
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).sendKeys("D@Ec");
    driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form input:nth-of-type(2)")).click();

    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-of-type(2)")).getText(), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-of-type(3)")).getText(), "Bc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-of-type(4)")).getText(), "Cc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-of-type(5)")).getText(), "Dc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-" + newid + " + label span:nth-of-type(6)")).getText(), "D@Ec");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(1) input")).getAttribute("value"), "Ac");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(2) input")).getAttribute("value"), "Bc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(3) input")).getAttribute("value"), "Cc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(4) input")).getAttribute("value"), "Dc");
    Assert.assertEquals(driver.findElement(By.cssSelector("#collapsible-content-" + newid +" div form span:nth-of-type(5) input")).getAttribute("value"), "D@Ec");

    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 4);

    driver.findElement(By.cssSelector("#collapsible-" + newid + " + label")).click();
    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")));
    driver.findElement(By.cssSelector("#collapsible-content-" + newid + " div form input:nth-of-type(3)")).click();
    
    try {
        driver.findElement(By.id("collapsible-" + newid));
        Assert.fail("Did not delete");
    } catch (NoSuchElementException e) { }
    Assert.assertEquals(driver.findElements(By.cssSelector(".collapsible-content")).size(), 3);
  }
}

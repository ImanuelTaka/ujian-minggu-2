package com.juaracoding.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.swaglabs.utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

  @Test(priority = 1)
  @Parameters({"username", "password"})
  public void loginSuccessWithValidCredentialTest(String username, String password) throws InterruptedException {
    openBrowserAndNavigateTo("https://www.saucedemo.com/");

    Thread.sleep(1000);
    driver.findElement(By.id("user-name")).sendKeys(username);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();
    
    String[] path = driver.getCurrentUrl().split("/");
    String expected = "/inventory.html";
    String actual = "/" + path[path.length - 1];

    String pathScreenshot = ScreenshotUtil.takeScreenshot(driver, "loginSuccessWithValidCredentialTest_01");
    Reporter.log("<img style='width: 30%' src='" + pathScreenshot + "' />");
    Reporter.log("<br /> <strong>" + pathScreenshot + "</strong>");
    
    Assert.assertEquals(actual, expected);

    quitBrowser();
  }

  @Test(priority = 2)
  @Parameters({"invalidUsername", "password"})
  public void loginFailedWithInvalidUsernameTest(String invalidUsername, String password) throws InterruptedException {
    openBrowserAndNavigateTo("https://www.saucedemo.com/");

    Thread.sleep(1000);
    driver.findElement(By.id("user-name")).sendKeys(invalidUsername);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();

    WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
    String actual = errorMessageElement.getText();
    String expected = "Epic sadface: Username and password do not match any user in this service";

    String pathScreenshot = ScreenshotUtil.takeScreenshot(driver, "loginFailedWithInvalidPasswordTest_02");
    Reporter.log("<img style='width: 30%' src='" + pathScreenshot + "' />");
    Reporter.log("<br /> <strong>" + pathScreenshot + "</strong>");

    Assert.assertEquals(actual, expected);
    quitBrowser();
  }

  @Test(priority = 3)
  @Parameters({"username", "invalidPassword"})
  public void loginFailedWithInvalidPasswordTest(String username, String invalidPassword) throws InterruptedException {
    openBrowserAndNavigateTo("https://www.saucedemo.com/");

    Thread.sleep(1000);
    driver.findElement(By.id("user-name")).sendKeys(username);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(invalidPassword);
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();

    WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
    String actual = errorMessageElement.getText();
    String expected = "Epic sadface: Username and password do not match any user in this service";

    String pathScreenshot = ScreenshotUtil.takeScreenshot(driver, "loginFailedWithInvalidUsernameTest_03");
    Reporter.log("<img style='width: 30%' src='" + pathScreenshot + "' />");
    Reporter.log("<br /> <strong>" + pathScreenshot + "</strong>");

    Assert.assertEquals(actual, expected);
    quitBrowser();
  }

  @Test (priority = 4)
  @Parameters({"nullUsername", "nullPassword"})
  public void loginWithNullPasswordTest(String nullUsername, String nullPassword) throws InterruptedException{
  openBrowserAndNavigateTo("https://www.saucedemo.com/");

    Thread.sleep(1000);
    driver.findElement(By.id("user-name")).sendKeys(nullUsername);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(nullPassword);
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();

    WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
    String actual = errorMessageElement.getText();
    String expected = "Epic sadface: Username is required";

    String pathScreenshot = ScreenshotUtil.takeScreenshot(driver, "loginWithNullPasswordTest_04");
    Reporter.log("<img style='width: 30%' src='" + pathScreenshot + "' />");
    Reporter.log("<br /> <strong>" + pathScreenshot + "</strong>");

    Assert.assertEquals(actual, expected);
    quitBrowser();
  }

  @Test (priority = 5)
  @Parameters({"username", "nullPassword"})
  public void loginWithNullUsernameAndNullPasswordTest(String username, String nullPassword) throws InterruptedException{
  openBrowserAndNavigateTo("https://www.saucedemo.com/");

    Thread.sleep(1000);
    driver.findElement(By.id("user-name")).sendKeys(username);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(nullPassword);
    Thread.sleep(1000);
    driver.findElement(By.id("login-button")).click();

    WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
    String actual = errorMessageElement.getText();
    String expected = "Epic sadface: Password is required";

    String pathScreenshot = ScreenshotUtil.takeScreenshot(driver, "loginWithNullUsernameAndNullPasswordTest_05");
    Reporter.log("<img style='width: 30%' src='" + pathScreenshot + "' />");
    Reporter.log("<br /> <strong>" + pathScreenshot + "</strong>");

    Assert.assertEquals(actual, expected);
    quitBrowser();
  }

}

package com.juaracoding.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.swaglabs.pages.InventoryPage;
import com.juaracoding.swaglabs.pages.LoginPage;

public class LoginTest extends BaseTest {

  @Test(priority = 1)
  @Parameters({"username", "password"})
  public void loginSuccessWithValidCredentialTest(String username, String password) {

    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    loginPage.login(username, password);

    Assert.assertEquals(inventoryPage.getPathURL(), "/inventory.html");
  }

   @Test(priority = 2)
  @Parameters({"invalidUsername", "password"})
  public void loginFailedWithInvalidUsernameTest(String invalidUsername, String password) {
    

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(invalidUsername, password);
    String expected = "Epic sadface: Username and password do not match any user in this service";
    Assert.assertEquals(loginPage.getErrorMessage(), expected);

  }

  @Test(priority = 3)
  @Parameters({"username", "invalidPassword"})
  public void loginFailedWithInvalidPasswordTest(String username, String invalidPassword) {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, invalidPassword);
    String expected = "Epic sadface: Username and password do not match any user in this service";

    Assert.assertEquals(loginPage.getErrorMessage(), expected);
   
  }

  @Test (priority = 4)
  @Parameters({"nullUsername", "nullPassword"})
  public void loginWithNullPasswordTest(String nullUsername, String nullPassword) {
  
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(nullUsername, nullPassword);;

    String expected = "Epic sadface: Username is required";

    Assert.assertEquals(loginPage.getErrorMessage(), expected);
    
  }

  @Test (priority = 5)
  @Parameters({"username", "nullPassword"})
  public void loginWithNullUsernameAndNullPasswordTest(String username, String nullPassword) {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, nullPassword);;

    String expected = "Epic sadface: Password is required";

    Assert.assertEquals(loginPage.getErrorMessage(), expected);
  }

}

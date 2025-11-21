package com.juaracoding.swaglabs.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  
  private By username = By.id("user-name");
  private By password = By.id("password");
  private By loginButton = By.id("login-button");
  private By errorMessage = By.xpath("//h3[@data-test='error']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void inputUsername(String data) {
    waitingElementReady(username).sendKeys(data);
  }

  public void inputPassword(String data) {
    waitingElementReady(password).sendKeys(data);
  }

  public void clickButtonLogin() {
    waitingElementReady(loginButton).click();
  }

  public String getErrorMessage() {
    return waitingElementReady(errorMessage).getText();
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }

  public void login(String username, String password) {
    inputUsername(username);
    inputPassword(password);
    clickButtonLogin();
  }

}

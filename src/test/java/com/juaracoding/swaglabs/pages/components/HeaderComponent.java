package com.juaracoding.swaglabs.pages.components;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// WebElement chartIcon = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
public class HeaderComponent extends BaseComponent {

  private By buttonAddToCart;
  private By buttonRemoveCart;
  private By cartIcon = By.xpath("//span[@data-test='shopping-cart-badge']");

   public HeaderComponent(WebDriver driver) {
    super(driver);
  }

  public void setButtonAddToCart(String xpathExpression) {
    this.buttonAddToCart = By.xpath(xpathExpression);
  }

  public void setButtonRemoveCart(String xpathExpression) {
    this.buttonRemoveCart = By.xpath(xpathExpression);
  }


  public void clickButtonAddToCart() {
    WebElement element = waitingElementReady(buttonAddToCart);
    element.click();
  }

  public void clickButtonRemoveCart() {
    WebElement element = waitingElementReady(buttonRemoveCart);
    element.click();
  }

  public boolean isVisibleButtonAddToCart() {
    try {
      WebElement element = waitingElementForCheckingDisplay(buttonAddToCart);
      return element.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isVisibleButtonRemoveToCart() {
    try {
      WebElement element = waitingElementForCheckingDisplay(buttonRemoveCart);
      return element.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    } catch (TimeoutException e) {
      return false;
    }
  }


  public boolean isVisibleCartIcon() {
    try {
      WebElement element = waitingElementForCheckingDisplay(cartIcon);
      return element.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public String getTextButtonAddToCart() {
    WebElement element = waitingElementReady(buttonAddToCart);
    return element.getText();
  }
  
  public String getTextButtonRemoveCart() {
    WebElement element = waitingElementReady(buttonAddToCart);
    return element.getText();
  }

  public int getTotalCart() {
    WebElement element = waitingElementReady(cartIcon);
    return Integer.parseInt(element.getText());
  }
}

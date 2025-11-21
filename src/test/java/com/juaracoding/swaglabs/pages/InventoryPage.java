package com.juaracoding.swaglabs.pages;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.swaglabs.pages.components.HeaderComponent;
import com.juaracoding.swaglabs.pages.components.NavbarComponent;
import com.juaracoding.swaglabs.utils.MiscUtil;

public class InventoryPage extends BasePage {

  private HeaderComponent headerComponent;
  private NavbarComponent navbarComponent;

  private By sortProduct = By.xpath("//select[@data-test='product-sort-container']");
  private By priceOfProducts = By.xpath("//div[@data-test='inventory-item-price']");

  public InventoryPage(WebDriver driver) {
    super(driver);
    headerComponent = new HeaderComponent(driver);
    navbarComponent = new NavbarComponent(driver);
  }

  public HeaderComponent getHeaderComponent() {
    return headerComponent;
  }

  public NavbarComponent getNavbarComponent() {
    return navbarComponent;
  }

  public String getPathURL() {
    String[] path = driver.getCurrentUrl().split("/");
    return "/" + path[path.length - 1];
  }

  public void selectLowToHigh() {
    Select dropdown = new Select(waitingElementReady(sortProduct));
    dropdown.selectByValue("lohi");
  }

  public ArrayList<BigDecimal> getPrices() {
    List<WebElement> elements = driver.findElements(priceOfProducts);

    return MiscUtil.convertToDecimalsFrom(elements);
  }
}

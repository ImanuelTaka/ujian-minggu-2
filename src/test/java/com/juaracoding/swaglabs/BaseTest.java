package com.juaracoding.swaglabs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.juaracoding.swaglabs.listeners.ScreenshotListener;
import com.juaracoding.swaglabs.listeners.SendEmailReporter;
import com.juaracoding.swaglabs.pages.LoginPage;


@Listeners({ScreenshotListener.class, SendEmailReporter.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://www.saucedemo.com/";
    

    private boolean manualOpeningBrowser = false;

    public void setManualOpenBrowser() {
        manualOpeningBrowser = true;
    }

    public void setAutoOpenBrowser() {
        manualOpeningBrowser = false;
    }


    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        if (!manualOpeningBrowser) {
            driver.get(baseUrl);
        }
    }

    @AfterMethod
    public void teardown(ITestContext context) {
        if (driver != null) {
        driver.quit();
        }
    }

    public void openBrowser(String url) {
        driver.get(url);
  }


    public void preTestLogin(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);
  }
}

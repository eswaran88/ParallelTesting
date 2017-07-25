package com.automation.parallel;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Eswaran M
 */
public class ParallelTesting {
    static WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void init(String browser){
        System.out.println("Browser : "+browser);
        if("Chrome".equals(browser)){
            System.out.println("Driver Path : "+OsType.getChromeOsType());
            System.setProperty("webdriver.chrome.driver", OsType.getChromeOsType());
            driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
        }else if("Firefox".equals(browser)){
            System.out.println("Driver Path : "+OsType.getFirefoxOsType());
            System.setProperty("webdriver.gecko.driver", OsType.getFirefoxOsType());
            DesiredCapabilities capabilities= DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);
        }
    }

    @Test(priority = 2)
    public void fileExportFile(){
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement fileDownloadElement = driver.findElement(By.linkText("Test File to Download"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileDownloadElement);
        fileDownloadElement.click();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}

package org.automationexerciestest.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

static WebDriver driver;

public static WebDriver getChromeDriver()
{
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    return driver;

}


public static void quitDriver()
{
    driver.quit();
}
}

package org.example.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverManager {

static WebDriver driver;

public static WebDriver getChromeDriver()
{
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    return driver;

}


public static void quitdriver()
{
    driver.quit();
}
}

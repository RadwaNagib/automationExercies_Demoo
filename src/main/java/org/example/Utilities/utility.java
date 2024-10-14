package org.example.Utilities;

//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import java.io.FileReader;

import static org.example.Utilities.waitUtility.*;


public class utility {


    //ToDo: Convert Locator to Web Element
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }


//TODO: Clicking on element after checking clickability
    public static void clicking(WebDriver driver, By locator)
    {
        explicityWaitForClickability(driver,locator);
        findWebElement(driver, locator).click();
    }


    //TODO: Send data to element after checking visibility
    public static String sendData(WebDriver driver, By locator, String data)
    {
        explicityWaitForVisibility(driver,locator);
        findWebElement(driver,locator).sendKeys(data);
        return data;
    }


    //TODO: get text from element after checking visibility
    public static String getText(WebDriver driver,By locator)
    {
        explicityWaitForVisibility(driver,locator);
        return findWebElement(driver,locator).getText();
    }

    //TODO: Clicking on element after checking clickability using fluentwait
    public static void clickmy(WebDriver driver, By locator)
    {
        fluentWaitForElement(driver,locator,7,2);
        findWebElement(driver, locator).click();
    }

    //TODO: get text from element after checking visibility using fluentwait
    public static String getTextmy(WebDriver driver,By locator)
    {
        fluentWaitForElement(driver,locator,7,2);
        return findWebElement(driver,locator).getText();
    }








}

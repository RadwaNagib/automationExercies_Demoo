package org.example.Utilities;

//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

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

    //TODO:   Method to check if search key is found in any of the image attributes or the description ex:<p>tag
    public static boolean isImageOrDescriptionRelatedToSearchKey(WebElement img  ,WebElement description,String searchkey) {
        //Extract alt ,title,src attributes
        String altText = img.getAttribute("alt");
        String title = img.getAttribute("title");
        String src = img.getAttribute("src");

        // Extract description text from the <p> tag
        String descriptionText=description.getText();

        //check if the search key appears in any of these attributes
        return (altText != null && altText.contains(searchkey)) ||
                (title != null && title.contains(searchkey)) ||
                (src != null && src.contains(searchkey)) ||
                (descriptionText!=null && descriptionText.contains(searchkey)) ;
    }

    //TODO: Method to extract string from web page to file
    public static void writeToFile(String text,String fileName)
    {
        try
             {
                FileWriter writer = new FileWriter(fileName, true);// 'true' enables append mode
                writer.write(text + System.lineSeparator());// Add a new line after each write
                writer.close();
            }

        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }

    }










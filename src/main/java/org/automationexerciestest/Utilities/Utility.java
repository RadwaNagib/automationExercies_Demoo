package org.automationexerciestest.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;

import static org.automationexerciestest.Utilities.WaitHelper.*;


public class Utility {


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
    public static void press_click(WebDriver driver, By locator)
    {
        fluentWaitForElement(driver,locator,7,2);
        findWebElement(driver, locator).click();
    }

    //TODO: get text from element after checking visibility using fluentwait
    public static String get_my_text(WebDriver driver, By locator)
    {
        fluentWaitForElement(driver,locator,7,2);
        return findWebElement(driver,locator).getText();
    }

    //TODO:   Method to check if search key is found in any of the image attributes or the description ex:<p>tag
    public static boolean isImageOrDescriptionRelatedToSearchKey(WebElement img  ,WebElement description,String search_key) {
        //Extract alt ,title,src attributes
        String altText = img.getAttribute("alt");
        String title = img.getAttribute("title");
        String src = img.getAttribute("src");

        // Extract description text from the <p> tag
        String descriptionText=description.getText();

        //check if the search key appears in any of these attributes
        return (altText != null && altText.contains(search_key)) ||
                (title != null && title.contains(search_key)) ||
                (src != null && src.contains(search_key)) ||
                (descriptionText!=null && descriptionText.contains(search_key)) ;
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










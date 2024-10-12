package org.example.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitUtility {

    //ToDo: Explicity wait for clickability
    public static void explicityWaitForClickability(WebDriver driver, By Locator )
    {
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(Locator));
    }

    //TODO: Explicity wait for visibility
    public static void explicityWaitForVisibility(WebDriver driver,By Locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

    //TODO: GeneralWait
    public static WebDriverWait generalwait(WebDriver driver,int timeout)
    {
        return new WebDriverWait(driver,Duration.ofSeconds(5));
    }
}

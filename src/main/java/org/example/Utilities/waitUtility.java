package org.example.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class waitUtility {

    //ToDo: Explicity wait for clickability
    public static void explicityWaitForClickability(WebDriver driver, By Locator )
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(Locator));
    }

    //TODO: Explicity wait for visibility
    public static void explicityWaitForVisibility(WebDriver driver,By Locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

    //TODO: GeneralWait
    public static WebDriverWait generalwait(WebDriver driver,int timeout)
    {
        return new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    //TODO: FLUENT WAIT WITH POLLING INTERVAL AND period time with ignore exception
    // Method to perform Fluent Wait for a WebElement
    public static WebElement fluentWaitForElement(WebDriver driver, By locator, int timeoutInSeconds, int pollingInSeconds) {
        // Fluent wait definition
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))        // Max timeout
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))       // Polling interval
                .ignoring(NoSuchElementException.class);                  // Ignore NoSuchElementException

        // Wait for the element to be present
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

}

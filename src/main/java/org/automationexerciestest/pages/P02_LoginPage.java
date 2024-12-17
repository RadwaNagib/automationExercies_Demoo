package org.automationexerciestest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.automationexerciestest.Utilities.Utility.*;

public class P02_LoginPage {

    WebDriver driver;

    public P02_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private final By signup_login_button= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By login_to_your_account_massage=By.xpath("//section[@id=\"form\"]/div/div/div/div/h2");
    private final By email_field =By.xpath("//input[@type=\"email\"]");
    private final By password_field =By.xpath("//input[@type=\"password\"]");
    private final By login_button=By.xpath("//button[@data-qa=\"login-button\"]");
    private final By delete_account_button=By.xpath("//i[@class=\"fa fa-trash-o\"]");
    private final By account_deleted_message=By.xpath("//b[text()=\"Account Deleted!\"]");


    public void clickOnSignupLoginButton() {
        clicking(driver, signup_login_button);
    }

    //get text from login to your account message
    public String getLoginToYourAccountMessage() {
        return getText(driver, login_to_your_account_massage);
    }

    //Enter valid email and password to login
    public void enterValidEmailPassword(String mail, String pass)
    {
        sendData(driver, email_field,mail);
        sendData(driver, password_field,pass);
    }

    //click on login button
    public void clickLoginButton() {
        clicking(driver, login_button);
    }

    //get logged in as message by using .getPageSource
    public boolean getLoggedInAsMessage() {
        String page_source = driver.getPageSource();
        String message;
        return page_source.contains("Logged in as");
    }

    //get username message by using .getPageSource
    public  boolean getUsernameInAsMessage() {
        String page_source = driver.getPageSource();
        String message;
        return page_source.contains("radwa");
    }


    //click on delete account button
    public void deleteAccountButton()
    {
        clicking(driver,delete_account_button);
    }

    //verify account deleted message appear
    public String accountDeletedMessage()
    {
        return getText(driver,account_deleted_message);

    }
}

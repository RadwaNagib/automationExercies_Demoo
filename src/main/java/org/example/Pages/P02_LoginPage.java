package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.example.Utilities.utility.*;

public class P02_LoginPage {

    WebDriver driver;

    public P02_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private final By signup_login_button= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By login_to_your_account_massage=By.xpath("//section[@id=\"form\"]/div/div/div/div/h2");
    private final By email_textinput=By.xpath("//input[@type=\"email\"]");
    private final By password_textinput=By.xpath("//input[@type=\"password\"]");
    private final By login_button=By.xpath("//button[@data-qa=\"login-button\"]");
    private final By delete_account_button=By.xpath("//i[@class=\"fa fa-trash-o\"]");
    private final By account_deleted_message=By.xpath("//b[text()=\"Account Deleted!\"]");



    public void clcik_on_signup_login_button()
    {
        clicking(driver,signup_login_button);
    }

    //get text from login to your account message
    public String get_login_to_your_account_message()
    {
        String mytext=getText(driver,login_to_your_account_massage);
        return mytext;
    }

    //Enter valid email and password to login
    public void enter_email_password(String mail,String pass)
    {
        sendData(driver,email_textinput,mail);
        sendData(driver,password_textinput,pass);
    }

    //click on login button
    public void click_login_button()
    {
        clicking(driver,login_button);
    }

//get logged in as message by using .getPageSource
public  boolean get_logged_in_as_message() {
    String pagesource = driver.getPageSource();
    String message;
    if (pagesource.contains("Logged in as")) {

        return true;
    }
    else return false;
}

    //get username message by using .getPageSource
    public  boolean get_username_in_as_message() {
        String pagesource = driver.getPageSource();
        String message;
        if (pagesource.contains("radwa")) {

            return true;
        }
        else return false;
    }


    //click on delete account button
    public void Delete_Account_Button()
    {
        clicking(driver,delete_account_button);
    }

    //verify account deleted message appear
    public String Account_Deleted_Message()
    {
        String message=getText(driver,account_deleted_message);
        return message;
    }
}

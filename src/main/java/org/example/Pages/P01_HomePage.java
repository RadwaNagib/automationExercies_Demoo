package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.example.Utilities.utility.*;
//import static sun.net.NetProperties.get;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    //locate signup/login bttn
    private final  By signup_login_button =By.xpath("//i[@class=\"fa fa-lock\"]");
    private final  By new_user_signup_msg=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final  By signup_name=By.xpath("//input[@data-qa=\"signup-name\"]");
    private final  By signup_email=By.xpath("//input[@data-qa=\"signup-email\"]");
    private final  By signup_button=By.xpath("//button[@data-qa=\"signup-button\"]");
    private final  By enter_accout_information =By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    private final  By title=By.id("id_gender1");
    private final  By password=By.id("password");
    private final  By day_select_dropdown =By.id("days");
    private final  By month_select_dropdown=By.id("months");
    private final  By year_select_dropdown=By.id("years");
    //locate checkbox
    private final  By checkbox1=By.id("newsletter");
    private final  By checkbox2=By.id("optin");

    //locate address information
    private final By first_name=By.cssSelector("input[data-qa=\"first_name\"]");
    private final By last_name=By.cssSelector("input[data-qa=\"last_name\"]");
    private final By company=By.cssSelector("input[data-qa=\"company\"]");
    private final By address_1=By.id("address1");
    private final By address_2=By.id("address2");
    private final By state=By.cssSelector("input[data-qa=\"state\"]");
    private final By city=By.cssSelector("input[data-qa=\"city\"]");
    private final By zip_code=By.cssSelector("input[data-qa=\"zipcode\"]");
    private final By  mobile_number=By.cssSelector("input[data-qa=\"mobile_number\"]");
    private final By account_created_message=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private final By continue_button=By.xpath("//*[text()=\"Continue\"]");
    private final By delete_account_button=By.xpath("//i[@class=\"fa fa-trash-o\"]");
    private final By account_deleted_message=By.xpath("//b[text()=\"Account Deleted!\"]");

    //locate <select> dropdown
    private final By country=By.id("country");


    //locate create account button using XPath's text() function to locate an element by its visible text.
    private final By create_account_bttn=By.xpath("//*[text()=\"Create Account\"]");

    //locate create account button using XPath's contain text() function to locate an element by its visible text.
    //private final By create_account_bttn =By.xpath("//*[contains(text(),\"Create\")]");

    public void clickonlogin_signupbttn()
{
    clicking(driver, signup_login_button);
}
    public String check_new_user_signup_msg()
       {
         String mymessage= getText(driver,new_user_signup_msg);
         return mymessage;
      }
public String enter_data_on_signup_name(String name)
{
    return sendData(driver,signup_name,name);
}
public String enter_data_on_email(String email)
{
    return sendData(driver,signup_email,email);
}
public void click_on_signup_button()
{
    clicking(driver,signup_button);
}
//get enter account information
public String get_enter_account_info_message()
{
    String message=getText(driver, enter_accout_information);
    return message;
}
//click on radiobutton
    public void select_radio_button()
    {
        clicking(driver,title);
    }
//send data to name  , password
public void send_data( String mypassword)
{

    sendData(driver,password,mypassword);
}
    //to interact with <select> dropdown
    //first step: Locate the <select> dropdown element
    //second step: Create an instance of the Select class and pass the dropdown WebElement to it
    //third step:Select by visible text or value or index


    //convert day to web element and select by index
    public void select_day()
    {
        WebElement day_dropdown_element=findWebElement(driver, day_select_dropdown);
        Select dropdown=new Select(day_dropdown_element);
        dropdown.selectByIndex(3);
    }
    //convert month to web element and select by index
    public void select_month()
    {
        WebElement month_dropdown_element=findWebElement(driver,month_select_dropdown);
        Select dropdown=new Select(month_dropdown_element);
        dropdown.selectByIndex(10);
    }
    //convert year to web element and select by index
    public void select_year()
    {
        WebElement year_dropdown_element=findWebElement(driver,year_select_dropdown);
        Select dropdown=new Select(year_dropdown_element);
        dropdown.selectByIndex(20);
    }

    //to full dropdown list(year,month,day)
    public void full_dropdown_list()
    {
        select_day();
        select_month();
        select_year();
    }

  //to interact with checkbox
    //step1:Locate the Checkbox: You can locate the checkbox using locators like By.id() or By.name()
    //step2:select the Checkbox: To select the checkbox, check if it's not already selected using .isSelected(), then click it.
    //step3:Deselect the Checkbox: To deselect a checkbox, you can use .click() if it's already selected
    //step4:Check if Checkbox is Selected: The .isSelected() method will return true if the checkbox is selected, and false otherwise.

    //select checkbox1
    public void select_checkbox1()
    {
        WebElement checkbox1_element=findWebElement(driver,checkbox1);
        if(!checkbox1_element.isSelected())
        {
            clicking(driver,checkbox1);
             //checkbox1_element.click();
        }
        else
        {
            System.out.println("check box1 selected");
        }
    }

    //select checkbox2
    public void select_checkbox2()
    {
        WebElement checkbox2_element=findWebElement(driver,checkbox2);
        if(!checkbox2_element.isSelected())
        {
            clicking(driver,checkbox2);
            //checkbox2_element.click();
        }
    }

    //send data to locate address information
    public void send_data_to_address_information(String fname,String lname,String mycompany,String address1,String address2,
                                                 String mystate,String mycity,String myzipcode,String mymobilenumber)
    {
        findWebElement(driver,first_name).clear();
        sendData(driver,first_name,fname);
        sendData(driver,last_name,lname);
        sendData(driver,company,mycompany);
        sendData(driver,address_1,address1);
        sendData(driver,address_2,address2);
        sendData(driver,state,mystate);
        sendData(driver,city,mycity);
        sendData(driver,zip_code,myzipcode);
        sendData(driver,mobile_number,mymobilenumber);
    }

    //convert <select> dropdown to web element and select by index
    public void select_country()
    {
        WebElement select_country_element=findWebElement(driver,country);
        Select dropdown=new Select(select_country_element);
        dropdown.selectByIndex(4);
    }

    //click on create account button
    public void click_on_create_account_button()
    {
        clicking(driver,create_account_bttn);
    }
//get text " account created message"
public String get_account_created_message()
{
    String message=getText(driver,account_created_message);
    return message;
}

//click on continue button after create account
    public void click_on_Continue_button()
    {
        clicking(driver,continue_button);
    }

//Use driver.getPageSource() to Verify Text in the Entire Page
//If the message is truly not contained inside any tag,
// another approach is to use the driver.getPageSource() method,
// which retrieves the entire HTML source of the page as a string.
// You can then search for the message inside this string

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
        //WebElement fname_element=findWebElement(driver,first_name);
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

package org.automationexerciestest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.automationexerciestest.Utilities.Utility.*;
//import static sun.net.NetProperties.get;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    //locate signup/login button
    private final  By signup_login_button =By.xpath("//i[@class=\"fa fa-lock\"]");
    private final  By new_user_signup_msg=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final  By signup_name_field =By.xpath("//input[@data-qa=\"signup-name\"]");
    private final  By signup_email_field =By.xpath("//input[@data-qa=\"signup-email\"]");
    private final  By signup_button=By.xpath("//button[@data-qa=\"signup-button\"]");
    private final  By enter_account_information_msg =By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    private final  By gender_radio_button =By.id("id_gender1");
    private final  By password_field =By.id("password");
    private final  By day_select_dropdown =By.id("days");
    private final  By month_select_dropdown=By.id("months");
    private final  By year_select_dropdown=By.id("years");
    //locate checkbox
    private final  By our_newsletter_checkbox1 =By.id("newsletter");
    private final  By our_partners_checkbox2 =By.id("optin");

    //locate address information
    private final By first_name_field =By.cssSelector("input[data-qa=\"first_name_field\"]");
    private final By last_name_field =By.cssSelector("input[data-qa=\"last_name_field\"]");
    private final By company_name_field =By.cssSelector("input[data-qa=\"company_name_field\"]");
    private final By address_1_name_field =By.id("address1");
    private final By address_2_name_field =By.id("address2");
    private final By state_name_field =By.cssSelector("input[data-qa=\"state_name_field\"]");
    private final By city_name_field =By.cssSelector("input[data-qa=\"city_name_field\"]");
    private final By zip_code_filed =By.cssSelector("input[data-qa=\"zipcode\"]");
    private final By mobile_number_filed =By.cssSelector("input[data-qa=\"mobile_number_filed\"]");
    private final By account_created_message=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private final By continue_button=By.xpath("//*[text()=\"Continue\"]");
    private final By delete_account_button=By.xpath("//i[@class=\"fa fa-trash-o\"]");
    private final By account_deleted_message=By.xpath("//b[text()=\"Account Deleted!\"]");

    //locate <select> dropdown
    private final By country_select =By.id("country_select");


    //locate create account button using XPath's text() function to locate an element by its visible text.
    private final By create_account_button = By.xpath("//*[text()=\"Create Account\"]");

    //locate create account button using XPath's contain text() function to locate an element by its visible text.
    //private final By create_account_button =By.xpath("//*[contains(text(),\"Create\")]");

    public void click_on_login_signup_button() {
        clicking(driver, signup_login_button);
    }

    public String check_new_user_signup_msg() {
        return getText(driver, new_user_signup_msg);
    }


    public void enter_data_on_signup_name(String name) {
        sendData(driver, signup_name_field, name);
    }

    public void enter_data_on_email(String email) {
        sendData(driver, signup_email_field, email);
    }

    public void click_on_signup_button() {
        clicking(driver, signup_button);
    }

    //get enter account information
    public String get_enter_account_info_message() {
        return getText(driver, enter_account_information_msg);
    }

    //click on radiobutton
    public void select_radio_button() {
        clicking(driver, gender_radio_button);
    }

    //send data to name  , password
    public void send_data(String my_password) {

        sendData(driver, password_field, my_password);
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

    //select our_newsletter_checkbox1
    public void select_checkbox1()
    {
        WebElement checkbox1_element=findWebElement(driver, our_newsletter_checkbox1);
        if(!checkbox1_element.isSelected())
        {
            clicking(driver, our_newsletter_checkbox1);
             //checkbox1_element.click();
        }
        else
        {
            System.out.println("check box1 selected");
        }
    }

    //select our_partners_checkbox2
    public void select_checkbox2()
    {
        WebElement checkbox2_element=findWebElement(driver, our_partners_checkbox2);
        if(!checkbox2_element.isSelected())
        {
            clicking(driver, our_partners_checkbox2);
            //checkbox2_element.click();
        }
    }

    //send data to locate address information
    public void send_data_to_address_information(String f_name, String l_name, String my_company, String address1, String address2,
                                                 String my_state, String my_city, String my_zip_code, String my_mobile_number)
    {
        findWebElement(driver, first_name_field).clear();
        sendData(driver, first_name_field, f_name);
        sendData(driver, last_name_field, l_name);
        sendData(driver, company_name_field, my_company);
        sendData(driver, address_1_name_field,address1);
        sendData(driver, address_2_name_field,address2);
        sendData(driver, state_name_field, my_state);
        sendData(driver, city_name_field, my_city);
        sendData(driver, zip_code_filed, my_zip_code);
        sendData(driver, mobile_number_filed, my_mobile_number);
    }

    //convert <select> dropdown to web element and select by index
    public void select_country()
    {
        WebElement select_country_element=findWebElement(driver, country_select);
        Select dropdown=new Select(select_country_element);
        dropdown.selectByIndex(1);
    }

    //click on create account button
    public void click_on_create_account_button()
    {
        clicking(driver, create_account_button);
    }

    //get text " account created message"
    public String get_account_created_message() {
        return getText(driver, account_created_message);

    }

    //click on continue button after create account
    public void click_on_Continue_button() {
        clicking(driver, continue_button);
    }

//Use driver.getPageSource() to Verify Text in the Entire Page
//If the message is truly not contained inside any tag,
// another approach is to use the driver.getPageSource() method,
// which retrieves the entire HTML source of the page as a string.
// You can then search for the message inside this string

    //get logged in as message by using .getPageSource
    public boolean get_logged_in_as_message() {
        String page_source = driver.getPageSource();
        String message;
        return page_source.contains("Logged in as");
    }

    //get username message by using .getPageSource
    public boolean get_username_in_as_message() {
        String page_source = driver.getPageSource();
        return page_source.contains("radwa");
    }

    //click on delete account button
    public void Delete_Account_Button() {
        clicking(driver, delete_account_button);
    }

    //verify account deleted message appear
    public String Account_Deleted_Message() {
        return getText(driver, account_deleted_message);

    }


}

package tests;

import org.automationexerciestest.drivermanager.DriverManager;
import org.automationexerciestest.pages.P01_HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import listeners.*;

import java.time.Instant;

import static org.automationexerciestest.Utilities.DataUtility.getJsonData;


//The @Listeners annotation is used to specify the listeners for the test class
@Listeners(Custom_Listeners.class)


public class Tc01_RegisterUser extends DriverManager {

    WebDriver driver;
    P01_HomePage p01HomePage;

    private final String baseurl = getJsonData("environment_data", "BaseURL");
    private final String signup_name = getJsonData("register_data", "signup_name");
    private final String signup_email = getJsonData("register_data", "signup_mail");
    private final String password = getJsonData("register_data", "password");
    private final String f_name = getJsonData("register_data", "f_name");
    private final String l_name = getJsonData("register_data", "l_name");
    private final String my_company = getJsonData("register_data", "my_company");
    private final String address1 = getJsonData("register_data", "address1");
    private final String address2 = getJsonData("register_data", "address2");
    private final String my_state = getJsonData("register_data", "my_state");
    private final String my_city = getJsonData("register_data", "my_city");
    private final String my_zipcode = getJsonData("register_data", "my_zipcode");
    private final String my_phone = getJsonData("register_data", "my_phone_number");


    @BeforeClass
    public void openDriver() {
        driver = getChromeDriver();
        driver.navigate().to(baseurl);
        p01HomePage = new P01_HomePage(driver);
    }

    @Test
    public void verifyHomePage() {
        String actual_url = driver.getCurrentUrl();

        //create object from soft assert
        SoftAssert softassert = new SoftAssert();

        //verify that home page visible successfully
        softassert.assertEquals(actual_url, baseurl, "error on navigate to homepage");
    }

    @Test
    public void verifySignupButton() {
        //click on signup/login button
        p01HomePage.click_on_login_signup_button();

        //create object from soft assert
        SoftAssert softassert = new SoftAssert();

        //asser "New User Signup!" appear
        String actual_message = p01HomePage.check_new_user_signup_msg();
        String expected_message = "New User Signup!";
        softassert.assertEquals(actual_message, expected_message, "message success don't displayed");

        //enter data on name and email then click signup button
        p01HomePage.enter_data_on_signup_name(signup_name);
        p01HomePage.enter_data_on_email(signup_email + Instant.now().toEpochMilli() + "@gmail.com");
        p01HomePage.click_on_signup_button();
    }

    @Test
    public void verifySignupSteps() {

        //create object from soft assert
        SoftAssert softassert = new SoftAssert();

        //verify enter account information message appear
        String actual_message_info = p01HomePage.get_enter_account_info_message();
        String expected_message_info = "ENTER ACCOUNT INFORMATION";
        softassert.assertEquals(actual_message_info, expected_message_info, "account information message not appear successfully");

        //enter data on account information message page
        p01HomePage.select_radio_button();
        p01HomePage.send_data(password);
        p01HomePage.full_dropdown_list();

        //select checkbox
        p01HomePage.select_checkbox1();
        p01HomePage.select_checkbox2();

        //enter data to personal information
        p01HomePage.send_data_to_address_information(f_name, l_name, my_company, address1, address2, my_state, my_city, my_zipcode, my_phone);
        p01HomePage.select_country();
        p01HomePage.click_on_create_account_button();

        //verify account created message appear
        String actual_result = p01HomePage.get_account_created_message();
        String expected_result = "ACCOUNT CREATED!";
        softassert.assertEquals(actual_result, expected_result, "Created account message not appear");
        softassert.assertAll();
    }

    @Test
    public void verifyContinueButton() {

        //click on continue button
        p01HomePage.click_on_Continue_button();
    }

    @Test
    public void verifyUserCanLogin() {

        //create object from soft assert
        SoftAssert softassert = new SoftAssert();

        //verify logged in as  message appear
        boolean expected_logged_message = true;
        boolean actual_logged_message = p01HomePage.get_logged_in_as_message();
        softassert.assertEquals(actual_logged_message, expected_logged_message, "logged in as not appear");

        //verify username appear
        boolean expected_username_message = true;
        boolean actual_username_message = p01HomePage.get_username_in_as_message();
        softassert.assertEquals(actual_username_message, expected_username_message, "radwa not appear");
        softassert.assertAll();
    }

    @Test
    public void verifyDeleteAccount() {

        //create object from soft assert
        SoftAssert softassert = new SoftAssert();

        //delete account by clicking on delete account button
        p01HomePage.Delete_Account_Button();

        //verify " ACCOUNT DELETED! message appear
        String actual_message_account_deleted = p01HomePage.Account_Deleted_Message();
        String expected_message_account_deleted = "ACCOUNT DELETED!";
        softassert.assertEquals(actual_message_account_deleted, expected_message_account_deleted, "account deleted message not appear");

    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

}

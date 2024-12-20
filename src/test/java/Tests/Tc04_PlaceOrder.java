package tests;

import org.apache.logging.log4j.core.net.Priority;
import org.automationexerciestest.drivermanager.DriverManager;
import org.automationexerciestest.pages.P01_HomePage;
import org.automationexerciestest.pages.P04_PlaceOrder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Instant;

import static org.automationexerciestest.Utilities.DataUtility.getJsonData;

public class Tc04_PlaceOrder extends DriverManager {
    WebDriver driver;
    P04_PlaceOrder pPlaceOrder;
    P01_HomePage p01HomePage;

    //base url
    private final String baseurl = getJsonData("environment_data", "BaseURL");

    //signup preparation
    private final String signup_name = getJsonData("register_data", "signup_name");
    private final String signup_email = getJsonData("register_data", "signup_mail");

    //enter account info
    private final String password = getJsonData("register_data", "password");
    private final String f_name = getJsonData("register_data", "f_name");
    private final String l_name = getJsonData("register_data", "l_name");

    //address info
    private final String my_company = getJsonData("register_data", "my_company");
    private final String address1 = getJsonData("register_data", "address1");
    private final String address2 = getJsonData("register_data", "address2");
    private final String my_state = getJsonData("register_data", "my_state");
    private final String my_city = getJsonData("register_data", "my_city");
    private final String my_zipcode = getJsonData("register_data", "my_zipcode");
    private final String my_phone = getJsonData("register_data", "my_phone_number");

    //place order data
    private final String my_comment_text=getJsonData("order_data","comment");
    private final String card_name=getJsonData("order_data","card_name");
    private final String card_number=getJsonData("order_data","card_number");
    private final String cvc=getJsonData("order_data","cvc");
    private final String expiration_month=getJsonData("order_data","expiration_month");
    private final String expiration_year=getJsonData("order_data","expiration_year");


    //create object from soft assert
    SoftAssert softassert = new SoftAssert();

    @BeforeClass
    public void openDriver() {
        driver = getChromeDriver();
        driver.get(baseurl);
        pPlaceOrder = new P04_PlaceOrder(driver);
        p01HomePage = new P01_HomePage(driver);

    }

    @Test(priority = 1)
    public void verifyHomePage() {
        String actual_url = driver.getCurrentUrl();

        //verify that home page visible successfully
        softassert.assertEquals(actual_url, baseurl, "error on navigate to homepage");
    }

    @Test(priority = 2)
    public void verifyAddProductToCart() {
        pPlaceOrder.add_Product_To_Cart();
        pPlaceOrder.proceed_To_Checkout_ShoppingCart();

        // Verify that cart page is displayed
        softassert.assertEquals(pPlaceOrder.proceed_To_Checkout_ShoppingCart(),"Shopping Cart","cart didn't return successfully");


    }

    @Test(priority = 3)
    public void verify_Checkout_And_Signup() {
        pPlaceOrder.proceed_To_Checkout();
        pPlaceOrder.proceed_To_RegisterLogin();
    }

    @Test(priority = 4)
    public void verify_Signup_Data() {

        //fill signup data
        p01HomePage.enter_data_on_signup_name(signup_name);
        p01HomePage.enter_data_on_email(signup_email + Instant.now().toEpochMilli() + "@gmail.com");
        p01HomePage.click_on_signup_button();

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
        @Test(priority = 5)
        public void verifyContinueButton() {

            //click on continue button
            p01HomePage.click_on_Continue_button();
        }

        @Test(priority = 6)
        public void verifyUserCanLogin() {

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

        @Test(priority = 7)
        public void verifyPlaceOrderProceed()
        {
            //Click 'Cart' button
            pPlaceOrder.click_Cart_Button();

            //Click 'Proceed To Checkout' button
            pPlaceOrder.proceed_To_Checkout();

            //Verify Address Details and Review Your Order
            softassert.assertEquals(pPlaceOrder.check_AddressDetails_Text(),"Address Details","Address Details Message not appear");

            //Enter description in comment text area
            pPlaceOrder.write_On_Textarea(my_comment_text);

            //click 'Place Order'
            pPlaceOrder.press_Place_Order_Button();

            //verify payment text appear
            softassert.assertEquals(pPlaceOrder.payment_Text(),"Payment","Payment text not appear");

            //fill full payment data
            pPlaceOrder.payment_Info(card_name,card_number,cvc,expiration_month,expiration_year);

            //clicking pay and confirm button
            pPlaceOrder.click_Pay_And_Confirm_button();

            //verify  Your order has been placed successfully! appear
            softassert.assertEquals(pPlaceOrder.order_Placed_Successfully(),"Your order has been placed successfully!","'Your order has been placed successfully!' this message not appear");
        }

        @Test(priority = 8)
        public void verifyDeleteAccount()
        {
            //create object from soft assert
            SoftAssert softassert = new SoftAssert();

            //delete account by clicking on delete account button
            p01HomePage.Delete_Account_Button();

            //verify " ACCOUNT DELETED! message appear
            String actual_message_account_deleted = p01HomePage.Account_Deleted_Message();
            String expected_message_account_deleted = "ACCOUNT DELETED!";
            softassert.assertEquals(actual_message_account_deleted, expected_message_account_deleted, "account deleted message not appear");

            //click on continue button
            p01HomePage.click_on_Continue_button();
        }

    @AfterClass
    public void closeBrowser() {
        DriverManager.quitDriver();
    }
}

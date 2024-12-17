package tests;

import org.automationexerciestest.drivermanager.DriverManager;
import org.automationexerciestest.pages.P02_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import listeners.*;
import static org.automationexerciestest.Utilities.DataUtility.getJsonData;


@Listeners(Custom_Listeners.class)
public class Tc02_Login_correct_email_and_password extends DriverManager {

    WebDriver driver;
    P02_LoginPage p02LoginPage;

    private final String baseurl=getJsonData("environment_data","BaseURL");
    private final String email=getJsonData("login_data","mail");
    private final String password=getJsonData("login_data","password");


    @BeforeClass
    public void openDriver()
    {
        driver=getChromeDriver();
        driver.navigate().to(baseurl);
        p02LoginPage = new P02_LoginPage(driver);
    }

    @Test
    public void verify_login_with_valid_data() {
        //verify navigate to home page successfully
        String actual_url = driver.getCurrentUrl();
        String expected_url = "https://automationexercise.com/";
        //create instance from soft asser to use function of (asser all)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual_url, expected_url, "can not navigate to home page");

        //click on signup_login button
        p02LoginPage.click_on_signup_login_button();

        //verify login to your account message appear
        String actual_message = p02LoginPage.get_login_to_your_account_message();
        String expected_message = "Login to your account";
        softAssert.assertEquals(actual_message, expected_message, "login to your account message not appear");

        //enter valid email and password
        p02LoginPage.enter_email_password(email, password);

        //click on login button
        p02LoginPage.click_login_button();

        //verify logged in as  message appear
        boolean expected_logged_message = true;
        boolean actual_logged_message = p02LoginPage.get_logged_in_as_message();
        softAssert.assertEquals(actual_logged_message, expected_logged_message, "logged in as not appear");

        //verify username appear
        boolean expected_username_message = true;
        boolean actual_username_message = p02LoginPage.get_username_in_as_message();
        softAssert.assertEquals(actual_username_message, expected_username_message, "radwa not appear");

        //delete account by clicking on delete account button
        p02LoginPage.Delete_Account_Button();

        //verify " ACCOUNT DELETED! message appear
        String actual_message_account_deleted = p02LoginPage.Account_Deleted_Message();
        String expected_message_account_deleted = "ACCOUNT DELETED!";
        softAssert.assertEquals(actual_message_account_deleted, expected_message_account_deleted, "account deleted message not appear");

        softAssert.assertAll();

    }

    @AfterClass
    public void closeBrowser()
    {
        DriverManager.quitDriver();
    }

}

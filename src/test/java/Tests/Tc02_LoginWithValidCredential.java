package tests;

import org.automationexerciestest.drivermanager.DriverManager;
import org.automationexerciestest.pages.P02_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import listeners.*;
import static org.automationexerciestest.Utilities.DataUtility.getJsonData;


@Listeners(Custom_Listeners.class)
public class Tc02_LoginWithValidCredential extends DriverManager {

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
    public void verifyHomePage() {
        //verify navigate to home page successfully
        String actual_url = driver.getCurrentUrl();
        String expected_url = "https://automationexercise.com/";

        //create instance from soft asser to use function of (asser all)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual_url, expected_url, "can not navigate to home page");


        //click on signup_login button
        p02LoginPage.clickOnSignupLoginButton();

        //verify login to your account message appear
        String actual_message = p02LoginPage.getLoginToYourAccountMessage();
        String expected_message = "Login to your account";
        softAssert.assertEquals(actual_message, expected_message, "login to your account message not appear");
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginWithValidData() {

        //create instance from soft asser to use function of (asser all)
        SoftAssert softAssert = new SoftAssert();

        //enter valid email and password
        p02LoginPage.enterValidEmailPassword(email, password);

        //click on login button
        p02LoginPage.clickLoginButton();

        //verify logged in as  message appear
        boolean expected_logged_message = true;
        boolean actual_logged_message = p02LoginPage.getLoggedInAsMessage();
        softAssert.assertEquals(actual_logged_message, expected_logged_message, "logged in as not appear");
    }

    @Test
    public void verifyUserNameAppear() {

        //create instance from soft asser to use function of (asser all)
        SoftAssert softAssert = new SoftAssert();

        //verify username appear
        boolean expected_username_message = true;
        boolean actual_username_message = p02LoginPage.getUsernameInAsMessage();
        softAssert.assertEquals(actual_username_message, expected_username_message, "radwa not appear");
    }

    @Test
    public void verifyDeleteAccount() {

        //create instance from soft asser to use function of (asser all)
        SoftAssert softAssert = new SoftAssert();

        //delete account by clicking on delete account button
        p02LoginPage.deleteAccountButton();

        //verify " ACCOUNT DELETED! message appear
        String actual_message_account_deleted = p02LoginPage.accountDeletedMessage();
        String expected_message_account_deleted = "ACCOUNT DELETED!";
        softAssert.assertEquals(actual_message_account_deleted, expected_message_account_deleted, "account deleted message not appear");

    }

    @AfterClass
    public void closeBrowser()
    {
        DriverManager.quitDriver();
    }

}

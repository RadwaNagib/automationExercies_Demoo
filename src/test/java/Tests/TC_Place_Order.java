package Tests;

import org.example.DriverManager.driverManager;
import org.example.Pages.P01_HomePage;
import org.example.Pages.P_PlaceOrder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.example.Utilities.dataUtility.getJsonData;

public class TC_Place_Order extends driverManager {
    WebDriver driver;
    P_PlaceOrder pPlaceOrder;
    P01_HomePage p01HomePage;

    private final String signup_name=getJsonData("register_data","signup_name");
    private final String signup_email=getJsonData("register_data","signup_mail");

    private final String baseurl=getJsonData("environment_data","BaseURL");

    @BeforeClass
    public void opendriver()
    {
        driver=getChromeDriver();
        driver.get(baseurl);
        pPlaceOrder=new P_PlaceOrder(driver);
        p01HomePage=new P01_HomePage(driver);
    }

    @Test
    public void register_While_Checkout()
    {
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(baseurl,driver.getCurrentUrl(),"error on baseurl");

        pPlaceOrder.cart_Page_Displayed();
        pPlaceOrder.checkout_signup();

        //fill signup data
        p01HomePage.enter_data_on_signup_name(signup_name);
        p01HomePage.enter_data_on_email(signup_email);
        p01HomePage.click_on_signup_button();



        softAssert.assertAll();
    }

    @AfterClass
    public void quitderiver()
    {
        driverManager.quitdriver();
    }
}

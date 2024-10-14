package Tests;

import org.example.DriverManager.driverManager;
import org.example.Pages.P03_ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.example.Utilities.dataUtility.getJsonData;

public class Tc09_Verify_All_Products_and_product_detail_page extends driverManager {

    WebDriver driver;
    P03_ProductPage p03ProductPage;

    private final String baseurl=getJsonData("environment_data","BaseURL");
    private final String women_list1=getJsonData("product_data","women_list1");
    private final String women_list2=getJsonData("product_data","women_list2");
    private final String women_list3=getJsonData("product_data","women_list3");
    private final String men_list1=getJsonData("product_data","men_list1");
    private final String men_list2=getJsonData("product_data","men_list2");
    private final String kids_list1=getJsonData("product_data","kids_list1");
    private final String kids_list2=getJsonData("product_data","kids_list2");
    private final String product_name=getJsonData("product_data","product_name");
    private final String category=getJsonData("product_data","category");
    private final String price=getJsonData("product_data","price");
    private final String availability=getJsonData("product_data","availability");
    private final String condition=getJsonData("product_data","condition");
    private final String brand=getJsonData("product_data","brand");






    @BeforeClass
    public void opendriver()
    {
        driver=driverManager.getChromeDriver();
        driver.navigate().to(baseurl);
        p03ProductPage=new P03_ProductPage(driver);
    }
    @Test
    public void verify_all_products_and_product_details_page() {
        //create instance from soft assert class

        SoftAssert softAssert = new SoftAssert();

        String expected_url = "https://automationexercise.com/";
        String actual_url = driver.getCurrentUrl();

        softAssert.assertEquals(actual_url, expected_url, "error during navigate to Home page");
        //clcik on product button
        p03ProductPage.click_on_product_button();

        //assert that "ALL PRODUCTS" appear
        softAssert.assertEquals(p03ProductPage.all_products_txt(),"ALL PRODUCTS","ERROR");

        //verify on products list
        softAssert.assertEquals(p03ProductPage.list1_Women(), women_list1,"DRESS NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list2_Women(),women_list2,"TOPS NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list3_Women(),women_list3,"SAREE NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list1_men(),men_list1,"Tshirts NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list2_men(),men_list2,"jens NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list1_kids(),kids_list1,"dress NOT APPEAR");
        softAssert.assertEquals(p03ProductPage.list2_kids(),kids_list2,"TOPS & SHIRTS NOT APPEAR");

        //click on view product link
        p03ProductPage.click_on_view_product();

        //assert to navigate to products details page
        String actual_product_details_page=driver.getCurrentUrl();
        String expected_product_details_page="https://automationexercise.com/product_details/1";
        softAssert.assertEquals(actual_product_details_page,expected_product_details_page,"products details page not appear");

        //verify product details is visible
        softAssert.assertEquals(p03ProductPage.get_product_name(),product_name,"error on product name");
        softAssert.assertEquals(p03ProductPage.get_category_text(),category,"category not appear");
        softAssert.assertEquals(p03ProductPage.get_price_text(),price,"price not appear");
        softAssert.assertEquals(p03ProductPage.get_availability_text(),availability,"availability not appear");
        softAssert.assertEquals(p03ProductPage.get_condition_text(),condition,"condition not appear");
        softAssert.assertEquals(p03ProductPage.get_brand_text(),brand,"brand not appear");

        softAssert.assertAll();

    }

        @AfterClass
        public void closebrowser()
        {
            driverManager.quitdriver();
        }







}

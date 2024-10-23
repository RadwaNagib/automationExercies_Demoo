package Tests;

import org.example.DriverManager.driverManager;
import org.example.Pages.P03_ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.Utilities.dataUtility.getJsonData;
import static org.example.Utilities.utility.isImageOrDescriptionRelatedToSearchKey;

public class Tc09_Verify_All_Products_info extends driverManager {

    WebDriver driver;
    P03_ProductPage p03ProductPage;

    private final String baseurl=getJsonData("environment_data","BaseURL");
    private final String all_products_message=getJsonData("product_data","all_product_message");
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
    private final String my_search_key=getJsonData("product_data","search_key");
    private final String product1_description =getJsonData("product_data","product1_description");
    private final String product1_price =getJsonData("product_data","product1_price");
    private final String product1_quantity =getJsonData("product_data","product1_quantity");
    private final String product1_total =getJsonData("product_data","product1_total");







    @BeforeTest
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
        softAssert.assertEquals(p03ProductPage.all_products_txt(),all_products_message,"ERROR");

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
    @Test
    public void Search_products()
    {
        //create instance from soft assert class
        SoftAssert softAssert = new SoftAssert();

        //verify navigate to homepage
        softAssert.assertEquals(driver.getCurrentUrl(),baseurl,"can't connect to home page");

        //click on product button
        p03ProductPage.click_on_product_button();

        //verify "ALL PRODUCTS" VISIBLE
        softAssert.assertEquals(p03ProductPage.all_products_txt(),all_products_message,"all products message not appear");

        //enter dress on side search field then click
        p03ProductPage.enter_search_key(my_search_key);
        p03ProductPage.click_on_search_button();

        //find all images inside featuresItemsDiv_ele
        List <WebElement> images=p03ProductPage.fearuresItemsDiv_ele().findElements(By.tagName("img"));

        // Loop through each image and check if it is related to the search key
        for(WebElement img :images) {
            WebElement description =p03ProductPage.fearuresItemsDiv_ele().findElement(By.tagName("p"));
            Boolean isRelated = isImageOrDescriptionRelatedToSearchKey(img,description, my_search_key);
            softAssert.assertEquals(isRelated.booleanValue(),true,"not related");

        }
        softAssert.assertAll();

    }

    @Test
    public void Add_Products_In_Cart()
    {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),baseurl,"can n't navigate to home page ");

        p03ProductPage.click_on_product_button();

        //hover on first add cart button then click
        p03ProductPage.click_first_add_cart();
        p03ProductPage.click_on_continue_shopping_button();

        //hover on second add cart button then click
        p03ProductPage.click_second_add_cart();
        p03ProductPage.click_view_cart_button();

        //verify the first product added in cart by its image, description, price, quantity, total
        softAssert.assertTrue(p03ProductPage.product1_image());

        // assert description not null
        softAssert.assertNotNull(p03ProductPage.get_description_from_product1(),"description shouldn't null");
        //assert after delete white space ,still stringr or description not null
        softAssert.assertFalse(p03ProductPage.get_description_from_product1().trim().isEmpty());


        softAssert.assertNotNull(p03ProductPage.get_price_from_product1(),"error on price");
        softAssert.assertFalse(p03ProductPage.get_price_from_product1().trim().isEmpty());


        softAssert.assertNotNull(p03ProductPage.get_quantity_from_product1(),"error on quantity");
        softAssert.assertFalse(p03ProductPage.get_quantity_from_product1().trim().isEmpty());


        softAssert.assertNotNull(p03ProductPage.get_total_from_product1(),"error on total");
        softAssert.assertFalse(p03ProductPage.get_total_from_product1().trim().isEmpty());

        softAssert.assertAll();



    }

        @AfterTest
        public void closebrowser()
        {
            driverManager.quitdriver();
        }







}

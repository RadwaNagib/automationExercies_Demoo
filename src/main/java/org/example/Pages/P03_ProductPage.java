package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import java.sql.SQLOutput;

import static org.example.Utilities.dataUtility.getJsonData;
import static org.example.Utilities.utility.*;

public class P03_ProductPage {

    WebDriver driver;
    Actions actions;

    public P03_ProductPage(WebDriver driver)
    {
        this.driver=driver;

    }

    //locate product button
    private final By product_button=By.xpath("//header[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private final By Women_list1=By.xpath("//div[@id=\"Women\"]/div/ul/li[1]/a");
    private final By Women_list2=By.xpath("//div[@id=\"Women\"]/div/ul/li[2]/a");
    private final By Women_list3=By.xpath("//div[@id=\"Women\"]/div/ul/li[3]/a");
    private final By Men_list1=By.xpath("//div[@id=\"Men\"]/div/ul/li[1]/a");
    private final By Men_list2=By.xpath("//div[@id=\"Men\"]/div/ul/li[2]/a");
    private final By Kids_list1=By.xpath("//div[@id=\"Kids\"]/div/ul/li[1]/a");
    private final By Kids_list2=By.xpath("//div[@id=\"Kids\"]/div/ul/li[2]/a");

    private final By all_products_message=By.xpath("//h2[@class=\"title text-center\"]");

    //to interact with panel-collapse ,must fallow some steps
    //1-Identify the panel locator (+)
    //2-Expand the panel if necessary
    //3-Wait for the panel to be visible

    private final By pluse_women=By.xpath("//span[@class=\"badge pull-right\"]");
    private final By pluse_men=By.xpath("//div[@class=\"panel panel-default\"][2]/div/h4/a/span");
    private final By pluse_kids=By.xpath("//div[@class=\"panel panel-default\"][3]/div/h4/a/span");

    //view products located
    private final By first_view_product=By.xpath("//a[@href=\"/product_details/1\"]");

    //locate product details
    private final By product_name=By.xpath("//div[@class=\"product-information\"]/h2");
    private final By category=By.xpath("//*[contains(text(),\"Category:\")]");
    private final By price=By.xpath("//*[contains(text(),\"Rs.\")]");
    private final By availability=By.xpath("//*[contains(text(),\"Availability:\")]");
    private final By condition=By.xpath("//*[contains(text(),\"Condition:\")]");
    private final By brand=By.xpath("//*[contains(text(),\"Brand:\")]");

    // Find the div with class 'features_items' containing the target images
    private final By featuresItemsDiv=By.xpath("//div[@class=\"features_items\"]");

    //locate search field
    private final By search_input=By.id("search_product");

    //locate search image
    private final By search_button=By.id("submit_search");

    //get search key file json
    private final String search_key=getJsonData("product_data","search_key");

    //locate first add to cart button
    private final By first_add_cart =By.xpath("//a[@data-product-id=\"1\"]");

    //locate continue shopping button
    private final By continue_shopping_button=By.xpath("//button[@data-dismiss=\"modal\"]");

    //locate second add to cart button
    private final By second_add_cart=By.xpath("//a[@data-product-id=\"2\"]");

    //locate view cart button by text() function
    private final By view_cart_button=By.xpath("//*[text()=\"View Cart\"]");

    //to click on product button
    public void click_on_product_button()
    {
        clicking(driver,product_button);
    }

    //locate product1 ,image, price, quantity, total price
    private final By product1_image_view_cart=By.xpath("//*[@id=\"product-1\"]/td[1]/a/img");
    private final By product1_description_view_cart =By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");
    private final By product1_price_view_cart=By.xpath("//*[@id=\"product-1\"]/td[3]/p");
    private final By product1_quantity_view_cart=By.xpath("//*[@id=\"product-1\"]/td[4]/button");
    private final By product1_total_price_view_cart=By.xpath("//*[@id=\"product-1\"]/td[5]/p");
//    private final By product2_description_view_cart=By.xpath("");
//    private final By product2_price_view_cart=By.xpath("");
//    private final By product2_quantity_view_cart=By.xpath("");
//    private final By product2_total_price_view_cart=By.xpath("");


    //get all products text
    public String all_products_txt()
    {
        String productsmessage=getText(driver,all_products_message);
        System.out.println("all products txt:" + productsmessage);
        return productsmessage;
    }

    //get text from Women List1
    public String list1_Women()
    {
        clickmy(driver,pluse_women);
        String list_one =getText(driver,Women_list1);
        return list_one;
    }

    //get text from women list2
    public String list2_Women()
    {
        String list_two=getText(driver,Women_list2);
        return list_two;
    }

    //get text from women list3
    public String list3_Women()
    {
        String list_three=getText(driver,Women_list3);
        return list_three;
    }

    //get text from men list1
    public String list1_men()
    {
        clickmy(driver,pluse_men);
        String list_one=getText(driver,Men_list1);
        return list_one;
    }

    //get text from men list2
    public String list2_men()
    {
        String list_two=getText(driver,Men_list2);
        return list_two;
    }

//get text from kids list1
    public String list1_kids()
    {
        clickmy(driver,pluse_kids);
        String list_one=getText(driver,Kids_list1);
        return list_one;
    }

    //get text from kids list2
    public String list2_kids()
    {
        String list_two=getText(driver,Kids_list2);
        return list_two;
    }

    //click on the first view product
    public void click_on_view_product()
    {
        clicking(driver,first_view_product);
    }

    //get text of product name
    public String get_product_name()
    {
        String my_product_name=getText(driver,product_name);
        return my_product_name;
    }
    //get category text
    public String get_category_text()
    {
        String my_category_text=getText(driver,category);
        return my_category_text;
    }
    //get price text
    public String get_price_text()
    {
        String my_price_text=getText(driver,price);
        return my_price_text;
    }
    //get availability text
    public String get_availability_text()
    {
        String my_available_text=getText(driver,availability);
        return my_available_text;
    }
    //get condition text
    public String get_condition_text()
    {
        String my_condition_text=getText(driver,condition);
        return my_condition_text;
    }
    //get brand text
    public String get_brand_text()
    {
        String my_brand_text=getText(driver,brand);
        return my_brand_text;
    }

    //send data inside search input
    public void enter_search_key(String search_key)
    {
        sendData(driver,search_input, search_key);
    }

    //click on search button
    public void click_on_search_button(){
        clicking(driver,search_button);
    }

    //convert featuresItemsDiv to webElement
    public WebElement fearuresItemsDiv_ele()
    {
       WebElement features_Items_Div_element = findWebElement(driver,featuresItemsDiv);
        return features_Items_Div_element;
    }

    //click on first add cart button
    public void click_first_add_cart()
    {
        //create instance from actions class to simulate advanced user interactions like hovering, clicking, dragging, and more.
        actions=new Actions(driver);
        //convert locator to web element
        WebElement first_add_cart_element =findWebElement(driver, first_add_cart);
        //hover and click
        actions.moveToElement(first_add_cart_element).click().perform();

    }

    //click on continue shopping button
    public void click_on_continue_shopping_button()
    {
        clicking(driver,continue_shopping_button);
    }

    //click on second add cart  button
    public void click_second_add_cart()
    {
        actions=new Actions(driver);
        WebElement second_add_cart_element=findWebElement(driver,second_add_cart);
        actions.moveToElement(second_add_cart_element).click().perform();
    }

    //click on view cart button
    public void click_view_cart_button()
    {
        clicking(driver,view_cart_button);
    }
    public boolean product1_image()
    {
        WebElement product1_image_element=findWebElement(driver,product1_image_view_cart);
        WebElement product1_des_element=findWebElement(driver,product1_description_view_cart);
        return isImageOrDescriptionRelatedToSearchKey(product1_image_element,product1_des_element,getJsonData("product_data","search_key"));
    }

    //get text from product1_description
    public String get_description_from_product1()
    {
        String des_product1_view_cart =getText(driver, product1_description_view_cart);
        return des_product1_view_cart;
    }
    //get text from product1 price
    public String get_price_from_product1()
    {
        String price_product1_view_cart=getText(driver,product1_price_view_cart);
        return price_product1_view_cart;
    }
    //get text from product1 quantity
    public String get_quantity_from_product1()
    {
        String quantity_product1_view_cart =getText(driver,product1_quantity_view_cart);
        return quantity_product1_view_cart;
    }
    //get text from product1 total
    public String get_total_from_product1()
    {
        String total_product1_view_cart=getText(driver,product1_total_price_view_cart);
        return total_product1_view_cart;
    }








}

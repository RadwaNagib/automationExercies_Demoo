package org.automationexerciestest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import java.sql.SQLOutput;

import static org.automationexerciestest.Utilities.DataUtility.getJsonData;
import static org.automationexerciestest.Utilities.Utility.*;

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

    private final By women_panel_collapse =By.xpath("//span[@class=\"badge pull-right\"]");
    private final By men_panel_collapse =By.xpath("//div[@class=\"panel panel-default\"][2]/div/h4/a/span");
    private final By plus_kids_panel_collapse =By.xpath("//div[@class=\"panel panel-default\"][3]/div/h4/a/span");

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
    private final By search_input_field =By.id("search_product");

    //locate search image
    private final By search_button=By.id("submit_search");

    //get search key file json
    private final String search_key=getJsonData("product_data","search_key");

    //locate first add to cart button
    private final By first_add_cart_button =By.xpath("//a[@data-product-id=\"1\"]");

    //locate continue shopping button
    private final By continue_shopping_button=By.xpath("//button[@data-dismiss=\"modal\"]");

    //locate second add to cart button
    private final By second_add_cart_button =By.xpath("//a[@data-product-id=\"2\"]");

    //locate view cart button by text() function
    private final By view_cart_button=By.xpath("//*[text()=\"View Cart\"]");

    //locate product1 ,image, price, quantity, total price
    private final By product1_image_view_cart = By.xpath("//*[@id=\"product-1\"]/td[1]/a/img");
    private final By product1_description_view_cart = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");
    private final By product1_price_view_cart = By.xpath("//*[@id=\"product-1\"]/td[3]/p");
    private final By product1_quantity_view_cart = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
    private final By product1_total_price_view_cart = By.xpath("//*[@id=\"product-1\"]/td[5]/p");

    //to click on product button
    public void clickOnProductButton()
    {
        clicking(driver,product_button);
    }

    //get all products text
    public String allProductsTxt() {
        String products_message = getText(driver, all_products_message);
        System.out.println("all products txt:" + products_message);
        return products_message;
    }

    //get text from Women List1
    public String list1_Women() {
        press_click(driver, women_panel_collapse);
        return getText(driver, Women_list1);
    }

    //get text from women list2
    public String list2_Women() {
        return getText(driver, Women_list2);

    }

    //get text from women list3
    public String list3_Women() {
        return getText(driver, Women_list3);

    }

    //get text from men list1
    public String list1_Men() {
        press_click(driver, men_panel_collapse);
        return getText(driver, Men_list1);
    }

    //get text from men list2
    public String list2_Men() {
        return getText(driver, Men_list2);
    }

    //get text from kids list1
    public String list1_Kids() {
        press_click(driver, plus_kids_panel_collapse);
        return getText(driver, Kids_list1);
    }

    //get text from kids list2
    public String list2_Kids() {
        return getText(driver, Kids_list2);
    }

    //click on the first view product
    public void clickOnViewProduct()
    {
        clicking(driver,first_view_product);
    }

    //get text of product name
    public String getProductName() {
        return getText(driver, product_name);
    }
    //get category text
    public String getCategoryTxt()
    {
       return getText(driver,category);
    }

    //get price text
    public String get_price_text() {
        return getText(driver, price);
    }

    //get availability text
    public String get_availability_text() {
        return getText(driver, availability);
    }

    //get condition text
    public String get_condition_text() {
        return getText(driver, condition);

    }

    //get brand text
    public String get_brand_text() {
        return getText(driver, brand);

    }

    //send data inside search input
    public void enter_search_key(String search_key)
    {
        sendData(driver, search_input_field, search_key);
    }

    //click on search button
    public void click_on_search_button(){
        clicking(driver,search_button);
    }

    //convert featuresItemsDiv to webElement
    public WebElement features_ItemsDiv_ele()
    {
       return findWebElement(driver,featuresItemsDiv);
    }

    //click on first add cart button
    public void click_first_add_cart() {
        //create instance from actions class to simulate advanced user interactions like hovering, clicking, dragging, and more.
        actions = new Actions(driver);
        //convert locator to web element
        WebElement first_add_cart_element = findWebElement(driver, first_add_cart_button);
        //hover and click
        actions.moveToElement(first_add_cart_element).click().perform();

    }

    //click on continue shopping button
    public void click_on_continue_shopping_button() {
        clicking(driver, continue_shopping_button);
    }

    //click on second add cart  button
    public void click_second_add_cart() {
        actions = new Actions(driver);
        WebElement second_add_cart_element = findWebElement(driver, second_add_cart_button);
        actions.moveToElement(second_add_cart_element).click().perform();
    }

    //click on view cart button
    public void click_view_cart_button() {
        clicking(driver, view_cart_button);
    }

    public boolean product1_image() {
        WebElement product1_image_element = findWebElement(driver, product1_image_view_cart);
        WebElement product1_des_element = findWebElement(driver, product1_description_view_cart);
        return isImageOrDescriptionRelatedToSearchKey(product1_image_element, product1_des_element, getJsonData("product_data", "search_key"));
    }

    //get text from product1_description
    public String get_description_from_product1() {
        return getText(driver, product1_description_view_cart);
    }

    //get text from product1 price
    public String get_price_from_product1() {
        return getText(driver, product1_price_view_cart);
    }

    //get text from product1 quantity
    public String get_quantity_from_product1() {
        return getText(driver, product1_quantity_view_cart);
    }

    //get text from product1 total
    public String get_total_from_product1() {
        return getText(driver, product1_total_price_view_cart);
    }

}

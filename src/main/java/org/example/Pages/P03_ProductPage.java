package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

import static org.example.Utilities.utility.*;

public class P03_ProductPage {

    WebDriver driver;

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

    //to click on product button
    public void click_on_product_button()
    {
        clicking(driver,product_button);
    }

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

}

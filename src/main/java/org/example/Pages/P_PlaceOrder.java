package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.Utilities.utility.*;

public class P_PlaceOrder {

    WebDriver driver;

    public P_PlaceOrder(WebDriver driver)
    {
        this.driver=driver;
    }

    private final By product_no_4= By.xpath("//a[@data-product-id=\"4\"]");
    private final By view_cart=By.xpath("//p[@class=\"text-center\"]/a/u");
    private final By shopping_cart_txt=By.xpath("//div[@class=\"breadcrumbs\"]/ol/li[2][@class=\"active\"]");
    private final By proceed_to_checkout=By.xpath("//section[@id=\"do_action\"]/div/div/div/a");
    private final By checkout_Register_Login=By.xpath("//div[@class=\"modal-body\"]/p[2]/a");

    public void cart_Page_Displayed()
    {
        clicking(driver,product_no_4);
        clicking(driver,view_cart);
        String get_shopping_cart_txt=getText(driver,shopping_cart_txt);
        String shopping=get_shopping_cart_txt.split(" ")[0];
        String cart=get_shopping_cart_txt.split(" ")[1];
        System.out.println("my text is :"+cart);
        System.out.println("my text is :"+shopping);
        try {
            writeToFile(shopping,"product_data.json");
            writeToFile(cart,"product_data.txt");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void checkout_signup()
    {
        clicking(driver,proceed_to_checkout);
        clicking(driver,checkout_Register_Login);
    }



}

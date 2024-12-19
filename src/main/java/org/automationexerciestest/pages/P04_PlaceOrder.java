package org.automationexerciestest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.automationexerciestest.Utilities.Utility.*;

public class P04_PlaceOrder {

    WebDriver driver;

    public P04_PlaceOrder(WebDriver driver) {
        this.driver = driver;
    }

    private final By add_to_cart_button = By.xpath("//a[@data-product-id=\"4\"]");
    private final By view_cart_link = By.xpath("//p[@class=\"text-center\"]/a/u");
    private final By shopping_cart_text = By.xpath("//div[@class=\"breadcrumbs\"]/ol/li[2][@class=\"active\"]");
    private final By proceed_to_checkout_button = By.xpath("//section[@id=\"do_action\"]/div/div/div/a");
    private final By checkout_Register_Login_button = By.xpath("//div[@class=\"modal-body\"]/p[2]/a");
    private final By cart_button=By.xpath("//div[2]//div//ul//li[3]//a[@href=\"/view_cart\"]");
    private final By comment_textarea_input_text =By.xpath("//div[@id=\"ordermsg\"]//textarea");

    private final By address_details_text=By.xpath("//*[@id=\"cart_items\"]//div//div[2]//h2");
    private final By place_order_button=By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    private final By payment_text=By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2");
    private final By name_on_card_text_field=By.xpath("//*[@name=\"name_on_card\"]");
    private final By card_number_text_field=By.xpath("//*[@class=\"form-control card-number\"]");
    private final By card_cvc_text_field=By.xpath("//*[@class=\"form-control card-cvc\"]");
    private final By card_expiry_month_text_field=By.xpath("//*[@class=\"form-control card-expiry-month\"]");
    private final By card_expiry_year_text_field=By.xpath("//*[@class=\"form-control card-expiry-year\"]");
    private final By pay_confirm_order_button=By.xpath("//*[@class=\"form-control btn btn-primary submit-button\"]");

    public void add_Product_To_Cart() {
        //Add products to cart
        clicking(driver, add_to_cart_button);

        //Click 'Cart' button
        clicking(driver, view_cart_link);
    }

    public String proceed_To_Checkout_ShoppingCart() {
        String get_shopping_cart_txt = getText(driver, shopping_cart_text);
        String shopping = get_shopping_cart_txt.split(" ")[0];
        System.out.println("my text is :" + shopping);
        String cart = get_shopping_cart_txt.split(" ")[1];
        System.out.println("my text is :" + cart);

        try {
            writeToFile(shopping, "product_data.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shopping + cart;
    }

    public void proceed_To_Checkout() {

        //Click Proceed To Checkout
        clicking(driver, proceed_to_checkout_button);
    }

    public void proceed_To_RegisterLogin() {

    //Click 'Register / Login' button
    clicking(driver, checkout_Register_Login_button);
}

public void click_Cart_Button()
{
    clicking(driver,cart_button);
}
public String check_AddressDetails_Text()
{
    return getText(driver,address_details_text);
}
public void write_On_Textarea(String data)
{
    sendData(driver, comment_textarea_input_text,data);
}
public void press_Place_Order_Button()
{
    clicking(driver,place_order_button);
}
}

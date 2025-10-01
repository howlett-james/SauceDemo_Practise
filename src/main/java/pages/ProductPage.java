package pages;

import base.DriverFactory;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class ProductPage {

    private WebDriver driver;
    private By productTitle = By.cssSelector(".inventory_details_name");
    private By productPrice = By.cssSelector(".inventory_details_price");
    private By btn = By.cssSelector(".btn_inventory");
    private By cart = By.id("shopping_cart_container");
    private By cartCount = By.cssSelector(".shopping_cart_badge");
    private By cartItemName = By.cssSelector(".inventory_item_name");
    private By cartItemPrice = By.cssSelector(".inventory_item_price");

    public ProductPage() {
        this.driver = DriverFactory.getDriver();
    }

    public ProductPage addToCart(){
        if(!Waits.waitForVisibility(driver,btn).getText().equals("REMOVE")){
            Waits.waitForClickability(driver,btn).click();
        }
        return this;
    }
    public ProductPage navigateToCart(){
        if(Waits.isVisible(driver,cartCount)){
            Waits.waitForClickability(driver,cart).click();
        }
        return this;
    }
}


package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import models.Product;
import utils.Waits;

import java.util.Random;

public class CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.cssSelector(".btn_action.checkout_button");
    private final By subheader = By.cssSelector(".subheader");
    private final By firstName = By.cssSelector("#first-name");
    private final By lastName = By.cssSelector("#last-name");
    private final By postalCode = By.cssSelector("#postal-code");
    private final By continueBtn = By.cssSelector(".btn_primary.cart_button");
    private final By pName = By.cssSelector(".inventory_item_name");
    private final By pPrice = By.cssSelector(".inventory_item_price");
    private final By finishBtn = By.cssSelector(".btn_action.cart_button");
    private final By orderHeader = By.cssSelector(".complete-header");
    private final By orderMsg = By.cssSelector(".complete-text");

    public CartPage() {
        this.driver = DriverFactory.getDriver();
    }

    public CartPage productCheckout() {
        if(Waits.isClickable(driver, checkoutButton)){
            Waits.waitForClickability(driver, checkoutButton).click();
        }
        return this;
    }

    public CartPage proceedCheckout(){
        if(Waits.isVisible(driver,subheader)){
            Waits.waitForVisibility(driver,firstName).sendKeys(new Faker().name().firstName());
            Waits.waitForVisibility(driver,lastName).sendKeys(new Faker().name().lastName());
            Waits.waitForVisibility(driver,postalCode).sendKeys(new Faker().numerify("######"));
        }
        if(Waits.isVisible(driver,continueBtn) && Waits.isClickable(driver,continueBtn)){
            Waits.waitForClickability(driver,continueBtn).click();
        }
        return this;
    }

    public CartPage confirmOrder(){
        try {
            if(Waits.isClickable(driver,finishBtn)){
                Waits.waitForClickability(driver,finishBtn).click();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public Product getCartItemDetails() {
        String name = Waits.waitForVisibility(driver,pName).getText();
        String price = Waits.waitForVisibility(driver,pPrice).getText();
        return new Product(name, price);
    }

    public String getOrderHeader(){
        return Waits.waitForVisibility(driver,orderHeader).getText();
    }
}

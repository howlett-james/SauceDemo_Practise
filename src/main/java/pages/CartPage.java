package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import models.Product;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

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

    private final Faker faker = new Faker();

    public CartPage() {
        this.driver = DriverFactory.getDriver();
        if (this.driver == null) throw new IllegalStateException("WebDriver is null");
    }

    public CartPage productCheckout() {
        if(Waits.isClickable(driver, checkoutButton)){
            Waits.waitForClickability(driver, checkoutButton).click();
        }
        return this;
    }

    public CartPage proceedCheckout(){
        if(Waits.isVisible(driver,subheader)){
            Waits.waitForVisibility(driver,firstName).sendKeys(faker.name().firstName());
            Waits.waitForVisibility(driver,lastName).sendKeys(faker.name().lastName());
            Waits.waitForVisibility(driver,postalCode).sendKeys(faker.numerify("######"));
        }
        if(Waits.isVisible(driver,continueBtn) && Waits.isClickable(driver,continueBtn)){
            Waits.waitForClickability(driver,continueBtn).click();
        }
        return this;
    }

    public CartPage confirmOrder(){
        if(Waits.isClickable(driver,finishBtn)){
            Waits.waitForClickability(driver,finishBtn).click();
        }
        return this;
    }

    public Product getCartItemDetails() {
        String name = Waits.waitForVisibility(driver,pName).getText();
        String price = Waits.waitForVisibility(driver,pPrice).getText();
        return new Product(name, price);
    }

    public List<Product> getAllCartItems() {
        List<WebElement> names = driver.findElements(pName);
        List<WebElement> prices = driver.findElements(pPrice);
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            products.add(new Product(names.get(i).getText(), prices.get(i).getText()));
        }
        return products;
    }


    public String getOrderHeader(){
        return Waits.waitForVisibility(driver,orderHeader).getText();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import models.Product;
import utils.Waits;

public class CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.className("btn_action checkout_button");

    public CartPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void clickCheckout() {
        if(Waits.isVisible(driver, checkoutButton) && verifyProduct()){
            Waits.waitForClickability(driver, checkoutButton).click();
        }
    }

    public static boolean verifyProduct() {
        Product actual = new ProductPage().getProductDetails();
        Product expected = new ProductSelection(null, actual).getSelectedProduct();
        boolean isNameMatching = actual.getName().equals(expected.getName());
        boolean isPriceMatching = actual.getPrice().equals(expected.getPrice());
        return isNameMatching && isPriceMatching;
    }
}

package TestScrips;

import Assertions.ProductPageAsserts;
import Constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import utils.TestContext;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUpTest(){
        loginPage = new LoginPage();
        cartPage = new CartPage();
    }

    @Test(priority = 2)
    public void testRandomProduct(){
        loginPage.enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLoginToInventory()
                .clickAnItem()
                .addToCart()
                .navigateToCart();
        ProductPageAsserts.verifyProduct(cartPage.getCartItemDetails());
        cartPage.productCheckout()
                .proceedCheckout()
                .confirmOrder();
        TestContext.clear();
        Assert.assertEquals(cartPage.getOrderHeader(),FrameworkConstants.orderHeader);
    }

    @Test(priority = 3)
    public void testRandomProducts(){
        loginPage.enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLoginToInventory()
                .addMultipleItems()
                .navigateToCart();
        ProductPageAsserts.verifyAllProducts(cartPage.getAllCartItems());
        cartPage.productCheckout()
                .proceedCheckout()
                .confirmOrder();
        TestContext.clear();
        Assert.assertEquals(cartPage.getOrderHeader(),FrameworkConstants.orderHeader);
    }
}

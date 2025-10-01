package TestScrips;

import Assertions.ProductPageAsserts;
import Constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import utils.TestContext;

public class ProductTest extends BaseTest {

    @Test
    public void testRandomProduct(){
        new LoginPage()
                .enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLoginToInventory()
                .clickAnItem()
                .addToCart()
                .navigateToCart();
        ProductPageAsserts.verifyProduct(new CartPage().getCartItemDetails());
        new CartPage()
                .productCheckout()
                .proceedCheckout()
                .confirmOrder();
        TestContext.clear();
        Assert.assertEquals(new CartPage().getOrderHeader(),FrameworkConstants.orderHeader);
    }
}

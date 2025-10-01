package TestScrips;

import Assertions.ProductPageAsserts;
import Constants.FrameworkConstants;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductSelection;

public class ProductTest extends BaseTest {

    @Test
    public void testRandomProduct(){
        ProductSelection selection = new LoginPage()
                .enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLoginToInventory()
                .clickAnItem();
        ProductPageAsserts.verifyProduct(
                selection.getProductPage().getProductDetails(),
                selection.getSelectedProduct()
        );
        selection.getProductPage()
                        .addToCart()
                                .navigateToCart();
        ProductPageAsserts.verifyProduct(
                selection.getProductPage().getCartItemDetails(),
                selection.getSelectedProduct()
        );
        new CartPage().clickCheckout();
    }
}

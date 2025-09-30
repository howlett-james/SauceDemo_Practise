package TestScrips;

import Assertions.ProductPageAsserts;
import Constants.FrameworkConstants;
import models.Product;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductSelection;

public class ProductTest extends BaseTest {

    @Test(priority = 0)
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
    }
}

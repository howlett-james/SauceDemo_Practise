package Assertions;

import models.Product;
import org.testng.Assert;
import utils.TestContext;
import java.util.List;

public class ProductPageAsserts {

    public static void verifyProduct(Product actual) {
        Product expected = TestContext.getSelectedProducts().get(0);
        Assert.assertEquals(actual.getName(), expected.getName(), "Product name mismatch!");
        Assert.assertEquals(actual.getPrice(), expected.getPrice(), "Product price mismatch!");
    }

    public static void verifyAllProducts(List<Product> actualProducts) {
        List<Product> expectedProducts = TestContext.getSelectedProducts();
        Assert.assertEquals(actualProducts.size(), expectedProducts.size(),
                "Product count mismatch!");

        for (int i = 0; i < expectedProducts.size(); i++) {
            Product expected = expectedProducts.get(i);
            Product actual = actualProducts.get(i);
            Assert.assertEquals(actual.getName(), expected.getName(), "Product name mismatch at index " + i);
            Assert.assertEquals(actual.getPrice(), expected.getPrice(), "Product price mismatch at index " + i);
        }
    }
}

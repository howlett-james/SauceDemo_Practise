package Assertions;

import models.Product;
import org.testng.Assert;

public class ProductPageAsserts {
    public static void verifyProduct(Product actual, Product expected) {
        Assert.assertEquals(actual.getName(), expected.getName(), "Product name mismatch!");
        Assert.assertEquals(actual.getPrice(), expected.getPrice(), "Product price mismatch!");
    }
}

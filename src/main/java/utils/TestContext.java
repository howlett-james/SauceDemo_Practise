package utils;

import models.Product;

public class TestContext {
    private static final ThreadLocal<Product> selectedProduct = new ThreadLocal<>();

    public static void setSelectedProduct(Product product) {
        selectedProduct.set(product);
    }

    public static Product getSelectedProduct() {
        return selectedProduct.get();
    }

    public static void clear() {
        selectedProduct.remove();
    }
}

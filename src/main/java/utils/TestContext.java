package utils;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class TestContext {

    private static final ThreadLocal<List<Product>> selectedProducts =
            ThreadLocal.withInitial(ArrayList::new);

    public static void setSelectedProduct(Product product) {
        selectedProducts.get().add(product);
    }

    public static void setSelectedProducts(List<Product> products) {
        selectedProducts.get().addAll(products);
    }

    public static List<Product> getSelectedProducts() {
        return selectedProducts.get();
    }

    public static void clear() {
        selectedProducts.get().clear();
    }
}

package pages;

import models.Product;

public class ProductSelection {
    private final ProductPage productPage;
    private final Product selectedProduct;

    public ProductSelection(ProductPage productPage, Product selectedProduct) {
        this.productPage = productPage;
        this.selectedProduct = selectedProduct;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }
}

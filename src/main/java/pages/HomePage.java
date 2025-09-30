package pages;

import base.DriverFactory;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HomePage {
    private final WebDriver driver;
    private final By inventoryLists = By.cssSelector(".inventory_list .inventory_item");

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isInventoryPageOpened() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public ProductSelection clickAnItem() {
        List<WebElement> items = driver.findElements(inventoryLists);
        WebElement randomItem = items.get(new Random().nextInt(items.size()));

        String name = randomItem.findElement(By.className("inventory_item_name")).getText();
        String price = randomItem.findElement(By.className("inventory_item_price")).getText();

        randomItem.findElement(By.className("inventory_item_name")).click();

        Product selectedProduct = new Product(name, price);
        ProductPage productPage = new ProductPage();

        return new ProductSelection(productPage, selectedProduct);
    }
}

package pages;

import base.DriverFactory;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestContext;
import utils.Waits;

import java.util.*;

public class HomePage {
    private final WebDriver driver;
    private static final Random random = new Random();
    private final By inventoryLists = By.cssSelector(".inventory_list .inventory_item");
    private final By pName = By.className("inventory_item_name");
    private final By pPrice = By.className("inventory_item_price");
    private final By addToCart = By.cssSelector(".btn_primary.btn_inventory");

    public HomePage() {
        this.driver = DriverFactory.getDriver();
        if (this.driver == null) throw new IllegalStateException("WebDriver is null");
    }

    public boolean isInventoryPageOpened() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public ProductPage clickAnItem() {
        List<WebElement> items = Waits.waitForVisibilityOfAllElements(driver, inventoryLists);
        if (items.isEmpty()) throw new IllegalStateException("No inventory items found!");
        WebElement randomItem = items.get(random.nextInt(items.size()));

        String name = randomItem.findElement(pName).getText();
        String price = randomItem.findElement(pPrice).getText();

        randomItem.findElement(pName).click();

        TestContext.setSelectedProduct(new Product(name, price));

        return new ProductPage();
    }

    public ProductPage addMultipleItems() {
        List<WebElement> items = Waits.waitForVisibilityOfAllElements(driver, inventoryLists);
        if (items.isEmpty()) throw new IllegalStateException("No inventory items found!");
        int[] arr = (items.size() > 1)
                ? random.ints(0, items.size())
                .distinct()
                .limit(Math.max(2, random.nextInt(items.size())))
                .toArray()
                : new int[0];
        List<Product> products = new ArrayList<>();

        for (int i : arr) {
            WebElement randomItem = items.get(arr[i]);
            String name = randomItem.findElement(pName).getText();
            String price = randomItem.findElement(pPrice).getText();
            products.add(new Product(name, price));
            randomItem.findElement(addToCart).click();
        }
        TestContext.setSelectedProducts(products);
        return new ProductPage();
    }
    /*public ProductPage clickMultipleItems() {
        List<WebElement> items = Waits.waitForVisibilityOfAllElements(driver, inventoryLists);
        if (items.isEmpty()) throw new IllegalStateException("No inventory items found!");
        List<Product> products = new ArrayList<>();

        int size = items.size();
        if (size < 2) throw new IllegalStateException("Need at least 2 items to add!");

        Set<Integer> selectedIndexes = new HashSet<>();//{4,5,2,1}
        while (selectedIndexes.size() < 2) {
            selectedIndexes.add(random.nextInt(size));
        }

        for (int index : selectedIndexes) {
            WebElement item = items.get(index);
            String name = item.findElement(pName).getText();
            String price = item.findElement(pPrice).getText();
            products.add(new Product(name, price));
            item.findElement(addToCart).click();
            System.out.println("Added: " + name + " | Price: " + price);
        }
        TestContext.setSelectedProducts(products);
        return new ProductPage();
    }*/
}

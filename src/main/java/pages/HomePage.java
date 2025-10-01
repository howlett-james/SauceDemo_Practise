package pages;

import base.DriverFactory;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestContext;
import utils.Waits;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HomePage {
    private final WebDriver driver;
    private final By inventoryLists = By.cssSelector(".inventory_list .inventory_item");
    private final By pName = By.className("inventory_item_name");
    private final By pPrice = By.className("inventory_item_price");

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isInventoryPageOpened() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public ProductPage clickAnItem() {
        List<WebElement> items = Collections.singletonList(Waits.waitForVisibility(driver, inventoryLists));
        WebElement randomItem = items.get(new Random().nextInt(items.size()));

        String name = randomItem.findElement(pName).getText();
        String price = randomItem.findElement(pPrice).getText();

        randomItem.findElement(pName).click();

        TestContext.setSelectedProduct(new Product(name, price));

        return new ProductPage();
    }
}

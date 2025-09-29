package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.DriverFactory;

public class Product {

    private final WebDriver driver;

    public Product() {
        this.driver = DriverFactory.getDriver();
    }

    public String AddToCart() {

        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
    }
}

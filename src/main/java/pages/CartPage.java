package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    public CartPage(){
        this.driver = DriverFactory.getDriver();
    }

    public void ShoppingCart(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();

    }
    public void checkOut(){
        driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
    }
    public void FirstName(){
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("john");
    }
    public void Lastname(){
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("s");
    }
    public void PostalCode(){
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("624000");
    }
    public void Continue(){
        driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
    }
    public void Finish(){
        driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
    }
}

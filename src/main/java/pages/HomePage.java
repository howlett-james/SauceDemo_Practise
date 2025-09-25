package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HomePage {
    private final WebDriver driver;

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isInventoryPageOpened() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory");
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

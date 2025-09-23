package base;

import org.openqa.selenium.WebDriver;

import Constants.FrameworkConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.initDriver(FrameworkConstants.CHROME);
        driver.get(FrameworkConstants.SAUCEDEMO_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

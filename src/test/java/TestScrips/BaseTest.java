package TestScrips;

import base.DriverFactory;

import Constants.FrameworkConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(String browser, boolean headless) {
        DriverFactory.initDriver(browser,headless);
        DriverFactory.getDriver().get(FrameworkConstants.URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

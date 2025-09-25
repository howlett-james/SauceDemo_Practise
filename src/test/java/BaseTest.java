import base.DriverFactory;

import Constants.FrameworkConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver(FrameworkConstants.BROWSER);
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(FrameworkConstants.URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

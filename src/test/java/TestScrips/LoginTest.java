package TestScrips;

import Constants.ErrorMessages;
import Constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test (priority = 0, description = "Positive test: login with valid credentials")
    public void testValidLogin() {
        new LoginPage()
                .enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLogin();
        Assert.assertTrue(new HomePage().isInventoryPageOpened(),
                "Login failed: Inventory page not opened.");
        Assert.assertEquals(new HomePage().getTitle(),FrameworkConstants.TITLE);
    }

    @Test (priority = 1, description = "Positive test: login with valid random credentials")
    public void testValidLoginWithRandom() {
        new LoginPage()
                .enterUsername(new LoginPage().getRandomCredential())
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLogin();
        Assert.assertTrue(new HomePage().isInventoryPageOpened(),
                "Login failed: Inventory page not opened.");
        Assert.assertEquals(new HomePage().getTitle(),FrameworkConstants.TITLE);
    }

    @Test(priority = 2, description = "Negative test: login with blank")
    public void testInvalidLogin_BlankCredentials() {
        new LoginPage()
                .enterUsername("")
                .enterPassword("")
                .clickLoginExpectingFailure();
        Assert.assertEquals(new LoginPage().getErrorMessage(), ErrorMessages.EMPTY_USERNAME, "Error message mismatch!");
    }
}

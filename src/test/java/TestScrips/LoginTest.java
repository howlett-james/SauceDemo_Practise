package TestScrips;

import Constants.ErrorMessages;
import Constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpTest(){
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test (priority = 0, description = "Positive test: login with valid credentials")
    public void testValidLogin() {
        loginPage
                .enterUsername(FrameworkConstants.USERNAME)
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLogin();
        Assert.assertTrue(homePage.isInventoryPageOpened(),
                "Login failed: Inventory page not opened.");
        Assert.assertEquals(homePage.getTitle(),FrameworkConstants.TITLE);
    }

    @Test (priority = 1, description = "Positive test: login with valid random credentials")
    public void testValidLoginWithRandom() {
        loginPage
                .enterUsername(loginPage.getRandomCredential())
                .enterPassword(FrameworkConstants.PASSWORD)
                .clickLogin();
        Assert.assertTrue(homePage.isInventoryPageOpened(),
                "Login failed: Inventory page not opened.");
        Assert.assertEquals(homePage.getTitle(),FrameworkConstants.TITLE);
    }

    @Test(priority = 2, description = "Negative test: login with blank")
    public void testInvalidLogin_BlankCredentials() {
        loginPage
                .enterUsername("")
                .enterPassword("")
                .clickLoginExpectingFailure();
        Assert.assertEquals(loginPage.getErrorMessage(), ErrorMessages.EMPTY_USERNAME, "Error message mismatch!");
    }
}

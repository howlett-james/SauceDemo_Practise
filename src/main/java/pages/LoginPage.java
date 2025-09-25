package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.name("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    public LoginPage enterUsername(String uname) {
        Waits.waitForVisibility(driver, usernameField).sendKeys(uname);
        return this;
    }

    public LoginPage enterPassword(String pwd) {
        Waits.waitForVisibility(driver, passwordField).sendKeys(pwd);
        return this;
    }

    public void clickLogin() {
        Waits.waitForClickability(driver, loginButton).click();
    }

    public String getErrorMessage() {
        return Waits.waitForVisibility(driver, errorMessage).getText();
    }

    public void clickLoginExpectingFailure() {
        driver.findElement(loginButton).click();
    }
}

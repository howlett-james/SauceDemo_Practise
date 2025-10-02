package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoginPage {

    private final WebDriver driver;
    private static final Random random = new Random();

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.name("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By loginCreds = By.id("login_credentials");

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        if (this.driver == null) throw new IllegalStateException("WebDriver is null");
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

    public HomePage clickLoginToInventory(){
        clickLogin();
        return new HomePage();
    }

    public String getErrorMessage() {
        return Waits.waitForVisibility(driver, errorMessage).getText();
    }

    public void clickLoginExpectingFailure() {
        Waits.waitForClickability(driver,loginButton).click();
    }

    public List<String> getCredentials(){
        return Arrays.stream(driver.findElement(loginCreds).getText()
                        .split("\\r?\\n"))
                .skip(1)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    public String getRandomCredential() {
        List<String> creds = getCredentials();
        return creds.get(random.nextInt(creds.size())); // pick random index
    }
}

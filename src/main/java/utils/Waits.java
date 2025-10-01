package utils;

import Constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickability(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public static boolean isVisible(WebDriver driver, By locator){
        try {
            waitForVisibility(driver,locator);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean isClickable(WebDriver driver,By locator){
        try {
            waitForClickability(driver,locator);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
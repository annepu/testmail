package mailTravel.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Helpers extends TestBase {

    public static final int DEFAULT_TIMEOUT_SECONDS = 15;

    public static void shortWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement (By by){
        var webDriverWait = new WebDriverWait(driver, 10);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static Boolean isElementDisplayed(WebDriver driver, By locator) {
        Helpers.waitForPageToLoad();
        WebElement element = driver.findElement(locator);
        return element.isDisplayed() && element.isEnabled();
    }

    public static void waitFor(WebDriver driver, ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public static void fluentWait(WebDriver driver, ExpectedCondition<WebElement> condition, int timeoutMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        wait.until(condition);
    }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }

    public static Boolean waitForIsDisplayed(WebDriver driver, By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (TimeoutException exception) {
           log.debug("Could not find the expected element");
            return false;
        }
        return true;
    }

    public static void scrollIntoView(WebDriver driver, By locator) {
        Helpers.waitForIsDisplayed(driver, locator,DEFAULT_TIMEOUT_SECONDS);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void clearAndSetText(WebDriver driver, WebElement element, String text) {
        element.clear();
        shortWait(1000);
        element.sendKeys(text);
    }

    public static void selectFromDropDown(WebDriver driver, By selector, int value) {
        try {
            Select dropdown = new Select(driver.findElement(selector));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            dropdown.selectByIndex(value);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToBottomOfPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public static void scrollToTopOfPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-document.body.scrollHeight);");
    }

    public static String executeJavascript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String result = (String) js.executeScript(script);
        if (result != null && !result.equals("undefined")) {
            return result;
        }
        return null;
    }

    public static void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


}

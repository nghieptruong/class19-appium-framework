package pages;

import constants.ConstantTimeout;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitVisibilityOfElementLocated(By locator, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElementLocated(By locator) {
        return waitVisibilityOfElementLocated(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public WebElement waitVisibilityOfElementLocated(WebElement element, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitClickable(By locator, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitClickable(WebElement element, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitInvisibilityOfElemementLocated(By locator, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitInvisibilityOfElemementLocated(By locator) {
        return waitInvisibilityOfElemementLocated(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public WebElement waitClickable(By locator) {
        return waitClickable(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void sendKeys(By locator, String value, long timeout) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeout);
        element.sendKeys(value);
    }

    public void sendKeys(By locator, String value) {
        sendKeys(locator, value, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void sendKeys(WebElement element, String value, long timeout) {
        WebElement expectedElement = waitVisibilityOfElementLocated(element, timeout);
        expectedElement.sendKeys(value);
    }

    public void sendKeys(WebElement element, String value) {
        sendKeys(element, value, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void click(By locator, long timeout) {
        WebElement element = waitClickable(locator, timeout);
        element.click();
    }

    public void click(By locator) {
        click(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void click(WebElement element, long timeout) {
        WebElement expectedElement = waitClickable(element, timeout);
        expectedElement.click();
    }

    public void click(WebElement element) {
        click(element, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public String getText(By locator, long timeout) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeout);
        return element.getText();
    }

    public String getText(By locator) {
        return getText(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public String getText(WebElement element, long timeout) {
        WebElement expectedElement = waitVisibilityOfElementLocated(element, timeout);
        return expectedElement.getText();
    }

    public String getText(WebElement element) {
        return getText(element, ConstantTimeout.DEFAULT_TIMEOUT);
    }
}

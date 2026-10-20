package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonPage {

    @AndroidFindBy(accessibility = "title")
    private WebElement title;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return getText(title).equals("Products");
    }
}

package pages.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class TopNavigationBar extends BasePage {

    @AndroidFindBy(accessibility = "View menu")
    private WebElement menu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenuItem;

    @AndroidFindBy(accessibility = "Logout Menu Item")
    private WebElement logoutMenuItem;

    public TopNavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        click(menu);
    }

    public void goToLogin() {
        clickMenu();
        click(loginMenuItem);
    }

    public boolean isLogoutItemDisplayed() {
        clickMenu();
        return logoutMenuItem.isDisplayed();
    }
}

package pages.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class TopNavigationBar extends BasePage {

    @iOSXCUITFindBy(accessibility = "More-tab-item")
    @AndroidFindBy(accessibility = "View menu")
    private WebElement menu;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenuItem;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
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

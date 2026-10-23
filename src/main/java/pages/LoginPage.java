package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonPage {

    //Thuoc tinh (private)
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement txtUserLogin;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement txtPasswordLogin;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Login\" AND label == \"Login\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Phuong thuc (method)
    public void enterAccount(String account) {
        sendKeys(txtUserLogin, account);
    }

    public void enterPassword(String password) {
        sendKeys(txtPasswordLogin, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    //High level action (Business action)
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}

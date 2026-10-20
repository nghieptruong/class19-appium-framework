package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonPage {

    //Thuoc tinh (private)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement txtUserLogin;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement txtPasswordLogin;

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

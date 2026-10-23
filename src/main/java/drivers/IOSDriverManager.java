package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        String udid = ConfigManager.getProperty("ios.udid");

        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("ios");
        options.setAutomationName("XCUITest");
        options.setUdid(udid);
        options.setBundleId("com.saucelabs.mydemo.app.ios");

        URL appiumServer = null;
        try {
            appiumServer = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        this.driver = new IOSDriver(appiumServer, options);
    }
}

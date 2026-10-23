package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        String udid = ConfigManager.getProperty("android.udid");
        String androidVersion = ConfigManager.getProperty("android.platformVersion");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid(udid);
        options.setPlatformVersion(androidVersion);
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        URL appiumServer = null;
        try {
            appiumServer = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.driver = new AndroidDriver(appiumServer, options);
    }
}

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoIOSApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("ios");
        options.setAutomationName("XCUITest");
        options.setUdid("87F8DA42-F0F6-4C6F-85C9-84646D59A10B");
        options.setBundleId("com.saucelabs.mydemo.app.ios");

        URL appiumServer = new URL("http://127.0.0.1:4723/");
        IOSDriver driver = new IOSDriver(appiumServer, options);

        Thread.sleep(3000);

    }
}

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("emulator-5554");
        options.setPlatformVersion("15");
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        URL appiumServer = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(appiumServer, options);

        Thread.sleep(3000);

    }
}

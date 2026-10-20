package drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String platform) {
        switch(platform.toLowerCase()) {
            case "android":
                return new AndroidDriverManager();
            case "ios":
                return new IOSDriverManager();
            default:
                return null;
        }
    }
}

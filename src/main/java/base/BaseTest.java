package base;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;
import utils.ConfigManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected Logger logger = LogManager.getLogger(getClass());
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Before suite executing...");
        ConfigManager.loadProperties();
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeTest
    public void beforeTest() {
        logger.info("Before test executing...");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Before method executing...");
        ExtentReportManager.createTest(method.getName());
        String platform = ConfigManager.getProperty("platform");
        DriverManager driverManager = DriverManagerFactory.getDriverManager(platform);
        driverManager.createDriver();
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.info("After method executing...");
        if(result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(driver, result.getTestName());
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        logger.info("After test executing...");
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("After suite executing...");
        ExtentReportManager.flushReports();
    }
}

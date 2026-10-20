package testcases;

import base.BaseTest;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import reports.ExtentReportManager;

public class TC02_Login extends BaseTest {

    @Test
    public void TC02_Verify_Login_Successfully() {

        String account = "bod@example.com";
        String password = "123456";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Pre-condition: User is at Login page (navigate to Login page)
        logger.info("Pre-condition: User is at Login page (navigate to Login page)");
        ExtentReportManager.info("Pre-condition: User is at Login page (navigate to Login page)");
        homePage.getTopNavigationBar().goToLogin();

        //Step 1. Enter user login
        logger.info("Step 1. Enter user login");
        ExtentReportManager.info("Step 1. Enter user login");
        loginPage.enterAccount(account);

        //Step 2. Enter password login
        logger.info("Step 2. Enter password login");
        ExtentReportManager.info("Step 2. Enter password login");
        loginPage.enterPassword(password);

        //Step 3. Click 'Dang Nhap'
        logger.info("Step 3. Click 'Dang Nhap'");
        ExtentReportManager.info("Step 3. Click 'Dang Nhap'");
        loginPage.clickLogin();

        //Step 4: Verify login successfully
        logger.info("Step 4: Verify login successfully");
        ExtentReportManager.info("Step 4: Verify login successfully");

        //VP: Verify user is take to Home Page
        logger.info("VP: Verify user is take to Home Page");
        ExtentReportManager.info("VP: Verify user is take to Home Page");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page not displayed !");

        //VP: Logout menu displays
        logger.info("VP: Verify Logout menu displays");
        ExtentReportManager.info("VP: Verify Logout menu displays");
        Assert.assertTrue(homePage.getTopNavigationBar().isLogoutItemDisplayed(), "Logout not displayed !");


    }

}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtil;

public class LaunchGPNTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://ntc.alfadock-pro.com/#/userlogin");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.selectLanguage("English");
        Thread.sleep(2000);
        ScreenshotUtil.takeScreenshot(driver, "Launch Test Server");

        loginPage.companyLogin("schedule-test", "schedule-test");
        System.out.println("Company Login Successful");
        ScreenshotUtil.takeScreenshot(driver, "Company Login Successful");
        Thread.sleep(2000);

        loginPage.userLogin("admin", "admin");
        System.out.println("User Login Successful");
        ScreenshotUtil.takeScreenshot(driver, "User Login Successful");
        Thread.sleep(2000);

        HomePage homePage = new HomePage(driver);
        homePage.clickSoftwareLibrary();
        Thread.sleep(10000);
        homePage.clickGPNLink();
        Thread.sleep(2000);

        GPNPage gpnPage = new GPNPage(driver);
        if (!gpnPage.switchToNewTab()) {
            System.out.println("New tab did not open.");
            driver.quit();
            return;
        }

        double loadTime = gpnPage.measurePageLoadTime();
        System.out.println("Switched to new tab");
        System.out.println("Page Load Time: " + loadTime + " Seconds");

        if (gpnPage.verifyTitle("SI Scheduler1")) {
            System.out.println("Title matched! GPN is Displayed Properly");
        } else {
            System.out.println("Title mismatch! GPN not displayed properly.");
        }
        
        Thread.sleep(5000);

        gpnPage.clickHomeIcon();
        Thread.sleep(5000);

        if (gpnPage.verifyTitle("alfaDOCK")) {
            System.out.println("Title matched! alfaDOCK is Displayed Properly");
        } else {
            System.out.println("Title mismatch! alfaDOCK not displayed properly.");
        }

        driver.quit();
    }
}

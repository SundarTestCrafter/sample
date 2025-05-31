package base.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    // ThreadLocal to ensure thread-safety when running tests in parallel
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    
    // Method to set WebDriver
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);  // Set the WebDriver instance to the ThreadLocal variable
    }

    // Method to get WebDriver
    public static WebDriver getDriver() {
        return driver.get();  // Return the WebDriver instance for the current thread
    }

    // Method to set ExtentTest
    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    // Method to get ExtentTest
    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }
}

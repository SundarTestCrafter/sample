package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentReportManager.getReportInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    // 🔧 Set ExtentTest in BasePage
    // Initialize ExtentTest properly
       //ExtentTest test = ExtentReportManager.getReportInstance().createTest("LoginTest");
      // BasePage.setExtentTest(test);

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        BasePage.extentTest.set(extentTest);  // <-- Set the reference here
    }


    @Override
    public void onTestSuccess(ITestResult result) {
    	WebDriver driver = BasePage.getDriver();
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
        test.get().pass("Test passed");
        ExtentTest extentTest = BasePage.extentTest.get();
        extentTest.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BasePage.getDriver();
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());

        ExtentTest extentTest = BasePage.extentTest.get();
        extentTest.fail(result.getThrowable()); // Log exception
        extentTest.addScreenCaptureFromPath(screenshotPath); // Attach image here
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Write all to report
    }
}

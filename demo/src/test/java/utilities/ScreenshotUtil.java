package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String cleanName = screenshotName.replaceAll("[^a-zA-Z0-9]", "_");
	    String fileName = cleanName + "_" + timestamp + ".png";

	    // Folder: test-output/screenshots/
	    String folderPath = System.getProperty("user.dir") + "/test-output/screenshots/";
	    File dir = new File(folderPath);
	    if (!dir.exists()) {
	        dir.mkdirs(); // Create folder if not exists
	    }

	    String fullPath = folderPath + fileName;
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(screenshot, new File(fullPath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Return relative path for ExtentReports (for HTML preview)
	    return "./screenshots/" + fileName;
	}
}

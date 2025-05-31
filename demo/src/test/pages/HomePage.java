package base.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    WebDriver driver;

    public GPNPage(WebDriver driver) {
    	super(driver);
    	this.driver = driver;
    }

    public boolean switchToNewTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() < 2) return false;
        driver.switchTo().window(tabs.get(1));
        return true;
    }
    
    public boolean switchToNewTab1() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() < 3) return false;
        driver.switchTo().window(tabs.get(2));
        return true;
    }
    
    public boolean switchToNewTab2() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() < 3) return false;
        driver.switchTo().window(tabs.get(1));
        return true;
    }

    public double measurePageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(driver.getCurrentUrl());
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;
    }

    public boolean verifyTitle(String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }

    public void clickHomeIcon() throws InterruptedException {
    	By locator = By.xpath("//div[@id='ToolBarDiv']//app-ui-titlebar//span/span[1]");
    	WebElement homeIcon = waitForClickability(locator);
    	homeIcon.click();
    }
    
    public void clickSettingIcon() {
    	By locator = By.xpath("//div[@id='ToolBarDiv']//ul/li[2]/a");
    	WebElement settingIcon = waitForClickability(locator);
    	settingIcon.click();
    }
    
    public void clickAIReports() {
    	By locator = By.xpath("//div[@id='ToolBarDiv']//ul/li[4]/a");
    	WebElement aiReports = waitForClickability(locator);
    	aiReports.click();
    }
    
    public void clickProcessFilterIcon() {
    	By locator = By.xpath("//div[@id='ToolBarDiv']//ul/li[5]/a");
    	WebElement processFilterIcon = waitForClickability(locator);
    	processFilterIcon.click();		
    }
    
    public void clickRefreshButton() {
    	By locator = By.xpath("//*[@id=\"PaginatorDiv\"]/div[1]/button/span[2]");
    	WebElement refreshButton = waitForClickability(locator);
    	refreshButton.click();
    }
    public void clickShowHideIcon() {
    	By locator = By.xpath("//div[@id='ToolBarDiv']//ul/li[6]/a");
    	WebElement showHideIcon = waitForClickability(locator);
    	showHideIcon.click();
    }
}

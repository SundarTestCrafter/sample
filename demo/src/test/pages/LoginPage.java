package base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
    private By comp_UN_TextBox = By.id("complogin_username");

  //  public LoginPage(WebDriver driver) {
  //      this.driver = driver;
  //  }

    /*public void selectLanguage(String language) {
    	
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"mainpage\"]/div[2]/select")));
        dropdown.selectByVisibleText(language);
    }*/
    
    public void selectLanguage(String language) {
        By locator = By.xpath("//*[@id='mainpage']//select"); // You can also pass this as a parameter
        WebElement dropdownElement = waitForClickability(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(language);
    }
    
    public void companyLogin(String username, String password) {
        By usernameLocator = By.id("complogin_username");
        By passwordLocator = By.id("complogin_password");
        By loginButtonLocator = By.id("logmein");

        // Wait and interact using reusable wait method
        WebElement usernameField = waitForClickability(usernameLocator);
        usernameField.click();
        usernameField.sendKeys(username);

        WebElement passwordField = waitForClickability(passwordLocator);
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement loginButton = waitForClickability(loginButtonLocator);
        loginButton.click();
    }

    public void userLogin(String username, String password) {
    	By usernameLocator = By.id("userlogin_username");
        By passwordLocator = By.id("userlogin_password");
        By loginButtonLocator = By.id("login");

        // Wait and interact using reusable wait method
        WebElement usernameField = waitForClickability(usernameLocator);
        usernameField.click();
        usernameField.sendKeys(username);

        WebElement passwordField = waitForClickability(passwordLocator);
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement loginButton = waitForClickability(loginButtonLocator);
        loginButton.click();
    }
}

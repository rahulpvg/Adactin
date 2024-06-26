package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// Declaration
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath ="//img[@class = 'logo']") private WebElement logo;
	@FindBy (xpath = "//input[@id='username']") private WebElement userName;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//input[@id='login']") private WebElement loginButton;
	
	// Initialization
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	// Use
	public void sendUserName (String user) throws IOException
	{
		userName.sendKeys(user);
	}
	public void sendPassword ()
	{
		password.sendKeys("admin");
	}
	public void clickOnLoginButton ()
	{
		wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
	}
	// OR
	public boolean logo ()
	{
	 return logo.isDisplayed();
	}
	
	public void loginToApplication (String user, String pass) throws InterruptedException
	{
		userName.sendKeys(user);
		Thread.sleep(3000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		System.out.println("Login");
	}	
}

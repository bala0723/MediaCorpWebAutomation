package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	RemoteWebDriver driver;
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'Avatar')]")
	public WebElement profileIcon;
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	public WebElement loginLink;
	
	@FindBy(xpath = "//img[contains(@src,'mail')]//..")
	public WebElement emailButton;
	
	@FindBy(id =  "email")
	public WebElement emailField;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueButton;
	
	@FindBy(id =  "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//span[text()='My Voo']")
	public WebElement MyVootTab;
	
	@FindBy(xpath = "//button[text()='Subscribe Now']")
	public WebElement PP1SubscribeNow;
	
	
	
}

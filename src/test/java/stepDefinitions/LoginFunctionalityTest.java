package stepDefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.EventUtils;

public class LoginFunctionalityTest {

	RemoteWebDriver driver;
	EventUtils eventUtils;
	LoginPage loginPage;

	@Given("^user launches the applpication lands on login page$")
	public void user_launches_the_applpication_lands_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://unitybeta.voot.com/");
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		eventUtils = new EventUtils(driver);

		if (eventUtils.waitUntilElementIsPresent(loginPage.profileIcon, 20)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPage.profileIcon);
		} else {
			System.out.println("Unable to launch the applications");
		}
	}

	@When("^user enters valid (.+) and (.+)$")
	public void user_enters_valid_and(String username, String password) {

		if (eventUtils.waitUntilElememtIsClickable(loginPage.loginLink, 20)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPage.loginLink);
		} else {
			System.out.println("Unable to click on Login link");
		}

		if (eventUtils.waitUntilElememtIsClickable(loginPage.emailButton, 20)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPage.emailButton);
		} else {
			System.out.println("Unable to click on Email Button");
		}

		if (eventUtils.waitUntilElememtIsClickable(loginPage.emailField, 20)) {
			loginPage.emailField.sendKeys(username);
		} else {
			System.out.println("Unable to enter username");
		}

		if (eventUtils.waitUntilElememtIsClickable(loginPage.continueButton, 20)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPage.continueButton);
		} else {
			System.out.println("Unable to click on continue Button");
		}

		if (eventUtils.waitUntilElememtIsClickable(loginPage.passwordField, 20)) {
			loginPage.passwordField.sendKeys(password);
		} else {
			System.out.println("Unable to enter passord");
		}

	}

	@And("^clicks on login button$")
	public void clicks_on_login_button() {

		if (eventUtils.waitUntilElememtIsClickable(loginPage.continueButton, 20)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPage.continueButton);
		} else {
			System.out.println("Unable to click on continue Button");
		}

	}

	@Then("^user lands on homepage$")
	public void user_lands_on_homepage() {

		if (!eventUtils.waitUntilElememtIsClickable(loginPage.MyVootTab, 20)) {
			fail("User unable to lsnd on MyVoot page");
		}

	}

	@Then("^user lands on payment page$")
	public void user_lands_on_payment_page() {

		if (!eventUtils.waitUntilElementIsPresent(loginPage.PP1SubscribeNow, 20)) {
			fail("User not landed on Payment Page");

		}

	}

	@And("^user kills the browser$")
	public void user_kills_the_browser() {
		driver.quit();
	}

}

package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionalityTest {

	@Given("^user launches the applpication lands on login page$")
	public void user_launches_the_applpication_lands_on_login_page() {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver= new ChromeDriver();
	   driver.get("https://unitybeta.voot.com");
			   
	}
	@When("^user enters valid (.+) and (.+)$")
	public void user_enters_valid_username_and_password(String username,String password) {
	    System.out.println("User gives username "+username);
	    System.out.println("User gives password:-"+password);
	}
	@And("^user lands on homepage$")
	public void clicks_on_login_button() {
	    System.out.println("clicked on login button");
	}
	@Then("^clicks on login button$")
	public void user_lands_on_homepage() {
	    System.out.println("user lands on login button");

	}

}

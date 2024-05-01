package stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.github.dockerjava.api.model.Driver;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import pages.HomePage;
import utilities.HandleExceptions;
import utilities.Log;


public class HomeSD {

	TestContext testContext;
	
	HomePage homePage;
    DriverManager webDriverManager;

	public HomeSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		webDriverManager=testContext.getWebDriverManager();
		
	}

	@Given("Admin Launch the Browser")
	public void admin_launch_the_browser() {
		Log.info("Admin Launch the Browser");
	    webDriverManager.getDriver();
	}

	@When("Admin gives correct LMS portal URL")
	public void admin_gives_correct_lms_portal_url() {
	    homePage.appUrl();
	    
	}

	@Then("Admin should land on the Home Page")
	public void admin_should_land_on_the_home_page() {
		Log.info("Admin is on Home Page");
	    
	}

	@Then("HTTP response {string} then the link is broken")
	public void http_response_then_the_link_is_broken(String string) {
	    homePage.broken_links();
	    
	}

	@Then("Admin should see correct spelling all the fields")
	public void admin_should_see_correct_spelling_all_the_fields() {
		 homePage.spellchecker();
	    
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() {
	    homePage.correctlogo(null);
	    
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
	    homePage.logoaligned();
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    homePage.loginbtncheck();
	    
	}

	@Then("Admin should able to click login button")
	public void admin_should_able_to_click_login_button() {
	    homePage.logincheck();
	    
	}

	@When("Admin gives invalid LMS portal URL")
	public void admin_gives_invalid_lms_portal_url() {
	    homePage.invalid_url();
	    
	}

	@Then("Admin should receive {string} error")
	public void admin_should_receive_error(String string) {
	    homePage.invalidURLstatus();
		//assertTrue(driver.getTitle().contains("404"));
	    
	}


}
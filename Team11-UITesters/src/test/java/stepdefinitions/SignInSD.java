package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;

import utilities.Log;

public class SignInSD {
	private static String title;
	TestContext testContext;

	HomePage homePage;

	static String username;
	static String password;

	public SignInSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();

	}

	@Given("user is on appUrl")
	public void user_is_on_app_url() {
		homePage.GoToHomePage();
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		homePage.GoToHomePage();
	}

	@Then("appUrl Page Title should be {string}")
	public void app_url_page_title_should_be(String string) {
		title = homePage.VerifyHomePageURL();
		Log.info("Title of current page is ***** " + title + " ****");
		// Assert.assertEquals(Title, "LMS", "Title do not match");
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void LMS_Login() {
		homePage.ClickOnSignIn();
	}

	@Then("Admin should land on dashboard page")
	public void Land_dashboard() {
		System.out.println("successfully loggein");
	}

}
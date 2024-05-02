package stepdefinitions;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import pages.HomePage;
import readers.ExcelReader;
import utilities.Log;


public class LoginPageSD {

TestContext testContext;
	
	HomePage homePage;
	ExcelReader reader = new ExcelReader();
	DriverManager webDriverManager;
	
	public LoginPageSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		webDriverManager=testContext.getWebDriverManager();
	}
	@Given("Admin is on Home Page")
	public void admin_is_on_home_page() {
		webDriverManager.getDriver();
	    homePage.appUrl();
	    
	}

	@When("Admin clicks login button")
	public void admin_clicks_login_button() {
	    homePage.logincheck();
	    
	}

	@Then("Admin land on Login Page")
	public void admin_land_on_login_page() {
		Log.info("Admin is on Login page");
	    
	}

	@Then("HTTP response {string} then the login link is broken")
	public void http_response_then_the_login_link_is_broken(String string) {
	    homePage.broken_links();
	    
	}

	@Then("Admin should see {string} in the Header")
	public void admin_should_see_in_the_header(String string) {
		String actualmsg= homePage.headerlogin();
	    Assert.assertEquals(string,actualmsg);
	    
	}

	@Then("Admin should see correct spelling in all the feilds")
	public void admin_should_see_correct_spelling_in_all_the_feilds() {
	    homePage.spellchecker();
	    
	}

	@Then("Admin should see two text feilds")
	public void admin_should_see_two_text_feilds() {
	    homePage.textcheck(2);
	    
	}

//	@Then("Admin should {string} in the first text feild")
//	public void admin_should_in_the_first_text_feild(String string) {
//		String actualmsg= homePage.usertext();
//	    Assert.assertEquals(string,actualmsg);
//	    
//	}
	@Then("Admin should User in the first text feild")
	public void admin_should_user_in_the_first_text_feild() {
		Assert.assertEquals(homePage.usertext(),"User");
//		String actualmsg= homePage.usertext();
//	    Assert.assertEquals("User",actualmsg);
	}

	@Then("Admin should Password in the second text feild")
	public void admin_should_password_in_the_second_text_feild() {
		Assert.assertEquals(homePage.passwordtext(),"Password");
//		String actualmsg= homePage.passwordtext();
//	    Assert.assertEquals("Password",actualmsg);
	}



	@Then("Admin should see {string} symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text(String string) {
	    homePage.astrikuser(string);
	    
	}

//	@Then("Admin should {string} in the second text feild")
//	public void admin_should_in_the_second_text_feild(String string) {
//		String actualmsg= homePage.passwordtext();
//	    Assert.assertEquals(string,actualmsg);
//	    
//	}

	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String string) {
	    homePage.astrikpassword(string);
	    
	}

	@Then("Admin should see input feild on the centre of the page")
	public void admin_should_see_input_feild_on_the_centre_of_the_page() {
	    homePage.centrepage();
	    
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
	    homePage.centreloginbtn();
	    
	}

	@Then("Admin should see user in grey color")
	public void admin_should_see_user_in_grey_color() {
        homePage.usercolor();
	    
	}

	@Then("Admin should see password in grey color")
	public void admin_should_see_password_in_grey_color() {
        homePage.passwordcolor();
	    
	}


}

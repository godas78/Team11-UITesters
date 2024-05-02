package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;
import utilities.Log;

public class LogoutSD {
	TestContext testContext;
	LogoutPage logoutPage;
	
	public LogoutSD(TestContext context)
	{
		testContext = context;
		logoutPage = testContext.getPageObjectManager().getLogoutPage();
	}
	
	@When("user clicks on Logout link")
	public void user_clicks_on_logout_link() {
		Log.info("User Landed in Logout page");
		logoutPage.clickNavtologout();
	}
	@Then("user is re-directed to Login page screen")
	public void user_is_re_directed_to_login_page_screen() {
		Log.info("User is re-directed to Logout page screen");
		logoutPage.Validationtologoutpage();
	}
}

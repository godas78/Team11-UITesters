package stepdefinitions;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import utilities.HandleExceptions;
import utilities.Log;
import context.TestContext;
import pages.HomePage;
import pages.ProgramNavPage;
import pages.ProgramdelPage;

public class ProgramNavSD {
	HomePage homePage;
	ProgramdelPage programdelpage;
	ProgramNavPage programnavPage;
	TestContext testContext;
		
	public ProgramNavSD(TestContext context)
	{
		testContext = context;
		programnavPage = testContext.getPageObjectManager().getProgramNavPage();
	}
	
	@When("user clicks on Batch link on Manage Program page")
	public void user_clicks_on_batch_link_on_manage_program_page() {
		Log.info("User is clicking on Batch link on Manage Program page");
		programnavPage.clickNavtobatch();
	}
	@Then("user is re-directed to Batch page")
	public void user_is_re_directed_to_batch_page() {
		Log.info("User Landed in Batch page");
		programnavPage.Validationtobatchpage();
	}
	
	@When("user clicks on User link on Manage Program page")
	public void user_clicks_on_User_link_on_manage_program_page() {
		Log.info("User is clicking on User link on Manage Program page");
		programnavPage.clickNavtouser();
	}
	@Then("user is re-directed to User page")
	public void user_is_re_directed_to_User_page() {
		Log.info("User Landed in User page");
		programnavPage.clickNavtouser();
	}
	@When("user clicks on Logout link on Manage Program page")
	public void user_clicks_on_logout_link_on_manage_program_page() {
		Log.info("User Landed in Logout page");
		programnavPage.clickNavtologout();
	}

	@Then("user is re-directed to Login page")
	public void user_is_re_directed_to_login_page() {
		Log.info("User is redirected to Logout page");
		programnavPage.Validationtologoutpage();
	}
}

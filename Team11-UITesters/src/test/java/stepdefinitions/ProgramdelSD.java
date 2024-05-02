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
import pages.ProgramdelPage;


public class ProgramdelSD {

	HomePage homePage;
	ProgramdelPage programdelpage;
	
	//String username;
	//String password;
	
	TestContext testContext;
	//TestContext testContext = context;
	
	public ProgramdelSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		programdelpage = testContext.getPageObjectManager().getprogramdelPage();
		
	}
	
	@When("user clicks Delete button on the data table for any row")
	public void user_clicks_delete_button_on_the_data_table_for_any_row() {
		Log.info("User is clicking on delete button");
		programdelpage.clickdeletebuttn();
		programdelpage.acceptdelno();
	}

	@Then("user should see a alert open with  YES and NO button for deletion")
	public void user_should_see_a_alert_open_with_yes_and_no_button_for_deletion() {
		Log.info("User is see an alert");
		Assert.assertTrue(programdelpage.Deletealert().isDisplayed(), "Delete popoup is displayed");
		Assert.assertTrue(programdelpage.Deleletehasoptionyes().isDisplayed(), "Delete popoup have yes button displayed");
		Assert.assertTrue(programdelpage.Deleletehasoptionno().isDisplayed(), "Delete popoup have no button displayed");
	}
	
	@Then("Admin should see a message Are you sure you want to delete Program name?")
	public void admin_should_see_a_message_are_you_sure_you_want_to_delete_program_name() {
		Log.info("User is able to see confirm box");
		programdelpage.clickdeletebuttn();
		Assert.assertTrue(programdelpage.confirmbox().isDisplayed(), "confirm box is displayed");
		programdelpage.acceptdelno();
	}
	@Given("user is on Confirm Deletion alert")
	public void user_is_on_confirm_deletion_alert() throws InterruptedException {
		Log.info("User is on confirm Deletion alert");
		programdelpage.clickdeletebuttn();
		Thread.sleep(2000);
		Assert.assertTrue(programdelpage.confirmbox().isDisplayed(), "confirm box is displayed");
	}

	@When("user clicks YES button on the alert")
	public void user_clicks_yes_button_on_the_alert() {
		programdelpage.acceptdelyes();
		programdelpage.ClickDeleteYesBtn();
	}

	@Then("user gets a message Successful Program Deleted and able to see that program deleted in the data table")
	public void user_gets_a_message_Successful_Program_Deleted_and_able_to_see_that_program_deleted_in_the_data_table() {
		programdelpage.ProgramdeleteSucessAlert();
	}
	@When("user clicks NO button on the alert")
	public void user_clicks_no_button_on_the_alert() {
		Log.info("User is clicking no Deletion alert");
		programdelpage.ClickDeleteNoBtn();
		//programPage.acceptdelno();
	}

	@Then("user can see the deletion alert disappears without deleting")
	public void user_can_see_the_deletion_alert_disappears_without_deleting() {
		programdelpage.ProgramdeleteNoAlert();
	}
	@When("user clicks Cancel or Close Icon on Deletion alert")
	public void user_clicks_cancel_or_close_icon_on_deletion_alert() {
		programdelpage.cancelpopup();
	}

	@Then("user can see the deletion alert disappears without any changes")
	public void user_can_see_the_deletion_alert_disappears_without_any_changes() {
		Log.info("User is clicking canceling alert");
		programdelpage.Deletealert();
	}
}


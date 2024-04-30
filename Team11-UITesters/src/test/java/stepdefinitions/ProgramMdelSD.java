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
import pages.ProgramMdelPage;
import pages.ProgramdelPage;

public class ProgramMdelSD {
	HomePage homePage;
	ProgramdelPage programdelPage;
	ProgramMdelPage programMdelPage;
	TestContext testContext;
	
	public ProgramMdelSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		programdelPage = (ProgramdelPage) testContext.getPageObjectManager().getprogramdelPage();
		programMdelPage = testContext.getPageObjectManager().getProgramMDelPage();
		
	}
	
	@When("user clicks any checkbox in the data table")
	public void user_clicks_any_checkbox_in_the_data_table() {
		Log.info("User is clicking on delete checkbox");
		programMdelPage.clickonedeletecheckbox();
		programMdelPage.assertCheckboxesSelected();
	}

	@Then("user should see common delete option enabled under header Manage Program")
	public void user_should_see_common_delete_option_enabled_under_header_manage_program() {
		Log.info("delete icon should be enabled");
		programMdelPage.deleteiconenabled();
	}
	
	@Given("user is on Confirm Deletion alert yes with single sel")
	public void user_is_on_confirm_deletion_alert_yes_with_multiple_sel() throws InterruptedException {
		Log.info("clicking on one checkbox with yes");
		programMdelPage.deleteclick();
		programMdelPage.confirmcheckpop();
		}
	
	@When("user clicks YES button on the alert check")
	public void user_clicks_yes_button_on_the_alert_check() throws InterruptedException {
		programMdelPage.checkdelyes();
	}
	@Then("user gets a message Successful Program Deleted and able to see that program deleted")
	public void user_gets_a_message_successful_program_deleted_and_able_to_see_that_program_deleted() throws InterruptedException {
		Log.info("delete successful");
		programMdelPage.ProgramdeletecheckSucessAlert();
	}
	@Given("user is on Confirm Deletion alert no with single sel")
	public void user_is_on_confirm_deletion_alert_no_with_multiple_sel() {
		Log.info("clicking on one checkbox with no");
		programMdelPage.clickseconddeletecheckbox();
		programMdelPage.deleteclick();
		programMdelPage.confirmcheckpop();
	}

	@When("user clicks NO button on the alert check")
	public void user_clicks_no_button_on_the_alert_check() {
		Log.info("delete now");
		programMdelPage.checkdelno();
	}

	@Then("user can see the deletion alert disappears without deleting the program")
	public void user_can_see_the_deletion_alert_disappears_without_deleting_the_program() {
		Log.info("clicking on no");
		programMdelPage.ProgramdeletecheckNoAlert();
	}
	@Given("user is on Confirm Deletion alert yes with multiple sel")
	public void user_is_on_confirm_deletion_alert_yes_with_multiple_sel1() {
		Log.info("user selects multiple check boxes-program9");
		programMdelPage.clickonedeletecheckbox();
		programMdelPage.clickseconddeletecheckbox();
		programMdelPage.deleteclick();
		
	}

	@When("Admin clicks YES button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		Log.info("user selects multiple check boxes and click yes");
		programMdelPage.confirmcheckpop();
		programMdelPage.checkdelyes();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
		Log.info("user selects multiple check boxes and click yes success");
		programMdelPage.ProgramdeletecheckSucessAlert();
	}
	
	@Given("Admin is on Confirm Deletion alert no with multiple sel")
	public void admin_is_on_confirm_deletion_alert_no_with_multiple_sel() {
		Log.info("user selects multiple check boxes with no-program10");
		programMdelPage.clickonedeletecheckbox();
		programMdelPage.clickseconddeletecheckbox();
		programMdelPage.deleteclick();
	}

	@When("Admin clicks NO button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		Log.info("user selects multiple check boxes with no confirm");
		programMdelPage.confirmcheckpop();
		programMdelPage.checkdelno();
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
		Log.info("user selects multiple check boxes with no option");
		programMdelPage.ProgramdeletecheckNoAlert();
	}
}

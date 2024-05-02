package stepdefinitions;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProgramPage;

public class EditProgramSD {
	
	TestContext testContext;
    ProgramPage programPage;
    
    public EditProgramSD(TestContext context)
	{
		testContext = context;
		programPage = testContext.getPageObjectManager().getProgramPage();
	}
	
	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
	    programPage.clickOnWebelement(programPage.editButton, 10);
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		Assert.assertTrue(programPage.popUpDisplayed(programPage.editButton));
	  // programPage.popUpDisplayed(programPage.editButton);
	   programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() throws InterruptedException {
		Thread.sleep(3000);
		programPage.clickOnWebelement(programPage.editButton, 10);
	}

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() {
	    programPage.enterProgramName("tyu9");
	    programPage.clickOnWebelement(programPage.saveButton, 10);
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		 programPage.getText(programPage.successprogramMessage);
	}

	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() {
	   programPage.clickOnWebelement(programPage.inactive, 10);
	   programPage.clickOnWebelement(programPage.saveButton, 10);
	}
	@When("Admin edit enters only numbers or special char in  {string} and {string} column")
	public void admin_edit_enters_only_numbers_or_special_char_in_name_and_desc_column(String name, String des) {
		programPage.enterProgramDescription(name, des);
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) throws InterruptedException {
		Thread.sleep(2000);
		 programPage.getText(programPage.successprogramMessage);
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		programPage.clickOnWebelement(programPage.cancelButton, 10);
	//  programPage.clickOnWebelement(programPage.xSuccessButton, 10);
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
	   programPage.getFooterText();
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
	   programPage.clickOnWebelement(programPage.editSave,10);
	   
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String excepted) {
	    //programPage.validateDisplayelement(programPage.);
	    programPage.getErrorMessage(programPage.errorMessage);
	    
	}




}

package stepdefinitions;

import com.sun.tools.sjavac.Log;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProgramPage;

public class AddProgramSD {
	
	 TestContext testContext;
	    ProgramPage programPage;
	    
	    public AddProgramSD(TestContext context)
		{
			testContext = context;
			programPage = testContext.getPageObjectManager().getProgramPage();
		}
	
	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
	   programPage.clickOnWebelement(programPage.ANewProgram, 10);
	   
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
	   programPage.clickOnWebelement(programPage.saveButton, 10);
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {	
	 programPage.elementcheaking(programPage.errorMessage);
	 programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
		programPage.enterProgramName("test");
		 programPage.clickOnWebelement(programPage.saveButton, 10);
	   
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
	  programPage.getErrorMessage(programPage.errorMessage);
	  programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
	   programPage.enterProgramDescription();
	   programPage.clickOnWebelement(programPage.saveButton, 10);
	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
		programPage.clickOnWebelement(programPage.active, 10);
		 programPage.clickOnWebelement(programPage.saveButton, 10);
	   }

	
	@When("Admin enters only numbers or special char in {string} and {string} column")
	public void admin_enters_only_numbers_or_special_char_in_and_column(String name, String des) {
		programPage.enterProgramDescription(name, des);
	    }
	
	@When("Admin clicks Cancel\\/Close\\(X) Icon on Program Details form")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
		 programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	  programPage.validateDisplayelement(programPage.ANewProgram);
	}


	@When("Admin enters valid values {string} and {string}")
	public void admin_enters_valid_values_and(String programName, String ProgramDescription) {
		programPage.enterProgramDescription(programName, ProgramDescription);
	    programPage.clickOnWebelement(programPage.active, 10);
	    programPage.clickOnWebelement(programPage.saveButton, 10);
	    
	    }
	@Then("Admin should see succes {string}")
	public void admin_should_see_succes(String message) {
	    programPage.getText(programPage.successprogramMessage);
	}

  @When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
	    programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
		 programPage.validateDisplayelement(programPage.ANewProgram);
	}




}

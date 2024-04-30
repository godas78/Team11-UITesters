package stepdefinitions;

import com.sun.tools.sjavac.Log;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProgramPage;

public class ProgramAddStep5 {
	
	 TestContext testContext;
	    ProgramPage programPage;
	    
	    public ProgramAddStep5(TestContext context)
		{
			testContext = context;
			programPage = testContext.getPageObjectManager().getProgramPage();
		}
	
	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
	   System.out.println("Admin is on popup window");
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
	   programPage.clickOnWebelement(programPage.saveButton, 10);
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
	programPage.clickOnWebelement(programPage.saveButton, 10);	
	 programPage.elementcheaking(programPage.errorMessage);
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
	   
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
	  
	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
	   
	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
	   
	}

	@When("Admin enters only numbers or special char in name and desc column")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() {
	  
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Program Details form")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
	   
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	   
	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
	    
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
	    
	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
	    
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
	   
	}




}

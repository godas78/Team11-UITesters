package stepdefinitions;

import org.testng.Assert;

//import com.sun.tools.sjavac.Log;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProgramPage;

public class AddProgram1SD {
	TestContext testContext;
    ProgramPage programPage;
    
    public AddProgram1SD(TestContext context)
   	{
   		testContext = context;
   		//homePage = testContext.getPageObjectManager().getHomePage();
   		programPage = testContext.getPageObjectManager().getProgramPage();
   	}
	
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		programPage.clickOnWebelement(programPage.ManageProgram, 10);
	   System.out.println("Admin is on program manage page");
	}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
	   programPage.clickOnWebelement(programPage.ANewProgram, 15); 
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	   Assert.assertTrue(programPage.popUpDisplayed(programPage.ANewProgram));
	   programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		 Assert.assertTrue(programPage.validateDisplayelement(programPage.inputName));
		 Assert.assertTrue(programPage.validateDisplayelement(programPage.inputDescription));
		 programPage.clickOnWebelement(programPage.xButon, 10);
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		 Assert.assertTrue(programPage.elementcheaking(programPage.radioButtons)); 
		 programPage.clickOnWebelement(programPage.xButon, 10);
	}




}

package stepdefinitions;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;
import pages.AddNewUser;
import pages.HomePage;
import pages.Userpagevalidation;

public class AddNewUserSD {
	
	TestContext testContext;
	WebDriver driver;
	Userpagevalidation userpagevalidation;
	HomePage homePage;
	AddNewUser adduser;


	public AddNewUserSD(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
		userpagevalidation = testContext.getPageObjectManager().getUserpagevalidation();
		adduser = testContext.getPageObjectManager().getAddUser();

	}
	

	@When("Admin clicks {string} button UM1")
	public void clicks_Adduserbutton(String string) {
		try {
			adduser.AddNewUserBtn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("UM1 Admin should see pop up open for user details with First Name,Middle name, Last Name, Location,phone, email, linkedin url, User Role, Role status,visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel ,Submit and close buttons")
	public void admin_should_see_pop_up_opendetails_UM1() {
	    
		adduser.validateAddUserPopup();
	}

	@Then("UM1 Admin should see text boxes for the fields First Name, Middle name,Last Name, Location, phone,email,linkedin url,Undergraduate,postgraduate,time zone ,user comments")
	public void admin_should_see_text_boxes_Userdetails_UM1() {

     adduser.validateAddUserText();
	}

	@Then("Admin should see dropdowns for the fields User Role,Role status, visa status on user details pop up UM1")
	public void admin_should_see_dropdowns_user_details_pop_up() {

     adduser.validateUserDropdowns();
	}
	@Given("Admin is on  User details pop up UM1")
	public void admin_is_on_user_details_pop_up() {
		
	    try {
			adduser.AddNewUserBtn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button UM1")
	public void admin_mandatory_fields_clicks_submit_button() {

		adduser.validatecreateUSerdetails();

		
	}

	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {

      adduser.validateNewUserSuccess();
	}

	@When("Admin skips to add value in mandatory field")
	public void admin_skips_to_add_value_in_mandatory_field() {
	    adduser.valdiatemissinginputsAdduser();
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {

adduser.valdiateerrormsgAddUser();
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")
	public void admin_enters_invalid_data_and_clicks_on_submit_button() {
		adduser.valdiatemissinginputsAdduser();
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
		 adduser.validateEmptyformSubmit();
		 
	}

	@When("Admin clicks on submit button without entering data UM1")
	public void admin_clicks_on_submit_button_without_entering_data() {

        adduser.validateEmptyformSubmit();
		
	}

	@When("Admin clicks Cancel or Close\\(X) Icon on User Details form UM1")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {

    adduser.closeUserUM1();
	}

	@Then("User Details popup window should be closed without saving UM1")
	public void user_details_popup_window_closed_without_saving() {
		
		adduser.validatecloseUserPopupUM1();
	}

	@When("Admin clicks Cancel button UM1")
	public void admin_clicks_cancel_button() {
		adduser.validateCancelUM1();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_user_details_popup_disappears_without_adding_any_user() {

		adduser.validateUserdetailpopclose();
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
	   adduser.validatecreateUSerdetails();
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {

  adduser.validateNewuserDatatable();
	}

}

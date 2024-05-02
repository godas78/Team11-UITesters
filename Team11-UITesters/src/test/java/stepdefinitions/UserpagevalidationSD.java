package stepdefinitions;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;
import pages.Userpagevalidation;
import utilities.Log;

public class UserpagevalidationSD {

	TestContext testContext;
	WebDriver driver;
	Userpagevalidation userpagevalidation;
	HomePage homePage;

	public UserpagevalidationSD(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
		userpagevalidation = testContext.getPageObjectManager().getUserpagevalidation();

	}
	@Given("Validate landing in User page and Admin is on dashboard page after Login")
	public void validatelandinguserpage() {
		String currenturl =driver.getCurrentUrl();
		String expectedurl= FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		
		Log.info("insider userpagevaldiation");
		
	    /*if(!currenturl.equals(expectedurl) ) {
	    	homePage.GoToHomePage();
	    	//homePage.ClickOnSignIn();
	    	
	    }
	    else {
	    	Log.info("User is already logged in !");
	    }*/
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_navigation_bar(String string) throws InterruptedException {
		Thread.sleep(2000);
		userpagevalidation.click_userbutton();
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_url_manageUser(String string) throws InterruptedException {
		Thread.sleep(2000);
		//userpagevalidation.validatemanageuser_page();
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_heading_with_text_on_the_page_MANAGEUSER(String string) {
		userpagevalidation.validatemanageuser_text();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table for usermodule.")
	public void admin_text_with_pagination_icon_below_the_table(String string) {
		userpagevalidation.validatepagination_user_text();
		
	}

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_column_names_id_name_location_phone_number_edit_delete() {
		userpagevalidation.validateTableHeaders();
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_delete_button_on_the_top_left_hand_side_as_disabled() {
		userpagevalidation.validateDeletebutton();
	}

	@Then("Admin should be able to see the {string} button above the data table")
	public void admin_button_above_the_data_table(String string) {
	    
		userpagevalidation.ValidateButtonsAboveDataTable();
	}

	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
		userpagevalidation.validateUserSearchbox();
	}

	@Then("Admin should see two  records displayed on the data table")
	public void admin_two_records_displayed_data_table() {
		userpagevalidation.validateRowCount();
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_data_table_should_have_checkbox() {
	  
		userpagevalidation.validateAllcheckbox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		userpagevalidation.validateEditIcon();

	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_data_table_delete_icon_enabled() {
		userpagevalidation.validateDeleteIcon();

	}


	@When("Admin enters user name into search box.")
	public void admin_enters_user_name_into_search_box() {
		try {
			userpagevalidation.validateSearchboxUsername();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {
	    
		Log.info("searchbox showed the correct rowdata");
	}

	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {
		userpagevalidation.validateInvalidSearchdata();
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
		Log.info("Showing 0 to 0 of 0 entries ");
	}

}

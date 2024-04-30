package stepdefinitions;

import java.util.List;
import java.util.Map;

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
		
	    if(!currenturl.equals(expectedurl) ) {
	    	homePage.GoToHomePage();
	    	String username= FileReaderManager.getInstance().getConfigReader().getLMSUserName();
	    	String password= FileReaderManager.getInstance().getConfigReader().getLMSPassword();
	    	homePage.validuser(username);
			homePage.validpassword(password);
	    	homePage.logincheck();
	    	
	    	
	    }
	    else {
	    	Log.info("User is already logged in !");
	    }
	}

	@When("Admin clicks User from navigation bar for UM1")
	public void admin_clicks_navigation_bar() {
		userpagevalidation.click_userbutton();
	}

	@Then("Admin should see the Manage User in the URL")
	public void admin_url_manageUser() {
		userpagevalidation.validatemanageuser_page();
	}

	@Then("Admin should see a heading with text Manage user on the page")
	public void admin_heading_MANAGEUSER() {
		userpagevalidation.validatemanageuser_text();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table for usermodule.")
	public void admin_text_with_pagination_icon_below_the_table(String string) {
		userpagevalidation.validatepagination_user_text();
		
	}

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete for UM")
	public void validateDatatableHeadings() {
		userpagevalidation.validateTableHeaders();
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled for UserDEtailsPage")
	public void admin_delete_button_top_left_side_disabled() {
		userpagevalidation.validateDeletebutton();
	}

	@Then("Admin should be able to see the {string} button above the data table for add new user")
	public void admin_button_above_the_data_table(String string) {
	    
		userpagevalidation.ValidateButtonsAboveDataTable();
	}

	@Then("Admin should be able to see the search text box above the data table for userdetailspage")
	public void admin_search_text_box_above_the_data_table() {
		userpagevalidation.validateUserSearchbox();
	}

	@Then("Admin should see two  records displayed on the data table for userdetailspage")
	public void records_displayed_data_table() {
		userpagevalidation.validateRowCount();
	}

	@Then("Each row in the data table should have a checkbox for userdetailspage")
	public void datatable_have_checkbox() {
	  
		userpagevalidation.validateAllcheckbox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled for userdetailspage")
	public void data_table_a_edit_icon_that_is_enabled() {
		userpagevalidation.validateEditIcon();

	}

	@Then("Each row in the data table should have a delete icon that is enabled for userdetailspage")
	public void data_table_delete_icon_enabled() {
		userpagevalidation.validateDeleteIcon();

	}


	@When("Admin enters user name into search box for userdetailspage")
	public void user_name_search_box() {
		try {
			userpagevalidation.validateSearchboxUsername();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("Admin should see user displayed with the entered name for userdetailspage")
	public void admin_displayed_with_the_entered_name() {
	    
		Log.info("searchbox showed the correct rowdata");
	}

	@When("Admin enters the keywords not present in the data table on the Search box for userdetailspage")
	public void enters_keywords_not_present_data_table_on_the_search_box() {
		userpagevalidation.validateInvalidSearchdata();
	}

	@Then("Admin should see zero entries on the data table for userdetailspage")
	public void admin_see_zero_entries_data_table() {
		Log.info("Showing 0 to 0 of 0 entries ");
	}

}

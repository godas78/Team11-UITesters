package stepdefinitions;


//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProgramPage;

public class ManageProgramSD {
    TestContext testContext;
    ProgramPage programPage;
  
    
    public ManageProgramSD(TestContext context)
	{
		testContext = context;
		programPage = testContext.getPageObjectManager().getProgramPage();
	}
	
    @Given("Admin is on dashboard pm page after Login")
    public void admin_is_on_dashboard_pm_page_after_login() {
	  System.out.println("Dashboard page");
	  
	}

	@When("Admin clicks pm {string} on the navigation bar")
	public void admin_clicks_pm_on_the_navigation_bar(String string) {
	   programPage.clickOnProgram(); 
	   
	}

	@Then("Admin should see URL with pm {string}")
	public void admin_should_see_url_with_pm(String url) {
		Assert.assertEquals(url, programPage.getProgramurl());
	}

	@Then("Admin should see a heading with text pm {string} on the page")
	public void admin_should_see_a_heading_with_text_pm_on_the_page(String expected) {
		 Assert.assertEquals(expected, programPage.getProgramText());
	}
	@Then("Admin should see the text pm as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_pm_as_along_with_pagination_icon_below_the_table(String expected) {
		String actual = programPage.getPaginationText();
		Assert.assertTrue(actual.matches(expected));
	   
	   
	}

	@Then("Admin should see the footer pm as {string}   #z- Total number of records")
	public void admin_should_see_the_footer_pm_as_z_total_number_of_records(String rawExpected) {
		String expected = rawExpected.replace("z", programPage.getExpectedFooterText());
		Assert.assertEquals(expected, programPage.getFooterText());
	  
	}

	@Then("Admin should see a pm Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_pm_delete_button_on_the_top_left_hand_side_as_disabled() {
	    Assert.assertFalse(programPage.elementIsEnabled(programPage.multipalDeleteButton));
	}

	@Then("Admin should see a pm {string} button on the program page above the data table")
	public void admin_should_see_a_pm_button_on_the_program_page_above_the_data_table(String string) {
		Assert.assertTrue( programPage.elementIsEnabled(programPage.ANewProgram));
	}

	@Then("Admin should see the number of pm records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_pm_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
		//Assert.assertEquals(int1, programPage.getTableRowCount());
		programPage.getColoumNameText();
	}

	@Then("Admin should see data table on  the Manage Program Page with following column headers pm {string}")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_pm(String expected) {
		Assert.assertEquals(expected, programPage.getColoumNameText());
	}

	@Then("Admin should see pm the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_pm_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	  Assert.assertTrue(programPage.validateDisplayelement(programPage.ProgramNameSort));
	  Assert.assertTrue(programPage.validateDisplayelement(programPage.ProgramDescriptionSort));
	  Assert.assertTrue(programPage.validateDisplayelement(programPage.ProgramStatus));
	}
	
	@Then("Admin should see pm check box on the left side in all rows of the data table")
	public void admin_should_see_pm_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	   Assert.assertTrue(programPage.elementcheaking(programPage.MultipalCheckbox));
	}

	@Then("Admin should see the pm Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_pm_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		 Assert.assertTrue(programPage.validateDeleteIconsEnabled());
	}

	@Then("Admin should see pm Search bar with text as {string}")
	public void admin_should_see_pm_search_bar_with_text_as(String expected) {
		Assert.assertEquals(expected, programPage.getSearchtext());
	}


	

}

package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.ProgramPage;

public class ProgramSteps3 {
    TestContext testContext;
    ProgramPage programPage;
  
    
    public ProgramSteps3(TestContext context)
	{
		testContext = context;
		programPage = testContext.getPageObjectManager().getProgramPage();
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	  System.out.println("Dashboard page");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   programPage.clickOnProgram(); 
	   
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String url) {
		Assert.assertEquals(url, programPage.getProgramurl());
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String expected) {
		 Assert.assertEquals(expected, programPage.getProgramText());
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String expected) {
		String actual = programPage.getPaginationText();
		Assert.assertTrue(actual.matches(expected));
	   
	   
	}

	@Then("Admin should see the footer as {string}   #z- Total number of records")
	public void admin_should_see_the_footer_as_z_total_number_of_records(String rawExpected) {
		String expected = rawExpected.replace("z", programPage.getExpectedFooterText());
		Assert.assertEquals(expected, programPage.getFooterText());
	  
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	    Assert.assertFalse("Multipal Delete button is Enabled",programPage.elementIsEnabled(programPage.multipalDeleteButton));
	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		Assert.assertTrue( programPage.elementIsEnabled(programPage.ANewProgram));
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
		//Assert.assertEquals(int1, programPage.getTableRowCount());
		programPage.getColoumNameText();
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers {string}")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers(String expected) {
		Assert.assertEquals(expected, programPage.getColoumNameText());
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	  Assert.assertTrue("programName sort icon not displayed" , programPage.validateDisplayelement(programPage.ProgramNameSort));
	  Assert.assertTrue("programDescription sort icon not displayed" , programPage.validateDisplayelement(programPage.ProgramDescriptionSort));
	  Assert.assertTrue("programStatus sort icon not displayed" , programPage.validateDisplayelement(programPage.ProgramStatus));
	}
	
	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	   Assert.assertTrue(programPage.elementcheaking(programPage.MultipalCheckbox));
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		
		 Assert.assertTrue(programPage.validateDeleteIconsEnabled());
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expected) {
		Assert.assertEquals(expected, programPage.getSearchtext());
	}


	

}

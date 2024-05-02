package stepdefinitions;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPagiPage;
import pages.ProgramsortPage;
import utilities.Helper;
import utilities.Log;

public class ProgrampagiSD {
	
	TestContext testContext;
	ProgramPagiPage programpagiPage;
		
	public ProgrampagiSD(TestContext context)
	{
		testContext = context;
		programpagiPage = testContext.getPageObjectManager().getProgramPagiPage();
	}
	@When("user clicks Next page link on the program table")
	public void user_clicks_next_page_link_on_the_program_table() {
		Log.info("User is clicking on right arrow");
		programpagiPage.clickrightarrow();
	}

	@Then("user should see the Pagination has Next active link")
	public void user_should_see_the_pagination_has_next_active_link() {
		Log.info("User is on next page");
		programpagiPage.rightarrowchk();
	}
	
	@When("user clicks Last page link")
	public void user_clicks_last_page_link() {
		Log.info("User is clicking on last page arrow");
		programpagiPage.clicklastpage();
	}

	@Then("user should see the last page record on the table with Next page link are disabled")
	public void user_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		Log.info("User is now on last page");		
		programpagiPage.leftarrowchk();
	}
	
	@When("user clicks First page link")
	public void user_clicks_first_page_link() {
		Log.info("User is clicking on first page arrow");
		programpagiPage.clickfirstpage();
	}

	@Then("user should see the first page record on the table with previous page link disabled")
	public void user_should_see_the_first_page_record_on_the_table_with_previous_page_link_disabled() {
		Log.info("User is now on first page");		
		programpagiPage.rightarrowchk();
	}
	@When("user clicks Start page link")
	public void user_clicks_start_page_link() {
		Log.info("User is clicking on start page arrow");
		programpagiPage.clickrightarrow();
		programpagiPage.clickrightarrow();
	}

	@Then("user should see the first page record on the table with previous page link being disabled")
	public void user_should_see_the_first_page_record_on_the_table_with_previous_page_link_being_disabled() {
		Log.info("User is now on first page");		
		programpagiPage.clickfirstpage();
		programpagiPage.rightarrowchk();
	}

}

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
import pages.ProgramsortPage;
import utilities.Helper;
import utilities.Log;

public class ProgramsortSD {
	
	TestContext testContext;
	ProgramsortPage programsortpage;
		
	public ProgramsortSD(TestContext context)
	{
		testContext = context;
		programsortpage = testContext.getPageObjectManager().getProgramsortPage();
	}	

	@Given("user is Manage Program page")
	public void user_is_on_manage_program_page() {
		Log.info("User is logged on success");
		}

	@When("user clicks the sort icon of program name column ascending")
	public void user_clicks_the_sort_icon_of_program_name_column_ascending() throws InterruptedException {
		Log.info("User is clicking sort ascending");
		programsortpage.clickprogramnameA();
		Thread.sleep(3000);
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order1() {
		Log.info("sorting ascending success");
		programsortpage.clickprogramnameascending();
	}
	@When("user clicks the sort icon of program name column descending")
	public void user_clicks_the_sort_icon_of_program_name_column_descending() throws InterruptedException {
		Log.info("User is clicking sort descending");
		programsortpage.clickprogramnameD();
	}

	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
		Log.info("sorting descending success");
		programsortpage.clickprogramnamedescending();
	}
	@When("user clicks the sort icon of programDesc column ascending")
	public void user_clicks_the_sort_icon_of_programdesc_column_ascending() {
		Log.info("click programdesc sorting ascending");
		programsortpage.clickprogramdescA();
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
		Log.info("programdesc sorting ascending sucess");
		programsortpage.clickprogramdescascending();
		
	}
	@When("user clicks the sort icon of programDesc column descending")
	public void user_clicks_the_sort_icon_of_programdesc_column_descending() {
		Log.info("click programdesc sorting descending");
		programsortpage.clickprogramdescD();
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
		Log.info("programdesc sorting descending sucess");
		programsortpage.clickprogramdescpdescending();
		
	}

	@When("user clicks the sort icon of program Status column ascending")
	public void user_clicks_the_sort_icon_of_program_status_column_ascending() {
		Log.info("click program status sorting ascending");
		programsortpage.clickprogramstatusA();
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
		Log.info("program status sorting ascending sucess");
		programsortpage.clickprogramstatusascending();
	}
	@When("user clicks the sort icon of program status column descending")
	public void user_clicks_the_sort_icon_of_program_status_column_descending() {
		Log.info("click program status sorting descending");
		programsortpage.clickprogramstatusD();
	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
		Log.info("program status sorting descending sucess");
		programsortpage.clickprogramstatusdescending();
		
	}
}

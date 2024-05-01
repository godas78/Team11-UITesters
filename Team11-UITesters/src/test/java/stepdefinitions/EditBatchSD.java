package stepdefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddandEditBatchPage;
import readers.ExcelReader;

public class EditBatchSD {
	TestContext testContext;
	AddandEditBatchPage addBatchPage;
	ExcelReader reader = new ExcelReader();
	String actualerror;
	
	public EditBatchSD(TestContext context)
	{
		testContext = context;
		addBatchPage = testContext.getPageObjectManager().getAddBatchPage();
		
	}	
	
//	TestContext testContext;
//	EditBatchPage editBatchPage;
//	
//	public EditBatchSD(TestContext context)
//	{
//		testContext = context;
//		editBatchPage = testContext.getPageObjectManager().getEditBatchPage();
//		
//	}	

	@Given("The edit icon on row level in data table is enabled for batch")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled_for_batch() {
		addBatchPage.checkEditIconisEnabled();
	}

	@When("Admin clicks the edit icon for batch")
	public void admin_clicks_the_edit_icon_for_batch() throws InterruptedException {
		addBatchPage.clicksTheEditIcon();
	}

	@Then("A new pop up with Batch details appears for batch")
	public void a_new_pop_up_with_batch_details_appears_for_batch() throws InterruptedException {
		Assert.assertTrue(addBatchPage.ValidateEditbatchPopup().isDisplayed(), "Edit batch popup is not displayed");
	}

	
	@When("Update the fields with valid values and click save from {string} and {int} for edit batch")
	public void update_the_fields_with_valid_values_and_click_save_from_and_for_edit_batch(String sheetname, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		addBatchPage.updateBatchDetails(sheetname,rowNumber);
	}

	@Then("The updated batch details should appear on the data table for edit batch module")
	public void the_updated_batch_details_should_appear_on_the_data_table_for_edit_batch_module() {
		addBatchPage.verifySuccessMessage();
	}
	
	@Given("Admin clicks the edit icon for edit batch")
	public void Admin_clicks_the_edit_icon_for_edit_batch() throws InterruptedException{
		addBatchPage.clickEditIconforinvalid();
		
	}

	@When("Update the fields with invalid values and click save from {string} and {int} for edit batch")
	public void update_the_fields_with_invalid_values_and_click_save_from_and_for_edit_batch(String sheetname, Integer rowNumber) 
		throws InvalidFormatException, IOException {
		actualerror = addBatchPage.updateinvalidBatchDetails(sheetname,rowNumber);
		System.out.println("actual err msg " +actualerror);
	}

	@Then("Error message should appear for edit batch module")
	public void error_message_should_appear_for_edit_batch_module() {
		Assert.assertFalse(actualerror.isEmpty(), "Error message is empty");
		addBatchPage.closeerrwin();
	}

	@When("Erase data from mandatory field for edit batch")
	public void erase_data_from_mandatory_field_from_and_for_edit_batch() throws InterruptedException {
		actualerror = addBatchPage.Blankmandatoryfield();
		System.out.println("Mandatory feild blank msg " +actualerror);
	}

	@When("Erase data from description field for edit batch")
	public void erase_data_from_description_field_from_and_for_edit_batch() throws InterruptedException {
		actualerror = addBatchPage.BlankDescritionfield();
		System.out.println("Description is mandatory " +actualerror);
		Assert.assertFalse(actualerror.isEmpty(), "No error message as description is not a mandatory field");
	}
}

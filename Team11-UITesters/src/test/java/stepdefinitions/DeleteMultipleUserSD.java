package stepdefinitions;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.UserPageV2;
import utilities.HandleExceptions;
import utilities.Log;

public class DeleteMultipleUserSD {

	TestContext testContext;
	UserPageV2 deleteMultipleUserSD;

	public DeleteMultipleUserSD(TestContext context) {
		testContext = context;
		deleteMultipleUserSD = testContext.getPageObjectManager().getUserPageV2();

	}

	@Given("Admin clicks delete button under header after selecting the check box in the data table DMU")
	public void admin_clicks_delete_button_under_header_after_selecting_the_check_box_in_the_data_table_DMU()
			throws InterruptedException {
		Thread.sleep(2000);

		deleteMultipleUserSD.clickUserModule();
		Thread.sleep(2000);
		deleteMultipleUserSD.clickUserIdArrow();
		Thread.sleep(2000);
		deleteMultipleUserSD.deleteCheckBox();
		Thread.sleep(2000);

		Log.info("Admin clicks header delete button and first check box");
	}
	

	@When("Admin clicks {string} button on the alert for delete multiple user DMU")
	public void admin_clicks_no_button_on_the_alert_for_delete_multiple_user_DMU(String expNo)
			throws InterruptedException {


		deleteMultipleUserSD.ClickDeleleteoptionNo();
		Log.info("Admin clicks No Button");

	}

	@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table DMU")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table_DMU() {
		try {
			Log.startTestCase();
			deleteMultipleUserSD.clickUserModule();

			String actualUrl = testContext.getHelper().getCurrentUrl();
			String expectedUrl = testContext.getHelper().getUserPageUrl();
			System.out.println("actual url" + actualUrl);
			System.out.println("expectedUrl url" + expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			deleteMultipleUserSD.userNotDelete();
			Log.info("'NO' button clicked on the alert for delete multiple user DMU");

		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	// *******Multiple checkbox deleted************

	@Given("Admin clicks delete button under header after selecting multiple checkboxes in the data table DMU")
	public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table_DMU() {
		try {
			Log.startTestCase();
			deleteMultipleUserSD.selectCheckboxesForRow134();
			Thread.sleep(2000);
			deleteMultipleUserSD.ClickDelBtn();
			Thread.sleep(2000);
			Assert.assertTrue(deleteMultipleUserSD.deleletePopUpOptionYes().isDisplayed(),
					"Delete popoup does not have yes button displayed");

			Log.info("Admin clicks delete button under header after selecting multiple checkboxes ");

		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table DMU")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table_DMU()
			throws InterruptedException {
		//String actualUrl = testContext.getHelper().getCurrentUrl();
		//String expectedUrl = testContext.getHelper().getUserPageUrl();
		String actualUrl  =deleteMultipleUserSD.getcurrentUrl();
		String expectedUrl  =deleteMultipleUserSD.getUserPageUrl();
		System.out.println("actual url" + actualUrl);
		System.out.println("expectedUrl url" + expectedUrl);

		deleteMultipleUserSD.userDeleteSucess();
		// deleteMultipleUserSD.validaterowisDeleted();

		Log.info("Admin is in Manage User Page");

	}

	@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data tables DMU")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_tables_DMU()
			throws InterruptedException {
		//String actualUrl = testContext.getHelper().getCurrentUrl();
		//String expectedUrl = testContext.getHelper().getUserPageUrl();
		String actualUrl  =deleteMultipleUserSD.getcurrentUrl();
		String expectedUrl  =deleteMultipleUserSD.getUserPageUrl();
		System.out.println("actual url" + actualUrl);
		System.out.println("expectedUrl url" + expectedUrl);
		deleteMultipleUserSD.selectCheckboxesForRow134();
		deleteMultipleUserSD.ClickDelBtn();
		deleteMultipleUserSD.ClickDeleleteoptionNo();
		deleteMultipleUserSD.userNotDelete();

	}

	@When("Admin clicks {string} button on the alert DMU")
	public void admin_clicks_yes_button_on_the_alert_DMU(String expYes) {
		deleteMultipleUserSD.ClickDeleteYesBtn();
		Log.info("Admin click Yes Button");
	}

	@Then("Admin should land on Manage User page and can see the selected user is deleted from the data table DMU")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_deleted_from_the_data_table_DMU()
			throws InterruptedException {
		//String actualUrl = testContext.getHelper().getCurrentUrl();
		//String expectedUrl = testContext.getHelper().getUserPageUrl();
		String actualUrl  =deleteMultipleUserSD.getcurrentUrl();
		String expectedUrl  =deleteMultipleUserSD.getUserPageUrl();
		
		System.out.println("actual url" + actualUrl);
		System.out.println("expectedUrl url" + expectedUrl);
		Log.info("Admin is in Manage User Page");
		deleteMultipleUserSD.validaterowisDeleted();
	}

	@And("Admin is on Confirm Deletion alert DMU")
	public void admin_is_on_confirm_deletion_alert_DMU() {

		Assert.assertTrue(deleteMultipleUserSD.Deletealert().isDisplayed(), "Confirm Deletion alert is not displayed");

		Log.info("Admin is on Confirm Deletion Alert");

	}

}

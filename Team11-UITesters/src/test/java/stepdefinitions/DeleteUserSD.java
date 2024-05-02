package stepdefinitions;

import java.util.NoSuchElementException;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.*;
//import pages.SignInPage;
import pages.UserPageV2;
import utilities.HandleExceptions;
import utilities.Log;

public class DeleteUserSD {

	TestContext testContext;
	UserPageV2 deleteUserSD;

	public DeleteUserSD(TestContext context) {
		testContext = context;
		deleteUserSD = testContext.getPageObjectManager().getUserPageV2();

	}

	@Given("Admin is on dashboard page after Login UM")
	public void admin_is_on_dashboard_page_after_login_UM() {

		//String actualUrl = testContext.getHelper().getCurrentUrl();
		//String expectedUrl = testContext.getHelper().getHomePageUrl();
		String actualUrl  =deleteUserSD.getcurrentUrl();
		String expectedUrl  =deleteUserSD.getdashboardPageUrl();
		
		System.out.println("actual url" + actualUrl);
		System.out.println("expectedUrl url" + expectedUrl);

	}

	@When("Admin clicks User on the navigation bar UM")
	public void admin_clicks_user_on_the_navigation_bar_UM() throws InterruptedException {

		deleteUserSD.clickUserModule();
		Log.info("****Click User Button***");

	}

	@When("Admin clicks the delete icon UM")
	public void admin_clicks_the_delete_icon_UM() throws InterruptedException {
		deleteUserSD.clickUserIdArrow();
		Thread.sleep(2000);
		deleteUserSD.ClickRightDelBtn();
		Log.info("****Clicks Delete Icon***");
	}

	@Given("Admin is on Manage User Page UM")
	public void admin_is_on_manage_user_page_UM() {
		try {
			Log.startTestCase();
			deleteUserSD.clickUserModule();
			String actualUrl = testContext.getHelper().getCurrentUrl();
			String expectedUrl = testContext.getHelper().getUserPageUrl();
			System.out.println("actual url" + actualUrl);
			System.out.println("expectedUrl url" + expectedUrl);

		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}

	}

	@Then("Admin should see a alert open with heading {string} along with  {string} and {string} button for deletion UM")
	public void admin_should_see_a_alert_open_with_heading_along_with_and_button_for_deletion_UM(String expectedconText,
			String expYes, String expNo) {

		try {
			Log.startTestCase();

			Assert.assertTrue(deleteUserSD.Deletealert().isDisplayed(), "Delete popoup is not displayed");
			Assert.assertTrue(deleteUserSD.deleletePopUpOptionNo().isDisplayed(),
					"Delete popoup does not have no button displayed");
			Assert.assertTrue(deleteUserSD.deleletePopUpOptionYes().isDisplayed(),
					"Delete popoup does not have yes button displayed");

			Log.info("Actual Confirm Text,Yes,No ");

		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Given("Admin is on {string} Deletion alert UM")
	public void admin_is_on_deletion_alert_UM(String expectedDelPopUp) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(deleteUserSD.Deletealert().isDisplayed(), "Delete popoup is not displayed");
		String actualText = deleteUserSD.getConfirmText();
		Assert.assertEquals(actualText, expectedDelPopUp);
		Log.info("Admin is on Confirm Deletion Alert");

	}

	@Given("Admin is on {string} Deletion alert UM after clicking delete icon")
	public void admin_is_on_deletion_alert_UM_after_clicking_delete_icon(String expectedDelPopUp) throws InterruptedException {
		deleteUserSD.clickUserModule();
		deleteUserSD.ClickRightDelBtn();
		Assert.assertTrue(deleteUserSD.Deletealert().isDisplayed(), "Delete popoup is not displayed");
		String actualText = deleteUserSD.getConfirmText();
		Assert.assertEquals(actualText, expectedDelPopUp);
		Log.info("Admin is on Confirm Deletion Alert");

	}

	@When("Admin click yes option UM")
	public void admin_click_yes_option_UM() {

		deleteUserSD.ClickDeleteYesBtn();
		Log.info("Admin click Yes Button");
	}

	@And("Admin gets a message {string} and {string} alert message UM")
	public void admin_gets_a_message_and_alert_message_UM(String expectedSuccess, String expectedDeleted) {
		try {
			Log.startTestCase();
			Assert.assertTrue(deleteUserSD.isSuccessDeleteMessageDisplayed(), "Success message not displayed");
			String actualTextMessage = deleteUserSD.getSuccessDeleteMessageText();
			Assert.assertEquals(actualTextMessage, expectedSuccess);
			Log.info("Admin got Success Message");
			Assert.assertTrue(deleteUserSD.isUserDeleteMessageDisplayed(), "Delete user message not displayed");
			String actualTextMessage2 = deleteUserSD.getUserDeleteMessageText();
			Assert.assertEquals(actualTextMessage2, expectedDeleted);
			Log.info("Admin got Deleted User message");
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
	}

	@Then("Admin do not see that user in the data table UM")
	public void admin_do_not_see_that_user_in_the_data_table_UM() throws InterruptedException {
		deleteUserSD.userDeleteSucess();

		Log.info("Deleted User Not Present in Data table");
	}

	@When("Admin click No option UM")
	public void admin_click_no_option_UM() throws InterruptedException {
		deleteUserSD.ClickDeleleteoptionNo();
		Log.info("Admin click No Button");
	}

	@Then("Admin can see the deletion alert disappears without any changes UM")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_UM() {
		deleteUserSD.isUserConfirmPopUpDisplayed();
		Log.info("deletion alert disappears ");
	}

	@When("Admin clicks on close button UM")
	public void admin_clicks_on_close_button_UM() {
		try {
			Log.startTestCase();
			deleteUserSD.clickCloseBtn();
			Log.info("Admin click Close Button");
		} catch (NoSuchElementException ex) {

			Log.error("Element not found: " + ex.getMessage());
		} catch (Exception ex) {

			HandleExceptions.Handle(ex);
		}
	}

	@When("Admin clicks any checkbox in the data table UM")
	public void admin_clicks_any_checkbox_in_the_data_table_UM() {
		deleteUserSD.clickAnyCheckBox();
		Log.info("Admin click any Checkbox");
	}

	@Then("Admin should see common delete option enabled under header Manage Program UM")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program_UM() {

		Assert.assertTrue(deleteUserSD.commonDeleteBtn(), "Common delete button is not  enabled.");

	}

}

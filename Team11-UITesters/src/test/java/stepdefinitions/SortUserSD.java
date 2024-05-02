package stepdefinitions;
import org.testng.Assert;
import context.TestContext;
import io.cucumber.java.en.*;
import pages.UserPageV2;
import utilities.Log;



public class SortUserSD{

	
	
TestContext testContext;
UserPageV2 sortUserSD;

 
	public SortUserSD(TestContext context) {
		testContext = context;
		sortUserSD = testContext.getPageObjectManager().getUserPageV2();
			}
@Given("Admin is on dashboard page after Login SU")
public void admin_is_on_dashboard_page_after_login_su() throws InterruptedException {
		sortUserSD.clearsearch();
		Log.info("Admin is in the dashboard page");
}

@When("Admin clicks User from navigation bar SU")
public void admin_clicks_user_from_navigation_bar_su() throws InterruptedException {
	sortUserSD.clickUserModule();

}

@Given("Admin is on Manage User Page SU")
public void admin_is_on_manage_user_page_su() {
  
//String actualUrl = testContext.getHelper().getCurrentUrl();
	String actualUrl  =sortUserSD.getcurrentUrl();
	String expectedUrl  =sortUserSD.getUserPageUrl();
	
//String expectedUrl = testContext.getHelper().getUserPageUrl();
System.out.println("Actual URL: " + actualUrl);
System.out.println("Expected URL: " + expectedUrl);
Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");

	Log.info("Admin is in the Manager User page");
}

@When("Admin clicks on ID sort icon SU")
public void admin_clicks_on_id_sort_icon_su() {
	sortUserSD.clickSortuID();
}

@Then("Admin should see User details are sorted by id SU")
public void admin_should_see_user_details_are_sorted_by_id_su() {

	sortUserSD.clickIdAscending();
	Log.info("sorting Id ascending validation success");
	
}

@When("Admin clicks on name sort icon SU")
public void admin_clicks_on_name_sort_icon_su() {
	sortUserSD.clickSortUName();
	
	Log.info("Clicking Name Arrow");
}

@Then("Admin should see User details are sorted by name SU")
public void admin_should_see_user_details_are_sorted_by_name_su() {
	
	sortUserSD.clickNameAscending();
	Log.info("sorting Name validation success");
}

@When("Admin clicks on Location sort icon SU")
public void admin_clicks_on_location_sort_icon_su() {
	sortUserSD.clickSortLocation();
	Log.info("clicking Location Arrow");
}

@Then("Admin should see User details are sorted by Location SU")
public void admin_should_see_user_details_are_sorted_by_location_su() {
	sortUserSD.clickLocationAscending();
	Log.info("sorting Location validation success");
}

@When("Admin clicks on Phone number sort icon SU")
public void admin_clicks_on_phone_number_sort_icon_su() {
	sortUserSD.clickSortPhoneNumber();
	Log.info("clicking Phone Number Arrow");
}

@Then("Admin should see User details are sorted by Phone number SU")
public void admin_should_see_user_details_are_sorted_by_phone_number_su() {
	sortUserSD.clickPhoneAscending();
	Log.info("sorting Phone validation success");
}

	
	
	

}

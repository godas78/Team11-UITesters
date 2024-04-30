package stepdefinitions;

import java.util.List;
import java.util.Map;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import pages.HomePage;
import readers.ExcelReader;
import utilities.Log;

public class LoginCredentialsSD {

TestContext testContext;
	
	HomePage homePage;
	ExcelReader reader = new ExcelReader();
	DriverManager webDriverManager;
	
	public LoginCredentialsSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		webDriverManager=testContext.getWebDriverManager();
	}
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
		webDriverManager.getDriver();
	   homePage.appUrl();
	   
	}

	@When("Admin enter valid credentials from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		System.out.println(testData);
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		homePage.validuser(user);
		homePage.validpassword(password);
		homePage.logincheck();
	   
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		Log.info("Login is successful with valid credential");
	   
	}

	@When("Admin enter invalid credentials from excel sheet {string} and {int}")
	public void admin_enter_invalid_credentials_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		homePage.invalidlogin(user, password);
	   
	}

	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {
		Log.info("Please check username/password");
	   
	}

	@When("Admin enter valid username from excel sheet {string} and {int}")
	public void admin_enter_valid_username_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
	    homePage.validuser(user);
	    homePage.validpassword(password);;
	    homePage.logincheck();
	   
	}

	@Then("Error message please check password")
	public void error_message_please_check_password() {
		Log.info("Please check password ");
	   
	}

	@When("Admin enter valid  password from excel sheet {string} and {int}")
	public void admin_enter_valid_password_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		homePage.validuser(user);
		homePage.validpassword(password);
		homePage.logincheck();
	   
	}

	@Then("Error message please check username")
	public void error_message_please_check_username() {
		Log.info("Please check user ");
	   
	}

	@When("Admin enter blank in username from excel sheet {string} and {int}")
	public void admin_enter_blank_in_username_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String password=testData.get(int1).get("Password");
		homePage.validpassword(password);
	    homePage.logincheck();
	   
	}

	@Then("Error message please check username or password")
	public void error_message_please_check_username_or_password() {
		Log.info("Please check user and password ");
	   
	}

	@When("Admin enter blank in password from excel sheet {string} and {int}")
	public void admin_enter_blank_in_password_from_excel_sheet_and(String string, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		homePage.validuser(user);
	    homePage.logincheck();
	   
	}

	@Then("Error message please check username also password")
	public void error_message_please_check_username_also_password() {
		Log.info("Please check user and password");
	   
	}

	@When("Admin clicks Login button with empty values in both columns")
	public void admin_clicks_login_button_with_empty_values_in_both_columns() {
		homePage.logincheck();
	   
	}

	@Then("Error message please check username and password")
	public void error_message_please_check_username_and_password() {
		Log.info("Please check user ");
	   
	}

	@When("Admin enter valid credentials and click through keyboard from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_and_click_through_keyboard_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		homePage.validuser(user);
		homePage.validpassword(password);
		homePage.keyboardaction();
	   
	}

	@Then("Admin should land dashboard page")
	public void admin_should_land_dashboard_page() {
		Log.info("Login is successful");
	   
	}

	@When("Admin enter valid credentials and click through mouse from excel sheet {string} and {int}")
	public void admin_enter_valid_credentials_and_click_through_mouse_from_excel_sheet_and(String Login, Integer int1) {
		List<Map<String,String>> testData=reader.ReadExcelFile("Login");
		String user=testData.get(int1).get("User");
		String password=testData.get(int1).get("Password");
		homePage.validuser(user);
		homePage.validpassword(password);
		homePage.mouseaction();
	   
	}

	@Then("Admin land on dashboard page")
	public void admin_land_on_dashboard_page() {
		Log.info("Login is successful");
	   
	}

}

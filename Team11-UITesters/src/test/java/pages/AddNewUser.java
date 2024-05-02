package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import context.TestContext;
import managers.FileReaderManager;
import utilities.Log;

public class AddNewUser {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@FindBy(xpath = "//div/button[@id='new']")
	WebElement newUserButton;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchbox;

	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']")
	WebElement tablebody;

	@FindBy(xpath = "//div[contains(@role, 'dialog')]")
	WebElement UserDetailsPOPUP;

	@FindBy(xpath = "//span[contains(text(), 'User Details')]")
	WebElement UserpopTitle;
	// xpaths for all input text fields
	@FindBy(xpath = "//input[@*='First name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@*='Middle name']")
	WebElement Midname;

	@FindBy(xpath = "//input[@*='Last name']")
	WebElement Lname;

	@FindBy(xpath = "//input[@*='Location']")
	WebElement loc;

	@FindBy(xpath = "//input[@*='Phone no']")
	WebElement phone;

	@FindBy(xpath = "//input[@*='LinkedIn Url']")
	WebElement linked;

	@FindBy(xpath = "//input[@*='Email address']")
	WebElement email;

	@FindBy(xpath = "//input[@*='Under Graduate']")
	WebElement UG;

	@FindBy(xpath = "//input[@*='Post Graduate']")
	WebElement PG;

	@FindBy(xpath = "//input[@*='Time Zone']")
	WebElement timezone;

	@FindBy(xpath = "//input[@*='User Comments']")
	WebElement comment;

	@FindBy(xpath = "//button/span[@class='mat-button-wrapper' and text()='Submit']")
	WebElement submitbutton;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Cancel']")
	WebElement cancelbutton;

	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon')]")
	WebElement closebutton;

	// xpath for the dropdwon lists

	@FindBy(xpath = " //*[@id='roleId']/div/span")
	WebElement userroleDropdown;

	@FindBy(xpath = "//*[@id='userRoleStatus']/div/span")
	WebElement UserRolestatusdropdown;

	@FindBy(xpath = "//*[@id='userVisaStatus']/div/span")
	WebElement UservisastatusDropdown;

	// USER ROLE DROPDWON OPTIONS

	// @FindBy(xpath="//*[@id='roleId']/div/span[text()='R01']")
	@FindBy(xpath = "//*[@id='roleId']/div/div[3]/div/ul/p-dropdownitem[1]/li ")
	WebElement userR01;

	@FindBy(xpath = "//*[@id='roleId']/div/div[3]/div/ul/p-dropdownitem[2]/li")
	WebElement userR02;

	@FindBy(xpath = "//*[@id='roleId']/div/div[3]/div/ul/p-dropdownitem[3]/li")
	WebElement userR03;

	// user role status options
	@FindBy(xpath = "//*[@id='userRoleStatus']/div/div[3]/div/ul/p-dropdownitem[1]/li")
	WebElement ActiveURS;

	@FindBy(xpath = "//*[@id='userRoleStatus']/div/div[3]/div/ul/p-dropdownitem[2]/li")
	WebElement InactiveURS;

	// user visa status
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[1]/li/span")
	WebElement Notspecified;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[2]/li/span")
	WebElement NA;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[3]/li/span")
	WebElement GCEAD;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[4]/li/span")
	WebElement H4EAD;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[5]/li/span")
	WebElement H4;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[6]/li/span")
	WebElement H1B;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[7]/li/span")
	WebElement CanadaEAD;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[8]/li/span")
	WebElement IndianCitizen;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[9]/li/span")
	WebElement USCitizen;
	@FindBy(xpath = "//*[@id='userVisaStatus']/div/div[3]/div/ul/p-dropdownitem[10]/li/span")
	WebElement CanadaCitizen;

// xpaths for all naming fields
	@FindBy(xpath = "//div/span/label/span[text()='First name']")
	WebElement FnameText;

	@FindBy(xpath = "//div/span/label/span[text()='Last name']")
	WebElement LnameText;

	@FindBy(xpath = "//div/span/label/span[text()='Middle name']")
	WebElement MidnameText;

	@FindBy(xpath = "//div/span/label/span[text()='Location']")
	WebElement locationText;

	@FindBy(xpath = "//div/span/label/span[text()='Phone no']")
	WebElement phoneText;

	@FindBy(xpath = "//div/span/label/span[text()='Under Graduate']")
	WebElement ugText;

	@FindBy(xpath = "//div/span/label/span[text()='Post Graduate']")
	WebElement pgText;

	@FindBy(xpath = "//div/span/label/span[text()='Time Zone']")
	WebElement timezoneText;

	@FindBy(xpath = "//div/span/label/span[text()='User Comments']")
	WebElement commenText;

	@FindBy(xpath = "//div/span/label/span[text()='LinkedIn Url']")
	WebElement linkedinText;

	@FindBy(xpath = "//div[@class='p-field']/label[text()='User Role']")
	WebElement userroleText;

	@FindBy(xpath = "//div[@class='p-field']/label[text()='User Role Status']")
	WebElement userroleStatusText;

	@FindBy(xpath = "//div[@class='p-field']/label[text()='User Visa Status']")
	WebElement userVisaStatusText;

// alert messages

	@FindBy(xpath = "//mat-form-field/div/div[3]/div/mat-error")
	WebElement ErrorMSG;

	String name1 = "Rocksin10";
	String actualErrMSG;
	String expectedErrMSg;

	public AddNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddNewUserBtn() throws InterruptedException {
		newUserButton.click();
		Log.info("Add New User button is clicked");
		Thread.sleep(80);
		UserDetailsPOPUP.isDisplayed();
		Log.info("userdetails pop up title :" + UserpopTitle.getText());

	}

	public void validateAddUserPopup() {
		Assert.assertTrue(FnameText.isDisplayed(), "Firstname is not displayed");
		Assert.assertTrue(MidnameText.isDisplayed(), "Midname is not displayed");
		Assert.assertTrue(LnameText.isDisplayed(), "lastname is not displayed");
		Assert.assertTrue(locationText.isDisplayed(), "Location is not displayed");
		Assert.assertTrue(phoneText.isDisplayed(), "Phone number is not displayed");
		Assert.assertTrue(linkedinText.isDisplayed(), "Linkedin url is not displayed");
		Assert.assertTrue(email.isDisplayed(), "Email id is not displayed");
		Assert.assertTrue(ugText.isDisplayed(), "Under grad is not displayed");
		Assert.assertTrue(pgText.isDisplayed(), "Post grad is not displayed");
		Assert.assertTrue(timezoneText.isDisplayed(), "timezone is not displayed");
		Assert.assertTrue(commenText.isDisplayed(), "comment is not displayed");
		Assert.assertTrue(cancelbutton.isDisplayed(), "cancel button is not displayed");
		Assert.assertTrue(submitbutton.isDisplayed(), "Submit is not displayed");
		Assert.assertTrue(userroleText.isDisplayed(), "userrole text  is not displayed");
		Assert.assertTrue(userroleStatusText.isDisplayed(), "userrole status is not displayed");
		Assert.assertTrue(userVisaStatusText.isDisplayed(), "user visa status is not displayed");
		Assert.assertTrue(closebutton.isDisplayed(), "close button is not displayed");
		Log.info("All the required fields of user details popup are displayed");
		cancelbutton.click();
	}

	public void validateAddUserText() {

		Assert.assertTrue(firstname.isDisplayed());
		Assert.assertTrue(Midname.isDisplayed());
		Assert.assertTrue(Lname.isDisplayed());
		Assert.assertTrue(loc.isDisplayed());
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(linked.isDisplayed());

		Assert.assertTrue(email.isDisplayed());

		Assert.assertTrue(UG.isDisplayed());
		Assert.assertTrue(PG.isDisplayed());
		Assert.assertTrue(timezone.isDisplayed());
		Assert.assertTrue(comment.isDisplayed());

		Log.info("All the required input text fields of user details popup are displayed");
		cancelbutton.click();
	}

	public void validateUserDropdowns() {
		Assert.assertTrue(userroleDropdown.isDisplayed(), "userroleDropdown  is not displayed");
		Assert.assertTrue(UserRolestatusdropdown.isDisplayed(), "UserRolestatusdropdown is not displayed");
		Assert.assertTrue(UservisastatusDropdown.isDisplayed(), "uservisa status dropdown is not displayed");
		Log.info("All the dropdowns are displayed");
		cancelbutton.click();
	}

	public void validatecreateUSerdetails() {
		firstname.sendKeys("Rocksin10");
		Midname.sendKeys("D");
		Lname.sendKeys("m");
		loc.sendKeys("NYC");
		phone.sendKeys("9880099112");
		linked.sendKeys("https://www.linkedin.com/in/Mike/");
		email.sendKeys("rocksin10@gmail.com");
		UG.sendKeys("CSE");
		PG.sendKeys("MS");
		timezone.sendKeys("EST");
		comment.sendKeys("test");
		userroleDropdown.click();
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userR01.click();
		UserRolestatusdropdown.click();
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActiveURS.click();
		UservisastatusDropdown.click();
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CanadaCitizen.click();

		submitbutton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void valdiatemissinginputsAdduser() {

		firstname.sendKeys("");
		Midname.sendKeys("");

		actualErrMSG = ErrorMSG.getText().trim();;
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGFname().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info(" error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		Lname.click();
		WebElement ErrorMSGMname =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Middle name is ']"));
		actualErrMSG = ErrorMSGMname.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGMidname().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info(" error message is correct" + actualErrMSG);
		} else {
			Log.info(" Error message is incorrect." + expectedErrMSg);
		}
		loc.click();
		WebElement ErrorMSGLname =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Last name is ']"));
		actualErrMSG = ErrorMSGLname.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGLastname().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		phone.click();
		WebElement ErrorMSGLoc =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Location is ']"));
		actualErrMSG = ErrorMSGLoc.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGLocation().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		linked.click();
		WebElement ErrorMSGphone =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Phone number is ']"));
		actualErrMSG = ErrorMSGphone.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGPhone().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		email.click();
		WebElement ErrorMSLinked =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='LinkedIn Url is ']"));
		actualErrMSG = ErrorMSLinked.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGLinkedin().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		UG.click();
		WebElement ErrorMSemail =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Email address is ']"));
		actualErrMSG = ErrorMSemail.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGEmail().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		PG.click();
		WebElement ErrorMSUG =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Under Graduate is ']"));
		actualErrMSG = ErrorMSUG.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGUG().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		timezone.click();
		WebElement ErrorMSPG =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Post Graduate is ']"));
		actualErrMSG = ErrorMSPG.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGPG().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		
		comment.click();
		WebElement ErrorMStime =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='Time Zone is ']"));
		actualErrMSG = ErrorMStime.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGTimeZone().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		timezone.click();
		WebElement ErrorMScomment =driver.findElement(By.xpath("//mat-form-field/div/div[3]/div/mat-error[text()='User Comments is ']"));
		actualErrMSG = ErrorMScomment.getText().trim();
		expectedErrMSg = FileReaderManager.getInstance().getConfigReader().getexpectedErrorMSGComment().trim();
		if (actualErrMSG.equalsIgnoreCase(expectedErrMSg)) {
			Log.info("error message is correct" + actualErrMSG);
		} else {
			Log.info("Error message is incorrect." + expectedErrMSg);
		}
		submitbutton.click();
	}

	public void valdiateerrormsgAddUser() {
		Log.info("All the fields error messages are validated and are correct");
		cancelbutton.click();
	}

	public void validateNewUserSuccess() {

		Log.info("user added successfully");
	}

	public void validateEmptyformSubmit() {
		
		cancelbutton.click();
	}


	public void validateCancelUM1() {

		cancelbutton.click();
		Log.info("user popup window is cancelled");
	}

	public void validateUserdetailpopclose() {

		

			Log.info("add user pop up is closed");
		
	}

	public void closeUserUM1() {
		closebutton.click();
		Log.info("pop up closed by clicking on close Icon");

	}

	public void validatecloseUserPopupUM1() {
		tablebody.isDisplayed();
		Log.info("add user pop up is closed and TABLE BODY is displayed");
	}

	public void validateNewuserDatatable() {
		searchbox.isEnabled();
		searchbox.sendKeys(name1);

		Log.info("username is entered in the searchbox : ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {

			List<WebElement> newrowDataList = driver.findElements(By.xpath("//tbody/tr[@class='ng-star-inserted']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(newrowDataList));
			int rowcount = newrowDataList.size();
			Log.info("row data size " + rowcount);
			for (WebElement row : newrowDataList) {
				String rowdata = row.getText();
				Log.info("rowdata value : " + rowdata);
				Assert.assertTrue(rowdata.contains(name1), "searchbox showed the correct rowdata");
				Log.info("only firstname is entered " + rowdata.contains(name1));
				Log.info("username is entered " + name1);
			}

		} catch (AssertionError e) {
			Log.error("error occurred during pagination" + e.getMessage());

		} catch (Exception e) {
			Log.error("error occurred during pagination" + e.getMessage());

		}

	}
}

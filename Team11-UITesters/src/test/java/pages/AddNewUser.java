package pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Log;

public class AddNewUser {
	
	WebDriver driver;
	@FindBy(xpath="//div/button[@id='new']")
	WebElement newUserButton;
	
	@FindBy(xpath="//div[contains(@role, 'dialog')]")
	WebElement UserDetailsPOPUP;
	
	@FindBy(xpath="//span[contains(text(), 'User Details')]")
	WebElement UserpopTitle;
	//xpaths for all input text fields
	@FindBy(xpath="//input[@*='First name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@*='Middle name']")
	WebElement Midname;
	
	@FindBy(xpath="//input[@*='Last name']")
	WebElement Lname;
	
	@FindBy(xpath="//input[@*='Location']")
	WebElement loc;
	
	@FindBy(xpath="//input[@*='Phone no']")
	WebElement phone;
	
	@FindBy(xpath="//input[@*='LinkedIn Url']")
	WebElement linked;
	
	@FindBy(xpath="//input[@*='Email address']")
	WebElement email;
	
	@FindBy(xpath="//input[@*='Under Graduate']")
	WebElement UG;
	
	@FindBy(xpath="//input[@*='Post Graduate']")
	WebElement PG;
	
	@FindBy(xpath="//input[@*='Time Zone']")
	WebElement timezone;
	
	@FindBy(xpath="//input[@*='User Comments']")
	WebElement comment;
	
	@FindBy(xpath="//button/span[@class='mat-button-wrapper' and text()='Submit']")
	WebElement submitbutton;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper' and text()='Cancel']")
	WebElement cancelbutton;
	
	@FindBy(xpath="//span[contains(@class,'p-dialog-header-close-icon')]")
	WebElement closebutton;
	
	//xpath for the dropdwon lists
	
	@FindBy(xpath=" //*[@id='roleId']/div/span")
	WebElement userroleDropdown;
	
	@FindBy(xpath="//*[@id='userRoleStatus']/div/span")
	WebElement UserRolestatusdropdown;
	
	@FindBy(xpath="//*[@id='userVisaStatus']/div/span")
	WebElement UservisastatusDropdown;
	//USER ROLE DROPDWON OPTIONS
	
	@FindBy(xpath="//*[@id='roleId']/div/span[text()='R01']")
	WebElement userR01;
	
	@FindBy(xpath="//*[@id='roleId']/div/span[text()='R02']")
	WebElement userR02;
	
	@FindBy(xpath="//*[@id='roleId']/div/span[text()='R03']")
	WebElement userR03;
	
	//user role status options
	@FindBy(xpath="//*[@id='userRoleStatus']/div/span[text()='Active']")
	WebElement ActiveURS;
	
	@FindBy(xpath="//*[@id='userRoleStatus']/div/span[text()='Inactive']")
	WebElement InactiveURS;
	
	//user visa status
	
	@FindBy(xpath="//*[@id='userVisaStatus']/div/span[text()='Not-Specified']")
	WebElement visaNotspec;
	
	
// xpaths for all naming fields
	@FindBy(xpath="//div/span/label/span[text()='First name']")
	WebElement FnameText;
	
	@FindBy(xpath="//div/span/label/span[text()='Last name']")
	WebElement LnameText;
	
	@FindBy(xpath="//div/span/label/span[text()='Middle name']")
	WebElement MidnameText;
	
	@FindBy(xpath="//div/span/label/span[text()='Location']")
	WebElement locationText;
	
	@FindBy(xpath="//div/span/label/span[text()='Phone no']")
	WebElement phoneText;
	
	@FindBy(xpath="//div/span/label/span[text()='Under Graduate']")
	WebElement ugText;
	
	@FindBy(xpath="//div/span/label/span[text()='Post Graduate']")
	WebElement pgText;
	
	@FindBy(xpath="//div/span/label/span[text()='Time Zone']")
	WebElement timezoneText;
	
	@FindBy(xpath="//div/span/label/span[text()='User Comments']")
	WebElement commenText;
	
	@FindBy(xpath="//div/span/label/span[text()='LinkedIn Url']")
	WebElement linkedinText;
	
	@FindBy(xpath="//div[@class='p-field']/label[text()='User Role']")
	WebElement userroleText;
	
	@FindBy(xpath="//div[@class='p-field']/label[text()='User Role Status']")
	WebElement userroleStatusText;
	
	@FindBy(xpath="//div[@class='p-field']/label[text()='User Visa Status']")
	WebElement userVisaStatusText;
	
// alert messages
	
	@FindBy(xpath="//*[@id='mat-error-0']")
	WebElement firstnameAlert;
	
	@FindBy(xpath="//*[@id='mat-error-1']")
	WebElement midnameAlert;
	
	@FindBy(xpath="//*[@id='mat-error-2']")
	WebElement lastnameAlert;
	
	
	public AddNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddNewUserBtn() throws InterruptedException {
		newUserButton.click();
		Log.info("Add New User button is clicked");
		Thread.sleep(100);
		UserDetailsPOPUP.isDisplayed();
		Log.info("userdetails pop up title :" +UserpopTitle.getText());
		
	}
	public void validateAddUserPopup() {
		Assert.assertTrue(FnameText.isDisplayed(),"Firstname is not displayed");
		Assert.assertTrue(MidnameText.isDisplayed(),"Midname is not displayed");
		Assert.assertTrue(LnameText.isDisplayed(),"lastname is not displayed");
		Assert.assertTrue(locationText.isDisplayed(),"Location is not displayed");
		Assert.assertTrue(phoneText.isDisplayed(),"Phone number is not displayed");
		Assert.assertTrue(linkedinText.isDisplayed(),"Linkedin url is not displayed");
		Assert.assertTrue(email.isDisplayed(),"Email id is not displayed");
		Assert.assertTrue(ugText.isDisplayed(),"Under grad is not displayed");
		Assert.assertTrue(pgText.isDisplayed(),"Post grad is not displayed");
		Assert.assertTrue(timezoneText.isDisplayed(),"timezone is not displayed");
		Assert.assertTrue(commenText.isDisplayed(),"comment is not displayed");
		Assert.assertTrue(cancelbutton.isDisplayed(),"cancel button is not displayed");
		Assert.assertTrue(submitbutton.isDisplayed(),"Submit is not displayed");
		Assert.assertTrue(userroleText.isDisplayed(),"userrole text  is not displayed");
		Assert.assertTrue(userroleStatusText.isDisplayed(),"userrole status is not displayed");
		Assert.assertTrue(userVisaStatusText.isDisplayed(),"user visa status is not displayed");
		Assert.assertTrue(closebutton.isDisplayed(),"close button is not displayed");
		Log.info("All the required fields of user details popup are displayed");
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
		
		
	}
	
	public void validateUserDropdowns() {
		Assert.assertTrue(userroleDropdown.isDisplayed(),"userroleDropdown  is not displayed");
		Assert.assertTrue(UserRolestatusdropdown.isDisplayed(), "UserRolestatusdropdown is not displayed");
		Assert.assertTrue(UservisastatusDropdown.isDisplayed(),"uservisa status dropdown is not displayed");
		Log.info("All the dropdowns are displayed");
	}
	
	public void validatecreateUSerdetails() {
		firstname.sendKeys("Mike");
		Midname.sendKeys("Daniel");
		Lname.sendKeys("D");
		loc.sendKeys("NYC");
		phone.sendKeys("1234567891");
		linked.sendKeys("https://www.linkedin.com/in/Mike/");
		email.sendKeys("mike@gmail.com");
		UG.sendKeys("CSE");
		PG.sendKeys("MS");
		timezone.sendKeys("EST");
		comment.sendKeys("test");
		userR02.click();
		ActiveURS.click();
		visaNotspec.click();
		//submitbutton.click();
	}
}

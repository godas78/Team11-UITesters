package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='login']/span[1]")
	WebElement loginBtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']") 
	WebElement password;
	
	
		
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GoToHomePage()
	{
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigated to LMS Web Page");
	}

	public String VerifyHomePageURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("Verifies that user is on LMS Web Page");
		return null;
	}
	
	public void ClickOnSignIn()
	{
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getLMSUserName());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getLMSPassword());
		loginBtn.click();
		Log.info("User clicked on Sign in");
	}
	
	/*public void VerifyNotSignedIn()
	{
		Assert.assertEquals(loginBtn.getText(), FileReaderManager.getInstance().getConfigReader().getLoginBtnText());
		Log.info("Verifies that user is not logged in");
	}
	
	public void VerifySignedIn()
	{
		Assert.assertEquals(signedInUser.getText().toLowerCase(), FileReaderManager.getInstance().getConfigReader().getDSAlgoUserName());
		Log.info("Verifies that user is logged in");
	}
	
	
	
	
	
	public void VerifyLoginErrorMsg()
	{
		Assert.assertEquals(alertMsg.getText(), FileReaderManager.getInstance().getConfigReader().getInvalidLoginMsg());
		Log.info("Verified the message that user is not logged in");
	}
	
	public void VerifyLoginSuccessMsg()
	{
		Assert.assertEquals(alertMsg.getText(), FileReaderManager.getInstance().getConfigReader().getValidLoginMsg());
		Log.info("Verified the success message for log in");
	}
	
	public void ClickOnSignOut()
	{
		signOutBtn.click();
		Log.info("User clicked on Sign out");
	}
	
	public void VerifyLogoutSuccessMsg()
	{
		Assert.assertEquals(alertMsg.getText(), FileReaderManager.getInstance().getConfigReader().getLogoutSuccessMsg());
		Log.info("Verified the success message for log out");
	}
	
	
	
	public void VerifySuccessfulRegistration(String userName) {
		String expectedMsg =  FileReaderManager.getInstance().getConfigReader().getSuccessfulRegisterationMsg() + userName;
		Assert.assertEquals(alertMsg.getText(), expectedMsg);
		Log.info("Verified registration success message for user " + userName);
	}*/
}

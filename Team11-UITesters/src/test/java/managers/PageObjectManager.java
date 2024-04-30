package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private HomePage homePage;
	
	private Userpagevalidation userpagevalidation;
	
	private AddNewUser adduser;

	
	
	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	

	public HomePage getHomePage()
	{
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public Userpagevalidation getUserpagevalidation()
	{
		return(userpagevalidation == null) ? userpagevalidation = new Userpagevalidation(driver) : userpagevalidation;
	}
	
	public AddNewUser getAddUser()
	{
		return(adduser == null) ? adduser = new AddNewUser(driver) : adduser;
	}
	
}

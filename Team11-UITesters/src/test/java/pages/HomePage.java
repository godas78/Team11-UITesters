package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import readers.ConfigFileReader;
import readers.ExcelReader;
import utilities.Log;


public class HomePage {

	WebDriver driver;
	
	String appUrl=ConfigFileReader.getApplicationUrl();
	String invalid_url=ConfigFileReader.getInvalidUrl();
	ExcelReader reader = new ExcelReader();
	//Actions act = new Actions(driver);
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy (xpath  = "//button[@id='login']") WebElement loginBtn;
	 @FindBy (xpath  = "//[@id='login']/span[1]") WebElement logintext ;
	 @FindBy (xpath  = "//button[@id='login']") WebElement loginpageloginbtn;
	 @FindBy (xpath  = "//a[text()='Customers']") WebElement learningtext ;	
	 @FindBy (xpath  = "//a[text()='Management']") WebElement managementtext ;
	 @FindBy (xpath  = "//a[text()='Systems']") WebElement systemtext;
	
	 @FindBy (xpath  = "//icon") WebElement logoimage ;
	 @FindBy (xpath  = "//loginpageheader") WebElement loginpageheader;
	 @FindBy (xpath  = "//loginpagetrailer") WebElement loginpagetrailer;
	
	 @FindBy (xpath  = "//input[@type='text']") WebElement textcheckuser;
	 @FindBy (xpath  = "//input[@type='password']") WebElement textcheckpassword;
;
	 @FindBy (xpath  = "//user//span[@class='Field_RequiredStar'][1]") WebElement loginuserasterick;
	 @FindBy (xpath  = "//password//span[@class='Field_RequiredStar'][1]") WebElement loginpasswordasterick;	
	
	 public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GoToHomePage()
	{
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		Log.info("User navigated to Home Page");
	}

	public String VerifyHomePageURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		Log.info("Verifies that user is on Home Page");
		return null;
	}

	public void appUrl() {
		driver.get(appUrl);
		
	}
	public void invalid_url() {
		driver.get(invalid_url);
		
	}
	public void invalidURLstatus() {
		assertTrue(driver.getTitle().contains("404"));
	}
	public void broken_links() {
		// TODO Auto-generated method stub
		
	}

	public void spellchecker() {
		// TODO Auto-generated method stub
		
	}

	public void correctlogo(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void logoaligned() {
		// TODO Auto-generated method stub
		
	}

	public void loginbtncheck() {
		if(loginBtn.isDisplayed()) 
		{
		    System.out.println("Login button is Displayed");
		}
		else
		    System.out.println("Show more is not there");
	}
		

	public void logincheck() {
		loginBtn.click();
	}
	public void getallText() {
		driver.getPageSource();
	}
	public void headerlogin(String string) {
		String expectedmsg = string;
		String actualmsg = loginpageheader.getText();
		Assert.assertEquals(expectedmsg,actualmsg);
		 System.out.println(actualmsg);
	}

	public void textcheck(int i) {
		// TODO Auto-generated method stub
		
	}

	public void usertext(String string) {
		String expectedmsg = string;
		String actualmsg = username.getText();
		Assert.assertEquals(expectedmsg,actualmsg);
		 System.out.println(actualmsg);
		
	}

	public void passwordtext(String string) {
		String expectedmsg = string;
		String actualmsg = password.getText();
		Assert.assertEquals(expectedmsg,actualmsg);
		 System.out.println(actualmsg);
		
	}
	public void astrikuser(String string) {
		String expectedmsg = string;
  		String actualmsg = loginuserasterick.getText();
  		Assert.assertEquals(expectedmsg,actualmsg);
  		 System.out.println(actualmsg);
		
	}
	public void astrikpassword(String string) {
		 String expectedmsg = string;
	  		String actualmsg = loginpasswordasterick.getText();
	  		Assert.assertEquals(expectedmsg,actualmsg);
	  		 System.out.println(actualmsg);
		
	}

	public void centrepage() {
		Dimension dimuser = username.getSize();
        Dimension dimpassword = password.getSize();
       int heightuser= dimuser.height;
       int widthuser=dimuser.width;
       int heightpassword= dimpassword.height;
       int widthpassword=dimpassword.width;
       
       if (heightuser>30 & heightuser<60 & widthuser>400 & widthuser<600 & heightpassword >30 &heightpassword<60 
      		 & widthpassword>400 & widthpassword<600 ) {
      	Log.info("Both text boxes are in page center");
       }  
		
	}

	public void centreloginbtn() {
		Dimension dimuser = loginBtn.getSize();
        int heightuser= dimuser.height;
        int widthuser=dimuser.width;
        
        if (heightuser>30 & heightuser<60 & widthuser>400 & widthuser<600  ) {
       	Log.info("Login button in the centre");
        }  
	}

	public void usercolor() {
		String color = username.getCssValue("color");
  	  String hex = Color.fromString(color).asHex();
  	  
  	  if (hex=="#808080" ) {
  		  Log.info("User String is in grey color");
  	  }
  	  else {
  		  Log.info("User String is not in grey color");
  	  }
		
	}

	public void passwordcolor() {
		String color = password.getCssValue("color");
  	  String hex = Color.fromString(color).asHex();
  	  
  	  if (hex=="#808080" ) {
  		  Log.info("User String is in grey color");
  	  }
  	  else {
  		  Log.info("User String is not in grey color");
  	  }
		
	}

	public void validuser(String user) {
		username.sendKeys(user);
	}

	public void validpassword(String passwrd) {
		password.sendKeys(passwrd);
		
	}
	public void loginpageloginbtn() {
  	  loginpageloginbtn.click();
    }

	public void invalidlogin(String user, String passwrd) {
		username.sendKeys(user);
  	  password.sendKeys(passwrd);
  	  loginBtn.click();
		
	}

	public void keyboardaction() {
		//act.moveToElement(loginpageloginbtn).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
	}

	public void mouseaction() {
	//	act.doubleClick(loginpageloginbtn).perform();
		
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
	
	public void ClickOnSignIn()
	{
		loginBtn.click();
		Log.info("User clicked on Sign in");
	}
	
	public void ClickOnRegister() {
		registerBtn.click();
	}
	
	public void ClickOnDataStructures()
	{
		dataStructureBtn.click();
		Log.info("User clicked on Get Started button for Data Structure");
	}
	
	public void ClickOnArray()
	{
		arrayBtn.click();
		Log.info("User clicked on Get Started button for Array");
	}
	
	public void ClickOnStack()
	{
		stackBtn.click();
		Log.info("User clicked on Get Started button for Stack");
	}
	
	public void ClickOnLinkedList()
	{
		linkedListBtn.click();
		Log.info("User clicked on Get Started button for Linked List");
	}
	
	public void ClickOnTree()
	{
		treeBtn.click();
		Log.info("User clicked on Get Started button for Tree");
	}
	
	public void ClickOnGraph()
	{
		graphBtn.click();
		Log.info("User clicked on Get Started button for Graph");
	}
	
	public void ClickOnQueue()
	{
		queueBtn.click();
		Log.info("User clicked on Get Started button for Queue");
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
	
	public void ClickOnDataStructuresDropdown() {
		dataStructuresDropdown.click();
	}
	
	public void ClickonDataStructureLinkname(String linkname) {
		WebElement element = driver.findElement(By.xpath("//a[@href='" + linkname + "']"));
		element.click();
	}

	public void ClickonDataStructureDropDown(String linkname) {
		WebElement element = driver.findElement(By.xpath("//a[@href='" + linkname + "']"));
		element.click();
	}
	
	public void VerifySuccessfulRegistration(String userName) {
		String expectedMsg =  FileReaderManager.getInstance().getConfigReader().getSuccessfulRegisterationMsg() + userName;
		Assert.assertEquals(alertMsg.getText(), expectedMsg);
		Log.info("Verified registration success message for user " + userName);
	}*/
}

package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

import utilities.Screenshots;



public class HomePage {

	WebDriver driver;
	
	String appUrl=ConfigFileReader.getApplicationUrl();
	String invalid_url=ConfigFileReader.getInvalidUrl();
	ExcelReader reader = new ExcelReader();
	//Actions act = new Actions(driver);
	String LinkURL = "";
	HttpURLConnection huc = null;
    int respCode = 200;
	
	@FindBy(id="username") WebElement username;
    @FindBy(xpath="//*[@id='mat-form-field-label-1']/span[1]") WebElement usertext;
    @FindBy(xpath="//*[@id='mat-form-field-label-3']/span[1]") WebElement passwordtext;
    @FindBy(id="password") WebElement password;
	@FindBy (xpath  = "//button[@id='login']") WebElement loginBtn;
	 @FindBy (xpath  = "//[@id='login']/span[1]") WebElement logintext ;
	 @FindBy (xpath  = "//button[@id='login']") WebElement loginpageloginbtn;
	//img[@src='assets/img/LMS-logo.jpg']--logo
	 @FindBy (xpath  = "//icon") WebElement logoimage ;
	 @FindBy (xpath  = "//div/mat-card/mat-card-content/form/p") WebElement loginpageheader;
	 @FindBy (xpath  = "//*[@id='mat-form-field-label-1']/span[2]") WebElement usernameasterick;
	 @FindBy (xpath  = "//*[@id='mat-form-field-label-3']/span[2]") WebElement passwordasterick;	
	
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
		
//		String title = driver.getTitle();
//        if (title.contains("404")) {
//            System.out.println("404 Page not found error received for invalid URL");
//        } else {
//            System.out.println("Invalid URL did not return a 404 error");
//        }
	}
	public void broken_links()  {
//List<WebElement> links = driver.findElements(By.tagName("a"));
//        
//        Iterator<WebElement> it = links.iterator();
//        
//        while(it.hasNext()){
//            
//        	LinkURL = it.next().getAttribute("href");
//            
//            System.out.println(LinkURL);
//		
//		if (LinkURL==null || LinkURL.isEmpty()) {
//			Log.info("URL is either not configurerd for anchor tag or it is empty");
//		}
//		
//		try {
//            huc = (HttpURLConnection)(new URL(LinkURL).openConnection());
//            
//            huc.setRequestMethod("HEAD");
//            
//            huc.connect(); 
//            
//            respCode = huc.getResponseCode();
//            
//            if(respCode >= 400){
//                System.out.println(LinkURL+" is a broken link");
//            }
//            else{
//                System.out.println(LinkURL+" is a valid link");
//            }
//		} catch (MalformedURLException e) {
//          
//            e.printStackTrace();
//        } catch (IOException e) {
//            
//            e.printStackTrace();
//        }
//	}
//	}
		String url= driver.getCurrentUrl();
		
		try {		

			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode()> 400) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage()+ " - " + "is a broken link");
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() );
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");

		}	
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
	public String headerlogin() {
		return loginpageheader.getText();
	}

	public void textcheck(int i) {
		// TODO Auto-generated method stub
		
	}

	public String usertext() {
		return usertext.getText();
	}
//		String expectedmsg = string;
//		String actualmsg = username.getText();
//		Assert.assertEquals(expectedmsg,actualmsg);
//		 System.out.println(actualmsg);
//		
//	}
//	public void usertext() {
//		username.getText();
//	}

	public String passwordtext() {
		return passwordtext.getText();
//		String expectedmsg = string;
//		String actualmsg = password.getText();
//		Assert.assertEquals(expectedmsg,actualmsg);
//		 System.out.println(actualmsg);
		
	}
	public void astrikuser(String string) {
		String expectedmsg = string;
  		String actualmsg = usernameasterick.getText();
  		Assert.assertEquals(expectedmsg,actualmsg);
  		 System.out.println(actualmsg);
		
	}
	public void astrikpassword(String string) {
		 String expectedmsg = string;
	  		String actualmsg = passwordasterick.getText();
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
		//act.doubleClick(loginpageloginbtn).perform();
		
	}

}
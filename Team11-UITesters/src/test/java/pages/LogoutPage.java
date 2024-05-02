package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import managers.FileReaderManager;
	import utilities.Log;
	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	public class LogoutPage {
		
	
		WebDriver driver;
		@FindBy(xpath = "//*/div/mat-card/mat-card-content/form/p[text()='Please login to LMS application']")WebElement logoutLabel;
		@FindBy(xpath = "//button/span[text()='Logout']") WebElement Navtologout;
		
		public LogoutPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		public void clickNavtologout() {
			Navtologout.click();
		}
		public void Validationtologoutpage() {
			Assert.assertEquals(logoutLabel.getText(),"Please login to LMS application");
		}
		
}

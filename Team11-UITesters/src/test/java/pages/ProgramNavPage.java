package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProgramNavPage {
	
		WebDriver driver;
	  @FindBy(xpath = "//button/span[text()='Batch']") WebElement Navtobatch;
	  @FindBy(xpath = "//button/span[text()='User']") WebElement Navtouser;
	  @FindBy(xpath = "//button/span[text()='Logout']") WebElement Navtologout;
	  @FindBy(xpath = "//span[contains(text(),'Batch')]")WebElement batchNameLabel;
	  @FindBy(xpath = "//span[contains(text(),'User')]")WebElement userNameLabel;
	  @FindBy(xpath = "//*/div/mat-card/mat-card-content/form/p[text()='Please login to LMS application']")WebElement logoutLabel;
	  
	  
	public ProgramNavPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickNavtobatch() {
		Navtobatch.click();
	}
	public void Validationtobatchpage() {
		Assert.assertEquals(batchNameLabel.getText(),"Batch");
	}
	public void clickNavtouser() {
		Navtouser.click();
	}
	public void Validationtouserpage() {
		Assert.assertEquals(userNameLabel.getText(),"User");
	}
	public void clickNavtologout() {
		Navtologout.click();
	}
	public void Validationtologoutpage() {
		Assert.assertEquals(logoutLabel.getText(),"Please login to LMS application");
	}
}

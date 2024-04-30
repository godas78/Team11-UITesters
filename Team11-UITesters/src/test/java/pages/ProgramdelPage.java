package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProgramdelPage {

	WebDriver driver;
	String footermsg;
	String footermsgforyes;
	String footermsgforyes1;
	String footermsgforNo;
	String footermsgforNo1;
	int num1;
	int num2;
	int num3;
	int num4;
	
	
	@FindBy(xpath = "//table/tbody/tr/td/div/span/button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']") WebElement deleteBtn;
	//@FindBy(xpath = "//table/tbody/tr/td/div/span/button[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']") deleteBtn;
	@FindBy(xpath = "//div[@class='p-dialog-content ng-tns-c133-4']") WebElement confirmpop;
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content')]") WebElement deletepopup;
	@FindBy(xpath = "//span[contains(text(),'Yes')]") WebElement yesbtn;
    @FindBy(xpath = "//span[contains(text(),'No')]") WebElement nobtn;
    @FindBy(xpath = "//div[@class='p-dialog-header-icons ng-tns-c133-4']") WebElement cancelbtn;
    @FindBy(xpath = "//div[contains(@class, 'p-d-flex p-ai-center p-jc-between ng-star-inserted')]") WebElement footerText;
    
		public ProgramdelPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

		public void clickdeletebuttn() {
			deleteBtn.click();
		}
		
		public void acceptdelyes() {
			yesbtn.click();
			
			  }
		
		public void acceptdelno() {
			  nobtn.click();
			  
			  }
		
		public void cancelpopup() {
			cancelbtn.click();			  
			  }
		
		public WebElement Deleletehasoptionyes() {
			return yesbtn;
			
		}
		public WebElement Deleletehasoptionno() {
			return nobtn;
			
		}
		public WebElement Deletealert() {
			
	        return deletepopup;

	}
		public WebElement confirmbox() {
			
	        return confirmpop;

	}
		public void ClickDeleteYesBtn() {
			
			 footermsgforyes=footerText.getAttribute("innerText");
			 System.out.println("this is before yes delete  " +footermsgforyes);
			  yesbtn.click();
		}
		
		public void ClickDeleteNoBtn() {
			footermsgforNo=footerText.getAttribute("innerText");
			 System.out.println("this is before No delete  " +footermsgforNo);
			 nobtn.click();
		}
		
		public void ProgramdeleteSucessAlert() {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.alertIsPresent());
//			Alert alert = driver.switchTo().alert();
//	      System.out.println(alert.getText() + " Alert is Displayed");
			
			footermsgforyes1=footerText.getAttribute("innerText");
			System.out.println("this is after clicking yes to del  " +footermsgforyes1);
			num1 = Integer.parseInt(footermsgforyes.replaceAll("\\D", ""));
	        num2 = Integer.parseInt(footermsgforyes1.replaceAll("\\D", ""));
//	        if (num1 == num2 + 1) {
//	            System.out.println("The integer in the first string." +num1 );
//	        } else {
//	            System.out.println("The integer in the first string is not greater by 1" +num2);
//	        }
	        Assert.assertEquals(num1, num2);
	    }
		
		public void ProgramdeleteNoAlert() {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.alertIsPresent());
//			Alert alert = driver.switchTo().alert();
//	      System.out.println(alert.getText() + " Alert is Displayed");
			
			footermsgforNo1=footerText.getAttribute("innerText");
			System.out.println("this is after clicking No to del  " +footermsgforNo1);
			num3 = Integer.parseInt(footermsgforNo.replaceAll("\\D", ""));
	        num4 = Integer.parseInt(footermsgforNo1.replaceAll("\\D", ""));
//	        if (num1 == num2 + 1) {
//	            System.out.println("The integer in the first string." +num1 );
//	        } else {
//	            System.out.println("The integer in the first string is not greater by 1" +num2);
//	        }
	        Assert.assertEquals(num3, num4);
	    }
}

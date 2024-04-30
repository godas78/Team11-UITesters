package pages;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProgramMdelPage {
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
	
	@FindBy(xpath = "//p-table//tr[1]/td[1]/p-tablecheckbox") WebElement firstcheckbox;
	@FindBy(xpath = "//p-table//tr[2]/td[1]/p-tablecheckbox") WebElement secondCheckbox;
	@FindBy(xpath = "//tr[2]//td[2]") WebElement programnametodelete;
	@FindBy(xpath = "//div[@class='p-confirm-dialog-message ng-tns-c133-4']") WebElement confirmcheckpop;
	@FindBy(xpath = "//div/button/span[@class='p-button-icon p-button-icon-left pi pi-check']") WebElement checkyes;
	@FindBy(xpath = "//div/button/span[@class='p-button-icon p-button-icon-left pi pi-times']") WebElement checkno;
	@FindBy(xpath = "//div/button/span[@class='p-button-icon pi pi-trash']") WebElement deleteicon;
	//@FindBy(xpath = "//div/div[1]/table/thead/tr/th[1][@class='p-checkbox-box']") WebElement deleteallcheckbox;
	@FindBy(xpath = "//p-table//tr//td[1]/p-tablecheckbox") List<WebElement> allcheckboxes;
	@FindBy(xpath = "//div[contains(@class, 'p-d-flex p-ai-center p-jc-between ng-star-inserted')]") WebElement footerText;
	
	public ProgramMdelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	public void clickonedeletecheckbox() {
		firstcheckbox.click();
	}
	public void clickseconddeletecheckbox() {
		secondCheckbox.click();
	}
		
	public void deleteiconenabled() {
		deleteicon.isEnabled();
	}
	
	public void checkdelyes() {
		footermsgforyes=footerText.getAttribute("innerText");
		System.out.println("this is after clicking no to del  " +footermsgforyes);
		checkyes.click();
		
	}
	public void checkdelno() {
		footermsgforNo=footerText.getAttribute("innerText");
		System.out.println("this is after clicking no to del  " +footermsgforNo);
		checkno.click();
		
	}
	public WebElement confirmcheckpop() {
		
        return confirmcheckpop;

}
	public void deleteclick() {
		deleteicon.click();
	}
	public void assertCheckboxesSelected() {
        
		for (WebElement firstcheckbox : allcheckboxes) {
            Assert.assertFalse(firstcheckbox.isSelected());
        }
	}
		
	public void selsecondCheckbox() {
			secondCheckbox.click();
	    }
	
	 public void selallChechbox() {
	       
	        for (WebElement allcheckboxes : allcheckboxes) {
	        	allcheckboxes.click();
	        }
	 }
	 public void ProgramdeletecheckSucessAlert() {
							
			footermsgforyes1=footerText.getAttribute("innerText");			
	        Assert.assertNotEquals(footermsgforyes+1, footermsgforyes1);
	    }
		
		public void ProgramdeletecheckNoAlert() {
			footermsgforNo1=footerText.getAttribute("innerText");
			System.out.println("this is after clicking No to del  " +footermsgforNo1);
			//num3 = Integer.parseInt(footermsgforNo.replaceAll("\\D", ""));
	        //num4 = Integer.parseInt(footermsgforNo1.replaceAll("\\D", ""));
	        Assert.assertEquals(num3, num4);
	    }
}
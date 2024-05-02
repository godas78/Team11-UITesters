package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.internal.org.jline.utils.Log;



public class ProgramPage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[text()=' Manage Program']") public WebElement ManageProgram ;
    @FindBy(id = "filterGlobal") public WebElement Search;
    @FindBy(xpath = "//span[text()='A New Program']")public WebElement ANewProgram;
    @FindBy(id = "program") WebElement program;
    @FindBy(xpath = "//div[@class=\"p-checkbox-box\"]") WebElement Checkbok;
    @FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> deleteIcons;
    @FindAll(@FindBy(how = How.XPATH,using= "//div[@class='p-checkbox-box p-component']")) public List<WebElement> MultipalCheckbox;
    @FindBy(xpath = "//span[@class=\"p-checkbox-icon pi pi-check\"]") WebElement firstCheckBox;
    @FindBy(xpath = "//div[text()=' Manage Program']") WebElement ManageProgramtext;
    @FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']") WebElement PaginationFooter;
    @FindAll(@FindBy(how = How.XPATH,using = "//tbody/tr")) List<WebElement> Tablecount;
    @FindAll(@FindBy(how = How.XPATH,using = "//tr")) List<WebElement> TableHeadercoloumNames;
    @FindBy(xpath = "//thead[@class='p-datatable-thead']") WebElement TableHeader;
    @FindBy(xpath = "//p-paginator/div/span[1]") WebElement paginationText;
    @FindBy(xpath = "//div[@class='p-datatable-footer ng-star-inserted']/div") WebElement FooterText;
    @FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']") public WebElement multipalDeleteButton; 
    @FindBy(xpath = "//th[text()='Program Name ']/p-sorticon") public WebElement ProgramNameSort;
    @FindBy(xpath = "//th[text()='Program Description ']/p-sorticon") public WebElement ProgramDescriptionSort;
    @FindBy(xpath = "//th[text()='Program Status ']/p-sorticon") public WebElement ProgramStatus;
    @FindBy(id = "programName") public WebElement inputName;
    @FindBy(id = "programDescription") public WebElement inputDescription;
    @FindBy(id = "saveProgram") public WebElement saveButton;
    @FindBy(xpath = "//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']") public WebElement xButon;
    @FindBy(xpath = "//div[@class='p-radiobutton-box']") public List<WebElement> radioButtons;
    @FindBy(xpath = "//div[@class='p-radiobutton-box'][1]") public WebElement active;
    @FindBy(xpath = "//div[@class='p-radiobutton-box']") public WebElement inactive;
    @FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']") public List<WebElement> errorMessage;
    @FindBy(xpath="//*[text()='Successful']") public WebElement successprogramMessage;
    @FindBy( xpath = "//span[@class='p-button-icon pi pi-pencil'][1]") public WebElement editButton;
    @FindBy(xpath = "//span[text()='Save']") public WebElement editSave;
    @FindBy( xpath  ="//button[@class='p-toast-icon-close p-link ng-tns-c90-12 p-ripple ng-star-inserted']") public WebElement xSuccessButton;
    @FindBy(xpath  ="//span[text()='Cancel']") public WebElement cancelButton;
   
    public ProgramPage (WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  public void clickOnWebelement(WebElement element, long waitTimeSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
		element= wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
}
  
  public void clickOnProgram() {
	  clickOnWebelement(program, 15);
  }
  
  public String getProgramText() {
	 String text = ManageProgramtext.getText();
	 System.out.println("programText "+text);
	 return text;
  }
  
  public String getProgramurl() {
	String url= driver.getCurrentUrl();
		 System.out.println("programurl "+url);
		 return url;
	  }
  
  public int getTableRowCount  () {
		int count= Tablecount.size();
			 System.out.println("programCount "+count);
			 return count;
		  }
 
  public String getPaginationText() {
		String pagetext= paginationText.getText();
			 System.out.println("programPageText "+pagetext);
			 return pagetext;
		  }
  
  public String getFooterText() {
		String footerText= FooterText.getText();
		System.out.println("programFooterText "+footerText);
			 return footerText;
		  }
  
  public String getExpectedFooterText() {
		String expectedfooterText= getPaginationText();
        String start = "of";
        String end = "entries";
       int startIndex = expectedfooterText.lastIndexOf(start) + 3;
        int endIndex = expectedfooterText.lastIndexOf(end)-1;
           String programCount= expectedfooterText.substring(startIndex, endIndex);
        System.out.println(programCount);
			// System.out.println("programexpectedFooterText "+expectedfooterText);
			 return programCount;
		  }
  
   public boolean validateDisplayelement(WebElement element) {
	   if(element.isDisplayed()) {
	   System.out.println(element.getText());}
	   else {
		   System.out.println("element not display");
		   return false;
	   }
	   
	   return true;
   }
   

   public boolean elementIsEnabled(WebElement element) {
	   return element.isEnabled();
	   
   }
   
   public String getColoumNameText() {
	  String   text = TableHeader.getText();
	  System.out.println(text);
	   return text;
    }
   
   public String getText(WebElement element) {
	 String text = element.getText();
	 System.out.println(text);
	return text;

	 }
  
   public boolean elementcheaking(List<WebElement> element) {
	   for(WebElement e:element ) {
			if(e.isDisplayed()) {
				System.out.println(e.getLocation());
				System.out.println(e.getText());
			}
			else {
				System.out.println("element is not displayed");
				return false;
			}
	   }
			return true;
	   }
   
	   public String getErrorMessage(List<WebElement> element) {
		   String errorMessage = null; 
				   for(WebElement e:element ) {
						if(e.isDisplayed()) {
							System.out.println(e.getText());
						}
				   }
						 
				return errorMessage;
	}
	   public void enterProgramName(String s) {
		   inputName.sendKeys(s);
		    }
	   public void enterProgramDescription( ) {
		   inputDescription.sendKeys("tr");
		    }
	   
	   public void enterProgramDescription(String prograName, String programDescription ) {
		   inputDescription.sendKeys(prograName);
		   inputName.sendKeys(programDescription);
		    }
	   
    public String getSearchtext() {
		 return  Search.getAttribute("placeholder");
		 }
   
   public boolean popUpDisplayed(WebElement element) {
	   if (element.isDisplayed())
	   { System.out.println("program page"+element.getText());
		  
	   }
	   else { 
		   System.out.println("pop up not opend");
		  return false;
	   }
	   return true; 
   }
	   public boolean validateDeleteIconsEnabled() {
	        boolean allDeleteIconsEnabled = true;
	        for (WebElement deleteIcon : deleteIcons) {
	            if (!deleteIcon.isEnabled()) {
	                System.out.println("Delete icon is not enabled: " + deleteIcon.getText());
	                allDeleteIconsEnabled = false;
	            }
	        }
	        return allDeleteIconsEnabled;
	    }

//	public void closePopupWindow(WebElement element) {
//		element.click();
//	}
	 
		
		 }



   
   


package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import readers.ExcelReader;
import utilities.Helper;



public class AddandEditBatchPage {
	
	ExcelReader reader = new ExcelReader();
	Random random = new Random();
	WebDriverWait wait;
	static String batchName, description, noOfClasses,InvalibatchName,Invaliddescription,noOfClassesupdated;
	static String BprogramName = "Python123";
	boolean flag = false;
	
	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement AddBatchPopup; 
	@FindBy(xpath = "//span[contains(text(), 'Batch Details')]") WebElement AddPopuptitle;
	@FindBy(id = "batchName") WebElement BnameText;
	@FindBy(xpath = "//input[@*='batchName']")WebElement BatchnameTextField;
	@FindBy(id = "batchDescription") WebElement BdescText;
	@FindBy(xpath = "//input[@*='batchDescription']") WebElement BdescriptionTextField;
	@FindBy(id="programName") WebElement BprogramNameTextField;
	@FindBy(id = "batchNoOfClasses") WebElement BClassesText; 
	@FindBy(id = "programName") WebElement programNameDropdown;
	@FindBy(xpath = "//div[@*='button']/span")WebElement BprogramNameFieldDropDownBtn;
	@FindBy(xpath = "//div[contains(@class, 'radio')]") WebElement statusField;
	@FindBy(xpath = "//*[@id='batchStatus']/div[1]") WebElement bactiveRadiobtn;
	@FindBy(xpath = "//input[@id='batchNoOfClasses']")WebElement bnoOfClassesField;
	@FindBy(xpath = "//button[@label='Save']")WebElement savebatchBtn;
	@FindBy(css = "tbody.p-datatable-tbody tr") List<WebElement> CurrentRows;
	@FindBy(css = "label[for='batchDescription']") WebElement descriptionLabel;
	@FindBy(xpath = "//span[contains(text(),'A New Batch')]") WebElement addNewbatchbtn;
	//@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon ng-tns-c132-13 pi pi-times')]") WebElement closeerrwindow;
	@FindBy(xpath = "//span[contains(@class, 'p-dialog-header-close-icon')]") WebElement closeerrwindow;
	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']") WebElement beditIcon ;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement editBatchPopup; 
	@FindBy(xpath = "//input[@*='INACTIVE']") WebElement statusINactiveRadiobtn;



	WebDriver driver;
	public AddandEditBatchPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public String ValidateAddNewbatchPopup() {
		
	    if (AddBatchPopup.isDisplayed()) {
	        return AddPopuptitle.getText();
	    } else {
	        return "";
	    	}
		}
	
	public void ValidateAddBtachFields() {
		if (BnameText != null && BdescText != null && BClassesText != null) {
            System.out.println("All required text box fields are present in the pop-up dialog.");
        } else {
            System.out.println("Some fields are missing in the pop-up dialog.");
        }
	}
	
	public boolean isPopupDisplayingProgramNameDropdown() {
        boolean isDisplayed = programNameDropdown.isDisplayed();
        boolean isDropdown = programNameDropdown.getTagName().equals("p-dropdown");
        return isDisplayed && isDropdown;
      
    }
	
	public boolean isStatusFieldRadioButton() {
		boolean statusisDisplayed = statusField.isDisplayed();
		List<WebElement> radioButtons = statusField.findElements(By.xpath("//p-radiobutton"));
        return statusisDisplayed && radioButtons.size() > 0;
    }
	public void clickaddbatch() {
		driver.navigate().back();
		driver.navigate().forward();
		addNewbatchbtn.click();
	}
	
	public void fillValidBatchDetails(String sheetname, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		
		List<Map<String, String>> data = reader.ReadExcelFile("Batch");
	//	batchName = data.get(RowNumber).get("BatchName") + random.nextInt(90) + 10;
		batchName = data.get(rowNumber).get("BatchName");
		BatchnameTextField.sendKeys(batchName);
		Thread.sleep(2000);
		////BdescriptionTextField.sendKeys(data.get(rowNumber).get("Description"));
		description= data.get(rowNumber).get("Description");
		System.out.println("Printing Description" +description);
		Thread.sleep(2000);
		BdescriptionTextField.sendKeys(description);
		BprogramNameFieldDropDownBtn.click();
//		Thread.sleep(2000);
//		WebElement python123Option = driver.findElement(By.xpath("//span[text()='Python123']"));
//		Thread.sleep(2000);
//		python123Option.click();
		
		 WebElement firstOption = driver.findElement(By.xpath("//ul[contains(@class, 'p-dropdown-items')]/p-dropdownitem[1]/li/span"));
	        firstOption.click();
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ENTER).perform();

		Thread.sleep(1000);
	
		if (!bactiveRadiobtn.isSelected()) {
			bactiveRadiobtn.click();
		}
		
		bnoOfClassesField.sendKeys(data.get(rowNumber).get("NoOfClasses"));
		Thread.sleep(1000);
	}

	public void clickSavebatchButton() throws InterruptedException {
		savebatchBtn.click();
		Thread.sleep(1000);
	}
	
	public void checkAddedBatchexists() {
	
		List<WebElement> alltabledata = new ArrayList<>();
	
		WebElement nextPageButton = driver
				.findElement(By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']"));
	
	while (nextPageButton.isEnabled()) {
	
		List<WebElement> currentPageRows = getRowsFromCurrentPage();
	
		alltabledata.addAll(currentPageRows);
	
		for (WebElement row : currentPageRows) {
	
			List<WebElement> cells = row.findElements(By.tagName("td"));
//			for (WebElement cell : cells) {
//                System.out.print(cell.getText() + "\t");
//            }
//            System.out.println(); 
//        
			List<WebElement> filteredCells = new ArrayList<>();
			for (int i = 1; i < cells.size() - 1; i++) {
				filteredCells.add(cells.get(i));
			}
	
			for (WebElement cell : filteredCells) {
	
				if (cell.getText().equalsIgnoreCase(batchName)) {
					flag = true;
					break;
				}
			}
		}
	
		nextPageButton.click();
	}
	
	if (flag) {
		System.out.println("Batch is created and diplayed in the table");
	} else
		System.out.println("batch is not created");
	}
	
	private List<WebElement> getRowsFromCurrentPage() {
		return CurrentRows;
	}

	
	public void checkDescriptionFieldOptional() {
		String labelText = descriptionLabel.getText();
		boolean flag = labelText.contains("*");

		try {
			Assert.assertEquals(flag, "true", "Description should not be a OptionalField");
		} catch (AssertionError e) {

			System.out.println("Description Is not Optional Assertion");
		}

	}
	
	
  public void checkAddedBatchexistsforoptional() {
		
//		driver.navigate().back();
//		driver.navigate().forward();
//		List<WebElement> alltabledata = new ArrayList<>();
//	
//		WebElement nextPageButton = driver
//				.findElement(By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']"));
//	
//	while (nextPageButton.isEnabled()) {
//	
//		List<WebElement> currentPageRows = getRowsFromCurrentPage();
//	
//		alltabledata.addAll(currentPageRows);
//	
//		for (WebElement row : currentPageRows) {
//	
//			List<WebElement> cells = row.findElements(By.tagName("td"));
////			for (WebElement cell : cells) {
////                System.out.print(cell.getText() + "\t");
////            }
////            System.out.println(); 
////        
//			List<WebElement> filteredCells = new ArrayList<>();
//			for (int i = 1; i < cells.size() - 1; i++) {
//				filteredCells.add(cells.get(i));
//			}
//	
//			for (WebElement cell : filteredCells) {
//	
//				if (cell.getText().equalsIgnoreCase(batchName)) {
//					flag = true;
//					break;
//				}
//			}
//		}
//	
//		nextPageButton.click();
//	}
//	
//	if (flag) {
//		System.out.println("Batch is created and diplayed in the table");
//	} else
//		System.out.println("batch is not created");
	}
 
  
  public void clickaddbatch1() {
		
		addNewbatchbtn.click();
	}
  
   public String fillInValidBatchDetails(String sheetname, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
	   WebElement errorMsg = null;
	   List<Map<String, String>> data = reader.ReadExcelFile("Batch");
			InvalibatchName = data.get(rowNumber).get("BatchName");
			System.out.println(InvalibatchName);
		//	Invaliddescription= data.get(rowNumber).get("Description");
			BatchnameTextField.sendKeys(InvalibatchName);
		//	BdescriptionTextField.sendKeys(Invaliddescription);
			errorMsg = driver.findElement(By.xpath("//small[@id='text-danger']"));
			return errorMsg.getText();
			
   }
   public void closeerrwin() {
	   closeerrwindow.click();
   }
   
   public boolean checkMandatoryFieldsBlank(String sheetname, Integer rowNumber)
			throws InvalidFormatException, IOException {
		List<Map<String, String>> data = reader.ReadExcelFile("Batch");
		boolean flag = false;
		WebElement errorMsg = null;
		for (int i = 0; i < 5; i++) {
			String fieldName = data.get(rowNumber).get("Fields");
			String expectedErrorMsg = data.get(rowNumber).get("errorMsg");
			savebatchBtn.click();
			switch (fieldName) {
			case "batchField":
				errorMsg = driver.findElement(By.xpath("//small[normalize-space()='Batch Name is required.']"));
				flag = Helper.validateErrorMsg(errorMsg.getText(), expectedErrorMsg);
				break;

			case "descriptionField":
				errorMsg = driver.findElement(By.xpath("//small[normalize-space()='Batch Description is required.']"));
				flag = Helper.validateErrorMsg(errorMsg.getText(), expectedErrorMsg);
				break;

			case "programField":
				errorMsg = driver.findElement(By.xpath("//small[normalize-space()='Program Name is required.']"));
				flag = Helper.validateErrorMsg(errorMsg.getText(), expectedErrorMsg);
				break;

			case "radioBtn":
				errorMsg = driver.findElement(By.xpath("//small[normalize-space()='Status is required.']"));
				flag = Helper.validateErrorMsg(errorMsg.getText(), expectedErrorMsg);
				break;

			case "NoOfClasses":
				errorMsg = driver.findElement(By.xpath("//small[normalize-space()='Number of classes is required.']"));
				flag = Helper.validateErrorMsg(errorMsg.getText(), expectedErrorMsg);
				//flag = context.getHelper().
				break;
			default:
				break;
			}
		}
		return flag;
	}
   
   //****************Edit batch code**********************
   public void checkEditIconisEnabled() {	
		WebElement searchBox = driver.findElement(By.id("filterGlobal"));
		searchBox.sendKeys(batchName);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody//tr")));

			WebElement editIcon = driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-pencil']"));

			Assert.assertTrue(editIcon.isEnabled());
			System.out.println("editicon is enabled");

		} catch (Exception e) {
			System.out.println("editicon not enabled");
		}

	}
   
   public void clicksTheEditIcon() throws InterruptedException {
	   Thread.sleep(1000);
		 beditIcon.click();
		 System.out.println("clicked edit icon");
	}
   
   public WebElement ValidateEditbatchPopup() throws InterruptedException {
		Thread.sleep(1000);
	    return editBatchPopup;
   }

   public void updateBatchDetails(String sheetname, Integer rowNumber) throws InvalidFormatException, IOException {
	   
		List<Map<String, String>> data = reader.ReadExcelFile("Batch");
		description = data.get(rowNumber).get("UpdateBatchDescription");
		noOfClassesupdated=data.get(rowNumber).get("UpdateNoofClasses");		
		BdescriptionTextField.sendKeys(description);
//		if(!statusINactiveRadiobtn.isSelected())
//		{
//			statusINactiveRadiobtn.click();
//		}
		bnoOfClassesField.sendKeys(noOfClassesupdated);
		savebatchBtn.click();
		//verifySuccessMessage();		
	}
   public void verifySuccessMessage() {
		String ExpectedText = "Successful";
		try {
			WebElement successMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			String actualText = successMessage.getText();
			System.out.println("actual Success Message: " + actualText);
			System.out.println("Expected :" + ExpectedText);
			Assert.assertTrue(actualText.contains(ExpectedText), "Batch edit failed" );
		} catch (Exception e) {
			System.out.println("Success message not found within the stipulated time");
		}
	}
   
   public void clickEditIconforinvalid() throws InterruptedException {
	   Thread.sleep(1000);
		 beditIcon.click();
		 System.out.println("clicked edit icon");
	}
   
   public String updateinvalidBatchDetails(String sheetname, Integer rowNumber) throws InvalidFormatException, IOException {
	   WebElement errorMsg1 = null;
		List<Map<String, String>> data = reader.ReadExcelFile("Batch");
		description = data.get(rowNumber).get("UpdateBatchDescription");
		noOfClassesupdated=data.get(rowNumber).get("UpdateNoofClasses");
		BdescriptionTextField.clear();
		BdescriptionTextField.sendKeys(description);
		//bnoOfClassesField.sendKeys(noOfClassesupdated);
		errorMsg1 = driver.findElement(By.xpath("//small[@id='text-danger']"));
		return errorMsg1.getText();
				
	}
   
   public String Blankmandatoryfield() throws InterruptedException {
	   WebElement errorMsg2 = null;
	   bnoOfClassesField.sendKeys(Keys.CONTROL + "a"); 
	   bnoOfClassesField.sendKeys(Keys.BACK_SPACE);
	//   BdescriptionTextField.sendKeys(Keys.CONTROL + "a"); // Select all text
	//   BdescriptionTextField.sendKeys(Keys.BACK_SPACE); // Delete selected text
	   Thread.sleep(2000);
	   errorMsg2 = driver.findElement(By.xpath("//small[@id='text-danger']"));
		return errorMsg2.getText();
	
   }
   
   public String BlankDescritionfield() throws InterruptedException {
	   WebElement errorMsg3 = null;
	   BdescriptionTextField.sendKeys(Keys.CONTROL + "a"); // Select all text
	   BdescriptionTextField.sendKeys(Keys.BACK_SPACE); // Delete selected text
	   Thread.sleep(2000);
	   errorMsg3 = driver.findElement(By.xpath("//small[@id='text-danger']"));
		return errorMsg3.getText();
	
   }
}

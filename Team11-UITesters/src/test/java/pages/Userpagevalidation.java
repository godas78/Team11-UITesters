package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class Userpagevalidation {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='user']/span[1]")
	WebElement userbttn;

	@FindBy(xpath = "//div/mat-card/mat-card-title/div[1]")
	WebElement manageuser_text;

	@FindBy(xpath = "//div//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginationText;

	@FindBy(xpath = "//div//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement nextlink;

	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']")
	WebElement pagination;

	@FindBy(xpath = "//button/span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement beforelink;

	@FindBy(xpath = "//div//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement lastpagelink;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement firstpagelink;

	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']")
	WebElement tablebody;

	@FindAll(@FindBy(xpath = "//tbody//tr[@class='ng-star-inserted']"))
	List<WebElement> rowDataList;

	// table header columns
	@FindBy(xpath = "//thead/tr/th[2][@class='p-sortable-column']")
	WebElement ID;

	@FindBy(xpath = "//thead/tr/th[3][@class='p-sortable-column']")
	WebElement Name;

	@FindBy(xpath = "//thead/tr/th[4][@class='p-sortable-column']")
	WebElement Location;

	@FindBy(xpath = "//thead/tr/th[5][@class='p-sortable-column']")
	WebElement Phone;

	@FindBy(xpath = "//thead/tr/th[6][@style='width: 10rem;' and text()=' Edit / Delete']")
	WebElement edit;

	@FindBy(xpath = "//div/table[@role='grid']")
	WebElement dataTable;

	@FindBy(xpath = "//div/button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement userpage_deleteButton;

	@FindBy(xpath = "//div/button/span[@class='p-button-label' and text()='Add New User']")
	WebElement AddNewUserButton;

	@FindBy(xpath = "//div/button/span[@class='p-button-label' and text()='Assign Student']")
	WebElement AssignStudentButton;

	@FindBy(xpath = "//div/button/span[@class='p-button-label' and text()='Assign Staff']")
	WebElement AssignStaffButton;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchbox;

	@FindBy(xpath = "//div[@class='p-checkbox-box p-component']")
	WebElement checkbox;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']")
	WebElement editIcon;

	@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash']")
	WebElement deleteIcon;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	String expected_paginationText = "Showing x to y of z entries";
	String name1 = "Vani";
	

	public Userpagevalidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_userbutton() {
		userbttn.isDisplayed();
		userbttn.click();
		Log.info("user button is clicked and navigating to manage user page");
	}

	/*public void validatemanageuser_page() {
		String current_user_URL = driver.getCurrentUrl();
		String urltext = FileReaderManager.getInstance().getConfigReader().getexpectedTextHeading();
		Log.info("expected url text : " + urltext);
		Log.info("current url text : " + current_user_URL);
		assert current_user_URL.contains(urltext) : "URL doesn't contain 'Manage User'";
	}*/

	public void validatemanageuser_text() {

		String userpagetext = FileReaderManager.getInstance().getConfigReader().getexpectedTextHeading();
		String current_text = manageuser_text.getText();
		Log.info("browser text" + current_text);
		Log.info("original text" + userpagetext);
		Assert.assertEquals(current_text, userpagetext, "Heading text doesn't match");
	}

	public void validatepagination_user_text() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", paginationText);
		// validate all the links in pagination
		Assert.assertTrue(paginationText.isDisplayed(), "Pagination text is not displayed");

		Assert.assertTrue(nextlink.isDisplayed(), "nextlink is not displayed");
		Assert.assertTrue(nextlink.isEnabled(), "nextlink is not enabled");

		Assert.assertTrue(beforelink.isDisplayed(), "beforelink is not displayed");
		Assert.assertTrue(lastpagelink.isDisplayed(), " lastpagelink is not displayed");
		Assert.assertTrue(lastpagelink.isEnabled(), " lastpagelink is not enabled");
		validatepaginationTextvalue();
	}

	public void validatepaginationTextvalue() {
		String firstpage="";
		String lastpage = "";
		String pagenumber ;
		WebElement paginationbuttons= driver.findElement(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']"));
		List<WebElement> buttons = paginationbuttons.findElements(By.tagName("button"));
		firstpage = buttons.get(0).getText();
		lastpage = buttons.get(buttons.size() -1).getText();
		
	Log.info("First page number: " + firstpage);
	Log.info("Last page number: " + lastpage);
	String pageText = paginationText.getText();
	Log.info("pagination text displayed : " + pageText); // "Showing x to y of z entries";
	int entries = validatepagination_totalRecords();
	String expectedText = "Showing "+firstpage +" to "+lastpage +" of "+entries+ " entries" ;
	Log.info("expected text  : "+expectedText);
	
	Assert.assertEquals(pageText, expectedText,"Text doesn't match");
	
	
	}
	public int validatepagination_totalRecords() {
		int totalRowcount = 0;
		boolean hasNextpage = true;
    while(hasNextpage) {
		
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
				int Rowcount = rowDataList.size();
				totalRowcount += Rowcount;
				WebElement next=driver.findElement(By.xpath("//div//span[@class='p-paginator-icon pi pi-angle-right']"));
				
				if (!next.isEnabled()) {
					 
					 hasNextpage = false;
			}else {
				wait.until(ExpectedConditions.elementToBeClickable(next));
				next.click();
			}
				
			} catch (Exception e) {
				Log.error("error occurred during pagination"+e.getMessage());
				 hasNextpage = false;
				break;
			}
	}
		 Log.info("Total rows : " + totalRowcount);
		 return totalRowcount;
	}

	public void validateTableHeaders() {

		Assert.assertNotNull(ID, "ID column is present");
		Assert.assertNotNull(Name, "Name column is present");
		Assert.assertNotNull(Location, "Location column is present");
		Assert.assertNotNull(Phone, "Phone column is present");
		Assert.assertNotNull(edit, "edit column is present");
		Log.info("All header columns are present");

	}

	public void validateDeletebutton() {

		userpage_deleteButton.isDisplayed();
		if (userpage_deleteButton.getAttribute("disabled") != null
				&& userpage_deleteButton.getAttribute("disabled").equals("true")) {
			Log.info("Delete button is disabled");

		} else {
			Log.info("Delete button is enabled");
		}
	}

	public void ValidateButtonsAboveDataTable() {

		int adduserLocation = AddNewUserButton.getLocation().getY();
		int assignStudentLocation = AssignStudentButton.getLocation().getY();
		int assignStaffLoaction = AssignStaffButton.getLocation().getY();
		int datatableLocation = dataTable.getLocation().getY();

		Log.info((adduserLocation < datatableLocation) ? "Adduser Button is above the datatable "
				: "Below the data table" + adduserLocation);
		Log.info((assignStudentLocation < datatableLocation) ? "AssignStudent Button  is above the datatable "
				: "Below the data table" + assignStudentLocation);
		Log.info((assignStaffLoaction < datatableLocation) ? "AssignStaff Button  is above the datatable "
				: "Below the data table" + assignStaffLoaction);
	}

	public void validateUserSearchbox() {

		searchbox.isDisplayed();
		int searchLocation = searchbox.getLocation().getY();
		int datatableLocation = dataTable.getLocation().getY();
		Log.info((searchLocation < datatableLocation) ? " searchbox is displayed above the datatable "
				: "Below datatable" + searchLocation);
	}

	public void validateRowCount() {

		wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
		int Rowcount = rowDataList.size();
		Log.info("Total rows on current page : " + Rowcount);
	}

	public void validateAllcheckbox() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
		for (WebElement row : rowDataList) {
			Assert.assertTrue(checkbox.isDisplayed(), "checkbox is displayed");
			String rowdata = row.getText();
			Log.info("Checkbox is displayed for " + rowdata);

		}
	}

	public void validateEditIcon() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
		for (WebElement row : rowDataList) {
			editIcon.isDisplayed();
			Assert.assertTrue(editIcon.isEnabled(), "editIcon is enabled");
			String rowdata = row.getText();
			Log.info("EditIcon is enabled for " + rowdata);

		}
	}

	public void validateDeleteIcon() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
		for (WebElement row : rowDataList) {
			deleteIcon.isDisplayed();
			Assert.assertTrue(deleteIcon.isEnabled(), "deleteIcon is enabled");
			String rowdata = row.getText();
			Log.info("deleteIcon is enabled for " + rowdata);

		}
	}

	public void validateSearchboxUsername() throws InterruptedException {

		searchbox.isEnabled();
        searchbox.sendKeys(name1);
      
		Log.info("username is entered in the searchbox : "+name1);
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
		try {
		 
		List<WebElement> newrowDataList = driver.findElements(By.xpath("//tbody/tr[@class='ng-star-inserted']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(newrowDataList));
		int rowcount =newrowDataList.size();
		Log.info("row data size " +rowcount);
		for (WebElement row : newrowDataList) {
			String rowdata = row.getText();
			Log.info("rowdata value : " + rowdata);
			 Assert.assertTrue(rowdata.contains(name1), "searchbox showed the correct rowdata");
			Log.info("only firstname is entered " + rowdata.contains(name1));
			Log.info("username is entered " + name1);
		}
		
		}catch (AssertionError e) {
			Log.error("error occurred during pagination"+e.getMessage());
			
			}
		catch (Exception e) {
			Log.error("error occurred during pagination"+e.getMessage());
			
		}
		
	}
	public void validateInvalidSearchdata() {
		
		searchbox.isEnabled();
        searchbox.sendKeys("PQR");
        Log.info("entered keys : PQR");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
		WebElement pageText=driver.findElement(By.xpath("//div/span[@class='p-paginator-current ng-star-inserted']"));
		String text = pageText.getText();
		Log.info("pagination text after entering invalid username : "+text);
		
	}

}

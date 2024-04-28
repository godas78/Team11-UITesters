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
	@FindBy(xpath="//thead/tr/th[2][@class='p-sortable-column']")
	WebElement ID;
	
	@FindBy(xpath="//thead/tr/th[3][@class='p-sortable-column']")
	WebElement Name;
	
	@FindBy(xpath="//thead/tr/th[4][@class='p-sortable-column']")
	WebElement Location;
	
	@FindBy(xpath="//thead/tr/th[5][@class='p-sortable-column']")
	WebElement Phone;
	
	@FindBy(xpath="//thead/tr/th[6][@style='width: 10rem;' and text()=' Edit / Delete']")
	WebElement edit;
	
	@FindBy(xpath="//div/table[@role='grid']")
	WebElement dataTable;
	
	@FindBy(xpath="//div/button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement userpage_deleteButton;
	
	@FindBy(xpath="//div/button/span[@class='p-button-label' and text()='Add New User']")
	WebElement AddNewUserButton;
	
	@FindBy(xpath="//div/button/span[@class='p-button-label' and text()='Assign Student']")
	WebElement AssignStudentButton;
	
	@FindBy(xpath="//div/button/span[@class='p-button-label' and text()='Assign Staff']")
	WebElement AssignStaffButton;
	
	
	
	

	String expected_paginationText = "Showing x to y of z entries";

	public Userpagevalidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_userbutton() {
		userbttn.isDisplayed();
		userbttn.click();
		Log.info("user button is clicked and navigating to manage user page");
	}

	public void validatemanageuser_page() {
		String current_user_URL = driver.getCurrentUrl();
		String urltext = FileReaderManager.getInstance().getConfigReader().getexpectedTextHeading();
		Log.info("expected url text : " + urltext);
		Log.info("current url text : " + current_user_URL);
		assert current_user_URL.contains(urltext) : "URL doesn't contain 'Manage User'";
	}

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
		String pageText = paginationText.getText();
		Log.info("pagination text displayed : " + pageText);
	}

	public void validatepagination_allPages() {
		int totalRowcount = 0;

		List<WebElement> paginationButtons = driver.findElements(By.tagName("button"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (WebElement button : paginationButtons) {
			try {
				// wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();

				wait.until(ExpectedConditions.visibilityOfAllElements(rowDataList));
				int Rowcount = rowDataList.size();
				totalRowcount += Rowcount;
				Log.info("Total rows on current page : " + totalRowcount);

			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				Log.warn("StaleElementReferenceException encountered");
				driver.navigate().refresh();
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("button")));
				paginationButtons = driver.findElements(By.tagName("button"));
				continue;

			} catch (org.openqa.selenium.TimeoutException e) {
				Log.error("time out");
				break;
			}
			paginationButtons = driver.findElements(By.tagName("button"));

			Log.info("Total entries : " + totalRowcount);

		}
	}

	public void validateTableHeaders() {

		Assert.assertNotNull(ID,"ID column is present");
		Assert.assertNotNull(Name,"Name column is present");
		Assert.assertNotNull(Location,"Location column is present");
		Assert.assertNotNull(Phone,"Phone column is present");
		Assert.assertNotNull(edit,"edit column is present");
		Log.info("All header columns are present");
		
	}
	
	public void validateDeletebutton() {
		
		userpage_deleteButton.isDisplayed();
		if(userpage_deleteButton.getAttribute("disabled") !=null && userpage_deleteButton.getAttribute("disabled").equals("true"))
		{
			Log.info("Delete button is disabled");
			
		}
		else {
			Log.info("Delete button is enabled");
		}
	}
	
	public void ValidateButtonsAboveDataTable() {
		
		int adduserLocation = AddNewUserButton.getLocation().getY();
		int assignStudentLocation = AssignStudentButton.getLocation().getY();
		int assignStaffLoaction = AssignStaffButton.getLocation().getY();
		int datatableLocation = dataTable.getLocation().getY();
		
	Log.info((adduserLocation < datatableLocation) ? "Adduser Button is above the datatable " : "Below the data table" +adduserLocation);
	Log.info((assignStudentLocation < datatableLocation) ? "AssignStudent Button  is above the datatable " : "Below the data table" +assignStudentLocation);
	Log.info((assignStaffLoaction < datatableLocation) ? "AssignStaff Button  is above the datatable " : "Below the data table" +assignStaffLoaction);	
	}
}

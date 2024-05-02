package pages;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import managers.FileReaderManager;
import utilities.Log;


public class ProgramPagiPage {
	WebDriver driver;
	boolean status;
	
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']") WebElement rightdblclick;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']") WebElement leftdblclick;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[@class='p-paginator-next p-paginator-element p-link p-ripple']") WebElement rightclick;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[@class='p-paginator-prev p-paginator-element p-link p-ripple']") WebElement leftclick;
	public ProgramPagiPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickrightarrow()
	{
		rightclick.click();
	}
	public void clickleftarrow()
	{
		leftclick.click();
	}
	public void clicklastpage()
	{
		rightdblclick.click();
	}
	public void clickfirstpage()
	{
		leftdblclick.click();
	}
	public void rightdblClick()
	{
		
		try {
			status = leftdblclick.isDisplayed();
			assertTrue(status);

			Log.info("right double arrow is displayed");

		} catch (AssertionError e) {
			Log.error("right double arrow is not displayed");

		}
		
	}
	public void leftdblClick()
	{
		
		try {
			status = leftdblclick.isDisplayed();
			assertTrue(status);

			Log.info("left double arrow is displayed");

		} catch (AssertionError e) {
			Log.error("left doungle arrow is not displayed");

		}
		
	}
	public void rightarrowchk()
	{
		try {
			status = rightclick.isDisplayed();
			assertTrue(status);

			Log.info("right single arrow is displayed");

		} catch (AssertionError e) {
			Log.error("right single arrow is not displayed");

		}
		
	}
	public void leftarrowchk()
	{
		try {
			status = leftclick.isDisplayed();
			assertTrue(status);

			Log.info("Left single arrow is displayed");

		} catch (AssertionError e) {
			Log.error("Left single arrow is not displayed");

		}
		
	}
	
}

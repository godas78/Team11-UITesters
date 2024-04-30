package pages;

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
import pages.HomePage;

public class ProgramsortPage {
		
		WebDriver driver;
	
		@FindBy(xpath = "//div/table/thead/tr/th[2][@class='p-sortable-column']") WebElement pNameA;
		@FindBy(xpath = "//div/table/thead/tr/th[2][@class='p-sortable-column p-highlight']") WebElement pNameD;
		@FindBy(xpath = "//div/table/thead/tr/th[3][@class='p-sortable-column']") WebElement pdNameA;
		@FindBy(xpath = "//div/table/thead/tr/th[3][@class='p-sortable-column p-highlight']") WebElement pdNameD;
		@FindBy(xpath = "//div/table/thead/tr/th[4][@class='p-sortable-column']") WebElement psNameA;
		@FindBy(xpath = "//div/table/thead/tr/th[4][@class='p-sortable-column p-highlight']") WebElement psNameD;
		
		public ProgramsortPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickprogramnameA()
		{
			   pNameA.click();
		}
		public void clickprogramnameD()
		{
			   pNameD.click();
		}
		public void clickprogramdescA()
		{
		
			   pdNameA.click();
		}
		public void clickprogramdescD()
		{
			   pdNameD.click();
		}
		public void clickprogramstatusA()
		{
		
			   psNameA.click();
		}
		public void clickprogramstatusD()
		{
			   psNameD.click();
		}
		
		public void clickprogramnameascending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		
		public void clickprogramnamedescending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		
		public void clickprogramdescascending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[3]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		public void clickprogramdescpdescending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[3]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		public void clickprogramstatusascending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[4]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		public void clickprogramstatusdescending()
		{
			List<WebElement> elementslist = driver.findElements(By.xpath("//tr/th[4]"));
			List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
			List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originallist.equals(sortedlist));
		}
		
		
}

		


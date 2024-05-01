package utilities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class Helper {
 
	private static WebDriver driver;
	
		public void navigateBack() {
			
		driver.navigate().back();
		}

		public void navigateForward() {

		driver.navigate().forward();

		}
		public String getTitleOfThePage() 
		{
		return driver.getTitle();
		}
		public static boolean validateErrorMsg(String errorMsg, String expectedErrorMsg) {
			boolean flag = false;
			try {
				// assertEquals(true, errorMsg.contains(expectedErrorMsg));
				assertEquals(errorMsg, expectedErrorMsg);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		}

}

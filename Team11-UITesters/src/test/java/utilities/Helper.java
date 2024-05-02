package utilities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import managers.FileReaderManager;

public class Helper {

	private static WebDriver driver;

	public void navigateBack() {

		driver.navigate().back();
	}

	public void navigateForward() {

		driver.navigate().forward();

	}

	public String getTitleOfThePage() {
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
	public String getUserPageUrl() {
	    String userPageUrl = FileReaderManager.getInstance().getConfigReader().getUserPageUrl();
	   
	    Log.info("User navigated to User Page");
	    return userPageUrl;
	}
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	public String getHomePageUrl() {
		String homePageUrl = FileReaderManager.getInstance().getConfigReader().getHomePageUrl();

		Log.info("User navigated to Home Page/DashBoardPage");
		return homePageUrl;
	}

}

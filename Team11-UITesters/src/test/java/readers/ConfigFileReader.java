package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;

public class ConfigFileReader {

	private static Properties properties;
	private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

	public ConfigFileReader() 
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try 
			{
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public BrowserType getBrowserType() 
	{
		String browserName = properties.getProperty("browserType");

		if (browserName == null || browserName.equals("chrome"))
			return BrowserType.CHROME;
		
		else if (browserName.equalsIgnoreCase("firefox"))
			return BrowserType.FIREFOX;
		
		else if (browserName.equals("edge"))
			return BrowserType.EDGE;
		
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public long getImplicitWait() 
	{
		String implicitlyWait = properties.getProperty("implicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public static String getApplicationUrl() 
	{
		String url = properties.getProperty("appUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("appUrl not specified in the Configuration.properties file.");
	}

	public String getHomePageUrl() 
	{
		String url = properties.getProperty("homePageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homePageUrl not specified in the Configuration.properties file.");
	}
	
	
	//readers
	
	public String getExcelPath() {
		String path = properties.getProperty("excelPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("path not specified in the Configuration.properties file.");
	}

	public String getScreenshotPath() {
		String path = properties.getProperty("screenshotPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("screenshotPath not specified in the Configuration.properties file.");
	}
	
	public String getLoginPageURL() {
		String loginurl = properties.getProperty("loginPageUrl");
		if (loginurl != null)
			return loginurl;
		else
			throw new RuntimeException("loginPageUrl not specified in the Config.properties file");
	}
	public String getLMSUserName() {
		String username = properties.getProperty("LMSUserName");
		if (username != null)
			return username;
		else
			throw new RuntimeException("LMSUserName not specified in the Configuration.properties file.");
	}
	
	public static String getInvalidUrl() {
		String invalid_url = properties.getProperty("invalid_url");
		if (invalid_url != null)
			return invalid_url;
		else
			throw new RuntimeException("invalidUrl not specified in the Config.properties file");
	}

	public String getLMSPassword() {
		String password = properties.getProperty("LMSPassword");
		if (password != null)
			return password;
		else
			throw new RuntimeException("LMSPassword not specified in the Configuration.properties file.");
	}
	public String getexpectedTextHeading() 
	{
		String url = properties.getProperty("expectedTextHeading");
		if (url != null)
			return url;
		else
			throw new RuntimeException("expectedTextHeading is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGFname() {
		String url = properties.getProperty("FnameErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Firstname erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGMidname() {
		String url = properties.getProperty("MnameErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Middle erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGLastname() {
		String url = properties.getProperty("LnameErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("last name erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGLocation() {
		String url = properties.getProperty("LocErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("location erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGPhone() {
		String url = properties.getProperty("PhoneErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("phone number erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGLinkedin() {
		String url = properties.getProperty("LinkedErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Linked in URL erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGEmail() {
		String url = properties.getProperty("EmailErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Email id erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGUG() {
		String url = properties.getProperty("UGErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("UG erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGPG() {
		String url = properties.getProperty("PGErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("PG erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGTimeZone() {
		String url = properties.getProperty("timezoneErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Timezone erroMSG is not specified in the Configuration.properties file.");
	}
	public String getexpectedErrorMSGComment() {
		String url = properties.getProperty("commentsErr");
		if (url != null)
			return url;
		else
			throw new RuntimeException("comments erroMSG is not specified in the Configuration.properties file.");
	}

	public String getUserPageUrl() 
	{
		String url = properties.getProperty("userUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("userPageUrl not specified in the Configuration.properties file.");
	}
	public String getdashboardPageUrl() 
	{
		String url = properties.getProperty("dashboardUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("dashboardpage url not specified in the Configuration.properties file.");
	}
}

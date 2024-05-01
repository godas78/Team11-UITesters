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
		String url = properties.getProperty("appUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homePageUrl not specified in the Configuration.properties file.");
	}
	
	public String getUserPageUrl() 
	{
		String url = properties.getProperty("userPageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("userPageUrl not specified in the Configuration.properties file.");
	}
	
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
	public static String getInvalidUrl() {
		String invalid_url = properties.getProperty("invalid_url");
		if (invalid_url != null)
			return invalid_url;
		else
			throw new RuntimeException("invalidUrl not specified in the Config.properties file");
	}

}
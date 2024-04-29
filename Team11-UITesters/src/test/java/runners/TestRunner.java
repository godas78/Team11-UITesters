package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/UserAPI.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=false,  //console output color
		//tags = "@tag14",
		features = {"src/test/resources/features/05.UserModule/01_UserPageValidation.feature"},
				//"src/test/resources/features/01.Login/1_SignIn.feature"}, //location of feature files
		glue= "stepdefinitions") //location of step definition files

//public class TestRunner { }

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }


}

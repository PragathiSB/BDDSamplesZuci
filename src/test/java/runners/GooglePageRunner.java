package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src//test//resources//features//ConduitSignIn.feature",
		glue= {"stepDefinitions"},
		dryRun=true,//checks if all steps in each scenario are executed or not, by default its value is false
		monochrome=true,//readable console output
		plugin= {"pretty",
				"html:target/Reports/HtmlReport.html",
				"json:target/Reports/JsonReport.json",
				"usage:target/Reports/UsageReport",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}//will give detailed explanation ,which includes junk charecters too,avoided using monochrome
		)
public class GooglePageRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true)
	  public Object[][] scenarios(){
		  return super.scenarios();
	  }

}

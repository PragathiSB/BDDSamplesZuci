package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class loginPageRunner {
	
	@CucumberOptions(
			features="src//test//resources//features//login.feature",
			glue= {"stepDefinitions"},
			dryRun=false,
			monochrome=true,
			plugin= {"pretty",
					"html:target/Reports/HtmlReport.html"
					
			}
			)
	public class LoginPageRunner extends AbstractTestNGCucumberTests {
	 
	}
	

}

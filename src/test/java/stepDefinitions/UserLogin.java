package stepDefinitions;
 
import java.util.List;
import java.util.Map;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class UserLogin {
	
	WebDriver driver;
	
	
	@Before
	
	public void setup() {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.manage().window().maximize();
	
	}
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		
		driver.get("https://the-internet.herokuapp.com/login");
	    
	}
//	@When("User enters credentials")
//	public void user_enters_credentials() {
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
//		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
//		
//	   
//	}
//	
//	@When("User enters {string} and {string}")
//	public void user_enters_credentials(String strUser, String strPwd) {
//		driver.findElement(By.id("username")).sendKeys(strUser);
//		driver.findElement(By.name("password")).sendKeys(strPwd);
//		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
//		
//	   
//	}
	

	@When("User enters credentials")
	public void user_enters_credential(DataTable dataTable) {
		List<Map<String,String>> users=dataTable.asMaps();
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
	   
	}
	@Then("Should display Success Msg")
	public void user_enters_credentials(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String expMsg=msgs.get(0);
		Assert.assertEquals("You logged into a secure area!",expMsg);
		
	}
	
//	@Then("Should display Success Msg")
//	public void should_display_success_msg() {
//	boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//    	Assert.assertTrue(isUserValid);
//	 }
// 
}
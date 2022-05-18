package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.lu.a;

public class StepDefinations {
	WebDriver driver;
	@Given("^navigates to orangehm$")
	public void navigates_to_orangehm() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://orangehrm.qedgetech.com/");
	    Thread.sleep(2000);
	    
	}

	@When("^user logs in using Username as \"([^\"]*)\"$")
	public void user_logs_in_using_Username_as(String username) throws Throwable {
	    driver.findElement(By.name("txtUsername")).sendKeys(username);
	}

	@When("^password as \"([^\"]*)\"$")
	public void password_as(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		   Thread.sleep(2000);
	}

	@Then("^user should validate  url text$")
	public void user_should_validate_url_text() throws Throwable {
	   String expected="dashboard";
	   String actual = driver.getCurrentUrl();
	   if(actual.contains(expected))
	   {
		   System.out.println("Login success");
	   }
	   else
	   {
		   System.out.println("Login Fail");
	   }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	   driver.close();
	}


}

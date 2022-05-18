package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserCreationSteps {
	WebDriver driver;
	@Given("^User Launch Url in Browser$")
	public void user_Launch_Url_in_Browser() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.get("http://orangehrm.qedgetech.com/");
	    Thread.sleep(2000);
	}

	@When("^I enter Username as \"([^\"]*)\"$")
	public void i_enter_Username_as(String username) throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys(username);
	}

	@When("^I Enter Password as\"([^\"]*)\"$")
	public void i_Enter_Password_as(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^i click login button$")
	public void i_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
	}

	@When("^I click Admin$")
	public void i_click_Admin() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		Thread.sleep(3000);
	}

	@When("^I click AddBtn$")
	public void i_click_AddBtn() throws Throwable {
		driver.findElement(By.name("btnAdd")).click();
		Thread.sleep(3000);
	}

	@When("^i Select \"([^\"]*)\" in user role$")
	public void i_Select_in_user_role(String UserRole) throws Throwable {
	    new Select(driver.findElement(By.name("systemUser[userType]"))).selectByVisibleText(UserRole);
	}

	@When("^i Enter \"([^\"]*)\" in ename$")
	public void i_Enter_in_ename(String Ename) throws Throwable {
		driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys(Ename);
	    
	}

	@When("^I Enter \"([^\"]*)\" in username$")
	public void i_Enter_in_username(String user) throws Throwable {
		driver.findElement(By.name("systemUser[userName]")).sendKeys(user);
	}

	@When("^I Enter \"([^\"]*)\" in password$")
	public void i_Enter_in_password(String pass) throws Throwable {
		driver.findElement(By.name("systemUser[password]")).sendKeys(pass);
		Thread.sleep(3000);
	}

	@When("^I Enter \"([^\"]*)\" in cpassword$")
	public void i_Enter_in_cpassword(String cpass) throws Throwable {
		driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys(cpass);
	}

	@When("^I click on save button$")
	public void i_click_on_save_button() throws Throwable {
		driver.findElement(By.name("btnSave")).click();
		Thread.sleep(3000);
	}

	@Then("^I vallidate Url$")
	public void i_vallidate_Url() throws Throwable {
	    String expected ="viewSystemUsers";
	    String actual = driver.getCurrentUrl();
	    if(actual.contains(expected))
	    {
	    	System.out.println("Add user success");
	    }
	    else
	    {
	    	System.out.println("Add user Fail");
	    }
	}

	@Then("^I close Browser$")
	public void i_close_Browser() throws Throwable {
	    driver.close();
	}


}

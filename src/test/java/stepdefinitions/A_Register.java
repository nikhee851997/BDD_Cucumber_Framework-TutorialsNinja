package stepdefinitions;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A_Register
{
  public WebDriver driver;
  public SoftAssert soft;
  
	
@Given("User navigates to Registerpage")
public void user_navigates_to_registerpage() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//div[@id='top-links']/descendant::a[2]")).click();
		driver.findElement(By.xpath("//div[@id='top-links']/descendant::a[3]")).click();
	}

@When("User enters firstname {string} in the respective field")
public void user_enters_firstname_in_the_respective_field(String firstnameText) 
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstnameText);
	}

@When("User enters lastname {string} in the respective field")
public void user_enters_lastname_in_the_respective_field(String lastnameText)
	{
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastnameText);
	}

@When("User enters emailaddress in the respective field")
public void user_enters_email_address_in_the_respective_field()
	{
	   driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());   
	}

@When("User enters telephonenumber {string} in the respective field")
public void user_enters_telephone_number_in_the_respective_field(String telephonenumberText) 
	{
	    driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephonenumberText);
	}

@When("User enters password {string} in the respective field")
public void user_enters_password_in_the_respective_field(String passwordText) 
	{
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
	}

@Then("User needs to confirmpassword {string} in the respective field")
public void user_needs_to_confirm_password_in_the_respective_field(String confirmpasswordText) 
	{
	    driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirmpasswordText);
	}

@When("User selects the option to subscribe in the respective option")
public void user_selects_the_option_to_subscribe_in_the_respective_option()
    { 
	   driver.findElement(By.xpath("//input[@name='newsletter'and @value='1']")).click();
    }

@Then("User needs to agree to privacypolicy by selecting the respective option")
public void user_needs_to_agree_to_privacypolicy_by_selecting_the_respective_option() 
	{
	    driver.findElement(By.xpath("//input[@name='agree' and @value='1']")).click();
	}

@When("User clicks continue button")
public void user_clicks_continue_button() 
	{
	    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}

@Then("User will be navigated to AccountPage")
public void user_will_be_navigated_to_account_page() throws Exception 
	{
		soft=new SoftAssert();
		Thread.sleep(5000);
		soft.assertTrue(driver.findElement(By.xpath("//div[@id='content']/p[1]")).isDisplayed());
		soft.assertAll();
		driver.close();
	}
	
public String getEmailWithTimeStamp()
	{
		Date date = new Date();
		String timeStamp = date.toString().replace(" ","_").replace(":","_");
		return "rajkumar" +timeStamp+ "@gmail.com";
	}
	
}

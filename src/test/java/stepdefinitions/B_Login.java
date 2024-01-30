package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B_Login 
{
public WebDriver driver;
public SoftAssert soft;
	
@Given("User navigates to LoginPage")
public void user_navigates_to_login_page() 
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo");
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Login")).click();
}

@When("User enters validemail {string} in the respective field")
public void user_enters_valid_email_in_the_respective_field(String validemailText) 
{
	driver.findElement(By.id("input-email")).sendKeys(validemailText);

}

@When("User enters validpassword {string} in the respective field")
public void user_enters_valid_password_in_the_respective_field(String validpasswordText) 
{
	driver.findElement(By.id("input-password")).sendKeys(validpasswordText);

}

@When("User clicks on the Login button")
public void user_clicks_on_the_login_button()
{
   driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
}

@Then("User successfully Login into AccountPage")
public void user_successfully_login_into_account_page() throws Exception 
{
	 soft = new SoftAssert();
	 Thread.sleep(5000);
	 soft.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']/descendant::a[text()='Logout']")).isDisplayed());
     soft.assertAll();
     driver.close();

}

@When("User enters invalidemail {string} in the respective field")
public void user_enters_invalidemail_in_the_respective_field(String invalidemailText) 
{
	driver.findElement(By.id("input-email")).sendKeys(invalidemailText);

}

@When("User enters invalidpassword {string} in the respective field")
public void user_enters_invalidpassword_in_the_respective_field(String invalidpasswordText) 
{
	driver.findElement(By.id("input-password")).sendKeys(invalidpasswordText);

}

@Then("User receives a warning message {string} in the LoginPage")
public void user_receives_a_warning_message_in_the_login_page(String errormessageText) 
{
    soft= new SoftAssert();
    soft.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());
    soft.assertAll();
    driver.close();
}

}

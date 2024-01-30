package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class C_SearchProduct 
{
public WebDriver driver;
public SoftAssert soft;
	
@Given("User navigates to LandingPage")
public void user_navigates_to_Landing_page() 
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo"); 
}
	
@When("User enters validproduct {string} in the searchbox")
public void user_enters_validproduct_in_the_searchbox(String validproduct) 
{
	 driver.findElement(By.xpath("//div[@id='search']/child::input")).sendKeys(validproduct);
}

@When("User clicks on search button")
public void user_clicks_on_search_button() 
{
	 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
}

@Then("User can see the product information that is displayed in SearchPage")
public void user_can_see_the_product_information_that_is_displayed_in_Search_Page() throws Exception
{
	soft= new SoftAssert();
	Thread.sleep(5000);
	soft.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
	soft.assertAll();
	driver.close();
}

@When("User enters invalidproduct {string} in the searchbox")
public void user_enters_invalidproduct_in_the_searchbox(String invalidproduct)
{
   driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidproduct);
}

@Then("User can see the warning message,{string}")
public void User_can_see_the_warning_message(String errormessage) 
{
	soft= new SoftAssert();
    soft.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following::p[1]")).isDisplayed());
    soft.assertAll();
    driver.close();
}	
	
}

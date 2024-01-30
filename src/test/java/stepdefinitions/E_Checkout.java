package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E_Checkout 
{
	public WebDriver driver;
	public SoftAssert soft;
	public WebDriverWait wait;

@Given("User will traverse to LoginPage")
public void user_will_traverse_to_login_page() 
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://tutorialsninja.com/demo");
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Login")).click();
}

@When("User interacts with mail selector and insert {string} in its field")
public void user_interacts_with_mail_selector_and_insert_in_its_field(String emailText) 
{
	driver.findElement(By.id("input-email")).sendKeys(emailText); 
}

@When("User interacts with pass selector and insert {string} in its field")
public void user_interacts_with_pass_selector_and_insert_in_its_field(String passwordText) 
{
	driver.findElement(By.id("input-password")).sendKeys(passwordText);
}

@When("User interacts with Login selector")
public void user_interacts_with_login_selector() 
{
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
}

@When("User interacts with searchbar selector and insert {string} in its field")
public void user_interacts_with_searchbar_selector_and_insert_in_its_field(String productText)
{
	 driver.findElement(By.xpath("//div[@id='search']/child::input")).sendKeys(productText);
}

@When("User interacts with search selector")
public void user_interacts_with_search_selector()
{
	 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
}

@Then("User will see the selected product in SearchPage")
public void user_will_see_the_selected_product_in_search_page()
{
	   wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-thumb']/descendant::a[text()='HP LP3065']")));
	   soft= new SoftAssert();
	   soft.assertTrue(driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::a[text()='HP LP3065']")).isDisplayed());
	   soft.assertAll();   
}
	
@When("User interacts with add to cart selector of the device in SearchPage")
public void user_interacts_with_add_to_cart_selector_of_the_device_in_search_page()
{
		driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).click();  		    
}

@When("User interacts with add to cart selector of the device in ProductPage")
public void user_interacts_with_add_to_cart_selector_of_the_device_in_product_page() 
{
		driver.findElement(By.xpath("//input[@id='input-quantity']/following::button")).click();
}

@When("User interacts with cart selector in ProductPage")
public void user_interacts_with_cart_selector_in_product_page() 
{
		driver.findElement(By.xpath("//div[@id='cart']")).click();   
}

@When("User interacts with checkout selector that is inside cart selector in ProductPage")
public void user_interacts_with_checkout_selector_that_is_inside_cart_selector_in_product_page() 
{
		driver.findElement(By.xpath("//p[@class='text-right']/a[2]")).click();
}

@When("User interacts with checkout selector in CartPage that traverse to CheckoutPage")
public void user_interacts_with_checkout_selector_in_cartpage_that_traverse_to_checkout_page() 
{
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
}

@When("User interacts with the continue selector in CheckoutPage for billing details")
public void user_interacts_with_the_continue_selector_in_checkout_page_for_billing_details()
{
		driver.findElement(By.xpath("//input[@id='button-payment-address']")).click(); 
}

@When("User interacts with continue selector for delivery details")
public void user_interacts_with_continue_selector_for_delivery_details() 
{
		driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();    
}

@When("User interacts with continue selector for delivery method")
public void user_interacts_with_continue_selector_for_delivery_method() 
{
		 driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
}

@When("User need to acknowlege to terms and conditions before placing order")
public void user_need_to_acknowlege_to_terms_and_conditions_before_placing_order() 
{
		driver.findElement(By.xpath("//input[@name='agree' or @value='1']")).click();
}

@When("User interacts with continue selector for payment method")
public void user_interacts_with_continue_selector_for_payment_method()
{
	   driver.findElement(By.xpath("//input[@id='button-payment-method']")).click(); 
}

@When("User interacts with confirm order selector")
public void user_interacts_with_confirm_order_selector() 
{
		driver.findElement(By.xpath("//input[@id='button-confirm']")).click();   
}

@Then("User will see a successful placement of order message")
public void user_will_see_a_successful_placement_of_order_message()
{
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));	     
		 soft = new SoftAssert();
		 soft.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed());
		 soft.assertAll();
		 driver.close();
		 	  
}

}

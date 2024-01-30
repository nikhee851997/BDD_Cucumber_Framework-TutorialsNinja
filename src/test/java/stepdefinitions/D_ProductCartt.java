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

public class D_ProductCartt 
{

	public WebDriver driver;
	public SoftAssert soft;
	public WebDriverWait wait;
	
		
@Given("User will be directed to LoginPage")
public void user_will_be_directed_to_login_page()
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://tutorialsninja.com/demo");
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Login")).click();
}

@When("User will enter emailid {string} in the field")
public void user_will_enter_email_id_in_the_field(String validemailText)
{
	driver.findElement(By.id("input-email")).sendKeys(validemailText);
}

@When("User will enter passcode {string} in the field")
public void user_will_enter_passcode_in_the_field(String validpasswordText)
{
	driver.findElement(By.id("input-password")).sendKeys(validpasswordText);
}
		
@When("User will tap on Login option")
public void user_will_tap_on_login_option() 
{
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
}

@When("User will enter product name {string} in the field")
public void user_will_enter_product_name_in_the_field(String validproduct)
{
	 driver.findElement(By.xpath("//div[@id='search']/child::input")).sendKeys(validproduct);
}

@When("User will tap on the search option")
public void user_will_tap_on_the_search_option() 
{
	 driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
}

@Then("User will see the product with name {string} in SearchPage")
public void user_will_see_the_product_with_name_in_search_page(String validproduct)
{
	soft= new SoftAssert();
	wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-thumb']/descendant::a[text()='HP LP3065']")));
	soft.assertTrue(driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::a[text()='HP LP3065']")).isDisplayed());
	soft.assertAll();
}

@When("User will tap on the product {string} for more details in SearchPage")
public void user_will_tap_on_the_product_for_more_details_in_searchpage(String validproduct)
{
	driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::a[text()='HP LP3065']")).click();
}

@When("User will tap on specs option of the product {string} in ProductPage")
public void user_will_tap_on_specs_option_of_the_product_in_product_page(String validproduct)
{
	
   driver.findElement(By.xpath("//div[@id='content']/div/descendant::li[5]/a")).click();  
}

@Then("User will see the product specs displayed in ProductPage")
public void user_will_see_the_product_specs_displayed_in_productpage()
{
	soft= new SoftAssert();
    wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tab-specification']")));
	soft.assertTrue(driver.findElement(By.xpath("//div[@id='tab-specification']")).isDisplayed());	
	soft.assertAll();
}

@When("User will tap on add to cart option of the product {string} in SearchPage")
public void user_will_tap_on_add_to_cart_option_of_the_product_in_search_page(String validproduct)
{
	driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).click();  
}

@When("User will tap on add to cart option of the product {string} in ProductPage")
public void user_will_tap_on_add_to_cart_option_of_the_product_in_product_page(String validproduct)
{
	driver.findElement(By.xpath("//input[@id='input-quantity']/following::button")).click();
}

@When("User will tap on cart option held on the top in ProductPage")
public void user_will_tap_on_cart_option_held_on_the_top_in_product_page() 
{
	driver.findElement(By.xpath("//div[@id='cart']")).click();   
}

@When("User will tap on view cart option that is in dropdown of cart option in ProductPage")
public void user_will_tap_on_view_cart_option_that_is_in_dropdown_of_cart_option_in_productpage()
{   
	driver.findElement(By.xpath("//p[@class='text-right']/a[1]")).click();
}

@Then("User will see the product {string} added to cart in CartPage")
public void user_will_see_the_product_added_to_cart_in_cart_page(String validproduct)
{
	soft= new SoftAssert();
	wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Checkout']")));
	soft.assertTrue(driver.findElement(By.xpath("//a[text()='Checkout']")).isDisplayed());
	soft.assertAll();
	driver.close();
}

	
}

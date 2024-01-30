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

public class F_Logout 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public SoftAssert soft;
	
@Given("User travel to LoginPage")
public void user_travel_to_login_page() 
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.get("https://tutorialsninja.com/demo");
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Login")).click();
	
}

@When("User insert ecredentials {string} in their field of LoginPage")
public void user_insert_ecredentials_in_their_field_of_login_page(String mText) 
{
	driver.findElement(By.id("input-email")).sendKeys(mText); 

}

@When("User insert pcredentials {string} in their field of LoginPage")
public void user_insert_pcredentials_in_their_field_of_login_page(String pText) 
{
	driver.findElement(By.id("input-password")).sendKeys(pText);

}

@When("User press down Login optn")
public void user_press_down_login_optn() 
{
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

}

@When("User navigates to AccountPage")
public void user_navigates_to_account_page() 
{
	wait= new WebDriverWait(driver,Duration.ofSeconds(8));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/following::a[text()='Logout']")));
	soft= new SoftAssert();
	soft.assertTrue(driver.findElement(By.xpath("//div[@id='content']/following::a[text()='Logout']")).isDisplayed());
	soft.assertAll();
}

@When("User press down Logout optn")
public void user_press_down_logout_optn() 
{
	driver.findElement(By.xpath("//div[@id='content']/following::a[text()='Logout']")).click();
    
}

@Then("User press down continue optn to Logout of aplication")
	public void user_press_down_continue_optn_to_logout_of_aplication() 
{
	    driver.findElement(By.xpath("//a[text()='Continue']")).click();
	    driver.close();
}



}

package Step_Description;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cucumber 
	{
		WebDriver driver;
		
		@Given("I am in the login page of saucedemo")
		public void i_am_in_the_login_page_of_saucedemo() throws InterruptedException 
		{
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("opening the saucedemo page");
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(2000);
		}

		@When("I enter the username and password")
		public void i_enter_the_username_and_password() throws InterruptedException 
		{
			System.out.println("entering username and password");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			Thread.sleep(2000);
			
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			Thread.sleep(2000);
			
			
		}

		@And("click the login button")
		public void click_the_login_button() throws InterruptedException 
		{
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
		}
		
		
		@Then("I validate the outcomes")
		public void i_validate_the_outcomes() 
		{
			System.out.println("Should be in the Home page");
		}
		
		@Given("I am in the home page of saucedemo")
		public void i_am_in_the_home_page_of_saucedemo() 
		{
		  System.out.println("In the home page of saucedemo");
		  
		}
		
		@When("I click items to addtocart")
		public void i_click_items_to_addtocart() throws InterruptedException 
		{
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			Thread.sleep(2000);
		}
		
		@And("click on Icon of AddToCart")
		public void click_on_icon_of_add_to_cart() 
		{
			driver.findElement(By.id("shopping_cart_container")).click();
			
		}
		
		@And("click on check out")
		public void click_on_check_out() 
		{
			driver.findElement(By.id("checkout")).click();
		}
		
		@Then("I validate the outcomes")
		public void i_validate_outcomes() 
		{
		   System.out.println("");
		}
		
		@Given("I am in the your cart of saucedemo")
		public void i_am_in_the_your_cart_of_saucedemo() 
		{
			driver.findElement(By.id("cancel")).click();
		    System.out.println("");
		}
		
		@When("I click on continue shopping")
		public void i_click_on_continue_shopping() 
		{
			driver.findElement(By.id("continue-shopping")).click();
		}
		
		@And("I click items to addtocart")
		public void click_items_to_addtocart() 
		{
			driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
			driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		}
		
		@And("click on Icon of AddToCart")
		public void click_on_icon_of_addcart() 
		{
			driver.findElement(By.id("shopping_cart_container")).click();
		}
		
		@And("click on check out")
		public void click_on_checkout() 
		{
			driver.findElement(By.id("checkout")).click();
		}
		
		@Then("I validate the outcomes")
		public void validate_outcomes() 
		{
		   System.out.println("");
		}
		
		@Given("I am in the Checkout: Your Information page of saucedemo")
		public void i_am_in_the_checkout_your_information_page_of_saucedemo() 
		{
		    System.out.println("");
		}
		
		@When("I enter firstname lastname and postalcode")
		public void i_enter_firstname_lastname_and_postalcode() 
		{
			driver.findElement(By.id("first-name")).sendKeys("Shalini");
			driver.findElement(By.id("last-name")).sendKeys("Parnarsu");
			driver.findElement(By.id("postal-code")).sendKeys("515004");
		}
		
		@And("click on continue")
		public void click_on_continue() 
		{
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("finish")).click();
		}
		
		@And("click on the back home")
		public void click_on_the_back_home() 
		{
			driver.findElement(By.id("back-to-products")).click();
		}
		
		@Given("I am in the Home page of saucedemo1")
		public void i_am_in_the_home_page_of_saucedemo1() 
		{
		    System.out.println("");
		}
		
		@When("I click on menu icon")
		public void i_click_on_menu_icon() 
		{
			driver.findElement(By.id("react-burger-menu-btn")).click();
		}
		
		@And("click on Logout")
		public void click_on_logout() 
		{
			driver.findElement(By.id("logout_sidebar_link")).click();
		}
		
		@Then("Validate the outcomes")
		public void validate_the_outcomes() 
		{
		  System.out.println();
		  driver.close();
		}
}
	

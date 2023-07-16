package omayoblogspot;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BlogSpot 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Select s;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Welcome\\Desktop\\Automation Testing\\Browser extension\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize the window
		driver.manage().deleteAllCookies(); //deleting all cookies
		
		//URL
		driver.get("http://omayo.blogspot.com/");  
		//applying thread to wait
		Thread.sleep(2000);   
		
		//clicking on blogs
		driver.findElement(By.id("blogsmenu")).click();  
		
		//Mouse HOVER
		//Step1:Create object of Action class
		Actions a=new Actions(driver);
		
		//Step2:Create object of List with Web Element
		List<WebElement>ls=driver.findElements(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/ul/li[2]/ul/li"));
		
		//Step3:Store size of list
		int size=ls.size();
		System.out.println("No of WebElements: "+size);
		
		//Step4:For Loop
		for(int i=1;i<=size;i++)
		{
			//Wait
			Thread.sleep(2000);
			
			//Display WebElements Name
			System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/ul/li[2]/ul/li["+i+"]")).getText());
			
			//Perform Mouse Hover
			a.moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/ul/li[2]/ul/li["+i+"]"))).click().perform();
			Thread.sleep(2000);
			
			//navigate back to main page
			driver.navigate().back(); 
			
			//clicking on menu
			driver.findElement(By.id("blogsmenu")).click(); 
		}
		
		//Scroll
		//Step1:Create object for javaScriptExecuter
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Scroll to Bottom
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Enter the username of simple login page
		driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[1]")).sendKeys("Shalini"); 
		
		//Enter the password of simple login page
		driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[2]")).sendKeys("Shalini");  
		
		//clicking on login
		driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[3]")).click();   
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert(); 
		//Accepting the alert
		alert.accept();
		Thread.sleep(2000);
		
		//Scrolling Using Pixel
		js.executeScript("window.scrollBy(0,500)");  
		Thread.sleep(2000);
		
		//clicking on radio button female
		driver.findElement(By.id("radio2")).click();  
		Thread.sleep(2000);
		
		//clicking on click to get alert
		driver.findElement(By.id("alert1")).click();  
		//Accepting the alert
		alert.accept();  
		Thread.sleep(2000);
		
		//uncheck on orange
		driver.findElement(By.id("checkbox1")).click();  
		//clicking on checkbox blue
		driver.findElement(By.id("checkbox2")).click();  
		Thread.sleep(2000);
		//clicking on prompt
		driver.findElement(By.id("prompt")).click(); 
		Thread.sleep(5000);
		//Accepting the alert
		alert.accept();  
		//clicking on getConfirmation
		driver.findElement(By.id("confirm")).click();  
		Thread.sleep(2000);
		//Accepting the alert
		alert.accept();  
		
		//Scroll to Bottom
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Text Area Field
		driver.findElement(By.id("ta1")).sendKeys("This is a sample Text on this page."); 
		//Text Area Field Two
		driver.findElement(By.xpath("//*[@id=\"HTML11\"]/div[1]/textarea")).sendKeys("The cat was playing in the garden."); 
		//HTML Form Username
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[1]")).sendKeys("Shalini"); 
		//HTML Form Password
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/input[2]")).sendKeys("Shalini");  
		//Clicking on login
		driver.findElement(By.xpath("//*[@id=\"HTML31\"]/div[1]/form/button")).click();  
		
		
		//DropDown:
				//Create object of select class
				s = new Select(driver.findElement(By.id("multiselect1")));
				
				//Select Option by index
				s.selectByIndex(2);
				Thread.sleep(2000);
				
				//Create object of select class
				s = new Select(driver.findElement(By.id("drop1")));
				
				//Select Option by visible text
				s.selectByVisibleText("doc 2");
				Thread.sleep(2000);
				
				//clicking on Selenium143 link1
				driver.findElement(By.id("link1")).click();   
				//navigating back
				driver.navigate().back();   
				//clicking on Selenium143 link2
				driver.findElement(By.id("link2")).click();  
				driver.navigate().back();
				//Text Box with Preloaded Text
				driver.findElement(By.id("textbox1")).sendKeys("Selenium WebDriver1"); 
				Thread.sleep(2000);
				//clicking on Opens In New Window Link
				driver.findElement(By.xpath("//*[@id=\"link2\"]")).click(); 
				Thread.sleep(2000);
				driver.navigate().back();
				//clicking on Enabled Button
				driver.findElement(By.id("but2")).click();  
				Thread.sleep(2000);
				//clicking on DisplayForTimeAndDissapear
				driver.findElement(By.id("alert2")).click();  
				//Accepting the alert
				alert.accept();  
				Thread.sleep(2000);
				//clicking on Popup Window
				driver.findElement(By.xpath("//*[@id=\"HTML37\"]/div[1]/p/a")).click(); 
				Thread.sleep(2000);
				
				
				String MainWindow=driver.getWindowHandle();		
				// To handle all new opened window.				
				Set<String> s1=driver.getWindowHandles();		
				Iterator<String> i1=s1.iterator();				
				while(i1.hasNext())			
				{		
					String ChildWindow=i1.next();				
					if(!MainWindow.equalsIgnoreCase(ChildWindow))			
					{    		
						// Switching to Child window
						driver.switchTo().window(ChildWindow);	
						// Closing the Child Window.
						driver.close();
					}
				}
				// Switching to Parent window i.e Main Window.
				driver.switchTo().window(MainWindow);
	}
}

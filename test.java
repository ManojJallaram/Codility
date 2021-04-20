package Selenium.Learning;
 		

 		
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.thread.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class test {		
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();

			driver.get("http://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html");  
			//Test 1  Search query input filed is exist
			Assert.assertTrue(driver.findElement(By.id("search-input")).isDisplayed());
			//Test 2 search button exists
			Assert.assertTrue(driver.findElement(By.id("search-button")).isEnabled());
			
			//Test3 Check if we click on search button
			driver.findElement(By.id("search-button")).click();
			
			Assert.assertTrue(driver.findElement(By.id("error-empty-query")).isDisplayed());
			
			//Test 4 no result
			
			driver.findElement(By.id("search-button")).sendKeys("ooeruto");
			
			Assert.assertTrue(driver.findElement(By.id("error-no-results")).isDisplayed());
			
			//Test 5 Royal search
			driver.findElement(By.id("search-button")).sendKeys("Royal");
			
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search-results\"]/li[text()='Port Royal']")).isDisplayed());
			
		
		}		
}